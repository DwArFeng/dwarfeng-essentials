package com.dwarfeng.essentials.node.all.he.configuration;

import com.dwarfeng.acckeeper.impl.bean.BeanMapper;
import com.dwarfeng.acckeeper.impl.bean.entity.*;
import com.dwarfeng.acckeeper.impl.bean.key.HibernateProtectorVariableKey;
import com.dwarfeng.acckeeper.impl.bean.key.HibernateRecordKey;
import com.dwarfeng.acckeeper.impl.dao.preset.*;
import com.dwarfeng.acckeeper.stack.bean.entity.*;
import com.dwarfeng.acckeeper.stack.bean.key.ProtectorVariableKey;
import com.dwarfeng.acckeeper.stack.bean.key.RecordKey;
import com.dwarfeng.subgrade.impl.bean.MapStructBeanTransformer;
import com.dwarfeng.subgrade.impl.dao.HibernateBatchBaseDao;
import com.dwarfeng.subgrade.impl.dao.HibernateEntireLookupDao;
import com.dwarfeng.subgrade.impl.dao.HibernatePresetLookupDao;
import com.dwarfeng.subgrade.sdk.bean.key.HibernateLongIdKey;
import com.dwarfeng.subgrade.sdk.bean.key.HibernateStringIdKey;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTemplate;

@Configuration
public class AcckeeperDaoConfiguration {

    private final HibernateTemplate hibernateTemplate;

    private final AccountPresetCriteriaMaker accountPresetCriteriaMaker;
    private final LoginStatePresetCriteriaMaker loginStatePresetCriteriaMaker;
    private final LoginHistoryPresetCriteriaMaker loginHistoryPresetCriteriaMaker;
    private final ProtectorInfoPresetCriteriaMaker protectorInfoPresetCriteriaMaker;
    private final ProtectorSupportPresetCriteriaMaker protectorSupportPresetCriteriaMaker;
    private final ProtectorVariablePresetCriteriaMaker protectorVariablePresetCriteriaMaker;
    private final LoginParamRecordPresetCriteriaMaker loginParamRecordPresetCriteriaMaker;
    private final ProtectDetailRecordPresetCriteriaMaker protectDetailRecordPresetCriteriaMaker;
    private final DeriveHistoryPresetCriteriaMaker deriveHistoryPresetCriteriaMaker;

    public AcckeeperDaoConfiguration(
            HibernateTemplate hibernateTemplate,
            AccountPresetCriteriaMaker accountPresetCriteriaMaker,
            LoginStatePresetCriteriaMaker loginStatePresetCriteriaMaker,
            LoginHistoryPresetCriteriaMaker loginHistoryPresetCriteriaMaker,
            ProtectorInfoPresetCriteriaMaker protectorInfoPresetCriteriaMaker,
            ProtectorSupportPresetCriteriaMaker protectorSupportPresetCriteriaMaker,
            ProtectorVariablePresetCriteriaMaker protectorVariablePresetCriteriaMaker,
            LoginParamRecordPresetCriteriaMaker loginParamRecordPresetCriteriaMaker,
            ProtectDetailRecordPresetCriteriaMaker protectDetailRecordPresetCriteriaMaker,
            DeriveHistoryPresetCriteriaMaker deriveHistoryPresetCriteriaMaker
    ) {
        this.hibernateTemplate = hibernateTemplate;
        this.accountPresetCriteriaMaker = accountPresetCriteriaMaker;
        this.loginStatePresetCriteriaMaker = loginStatePresetCriteriaMaker;
        this.loginHistoryPresetCriteriaMaker = loginHistoryPresetCriteriaMaker;
        this.protectorInfoPresetCriteriaMaker = protectorInfoPresetCriteriaMaker;
        this.protectorSupportPresetCriteriaMaker = protectorSupportPresetCriteriaMaker;
        this.protectorVariablePresetCriteriaMaker = protectorVariablePresetCriteriaMaker;
        this.loginParamRecordPresetCriteriaMaker = loginParamRecordPresetCriteriaMaker;
        this.protectDetailRecordPresetCriteriaMaker = protectDetailRecordPresetCriteriaMaker;
        this.deriveHistoryPresetCriteriaMaker = deriveHistoryPresetCriteriaMaker;
    }

    @Bean(name = "acckeeper.accountHibernateBatchBaseDao")
    public HibernateBatchBaseDao<StringIdKey, HibernateStringIdKey, Account, HibernateAccount>
    accountHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                hibernateTemplate,
                new MapStructBeanTransformer<>(StringIdKey.class, HibernateStringIdKey.class, BeanMapper.class),
                new MapStructBeanTransformer<>(Account.class, HibernateAccount.class, BeanMapper.class),
                HibernateAccount.class
        );
    }

    @Bean(name = "acckeeper.accountHibernateEntireLookupDao")
    public HibernateEntireLookupDao<Account, HibernateAccount> accountHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                hibernateTemplate,
                new MapStructBeanTransformer<>(Account.class, HibernateAccount.class, BeanMapper.class),
                HibernateAccount.class
        );
    }

    @Bean(name = "acckeeper.accountHibernatePresetLookupDao")
    public HibernatePresetLookupDao<Account, HibernateAccount> accountHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                hibernateTemplate,
                new MapStructBeanTransformer<>(Account.class, HibernateAccount.class, BeanMapper.class),
                HibernateAccount.class,
                accountPresetCriteriaMaker
        );
    }

    @Bean(name = "acckeeper.loginStateHibernateBatchBaseDao")
    public HibernateBatchBaseDao<StringIdKey, HibernateStringIdKey, LoginState, HibernateLoginState>
    loginStateHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                hibernateTemplate,
                new MapStructBeanTransformer<>(StringIdKey.class, HibernateStringIdKey.class, BeanMapper.class),
                new MapStructBeanTransformer<>(LoginState.class, HibernateLoginState.class, BeanMapper.class),
                HibernateLoginState.class
        );
    }

    @Bean(name = "acckeeper.loginStateHibernateEntireLookupDao")
    public HibernateEntireLookupDao<LoginState, HibernateLoginState> loginStateHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                hibernateTemplate,
                new MapStructBeanTransformer<>(LoginState.class, HibernateLoginState.class, BeanMapper.class),
                HibernateLoginState.class
        );
    }

    @Bean(name = "acckeeper.loginStateHibernatePresetLookupDao")
    public HibernatePresetLookupDao<LoginState, HibernateLoginState> loginStateHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                hibernateTemplate,
                new MapStructBeanTransformer<>(LoginState.class, HibernateLoginState.class, BeanMapper.class),
                HibernateLoginState.class,
                loginStatePresetCriteriaMaker
        );
    }

    @Bean(name = "acckeeper.loginHistoryHibernateBatchBaseDao")
    public HibernateBatchBaseDao<LongIdKey, HibernateLongIdKey, LoginHistory, HibernateLoginHistory>
    loginHistoryHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                hibernateTemplate,
                new MapStructBeanTransformer<>(LongIdKey.class, HibernateLongIdKey.class, BeanMapper.class),
                new MapStructBeanTransformer<>(LoginHistory.class, HibernateLoginHistory.class, BeanMapper.class),
                HibernateLoginHistory.class
        );
    }

    @Bean(name = "acckeeper.loginHistoryHibernateEntireLookupDao")
    public HibernateEntireLookupDao<LoginHistory, HibernateLoginHistory> loginHistoryHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                hibernateTemplate,
                new MapStructBeanTransformer<>(LoginHistory.class, HibernateLoginHistory.class, BeanMapper.class),
                HibernateLoginHistory.class
        );
    }

    @Bean(name = "acckeeper.loginHistoryHibernatePresetLookupDao")
    public HibernatePresetLookupDao<LoginHistory, HibernateLoginHistory> loginHistoryHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                hibernateTemplate,
                new MapStructBeanTransformer<>(LoginHistory.class, HibernateLoginHistory.class, BeanMapper.class),
                HibernateLoginHistory.class,
                loginHistoryPresetCriteriaMaker
        );
    }

    @Bean(name = "acckeeper.protectorInfoHibernateBatchBaseDao")
    public HibernateBatchBaseDao<StringIdKey, HibernateStringIdKey, ProtectorInfo, HibernateProtectorInfo>
    protectorInfoHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                hibernateTemplate,
                new MapStructBeanTransformer<>(StringIdKey.class, HibernateStringIdKey.class, BeanMapper.class),
                new MapStructBeanTransformer<>(
                        ProtectorInfo.class, HibernateProtectorInfo.class, BeanMapper.class
                ),
                HibernateProtectorInfo.class
        );
    }

    @Bean(name = "acckeeper.protectorInfoHibernateEntireLookupDao")
    public HibernateEntireLookupDao<ProtectorInfo, HibernateProtectorInfo> protectorInfoHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                hibernateTemplate,
                new MapStructBeanTransformer<>(
                        ProtectorInfo.class, HibernateProtectorInfo.class, BeanMapper.class
                ),
                HibernateProtectorInfo.class
        );
    }

    @Bean(name = "acckeeper.protectorInfoHibernatePresetLookupDao")
    public HibernatePresetLookupDao<ProtectorInfo, HibernateProtectorInfo> protectorInfoHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                hibernateTemplate,
                new MapStructBeanTransformer<>(
                        ProtectorInfo.class, HibernateProtectorInfo.class, BeanMapper.class
                ),
                HibernateProtectorInfo.class,
                protectorInfoPresetCriteriaMaker
        );
    }

    @Bean(name = "acckeeper.protectorSupportHibernateBatchBaseDao")
    public HibernateBatchBaseDao<StringIdKey, HibernateStringIdKey, ProtectorSupport, HibernateProtectorSupport>
    protectorSupportHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                hibernateTemplate,
                new MapStructBeanTransformer<>(StringIdKey.class, HibernateStringIdKey.class, BeanMapper.class),
                new MapStructBeanTransformer<>(
                        ProtectorSupport.class, HibernateProtectorSupport.class, BeanMapper.class
                ),
                HibernateProtectorSupport.class
        );
    }

    @Bean(name = "acckeeper.protectorSupportHibernateEntireLookupDao")
    public HibernateEntireLookupDao<ProtectorSupport, HibernateProtectorSupport>
    protectorSupportHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                hibernateTemplate,
                new MapStructBeanTransformer<>(
                        ProtectorSupport.class, HibernateProtectorSupport.class, BeanMapper.class
                ),
                HibernateProtectorSupport.class
        );
    }

    @Bean(name = "acckeeper.protectorSupportHibernatePresetLookupDao")
    public HibernatePresetLookupDao<ProtectorSupport, HibernateProtectorSupport>
    protectorSupportHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                hibernateTemplate,
                new MapStructBeanTransformer<>(
                        ProtectorSupport.class, HibernateProtectorSupport.class, BeanMapper.class
                ),
                HibernateProtectorSupport.class,
                protectorSupportPresetCriteriaMaker
        );
    }

    @Bean(name = "acckeeper.protectorVariableHibernateBatchBaseDao")
    public HibernateBatchBaseDao<ProtectorVariableKey, HibernateProtectorVariableKey, ProtectorVariable,
            HibernateProtectorVariable> protectorVariableHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                hibernateTemplate,
                new MapStructBeanTransformer<>(
                        ProtectorVariableKey.class, HibernateProtectorVariableKey.class, BeanMapper.class
                ),
                new MapStructBeanTransformer<>(
                        ProtectorVariable.class, HibernateProtectorVariable.class, BeanMapper.class
                ),
                HibernateProtectorVariable.class
        );
    }

    @Bean(name = "acckeeper.protectorVariableHibernateEntireLookupDao")
    public HibernateEntireLookupDao<ProtectorVariable, HibernateProtectorVariable>
    protectorVariableHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                hibernateTemplate,
                new MapStructBeanTransformer<>(
                        ProtectorVariable.class, HibernateProtectorVariable.class, BeanMapper.class
                ),
                HibernateProtectorVariable.class
        );
    }

    @Bean(name = "acckeeper.protectorVariableHibernatePresetLookupDao")
    public HibernatePresetLookupDao<ProtectorVariable, HibernateProtectorVariable>
    protectorVariableHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                hibernateTemplate,
                new MapStructBeanTransformer<>(
                        ProtectorVariable.class, HibernateProtectorVariable.class, BeanMapper.class
                ),
                HibernateProtectorVariable.class,
                protectorVariablePresetCriteriaMaker
        );
    }

    @Bean(name = "acckeeper.loginParamRecordHibernateBatchBaseDao")
    public HibernateBatchBaseDao<RecordKey, HibernateRecordKey, LoginParamRecord, HibernateLoginParamRecord>
    loginParamRecordHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                hibernateTemplate,
                new MapStructBeanTransformer<>(
                        RecordKey.class, HibernateRecordKey.class, BeanMapper.class
                ),
                new MapStructBeanTransformer<>(
                        LoginParamRecord.class, HibernateLoginParamRecord.class, BeanMapper.class
                ),
                HibernateLoginParamRecord.class
        );
    }

    @Bean(name = "acckeeper.loginParamRecordHibernateEntireLookupDao")
    public HibernateEntireLookupDao<LoginParamRecord, HibernateLoginParamRecord>
    loginParamRecordHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                hibernateTemplate,
                new MapStructBeanTransformer<>(
                        LoginParamRecord.class, HibernateLoginParamRecord.class, BeanMapper.class
                ),
                HibernateLoginParamRecord.class
        );
    }

    @Bean(name = "acckeeper.loginParamRecordHibernatePresetLookupDao")
    public HibernatePresetLookupDao<LoginParamRecord, HibernateLoginParamRecord>
    loginParamRecordHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                hibernateTemplate,
                new MapStructBeanTransformer<>(
                        LoginParamRecord.class, HibernateLoginParamRecord.class, BeanMapper.class
                ),
                HibernateLoginParamRecord.class,
                loginParamRecordPresetCriteriaMaker
        );
    }

    @Bean(name = "acckeeper.protectDetailRecordHibernateBatchBaseDao")
    public HibernateBatchBaseDao<RecordKey, HibernateRecordKey, ProtectDetailRecord, HibernateProtectDetailRecord>
    protectDetailRecordHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                hibernateTemplate,
                new MapStructBeanTransformer<>(
                        RecordKey.class, HibernateRecordKey.class, BeanMapper.class
                ),
                new MapStructBeanTransformer<>(
                        ProtectDetailRecord.class, HibernateProtectDetailRecord.class, BeanMapper.class
                ),
                HibernateProtectDetailRecord.class
        );
    }

    @Bean(name = "acckeeper.protectDetailRecordHibernateEntireLookupDao")
    public HibernateEntireLookupDao<ProtectDetailRecord, HibernateProtectDetailRecord>
    protectDetailRecordHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                hibernateTemplate,
                new MapStructBeanTransformer<>(
                        ProtectDetailRecord.class, HibernateProtectDetailRecord.class, BeanMapper.class
                ),
                HibernateProtectDetailRecord.class
        );
    }

    @Bean(name = "acckeeper.protectDetailRecordHibernatePresetLookupDao")
    public HibernatePresetLookupDao<ProtectDetailRecord, HibernateProtectDetailRecord>
    protectDetailRecordHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                hibernateTemplate,
                new MapStructBeanTransformer<>(
                        ProtectDetailRecord.class, HibernateProtectDetailRecord.class, BeanMapper.class
                ),
                HibernateProtectDetailRecord.class,
                protectDetailRecordPresetCriteriaMaker
        );
    }

    @Bean(name = "acckeeper.deriveHistoryHibernateBatchBaseDao")
    public HibernateBatchBaseDao<LongIdKey, HibernateLongIdKey, DeriveHistory, HibernateDeriveHistory>
    deriveHistoryHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                hibernateTemplate,
                new MapStructBeanTransformer<>(LongIdKey.class, HibernateLongIdKey.class, BeanMapper.class),
                new MapStructBeanTransformer<>(
                        DeriveHistory.class, HibernateDeriveHistory.class, BeanMapper.class
                ),
                HibernateDeriveHistory.class
        );
    }

    @Bean(name = "acckeeper.deriveHistoryHibernateEntireLookupDao")
    public HibernateEntireLookupDao<DeriveHistory, HibernateDeriveHistory> deriveHistoryHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                hibernateTemplate,
                new MapStructBeanTransformer<>(
                        DeriveHistory.class, HibernateDeriveHistory.class, BeanMapper.class
                ),
                HibernateDeriveHistory.class
        );
    }

    @Bean(name = "acckeeper.deriveHistoryHibernatePresetLookupDao")
    public HibernatePresetLookupDao<DeriveHistory, HibernateDeriveHistory> deriveHistoryHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                hibernateTemplate,
                new MapStructBeanTransformer<>(
                        DeriveHistory.class, HibernateDeriveHistory.class, BeanMapper.class
                ),
                HibernateDeriveHistory.class,
                deriveHistoryPresetCriteriaMaker
        );
    }
}
