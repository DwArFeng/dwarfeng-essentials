package com.dwarfeng.essentials.sdk.hibernate;

import org.hibernate.boot.Metadata;
import org.hibernate.boot.model.relational.Database;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.integrator.spi.Integrator;
import org.hibernate.mapping.PersistentClass;
import org.hibernate.mapping.Table;
import org.hibernate.service.spi.SessionFactoryServiceRegistry;

/**
 * 基于实体包名重写主表名称的 Hibernate Integrator。
 *
 * <p>
 * 该 Integrator 在 Hibernate 创建会话工厂期间遍历聚合运行时的实体映射，并依据实体类所在包名重写实体主表名称，
 * 以隔离多个来源服务的同名表。表名的具体转换规则由 {@link TablePrefixResolver} 提供。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class PackagePrefixTableNameIntegrator implements Integrator {

    @Override
    public void integrate(
            Metadata metadata, SessionFactoryImplementor sessionFactory, SessionFactoryServiceRegistry serviceRegistry
    ) {
        for (PersistentClass persistentClass : metadata.getEntityBindings()) {
            Table table = persistentClass.getTable();
            if (table != null) {
                table.setName(TablePrefixResolver.resolveTableName(
                        persistentClass.getClassName(), table.getName()
                ));
            }
        }
    }

    public void integrate(
            Metadata metadata, Database database, SessionFactoryImplementor sessionFactory,
            SessionFactoryServiceRegistry serviceRegistry
    ) {
        integrate(metadata, sessionFactory, serviceRegistry);
    }

    @Override
    public void disintegrate(SessionFactoryImplementor sessionFactory, SessionFactoryServiceRegistry serviceRegistry) {
        // 当前实现不持有额外资源，无需在销毁阶段处理。
    }
}
