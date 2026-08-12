package com.dwarfeng.essentials.sdk.hibernate;

import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.BootstrapServiceRegistryBuilder;
import org.hibernate.integrator.spi.Integrator;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.annotation.Nonnull;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

/**
 * 实体名称元数据源工厂 Bean。
 *
 * <p>
 * 该工厂在 Spring 初始化阶段创建 {@link MetadataSources}，注册指定的 Hibernate Integrator，
 * 并将动态生成的 ORM XML 添加到元数据源中。
 * {@code LocalSessionFactoryBean} 使用该元数据源扫描聚合来源包时，会应用隔离后的实体名称和主表名称，
 * 从而无需修改来源服务制品即可消除重复的 JPA 实体名称与数据表名称。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class EntityNameMetadataSourcesFactoryBean implements FactoryBean<MetadataSources>, InitializingBean,
        ResourceLoaderAware {

    private ResourceLoader resourceLoader = new PathMatchingResourcePatternResolver();
    private Integrator[] hibernateIntegrators = new Integrator[0];
    private MetadataSources metadataSources;

    @Override
    public void setResourceLoader(@Nonnull ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public void setHibernateIntegrators(Integrator... hibernateIntegrators) {
        this.hibernateIntegrators = hibernateIntegrators == null ? new Integrator[0] : hibernateIntegrators;
    }

    @Override
    public void afterPropertiesSet() {
        BootstrapServiceRegistryBuilder registryBuilder = new BootstrapServiceRegistryBuilder()
                .applyClassLoader(resourceLoader.getClassLoader());
        for (Integrator hibernateIntegrator : hibernateIntegrators) {
            registryBuilder.applyIntegrator(hibernateIntegrator);
        }

        metadataSources = new MetadataSources(registryBuilder.build());
        byte[] ormXmlBytes = EntityNameMappingRules.buildOrmXml(resourceLoader).getBytes(StandardCharsets.UTF_8);
        metadataSources.addInputStream(new ByteArrayInputStream(ormXmlBytes));
    }

    @Override
    public MetadataSources getObject() {
        return metadataSources;
    }

    @Override
    public Class<?> getObjectType() {
        return MetadataSources.class;
    }
}
