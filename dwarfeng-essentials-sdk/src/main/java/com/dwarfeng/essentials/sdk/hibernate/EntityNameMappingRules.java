package com.dwarfeng.essentials.sdk.hibernate;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;

import javax.persistence.Entity;
import java.io.IOException;
import java.util.*;

/**
 * 定义 Chimera 运行时的 JPA 实体名称隔离规则。
 *
 * <p>
 * 来源服务以 Maven 坐标依赖的方式保留在聚合工程中，无法直接修改其实体注解。该规则集根据来源服务的实体包扫描所有
 * {@link Entity} 类型，并为每个实体生成服务级逻辑名称。
 * 生成的 ORM XML 会在 Hibernate 扫描实体包前注册，使不同来源模块的实体位于统一且彼此隔离的 JPA 命名空间中。
 * 数据表名称的隔离由 {@link PackagePrefixTableNameIntegrator} 负责。
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

    private EntityNameMappingRules() {
        throw new IllegalStateException("Illegal instantiation");
    }

    public static String[] entityPackages() {
        List<String> entityPackages = new ArrayList<>(ENTITY_PACKAGE_PREFIX_MAP.size());
        for (String entityPackagePrefix : ENTITY_PACKAGE_PREFIX_MAP.keySet()) {
            entityPackages.add(entityPackagePrefix.substring(0, entityPackagePrefix.length() - 1));
        }
        return entityPackages.toArray(new String[0]);
    }

    static String buildOrmXml(ResourceLoader resourceLoader) {
        Map<String, String> entityNameMap = entityNameMap(resourceLoader);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        stringBuilder.append("<entity-mappings\n");
        stringBuilder.append("        xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n");
        stringBuilder.append("        xmlns=\"http://xmlns.jcp.org/xml/ns/persistence/orm\"\n");
        stringBuilder.append("        xsi:schemaLocation=\"http://xmlns.jcp.org/xml/ns/persistence/orm\n");
        stringBuilder.append("        http://xmlns.jcp.org/xml/ns/persistence/orm_2_2.xsd\"\n");
        stringBuilder.append("        version=\"2.2\"\n");
        stringBuilder.append(">\n\n");
        for (Map.Entry<String, String> entry : entityNameMap.entrySet()) {
            stringBuilder.append("    <entity class=\"");
            stringBuilder.append(entry.getKey());
            stringBuilder.append("\" name=\"");
            stringBuilder.append(entry.getValue());
            stringBuilder.append("\"/>\n");
        }
        stringBuilder.append("</entity-mappings>\n");
        return stringBuilder.toString();
    }

    static Map<String, String> entityNameMap(ResourceLoader resourceLoader) {
        ResourcePatternResolver resourcePatternResolver = ResourcePatternUtils.getResourcePatternResolver(
                resourceLoader
        );
        CachingMetadataReaderFactory metadataReaderFactory = new CachingMetadataReaderFactory(resourcePatternResolver);
        Map<String, String> entityClassNamePrefixMap = new TreeMap<>();

        for (Map.Entry<String, String> entry : ENTITY_PACKAGE_PREFIX_MAP.entrySet()) {
            String entityPackagePrefix = entry.getKey();
            String resourcePattern = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX
                    + entityPackagePrefix.replace('.', '/') + "**/*.class";
            scanEntityClassNamePrefixMap(
                    resourcePatternResolver, metadataReaderFactory, entityPackagePrefix, entry.getValue(),
                    entityClassNamePrefixMap, resourcePattern
            );
        }

        if (entityClassNamePrefixMap.isEmpty()) {
            throw new IllegalStateException("未扫描到任何来源 JPA 实体");
        }

        return buildEntityNameMap(entityClassNamePrefixMap);
    }

    private static Map<String, String> buildEntityNameMap(Map<String, String> entityClassNamePrefixMap) {
        Map<String, String> entityNameMap = new LinkedHashMap<>();
        Map<String, String> entityNameClassMap = new LinkedHashMap<>();
        for (Map.Entry<String, String> entry : entityClassNamePrefixMap.entrySet()) {
            String entityClassName = entry.getKey();
            String entityName = entry.getValue() + entityClassName.substring(entityClassName.lastIndexOf('.') + 1);
            String previousEntityClassName = entityNameClassMap.put(entityName, entityClassName);
            if (previousEntityClassName != null) {
                throw new IllegalStateException(
                        "生成了重复的 JPA 实体名称: " + entityName + ", 实体类: "
                                + previousEntityClassName + ", " + entityClassName
                );
            }
            entityNameMap.put(entityClassName, entityName);
        }
        return Collections.unmodifiableMap(entityNameMap);
    }

    private static void scanEntityClassNamePrefixMap(
            ResourcePatternResolver resourcePatternResolver, CachingMetadataReaderFactory metadataReaderFactory,
            String entityPackagePrefix, String entityNamePrefix, Map<String, String> entityClassNamePrefixMap,
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
                String previousEntityNamePrefix = entityClassNamePrefixMap.put(entityClassName, entityNamePrefix);
                if (previousEntityNamePrefix != null) {
                    throw new IllegalStateException("发现重复的来源 JPA 实体类: " + entityClassName);
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("无法扫描来源 JPA 实体: " + entityPackagePrefix, e);
        }
    }
}
