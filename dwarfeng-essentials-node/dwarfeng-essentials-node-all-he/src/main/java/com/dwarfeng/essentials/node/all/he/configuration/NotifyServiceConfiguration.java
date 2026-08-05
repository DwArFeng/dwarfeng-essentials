package com.dwarfeng.essentials.node.all.he.configuration;

import com.dwarfeng.notify.impl.service.operation.NotifyHistoryCrudOperation;
import com.dwarfeng.notify.impl.service.operation.NotifySettingCrudOperation;
import com.dwarfeng.notify.impl.service.operation.TopicCrudOperation;
import com.dwarfeng.notify.impl.service.operation.UserCrudOperation;
import com.dwarfeng.notify.stack.bean.entity.*;
import com.dwarfeng.notify.stack.bean.key.*;
import com.dwarfeng.notify.stack.cache.*;
import com.dwarfeng.notify.stack.dao.*;
import com.dwarfeng.subgrade.impl.generation.ExceptionKeyGenerator;
import com.dwarfeng.subgrade.impl.service.CustomBatchCrudService;
import com.dwarfeng.subgrade.impl.service.DaoOnlyEntireLookupService;
import com.dwarfeng.subgrade.impl.service.DaoOnlyPresetLookupService;
import com.dwarfeng.subgrade.impl.service.GeneralBatchCrudService;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.log.LogLevel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotifyServiceConfiguration {

    private final ServiceExceptionMapperConfiguration serviceExceptionMapperConfiguration;
    private final GenerateConfiguration generateConfiguration;

    private final UserCrudOperation userCrudOperation;
    private final UserDao userDao;
    private final RouterInfoDao routerInfoDao;
    private final RouterInfoCache routerInfoCache;
    private final RouterSupportDao routerSupportDao;
    private final RouterSupportCache routerSupportCache;
    private final NotifySettingCrudOperation notifySettingCrudOperation;
    private final NotifySettingDao notifySettingDao;
    private final SenderInfoDao senderInfoDao;
    private final SenderInfoCache senderInfoCache;
    private final SenderSupportDao senderSupportDao;
    private final SenderSupportCache senderSupportCache;
    private final TopicCrudOperation topicCrudOperation;
    private final TopicDao topicDao;
    private final DispatcherInfoDao dispatcherInfoDao;
    private final DispatcherInfoCache dispatcherInfoCache;
    private final DispatcherSupportDao dispatcherSupportDao;
    private final DispatcherSupportCache dispatcherSupportCache;
    private final MetaDao metaDao;
    private final MetaCache metaCache;
    private final MetaIndicatorDao metaIndicatorDao;
    private final MetaIndicatorCache metaIndicatorCache;
    private final NotifyHistoryCrudOperation notifyHistoryCrudOperation;
    private final NotifyHistoryDao notifyHistoryDao;
    private final NotifyInfoRecordDao notifyInfoRecordDao;
    private final NotifyInfoRecordCache notifyInfoRecordCache;
    private final NotifySendRecordDao notifySendRecordDao;
    private final NotifySendRecordCache notifySendRecordCache;

    @Value("${com.dwarfeng.essentials.cache.timeout.entity.notify.router_info}")
    private long routerInfoTimeout;
    @Value("${com.dwarfeng.essentials.cache.timeout.entity.notify.router_support}")
    private long routerSupportTimeout;
    @Value("${com.dwarfeng.essentials.cache.timeout.entity.notify.sender_info}")
    private long senderInfoTimeout;
    @Value("${com.dwarfeng.essentials.cache.timeout.entity.notify.sender_support}")
    private long senderSupportTimeout;
    @Value("${com.dwarfeng.essentials.cache.timeout.entity.notify.dispatcher_info}")
    private long dispatcherInfoTimeout;
    @Value("${com.dwarfeng.essentials.cache.timeout.entity.notify.dispatcher_support}")
    private long dispatcherSupportTimeout;
    @Value("${com.dwarfeng.essentials.cache.timeout.entity.notify.meta}")
    private long metaTimeout;
    @Value("${com.dwarfeng.essentials.cache.timeout.entity.notify.meta_indicator}")
    private long metaIndicatorTimeout;
    @Value("${com.dwarfeng.essentials.cache.timeout.entity.notify.notify_info_record}")
    private long notifyInfoRecordTimeout;
    @Value("${com.dwarfeng.essentials.cache.timeout.entity.notify.notify_send_record}")
    private long notifySendRecordTimeout;

    public NotifyServiceConfiguration(
            ServiceExceptionMapperConfiguration serviceExceptionMapperConfiguration,
            GenerateConfiguration generateConfiguration,
            UserCrudOperation userCrudOperation,
            UserDao userDao,
            RouterInfoDao routerInfoDao,
            RouterInfoCache routerInfoCache,
            RouterSupportDao routerSupportDao,
            RouterSupportCache routerSupportCache,
            NotifySettingCrudOperation notifySettingCrudOperation,
            NotifySettingDao notifySettingDao,
            SenderInfoDao senderInfoDao,
            SenderInfoCache senderInfoCache,
            SenderSupportDao senderSupportDao,
            SenderSupportCache senderSupportCache,
            TopicCrudOperation topicCrudOperation,
            TopicDao topicDao,
            DispatcherInfoDao dispatcherInfoDao,
            DispatcherInfoCache dispatcherInfoCache,
            DispatcherSupportDao dispatcherSupportDao,
            DispatcherSupportCache dispatcherSupportCache,
            MetaDao metaDao,
            MetaCache metaCache,
            MetaIndicatorDao metaIndicatorDao,
            MetaIndicatorCache metaIndicatorCache,
            NotifyHistoryCrudOperation notifyHistoryCrudOperation,
            NotifyHistoryDao notifyHistoryDao,
            NotifyInfoRecordDao notifyInfoRecordDao,
            NotifyInfoRecordCache notifyInfoRecordCache,
            NotifySendRecordDao notifySendRecordDao,
            NotifySendRecordCache notifySendRecordCache
    ) {
        this.serviceExceptionMapperConfiguration = serviceExceptionMapperConfiguration;
        this.generateConfiguration = generateConfiguration;
        this.userCrudOperation = userCrudOperation;
        this.userDao = userDao;
        this.routerInfoDao = routerInfoDao;
        this.routerInfoCache = routerInfoCache;
        this.routerSupportDao = routerSupportDao;
        this.routerSupportCache = routerSupportCache;
        this.notifySettingCrudOperation = notifySettingCrudOperation;
        this.notifySettingDao = notifySettingDao;
        this.senderInfoDao = senderInfoDao;
        this.senderInfoCache = senderInfoCache;
        this.senderSupportDao = senderSupportDao;
        this.senderSupportCache = senderSupportCache;
        this.topicCrudOperation = topicCrudOperation;
        this.topicDao = topicDao;
        this.dispatcherInfoDao = dispatcherInfoDao;
        this.dispatcherInfoCache = dispatcherInfoCache;
        this.dispatcherSupportDao = dispatcherSupportDao;
        this.dispatcherSupportCache = dispatcherSupportCache;
        this.metaDao = metaDao;
        this.metaCache = metaCache;
        this.metaIndicatorDao = metaIndicatorDao;
        this.metaIndicatorCache = metaIndicatorCache;
        this.notifyHistoryCrudOperation = notifyHistoryCrudOperation;
        this.notifyHistoryDao = notifyHistoryDao;
        this.notifyInfoRecordDao = notifyInfoRecordDao;
        this.notifyInfoRecordCache = notifyInfoRecordCache;
        this.notifySendRecordDao = notifySendRecordDao;
        this.notifySendRecordCache = notifySendRecordCache;
    }

    @Bean(name = "notify.userCustomBatchCrudService")
    public CustomBatchCrudService<StringIdKey, User> userCustomBatchCrudService() {
        return new CustomBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                userCrudOperation,
                new ExceptionKeyGenerator<>()
        );
    }

    @Bean(name = "notify.userDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<User> userDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                userDao
        );
    }

    @Bean(name = "notify.userDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<User> userDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                userDao
        );
    }

    @Bean(name = "notify.routerInfoGeneralBatchCrudService")
    public GeneralBatchCrudService<LongIdKey, RouterInfo> routerInfoGeneralBatchCrudService() {
        return new GeneralBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                routerInfoDao,
                routerInfoCache,
                generateConfiguration.snowflakeLongIdKeyGenerator(),
                routerInfoTimeout
        );
    }

    @Bean(name = "notify.routerInfoDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<RouterInfo> routerInfoDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                routerInfoDao
        );
    }

    @Bean(name = "notify.routerInfoDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<RouterInfo> routerInfoDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                routerInfoDao
        );
    }

    @Bean(name = "notify.routerSupportGeneralBatchCrudService")
    public GeneralBatchCrudService<StringIdKey, RouterSupport> routerSupportGeneralBatchCrudService() {
        return new GeneralBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                routerSupportDao,
                routerSupportCache,
                new ExceptionKeyGenerator<>(),
                routerSupportTimeout
        );
    }

    @Bean(name = "notify.routerSupportDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<RouterSupport> routerSupportDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                routerSupportDao
        );
    }

    @Bean(name = "notify.routerSupportDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<RouterSupport> routerSupportDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                routerSupportDao
        );
    }

    @Bean(name = "notify.notifySettingCustomBatchCrudService")
    public CustomBatchCrudService<LongIdKey, NotifySetting> notifySettingCustomBatchCrudService() {
        return new CustomBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                notifySettingCrudOperation,
                generateConfiguration.snowflakeLongIdKeyGenerator()
        );
    }

    @Bean(name = "notify.notifySettingDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<NotifySetting> notifySettingDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                notifySettingDao
        );
    }

    @Bean(name = "notify.notifySettingDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<NotifySetting> notifySettingDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                notifySettingDao
        );
    }

    @Bean(name = "notify.senderInfoCustomBatchCrudService")
    public GeneralBatchCrudService<SenderInfoKey, SenderInfo> senderInfoCustomBatchCrudService() {
        return new GeneralBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                senderInfoDao,
                senderInfoCache,
                new ExceptionKeyGenerator<>(),
                senderInfoTimeout
        );
    }

    @Bean(name = "notify.senderInfoDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<SenderInfo> senderInfoDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                senderInfoDao
        );
    }

    @Bean(name = "notify.senderInfoDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<SenderInfo> senderInfoDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                senderInfoDao
        );
    }

    @Bean(name = "notify.senderSupportGeneralBatchCrudService")
    public GeneralBatchCrudService<StringIdKey, SenderSupport> senderSupportGeneralBatchCrudService() {
        return new GeneralBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                senderSupportDao,
                senderSupportCache,
                new ExceptionKeyGenerator<>(),
                senderSupportTimeout
        );
    }

    @Bean(name = "notify.senderSupportDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<SenderSupport> senderSupportDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                senderSupportDao
        );
    }

    @Bean(name = "notify.senderSupportDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<SenderSupport> senderSupportDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                senderSupportDao
        );
    }

    @Bean(name = "notify.topicCustomBatchCrudService")
    public CustomBatchCrudService<StringIdKey, Topic> topicCustomBatchCrudService() {
        return new CustomBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                topicCrudOperation,
                new ExceptionKeyGenerator<>()
        );
    }

    @Bean(name = "notify.topicDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<Topic> topicDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                topicDao
        );
    }

    @Bean(name = "notify.topicDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<Topic> topicDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                topicDao
        );
    }

    @Bean(name = "notify.dispatcherInfoCustomBatchCrudService")
    public GeneralBatchCrudService<StringIdKey, DispatcherInfo> dispatcherInfoCustomBatchCrudService() {
        return new GeneralBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                dispatcherInfoDao,
                dispatcherInfoCache,
                new ExceptionKeyGenerator<>(),
                dispatcherInfoTimeout
        );
    }

    @Bean(name = "notify.dispatcherInfoDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<DispatcherInfo> dispatcherInfoDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                dispatcherInfoDao
        );
    }

    @Bean(name = "notify.dispatcherInfoDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<DispatcherInfo> dispatcherInfoDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                dispatcherInfoDao
        );
    }

    @Bean(name = "notify.dispatcherSupportGeneralBatchCrudService")
    public GeneralBatchCrudService<StringIdKey, DispatcherSupport> dispatcherSupportGeneralBatchCrudService() {
        return new GeneralBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                dispatcherSupportDao,
                dispatcherSupportCache,
                new ExceptionKeyGenerator<>(),
                dispatcherSupportTimeout
        );
    }

    @Bean(name = "notify.dispatcherSupportDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<DispatcherSupport> dispatcherSupportDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                dispatcherSupportDao
        );
    }

    @Bean(name = "notify.dispatcherSupportDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<DispatcherSupport> dispatcherSupportDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                dispatcherSupportDao
        );
    }

    @Bean(name = "notify.metaGeneralBatchCrudService")
    public GeneralBatchCrudService<MetaKey, Meta> metaGeneralBatchCrudService() {
        return new GeneralBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                metaDao,
                metaCache,
                new ExceptionKeyGenerator<>(),
                metaTimeout
        );
    }

    @Bean(name = "notify.metaDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<Meta> metaDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                metaDao
        );
    }

    @Bean(name = "notify.metaDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<Meta> metaDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                metaDao
        );
    }

    @Bean(name = "notify.metaIndicatorGeneralBatchCrudService")
    public GeneralBatchCrudService<MetaIndicatorKey, MetaIndicator>
    metaIndicatorGeneralBatchCrudService() {
        return new GeneralBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                metaIndicatorDao,
                metaIndicatorCache,
                new ExceptionKeyGenerator<>(),
                metaIndicatorTimeout
        );
    }

    @Bean(name = "notify.metaIndicatorDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<MetaIndicator> metaIndicatorDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                metaIndicatorDao
        );
    }

    @Bean(name = "notify.metaIndicatorDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<MetaIndicator> metaIndicatorDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                metaIndicatorDao
        );
    }

    @Bean(name = "notify.notifyHistoryCustomBatchCrudService")
    public CustomBatchCrudService<LongIdKey, NotifyHistory> notifyHistoryCustomBatchCrudService() {
        return new CustomBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                notifyHistoryCrudOperation,
                generateConfiguration.snowflakeLongIdKeyGenerator()
        );
    }

    @Bean(name = "notify.notifyHistoryDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<NotifyHistory> notifyHistoryDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                notifyHistoryDao
        );
    }

    @Bean(name = "notify.notifyHistoryDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<NotifyHistory> notifyHistoryDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                notifyHistoryDao
        );
    }

    @Bean(name = "notify.notifyInfoRecordGeneralBatchCrudService")
    public GeneralBatchCrudService<NotifyInfoRecordKey, NotifyInfoRecord> notifyInfoRecordGeneralBatchCrudService() {
        return new GeneralBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                notifyInfoRecordDao,
                notifyInfoRecordCache,
                new ExceptionKeyGenerator<>(),
                notifyInfoRecordTimeout
        );
    }

    @Bean(name = "notify.notifyInfoRecordDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<NotifyInfoRecord> notifyInfoRecordDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                notifyInfoRecordDao
        );
    }

    @Bean(name = "notify.notifyInfoRecordDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<NotifyInfoRecord> notifyInfoRecordDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                notifyInfoRecordDao
        );
    }

    @Bean(name = "notify.notifySendRecordGeneralBatchCrudService")
    public GeneralBatchCrudService<NotifySendRecordKey, NotifySendRecord> notifySendRecordGeneralBatchCrudService() {
        return new GeneralBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                notifySendRecordDao,
                notifySendRecordCache,
                new ExceptionKeyGenerator<>(),
                notifySendRecordTimeout
        );
    }

    @Bean(name = "notify.notifySendRecordDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<NotifySendRecord> notifySendRecordDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                notifySendRecordDao
        );
    }

    @Bean(name = "notify.notifySendRecordDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<NotifySendRecord> notifySendRecordDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                notifySendRecordDao
        );
    }
}
