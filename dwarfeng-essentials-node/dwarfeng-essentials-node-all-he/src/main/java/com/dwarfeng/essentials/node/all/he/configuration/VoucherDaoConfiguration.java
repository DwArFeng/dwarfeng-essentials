package com.dwarfeng.essentials.node.all.he.configuration;

import com.dwarfeng.subgrade.impl.bean.MapStructBeanTransformer;
import com.dwarfeng.subgrade.impl.dao.HibernateBatchBaseDao;
import com.dwarfeng.subgrade.impl.dao.HibernateEntireLookupDao;
import com.dwarfeng.subgrade.impl.dao.HibernatePresetLookupDao;
import com.dwarfeng.subgrade.sdk.bean.key.HibernateLongIdKey;
import com.dwarfeng.subgrade.sdk.bean.key.HibernateStringIdKey;
import com.dwarfeng.subgrade.sdk.hibernate.modification.DefaultDeletionMod;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.voucher.impl.bean.BeanMapper;
import com.dwarfeng.voucher.impl.bean.entity.*;
import com.dwarfeng.voucher.impl.bean.key.HibernateVoucherCategoryVariableKey;
import com.dwarfeng.voucher.impl.bean.key.HibernateVoucherVariableKey;
import com.dwarfeng.voucher.impl.dao.preset.*;
import com.dwarfeng.voucher.stack.bean.entity.*;
import com.dwarfeng.voucher.stack.bean.key.VoucherCategoryVariableKey;
import com.dwarfeng.voucher.stack.bean.key.VoucherVariableKey;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTemplate;

@Configuration
public class VoucherDaoConfiguration {

    private final HibernateTemplate hibernateTemplate;

    private final CheckerInfoPresetCriteriaMaker checkerInfoPresetCriteriaMaker;
    private final CheckerSupportPresetCriteriaMaker checkerSupportPresetCriteriaMaker;
    private final VoucherPresetCriteriaMaker voucherPresetCriteriaMaker;
    private final VoucherCategoryPresetCriteriaMaker voucherCategoryPresetCriteriaMaker;
    private final VoucherCategoryVariablePresetCriteriaMaker voucherCategoryVariablePresetCriteriaMaker;
    private final VoucherVariablePresetCriteriaMaker voucherVariablePresetCriteriaMaker;

    @Value("${com.dwarfeng.essentials.hibernate.jdbc.batch_size}")
    private int batchSize;

    public VoucherDaoConfiguration(
            HibernateTemplate hibernateTemplate,
            CheckerInfoPresetCriteriaMaker checkerInfoPresetCriteriaMaker,
            CheckerSupportPresetCriteriaMaker checkerSupportPresetCriteriaMaker,
            VoucherPresetCriteriaMaker voucherPresetCriteriaMaker,
            VoucherCategoryPresetCriteriaMaker voucherCategoryPresetCriteriaMaker,
            VoucherCategoryVariablePresetCriteriaMaker voucherCategoryVariablePresetCriteriaMaker,
            VoucherVariablePresetCriteriaMaker voucherVariablePresetCriteriaMaker
    ) {
        this.hibernateTemplate = hibernateTemplate;
        this.checkerInfoPresetCriteriaMaker = checkerInfoPresetCriteriaMaker;
        this.checkerSupportPresetCriteriaMaker = checkerSupportPresetCriteriaMaker;
        this.voucherPresetCriteriaMaker = voucherPresetCriteriaMaker;
        this.voucherCategoryPresetCriteriaMaker = voucherCategoryPresetCriteriaMaker;
        this.voucherCategoryVariablePresetCriteriaMaker = voucherCategoryVariablePresetCriteriaMaker;
        this.voucherVariablePresetCriteriaMaker = voucherVariablePresetCriteriaMaker;
    }

    @Bean(name = "voucher.checkerInfoHibernateBatchBaseDao")
    public HibernateBatchBaseDao<StringIdKey, HibernateStringIdKey, CheckerInfo, HibernateCheckerInfo>
    checkerInfoHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                hibernateTemplate,
                new MapStructBeanTransformer<>(StringIdKey.class, HibernateStringIdKey.class, BeanMapper.class),
                new MapStructBeanTransformer<>(CheckerInfo.class, HibernateCheckerInfo.class, BeanMapper.class),
                HibernateCheckerInfo.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean(name = "voucher.checkerInfoHibernateEntireLookupDao")
    public HibernateEntireLookupDao<CheckerInfo, HibernateCheckerInfo> checkerInfoHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                hibernateTemplate,
                new MapStructBeanTransformer<>(CheckerInfo.class, HibernateCheckerInfo.class, BeanMapper.class),
                HibernateCheckerInfo.class
        );
    }

    @Bean(name = "voucher.checkerInfoHibernatePresetLookupDao")
    public HibernatePresetLookupDao<CheckerInfo, HibernateCheckerInfo> checkerInfoHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                hibernateTemplate,
                new MapStructBeanTransformer<>(CheckerInfo.class, HibernateCheckerInfo.class, BeanMapper.class),
                HibernateCheckerInfo.class,
                checkerInfoPresetCriteriaMaker
        );
    }

    @Bean(name = "voucher.checkerSupportHibernateBatchBaseDao")
    public HibernateBatchBaseDao<StringIdKey, HibernateStringIdKey, CheckerSupport, HibernateCheckerSupport>
    checkerSupportHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                hibernateTemplate,
                new MapStructBeanTransformer<>(StringIdKey.class, HibernateStringIdKey.class, BeanMapper.class),
                new MapStructBeanTransformer<>(
                        CheckerSupport.class, HibernateCheckerSupport.class, BeanMapper.class
                ),
                HibernateCheckerSupport.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean(name = "voucher.checkerSupportHibernateEntireLookupDao")
    public HibernateEntireLookupDao<CheckerSupport, HibernateCheckerSupport> checkerSupportHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                hibernateTemplate,
                new MapStructBeanTransformer<>(
                        CheckerSupport.class, HibernateCheckerSupport.class, BeanMapper.class
                ),
                HibernateCheckerSupport.class
        );
    }

    @Bean(name = "voucher.checkerSupportHibernatePresetLookupDao")
    public HibernatePresetLookupDao<CheckerSupport, HibernateCheckerSupport> checkerSupportHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                hibernateTemplate,
                new MapStructBeanTransformer<>(
                        CheckerSupport.class, HibernateCheckerSupport.class, BeanMapper.class
                ),
                HibernateCheckerSupport.class,
                checkerSupportPresetCriteriaMaker
        );
    }

    @Bean(name = "voucher.voucherHibernateBatchBaseDao")
    public HibernateBatchBaseDao<LongIdKey, HibernateLongIdKey, Voucher, HibernateVoucher>
    voucherHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                hibernateTemplate,
                new MapStructBeanTransformer<>(LongIdKey.class, HibernateLongIdKey.class, BeanMapper.class),
                new MapStructBeanTransformer<>(Voucher.class, HibernateVoucher.class, BeanMapper.class),
                HibernateVoucher.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean(name = "voucher.voucherHibernateEntireLookupDao")
    public HibernateEntireLookupDao<Voucher, HibernateVoucher> voucherHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                hibernateTemplate,
                new MapStructBeanTransformer<>(Voucher.class, HibernateVoucher.class, BeanMapper.class),
                HibernateVoucher.class
        );
    }

    @Bean(name = "voucher.voucherHibernatePresetLookupDao")
    public HibernatePresetLookupDao<Voucher, HibernateVoucher> voucherHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                hibernateTemplate,
                new MapStructBeanTransformer<>(Voucher.class, HibernateVoucher.class, BeanMapper.class),
                HibernateVoucher.class,
                voucherPresetCriteriaMaker
        );
    }

    @Bean(name = "voucher.voucherCategoryHibernateBatchBaseDao")
    public HibernateBatchBaseDao<StringIdKey, HibernateStringIdKey, VoucherCategory, HibernateVoucherCategory>
    voucherCategoryHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                hibernateTemplate,
                new MapStructBeanTransformer<>(
                        StringIdKey.class, HibernateStringIdKey.class, BeanMapper.class
                ),
                new MapStructBeanTransformer<>(
                        VoucherCategory.class, HibernateVoucherCategory.class, BeanMapper.class
                ),
                HibernateVoucherCategory.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean(name = "voucher.voucherCategoryHibernateEntireLookupDao")
    public HibernateEntireLookupDao<VoucherCategory, HibernateVoucherCategory>
    voucherCategoryHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                hibernateTemplate,
                new MapStructBeanTransformer<>(
                        VoucherCategory.class, HibernateVoucherCategory.class, BeanMapper.class
                ),
                HibernateVoucherCategory.class
        );
    }

    @Bean(name = "voucher.voucherCategoryHibernatePresetLookupDao")
    public HibernatePresetLookupDao<VoucherCategory, HibernateVoucherCategory>
    voucherCategoryHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                hibernateTemplate,
                new MapStructBeanTransformer<>(
                        VoucherCategory.class, HibernateVoucherCategory.class, BeanMapper.class
                ),
                HibernateVoucherCategory.class,
                voucherCategoryPresetCriteriaMaker
        );
    }

    @Bean(name = "voucher.voucherCategoryVariableHibernateBatchBaseDao")
    public HibernateBatchBaseDao<VoucherCategoryVariableKey, HibernateVoucherCategoryVariableKey,
            VoucherCategoryVariable, HibernateVoucherCategoryVariable> voucherCategoryVariableHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                hibernateTemplate,
                new MapStructBeanTransformer<>(
                        VoucherCategoryVariableKey.class, HibernateVoucherCategoryVariableKey.class, BeanMapper.class
                ),
                new MapStructBeanTransformer<>(
                        VoucherCategoryVariable.class, HibernateVoucherCategoryVariable.class, BeanMapper.class
                ),
                HibernateVoucherCategoryVariable.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean(name = "voucher.voucherCategoryVariableHibernateEntireLookupDao")
    public HibernateEntireLookupDao<VoucherCategoryVariable, HibernateVoucherCategoryVariable>
    voucherCategoryVariableHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                hibernateTemplate,
                new MapStructBeanTransformer<>(
                        VoucherCategoryVariable.class, HibernateVoucherCategoryVariable.class, BeanMapper.class
                ),
                HibernateVoucherCategoryVariable.class
        );
    }

    @Bean(name = "voucher.voucherCategoryVariableHibernatePresetLookupDao")
    public HibernatePresetLookupDao<VoucherCategoryVariable, HibernateVoucherCategoryVariable>
    voucherCategoryVariableHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                hibernateTemplate,
                new MapStructBeanTransformer<>(
                        VoucherCategoryVariable.class, HibernateVoucherCategoryVariable.class, BeanMapper.class
                ),
                HibernateVoucherCategoryVariable.class,
                voucherCategoryVariablePresetCriteriaMaker
        );
    }

    @Bean(name = "voucher.voucherVariableHibernateBatchBaseDao")
    public HibernateBatchBaseDao<VoucherVariableKey, HibernateVoucherVariableKey, VoucherVariable,
            HibernateVoucherVariable> voucherVariableHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                hibernateTemplate,
                new MapStructBeanTransformer<>(
                        VoucherVariableKey.class, HibernateVoucherVariableKey.class, BeanMapper.class
                ),
                new MapStructBeanTransformer<>(
                        VoucherVariable.class, HibernateVoucherVariable.class, BeanMapper.class
                ),
                HibernateVoucherVariable.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean(name = "voucher.voucherVariableHibernateEntireLookupDao")
    public HibernateEntireLookupDao<VoucherVariable, HibernateVoucherVariable>
    voucherVariableHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                hibernateTemplate,
                new MapStructBeanTransformer<>(
                        VoucherVariable.class, HibernateVoucherVariable.class, BeanMapper.class
                ),
                HibernateVoucherVariable.class
        );
    }

    @Bean(name = "voucher.voucherVariableHibernatePresetLookupDao")
    public HibernatePresetLookupDao<VoucherVariable, HibernateVoucherVariable>
    voucherVariableHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                hibernateTemplate,
                new MapStructBeanTransformer<>(
                        VoucherVariable.class, HibernateVoucherVariable.class, BeanMapper.class
                ),
                HibernateVoucherVariable.class,
                voucherVariablePresetCriteriaMaker
        );
    }
}
