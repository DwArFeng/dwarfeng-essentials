package com.dwarfeng.essentials.sdk.hibernate;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.IOException;
import java.util.*;

/**
 * 实体名称映射规则。
 *
 * <p>
 * 该规则集根据来源服务的实体包扫描所有 {@link Entity} 类型，并为每个实体生成服务级逻辑名称。
 * 生成的 ORM XML 会在 Hibernate 扫描实体包前注册，使不同来源模块的实体位于统一且彼此隔离的 JPA 命名空间中，
 * 并覆写实体主表名称，为不同来源服务的实体表添加来源服务前缀，避免不同来源服务的实体表名称冲突。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public final class EntityNameMappingRules {

    private static final Map<String, String> ENTITY_PACKAGE_PREFIX_MAP;

    static {
        Map<String, String> entityPackagePrefixMap = new LinkedHashMap<>();
        entityPackagePrefixMap.put("com.dwarfeng.acckeeper.impl.bean.entity.", "Acckeeper");
        entityPackagePrefixMap.put("com.dwarfeng.rbacds.impl.bean.entity.", "Rbacds");
        entityPackagePrefixMap.put("com.dwarfeng.buddy.impl.bean.entity.", "Buddy");
        entityPackagePrefixMap.put("com.dwarfeng.settingrepo.impl.bean.entity.", "Settingrepo");
        entityPackagePrefixMap.put("com.dwarfeng.notify.impl.bean.entity.", "Notify");
        ENTITY_PACKAGE_PREFIX_MAP = Collections.unmodifiableMap(entityPackagePrefixMap);
    }

    public static String[] entityPackages() {
        List<String> entityPackages = new ArrayList<>(ENTITY_PACKAGE_PREFIX_MAP.size());
        for (String entityPackagePrefix : ENTITY_PACKAGE_PREFIX_MAP.keySet()) {
            entityPackages.add(entityPackagePrefix.substring(0, entityPackagePrefix.length() - 1));
        }
        return entityPackages.toArray(new String[0]);
    }

    public static String buildOrmXml(ResourceLoader resourceLoader) {
        Map<String, EntityMapping> entityMappingMap = entityMappingMap(resourceLoader);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        stringBuilder.append("<entity-mappings\n");
        stringBuilder.append("        xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n");
        stringBuilder.append("        xmlns=\"http://xmlns.jcp.org/xml/ns/persistence/orm\"\n");
        stringBuilder.append("        xsi:schemaLocation=\"http://xmlns.jcp.org/xml/ns/persistence/orm\n");
        stringBuilder.append("        http://xmlns.jcp.org/xml/ns/persistence/orm_2_2.xsd\"\n");
        stringBuilder.append("        version=\"2.2\"\n");
        stringBuilder.append(">\n\n");
        for (Map.Entry<String, EntityMapping> entry : entityMappingMap.entrySet()) {
            stringBuilder.append("    <entity class=\"");
            stringBuilder.append(entry.getKey());
            stringBuilder.append("\" name=\"");
            stringBuilder.append(entry.getValue().entityName);
            stringBuilder.append("\">\n");
            stringBuilder.append("        <table name=\"");
            stringBuilder.append(entry.getValue().tableName);
            stringBuilder.append("\"/>\n");
            stringBuilder.append("    </entity>\n");
        }
        stringBuilder.append("</entity-mappings>\n");
        return stringBuilder.toString();
    }

    private static Map<String, EntityMapping> entityMappingMap(ResourceLoader resourceLoader) {
        ResourcePatternResolver resourcePatternResolver = ResourcePatternUtils.getResourcePatternResolver(
                resourceLoader
        );
        CachingMetadataReaderFactory metadataReaderFactory = new CachingMetadataReaderFactory(resourcePatternResolver);
        Map<String, EntityMapping> entityClassNameMappingMap = new TreeMap<>();

        for (Map.Entry<String, String> entry : ENTITY_PACKAGE_PREFIX_MAP.entrySet()) {
            String entityPackagePrefix = entry.getKey();
            String resourcePattern = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX
                    + entityPackagePrefix.replace('.', '/') + "**/*.class";
            scanEntityClassNameMappingMap(
                    resourcePatternResolver, metadataReaderFactory, entityPackagePrefix, entry.getValue(),
                    entityClassNameMappingMap, resourcePattern
            );
        }

        if (entityClassNameMappingMap.isEmpty()) {
            throw new IllegalStateException("未扫描到任何来源 JPA 实体");
        }

        return buildEntityMappingMap(entityClassNameMappingMap);
    }

    private static void scanEntityClassNameMappingMap(
            ResourcePatternResolver resourcePatternResolver, CachingMetadataReaderFactory metadataReaderFactory,
            String entityPackagePrefix, String entityNamePrefix, Map<String, EntityMapping> entityClassNameMappingMap,
            String resourcePattern
    ) {
        try {
            for (Resource resource : resourcePatternResolver.getResources(resourcePattern)) {
                MetadataReader metadataReader = metadataReaderFactory.getMetadataReader(resource);
                if (!metadataReader.getAnnotationMetadata().hasAnnotation(Entity.class.getName())) {
                    continue;
                }
                String entityClassName = metadataReader.getClassMetadata().getClassName();
                if (!entityClassName.startsWith(entityPackagePrefix)) {
                    throw new IllegalStateException("实体类不匹配已登记的实体包规则: " + entityClassName);
                }
                EntityMapping previousEntityMapping = entityClassNameMappingMap.put(
                        entityClassName, new EntityMapping(entityNamePrefix, resolveTableName(metadataReader, entityClassName))
                );
                if (previousEntityMapping != null) {
                    throw new IllegalStateException("发现重复的来源 JPA 实体类: " + entityClassName);
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("无法扫描来源 JPA 实体: " + entityPackagePrefix, e);
        }
    }

    private static Map<String, EntityMapping> buildEntityMappingMap(
            Map<String, EntityMapping> entityClassNameMappingMap
    ) {
        Map<String, EntityMapping> entityMappingMap = new LinkedHashMap<>();
        Map<String, String> entityNameClassMap = new LinkedHashMap<>();
        for (Map.Entry<String, EntityMapping> entry : entityClassNameMappingMap.entrySet()) {
            String entityClassName = entry.getKey();
            EntityMapping entityMapping = entry.getValue();
            String entityName = entityMapping.entityName + entityClassName.substring(entityClassName.lastIndexOf('.') + 1);
            String previousEntityClassName = entityNameClassMap.put(entityName, entityClassName);
            if (previousEntityClassName != null) {
                throw new IllegalStateException(
                        "生成了重复的 JPA 实体名称: " + entityName + ", 实体类: "
                                + previousEntityClassName + ", " + entityClassName
                );
            }
            entityMappingMap.put(entityClassName, new EntityMapping(entityName, entityMapping.tableName));
        }
        return Collections.unmodifiableMap(entityMappingMap);
    }

    private static String resolveTableName(MetadataReader metadataReader, String entityClassName) {
        Map<String, Object> tableAttributes = metadataReader.getAnnotationMetadata().getAnnotationAttributes(
                Table.class.getName()
        );
        if (tableAttributes == null) {
            throw new IllegalStateException("来源 JPA 实体未声明 @Table: " + entityClassName);
        }
        Object tableNameAttribute = tableAttributes.get("name");
        if (!(tableNameAttribute instanceof String) || ((String) tableNameAttribute).isEmpty()) {
            throw new IllegalStateException("来源 JPA 实体未声明 @Table.name: " + entityClassName);
        }
        return TablePrefixResolver.resolveTableName(entityClassName, (String) tableNameAttribute);
    }

    private static final class EntityMapping {

        private final String entityName;
        private final String tableName;

        private EntityMapping(String entityName, String tableName) {
            this.entityName = entityName;
            this.tableName = tableName;
        }
    }

    private EntityNameMappingRules() {
        throw new IllegalStateException("禁止实例化");
    }
}
