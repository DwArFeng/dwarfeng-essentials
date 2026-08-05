package com.dwarfeng.essentials.node.all.he.configuration;

import com.dwarfeng.rbacds.impl.bean.BeanMapper;
import com.dwarfeng.rbacds.impl.bean.entity.*;
import com.dwarfeng.rbacds.impl.bean.key.HibernatePermissionGroupKey;
import com.dwarfeng.rbacds.impl.bean.key.HibernatePermissionKey;
import com.dwarfeng.rbacds.impl.bean.key.HibernatePexpKey;
import com.dwarfeng.rbacds.impl.bean.key.HibernateRoleUserRelationKey;
import com.dwarfeng.rbacds.impl.dao.preset.*;
import com.dwarfeng.rbacds.stack.bean.entity.*;
import com.dwarfeng.rbacds.stack.bean.key.PermissionGroupKey;
import com.dwarfeng.rbacds.stack.bean.key.PermissionKey;
import com.dwarfeng.rbacds.stack.bean.key.PexpKey;
import com.dwarfeng.rbacds.stack.bean.key.RoleUserRelationKey;
import com.dwarfeng.subgrade.impl.bean.MapStructBeanTransformer;
import com.dwarfeng.subgrade.impl.dao.HibernateBatchBaseDao;
import com.dwarfeng.subgrade.impl.dao.HibernateEntireLookupDao;
import com.dwarfeng.subgrade.impl.dao.HibernatePresetLookupDao;
import com.dwarfeng.subgrade.sdk.bean.key.HibernateStringIdKey;
import com.dwarfeng.subgrade.sdk.hibernate.modification.DefaultDeletionMod;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTemplate;

@Configuration
public class RbacdsDaoConfiguration {

    private final HibernateTemplate template;

    private final PexpPresetCriteriaMaker pexpPresetCriteriaMaker;
    private final RolePresetCriteriaMaker rolePresetCriteriaMaker;
    private final UserPresetCriteriaMaker userPresetCriteriaMaker;
    private final PermissionPresetCriteriaMaker permissionPresetCriteriaMaker;
    private final PermissionGroupPresetCriteriaMaker permissionGroupPresetCriteriaMaker;
    private final FilterSupportPresetCriteriaMaker filterSupportPresetCriteriaMaker;
    private final RoleUserRelationPresetCriteriaMaker roleUserRelationPresetCriteriaMaker;
    private final ScopePresetCriteriaMaker scopePresetCriteriaMaker;

    @Value("${com.dwarfeng.essentials.hibernate.jdbc.batch_size}")
    private int batchSize;

    public RbacdsDaoConfiguration(
            HibernateTemplate template,
            PexpPresetCriteriaMaker pexpPresetCriteriaMaker,
            RolePresetCriteriaMaker rolePresetCriteriaMaker,
            UserPresetCriteriaMaker userPresetCriteriaMaker,
            PermissionPresetCriteriaMaker permissionPresetCriteriaMaker,
            PermissionGroupPresetCriteriaMaker permissionGroupPresetCriteriaMaker,
            FilterSupportPresetCriteriaMaker filterSupportPresetCriteriaMaker,
            RoleUserRelationPresetCriteriaMaker roleUserRelationPresetCriteriaMaker,
            ScopePresetCriteriaMaker scopePresetCriteriaMaker
    ) {
        this.template = template;
        this.pexpPresetCriteriaMaker = pexpPresetCriteriaMaker;
        this.rolePresetCriteriaMaker = rolePresetCriteriaMaker;
        this.userPresetCriteriaMaker = userPresetCriteriaMaker;
        this.permissionPresetCriteriaMaker = permissionPresetCriteriaMaker;
        this.permissionGroupPresetCriteriaMaker = permissionGroupPresetCriteriaMaker;
        this.filterSupportPresetCriteriaMaker = filterSupportPresetCriteriaMaker;
        this.roleUserRelationPresetCriteriaMaker = roleUserRelationPresetCriteriaMaker;
        this.scopePresetCriteriaMaker = scopePresetCriteriaMaker;
    }

    @Bean(name = "rbacds.permissionDaoDelegate")
    public HibernateBatchBaseDao<PermissionKey, HibernatePermissionKey, Permission, HibernatePermission>
    permissionDaoDelegate() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(PermissionKey.class, HibernatePermissionKey.class, BeanMapper.class),
                new MapStructBeanTransformer<>(Permission.class, HibernatePermission.class, BeanMapper.class),
                HibernatePermission.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean(name = "rbacds.permissionHibernateEntireLookupDao")
    public HibernateEntireLookupDao<Permission, HibernatePermission> permissionHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(Permission.class, HibernatePermission.class, BeanMapper.class),
                HibernatePermission.class
        );
    }

    @Bean(name = "rbacds.permissionHibernatePresetLookupDao")
    public HibernatePresetLookupDao<Permission, HibernatePermission> permissionHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(Permission.class, HibernatePermission.class, BeanMapper.class),
                HibernatePermission.class,
                permissionPresetCriteriaMaker
        );
    }

    @Bean(name = "rbacds.pexpDaoDelegate")
    public HibernateBatchBaseDao<PexpKey, HibernatePexpKey, Pexp, HibernatePexp> pexpDaoDelegate() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(PexpKey.class, HibernatePexpKey.class, BeanMapper.class),
                new MapStructBeanTransformer<>(Pexp.class, HibernatePexp.class, BeanMapper.class),
                HibernatePexp.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean(name = "rbacds.pexpHibernatePresetLookupDao")
    public HibernatePresetLookupDao<Pexp, HibernatePexp> pexpHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(Pexp.class, HibernatePexp.class, BeanMapper.class),
                HibernatePexp.class,
                pexpPresetCriteriaMaker
        );
    }

    @Bean(name = "rbacds.roleDaoDelegate")
    public HibernateBatchBaseDao<StringIdKey, HibernateStringIdKey, Role, HibernateRole> roleDaoDelegate() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(StringIdKey.class, HibernateStringIdKey.class, BeanMapper.class),
                new MapStructBeanTransformer<>(Role.class, HibernateRole.class, BeanMapper.class),
                HibernateRole.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean(name = "rbacds.roleHibernatePresetLookupDao")
    public HibernatePresetLookupDao<Role, HibernateRole> roleHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(Role.class, HibernateRole.class, BeanMapper.class),
                HibernateRole.class,
                rolePresetCriteriaMaker
        );
    }

    @Bean(name = "rbacds.roleHibernateEntireLookupDao")
    public HibernateEntireLookupDao<Role, HibernateRole> roleHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(Role.class, HibernateRole.class, BeanMapper.class),
                HibernateRole.class
        );
    }

    @Bean(name = "rbacds.userDaoDelegate")
    public HibernateBatchBaseDao<StringIdKey, HibernateStringIdKey, User, HibernateUser> userDaoDelegate() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(StringIdKey.class, HibernateStringIdKey.class, BeanMapper.class),
                new MapStructBeanTransformer<>(User.class, HibernateUser.class, BeanMapper.class),
                HibernateUser.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean(name = "rbacds.userHibernatePresetLookupDao")
    public HibernatePresetLookupDao<User, HibernateUser> userHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(User.class, HibernateUser.class, BeanMapper.class),
                HibernateUser.class,
                userPresetCriteriaMaker
        );
    }

    @Bean(name = "rbacds.userHibernateEntireLookupDao")
    public HibernateEntireLookupDao<User, HibernateUser> userHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(User.class, HibernateUser.class, BeanMapper.class),
                HibernateUser.class
        );
    }

    @Bean(name = "rbacds.permissionGroupDaoDelegate")
    public HibernateBatchBaseDao<PermissionGroupKey, HibernatePermissionGroupKey, PermissionGroup,
            HibernatePermissionGroup> permissionGroupDaoDelegate() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(
                        PermissionGroupKey.class, HibernatePermissionGroupKey.class, BeanMapper.class
                ),
                new MapStructBeanTransformer<>(
                        PermissionGroup.class, HibernatePermissionGroup.class, BeanMapper.class
                ),
                HibernatePermissionGroup.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean(name = "rbacds.permissionGroupHibernateEntireLookupDao")
    public HibernateEntireLookupDao<PermissionGroup, HibernatePermissionGroup>
    permissionGroupHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(
                        PermissionGroup.class, HibernatePermissionGroup.class, BeanMapper.class
                ),
                HibernatePermissionGroup.class
        );
    }

    @Bean(name = "rbacds.permissionGroupHibernatePresetLookupDao")
    public HibernatePresetLookupDao<PermissionGroup, HibernatePermissionGroup>
    permissionGroupHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(
                        PermissionGroup.class, HibernatePermissionGroup.class, BeanMapper.class
                ),
                HibernatePermissionGroup.class,
                permissionGroupPresetCriteriaMaker
        );
    }

    @Bean(name = "rbacds.filterSupportHibernateBatchBaseDao")
    public HibernateBatchBaseDao<StringIdKey, HibernateStringIdKey, FilterSupport, HibernateFilterSupport>
    filterSupportHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(StringIdKey.class, HibernateStringIdKey.class, BeanMapper.class),
                new MapStructBeanTransformer<>(FilterSupport.class, HibernateFilterSupport.class, BeanMapper.class),
                HibernateFilterSupport.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean(name = "rbacds.filterSupportHibernateEntireLookupDao")
    public HibernateEntireLookupDao<FilterSupport, HibernateFilterSupport> filterSupportHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(FilterSupport.class, HibernateFilterSupport.class, BeanMapper.class),
                HibernateFilterSupport.class
        );
    }

    @Bean(name = "rbacds.filterSupportHibernatePresetLookupDao")
    public HibernatePresetLookupDao<FilterSupport, HibernateFilterSupport> filterSupportHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(FilterSupport.class, HibernateFilterSupport.class, BeanMapper.class),
                HibernateFilterSupport.class,
                filterSupportPresetCriteriaMaker
        );
    }

    @Bean(name = "rbacds.roleUserRelationSupportHibernateBatchBaseDao")
    public HibernateBatchBaseDao<RoleUserRelationKey, HibernateRoleUserRelationKey, RoleUserRelation,
            HibernateRoleUserRelation> roleUserRelationSupportHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(
                        RoleUserRelationKey.class, HibernateRoleUserRelationKey.class, BeanMapper.class
                ),
                new MapStructBeanTransformer<>(
                        RoleUserRelation.class, HibernateRoleUserRelation.class, BeanMapper.class
                ),
                HibernateRoleUserRelation.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean(name = "rbacds.roleUserRelationSupportHibernateEntireLookupDao")
    public HibernateEntireLookupDao<RoleUserRelation, HibernateRoleUserRelation>
    roleUserRelationSupportHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(
                        RoleUserRelation.class, HibernateRoleUserRelation.class, BeanMapper.class
                ),
                HibernateRoleUserRelation.class
        );
    }

    @Bean(name = "rbacds.roleUserRelationSupportHibernatePresetLookupDao")
    public HibernatePresetLookupDao<RoleUserRelation, HibernateRoleUserRelation>
    roleUserRelationSupportHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(
                        RoleUserRelation.class, HibernateRoleUserRelation.class, BeanMapper.class
                ),
                HibernateRoleUserRelation.class,
                roleUserRelationPresetCriteriaMaker
        );
    }

    @Bean(name = "rbacds.scopeSupportHibernateBatchBaseDao")
    public HibernateBatchBaseDao<StringIdKey, HibernateStringIdKey, Scope, HibernateScope>
    scopeSupportHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(StringIdKey.class, HibernateStringIdKey.class, BeanMapper.class),
                new MapStructBeanTransformer<>(Scope.class, HibernateScope.class, BeanMapper.class),
                HibernateScope.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean(name = "rbacds.scopeSupportHibernateEntireLookupDao")
    public HibernateEntireLookupDao<Scope, HibernateScope> scopeSupportHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(Scope.class, HibernateScope.class, BeanMapper.class),
                HibernateScope.class
        );
    }

    @Bean(name = "rbacds.scopeSupportHibernatePresetLookupDao")
    public HibernatePresetLookupDao<Scope, HibernateScope> scopeSupportHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(Scope.class, HibernateScope.class, BeanMapper.class),
                HibernateScope.class,
                scopePresetCriteriaMaker
        );
    }
}
