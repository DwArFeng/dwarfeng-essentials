package com.dwarfeng.essentials.node.all.he.configuration;

import com.dwarfeng.audit.impl.service.operation.*;
import com.dwarfeng.audit.stack.bean.entity.*;
import com.dwarfeng.audit.stack.bean.key.AuditEntryPropertyKey;
import com.dwarfeng.audit.stack.bean.key.AuditPropertyIndicatorKey;
import com.dwarfeng.audit.stack.bean.key.InspectorVariableKey;
import com.dwarfeng.audit.stack.cache.*;
import com.dwarfeng.audit.stack.dao.*;
import com.dwarfeng.subgrade.impl.generation.DenseUuidStringKeyGenerator;
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
public class AuditServiceConfiguration {

    private final ServiceExceptionMapperConfiguration serviceExceptionMapperConfiguration;
    private final GenerateConfiguration generateConfiguration;

    private final AuditCategoryCrudOperation auditCategoryCrudOperation;
    private final AuditCategoryDao auditCategoryDao;
    private final AuditPropertyIndicatorDao auditPropertyIndicatorDao;
    private final AuditPropertyIndicatorCache auditPropertyIndicatorCache;
    private final AuditEntryCrudOperation auditEntryCrudOperation;
    private final AuditEntryDao auditEntryDao;
    private final AuditEntryPropertyDao auditEntryPropertyDao;
    private final AuditEntryPropertyCache auditEntryPropertyCache;
    private final InspectionAlarmTypeIndicatorDao inspectionAlarmTypeIndicatorDao;
    private final InspectionAlarmTypeIndicatorCache inspectionAlarmTypeIndicatorCache;
    private final InspectionCrudOperation inspectionCrudOperation;
    private final InspectionDao inspectionDao;
    private final InspectionAlarmDao inspectionAlarmDao;
    private final InspectionAlarmCache inspectionAlarmCache;
    private final InspectionDriverInfoDao inspectionDriverInfoDao;
    private final InspectionDriverInfoCache inspectionDriverInfoCache;
    private final InspectionDriverSupportDao inspectionDriverSupportDao;
    private final InspectionDriverSupportCache inspectionDriverSupportCache;
    private final InspectionTaskCrudOperation inspectionTaskCrudOperation;
    private final InspectionTaskDao inspectionTaskDao;
    private final InspectionTaskEventDao inspectionTaskEventDao;
    private final InspectionTaskEventCache inspectionTaskEventCache;
    private final InspectorInfoCrudOperation inspectorInfoCrudOperation;
    private final InspectorInfoDao inspectorInfoDao;
    private final InspectorSupportDao inspectorSupportDao;
    private final InspectorSupportCache inspectorSupportCache;
    private final InspectorVariableDao inspectorVariableDao;
    private final InspectorVariableCache inspectorVariableCache;

    @Value("${com.dwarfeng.essentials.cache.timeout.entity.audit.audit_property_indicator}")
    private long auditPropertyIndicatorTimeout;

    @Value("${com.dwarfeng.essentials.cache.timeout.entity.audit.audit_entry_property}")
    private long auditEntryPropertyTimeout;
    @Value("${cache.timeout.entity.inspection_alarm_type_indicator}")
    private long inspectionAlarmTypeIndicatorTimeout;
    @Value("${cache.timeout.entity.inspection_alarm}")
    private long inspectionAlarmTimeout;
    @Value("${cache.timeout.entity.inspection_driver_info}")
    private long inspectionDriverInfoTimeout;
    @Value("${cache.timeout.entity.inspection_driver_support}")
    private long inspectionDriverSupportTimeout;
    @Value("${cache.timeout.entity.inspection_task_event}")
    private long inspectionTaskEventTimeout;
    @Value("${cache.timeout.entity.inspector_support}")
    private long inspectorSupportTimeout;
    @Value("${cache.timeout.entity.inspector_variable}")
    private long inspectorVariableTimeout;

    public AuditServiceConfiguration(
            ServiceExceptionMapperConfiguration serviceExceptionMapperConfiguration,
            GenerateConfiguration generateConfiguration,
            AuditCategoryCrudOperation auditCategoryCrudOperation,
            AuditCategoryDao auditCategoryDao,
            AuditPropertyIndicatorDao auditPropertyIndicatorDao,
            AuditPropertyIndicatorCache auditPropertyIndicatorCache,
            AuditEntryCrudOperation auditEntryCrudOperation,
            AuditEntryDao auditEntryDao,
            AuditEntryPropertyDao auditEntryPropertyDao,
            AuditEntryPropertyCache auditEntryPropertyCache,
            InspectionAlarmTypeIndicatorDao inspectionAlarmTypeIndicatorDao,
            InspectionAlarmTypeIndicatorCache inspectionAlarmTypeIndicatorCache,
            InspectionCrudOperation inspectionCrudOperation,
            InspectionDao inspectionDao,
            InspectionAlarmDao inspectionAlarmDao,
            InspectionAlarmCache inspectionAlarmCache,
            InspectionDriverInfoDao inspectionDriverInfoDao,
            InspectionDriverInfoCache inspectionDriverInfoCache,
            InspectionDriverSupportDao inspectionDriverSupportDao,
            InspectionDriverSupportCache inspectionDriverSupportCache,
            InspectionTaskCrudOperation inspectionTaskCrudOperation,
            InspectionTaskDao inspectionTaskDao,
            InspectionTaskEventDao inspectionTaskEventDao,
            InspectionTaskEventCache inspectionTaskEventCache,
            InspectorInfoCrudOperation inspectorInfoCrudOperation,
            InspectorInfoDao inspectorInfoDao,
            InspectorSupportDao inspectorSupportDao,
            InspectorSupportCache inspectorSupportCache,
            InspectorVariableDao inspectorVariableDao,
            InspectorVariableCache inspectorVariableCache
    ) {
        this.serviceExceptionMapperConfiguration = serviceExceptionMapperConfiguration;
        this.generateConfiguration = generateConfiguration;
        this.auditCategoryCrudOperation = auditCategoryCrudOperation;
        this.auditCategoryDao = auditCategoryDao;
        this.auditPropertyIndicatorDao = auditPropertyIndicatorDao;
        this.auditPropertyIndicatorCache = auditPropertyIndicatorCache;
        this.auditEntryCrudOperation = auditEntryCrudOperation;
        this.auditEntryDao = auditEntryDao;
        this.auditEntryPropertyDao = auditEntryPropertyDao;
        this.auditEntryPropertyCache = auditEntryPropertyCache;
        this.inspectionAlarmTypeIndicatorDao = inspectionAlarmTypeIndicatorDao;
        this.inspectionAlarmTypeIndicatorCache = inspectionAlarmTypeIndicatorCache;
        this.inspectionCrudOperation = inspectionCrudOperation;
        this.inspectionDao = inspectionDao;
        this.inspectionAlarmDao = inspectionAlarmDao;
        this.inspectionAlarmCache = inspectionAlarmCache;
        this.inspectionDriverInfoDao = inspectionDriverInfoDao;
        this.inspectionDriverInfoCache = inspectionDriverInfoCache;
        this.inspectionDriverSupportDao = inspectionDriverSupportDao;
        this.inspectionDriverSupportCache = inspectionDriverSupportCache;
        this.inspectionTaskCrudOperation = inspectionTaskCrudOperation;
        this.inspectionTaskDao = inspectionTaskDao;
        this.inspectionTaskEventDao = inspectionTaskEventDao;
        this.inspectionTaskEventCache = inspectionTaskEventCache;
        this.inspectorInfoCrudOperation = inspectorInfoCrudOperation;
        this.inspectorInfoDao = inspectorInfoDao;
        this.inspectorSupportDao = inspectorSupportDao;
        this.inspectorSupportCache = inspectorSupportCache;
        this.inspectorVariableDao = inspectorVariableDao;
        this.inspectorVariableCache = inspectorVariableCache;
    }

    @Bean(name = "audit.auditCategoryCustomBatchCrudService")
    public CustomBatchCrudService<StringIdKey, AuditCategory> auditCategoryCustomBatchCrudService() {
        return new CustomBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                auditCategoryCrudOperation,
                new DenseUuidStringKeyGenerator()
        );
    }

    @Bean(name = "audit.auditCategoryDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<AuditCategory> auditCategoryDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                auditCategoryDao
        );
    }

    @Bean(name = "audit.auditCategoryDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<AuditCategory> auditCategoryDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                auditCategoryDao
        );
    }

    @Bean(name = "audit.auditPropertyIndicatorGeneralBatchCrudService")
    public GeneralBatchCrudService<AuditPropertyIndicatorKey, AuditPropertyIndicator>
    auditPropertyIndicatorGeneralBatchCrudService() {
        return new GeneralBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                auditPropertyIndicatorDao,
                auditPropertyIndicatorCache,
                new ExceptionKeyGenerator<>(),
                auditPropertyIndicatorTimeout
        );
    }

    @Bean(name = "audit.auditPropertyIndicatorDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<AuditPropertyIndicator> auditPropertyIndicatorDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                auditPropertyIndicatorDao
        );
    }

    @Bean(name = "audit.auditPropertyIndicatorDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<AuditPropertyIndicator> auditPropertyIndicatorDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                auditPropertyIndicatorDao
        );
    }

    @Bean(name = "audit.auditEntryCustomBatchCrudService")
    public CustomBatchCrudService<LongIdKey, AuditEntry> auditEntryCustomBatchCrudService() {
        return new CustomBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                auditEntryCrudOperation,
                generateConfiguration.snowflakeLongIdKeyGenerator()
        );
    }

    @Bean(name = "audit.auditEntryDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<AuditEntry> auditEntryDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                auditEntryDao
        );
    }

    @Bean(name = "audit.auditEntryDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<AuditEntry> auditEntryDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                auditEntryDao
        );
    }

    @Bean(name = "audit.auditEntryPropertyGeneralBatchCrudService")
    public GeneralBatchCrudService<AuditEntryPropertyKey, AuditEntryProperty>
    auditEntryPropertyGeneralBatchCrudService() {
        return new GeneralBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                auditEntryPropertyDao,
                auditEntryPropertyCache,
                new ExceptionKeyGenerator<>(),
                auditEntryPropertyTimeout
        );
    }

    @Bean(name = "audit.auditEntryPropertyDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<AuditEntryProperty> auditEntryPropertyDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                auditEntryPropertyDao
        );
    }

    @Bean(name = "audit.auditEntryPropertyDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<AuditEntryProperty> auditEntryPropertyDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                auditEntryPropertyDao
        );
    }

    @Bean(name = "audit.inspectionAlarmTypeIndicatorGeneralBatchCrudService")
    public GeneralBatchCrudService<StringIdKey, InspectionAlarmTypeIndicator>
    inspectionAlarmTypeIndicatorGeneralBatchCrudService() {
        return new GeneralBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                inspectionAlarmTypeIndicatorDao,
                inspectionAlarmTypeIndicatorCache,
                new ExceptionKeyGenerator<>(),
                inspectionAlarmTypeIndicatorTimeout
        );
    }

    @Bean(name = "audit.inspectionAlarmTypeIndicatorDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<InspectionAlarmTypeIndicator>
    inspectionAlarmTypeIndicatorDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                inspectionAlarmTypeIndicatorDao
        );
    }

    @Bean(name = "audit.inspectionAlarmTypeIndicatorDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<InspectionAlarmTypeIndicator>
    inspectionAlarmTypeIndicatorDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                inspectionAlarmTypeIndicatorDao
        );
    }

    @Bean(name = "audit.inspectionCustomBatchCrudService")
    public CustomBatchCrudService<LongIdKey, Inspection> inspectionCustomBatchCrudService() {
        return new CustomBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                inspectionCrudOperation,
                generateConfiguration.snowflakeLongIdKeyGenerator()
        );
    }

    @Bean(name = "audit.inspectionDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<Inspection> inspectionDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                inspectionDao
        );
    }

    @Bean(name = "audit.inspectionDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<Inspection> inspectionDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                inspectionDao
        );
    }

    @Bean(name = "audit.inspectionAlarmGeneralBatchCrudService")
    public GeneralBatchCrudService<LongIdKey, InspectionAlarm> inspectionAlarmGeneralBatchCrudService() {
        return new GeneralBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                inspectionAlarmDao,
                inspectionAlarmCache,
                generateConfiguration.snowflakeLongIdKeyGenerator(),
                inspectionAlarmTimeout
        );
    }

    @Bean(name = "audit.inspectionAlarmDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<InspectionAlarm> inspectionAlarmDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                inspectionAlarmDao
        );
    }

    @Bean(name = "audit.inspectionAlarmDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<InspectionAlarm> inspectionAlarmDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                inspectionAlarmDao
        );
    }

    @Bean(name = "audit.inspectionDriverInfoGeneralBatchCrudService")
    public GeneralBatchCrudService<LongIdKey, InspectionDriverInfo> inspectionDriverInfoGeneralBatchCrudService() {
        return new GeneralBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                inspectionDriverInfoDao,
                inspectionDriverInfoCache,
                generateConfiguration.snowflakeLongIdKeyGenerator(),
                inspectionDriverInfoTimeout
        );
    }

    @Bean(name = "audit.inspectionDriverInfoDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<InspectionDriverInfo> inspectionDriverInfoDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                inspectionDriverInfoDao
        );
    }

    @Bean(name = "audit.inspectionDriverInfoDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<InspectionDriverInfo> inspectionDriverInfoDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                inspectionDriverInfoDao
        );
    }

    @Bean(name = "audit.inspectionDriverSupportGeneralBatchCrudService")
    public GeneralBatchCrudService<StringIdKey, InspectionDriverSupport>
    inspectionDriverSupportGeneralBatchCrudService() {
        return new GeneralBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                inspectionDriverSupportDao,
                inspectionDriverSupportCache,
                new ExceptionKeyGenerator<>(),
                inspectionDriverSupportTimeout
        );
    }

    @Bean(name = "audit.inspectionDriverSupportDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<InspectionDriverSupport> inspectionDriverSupportDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                inspectionDriverSupportDao
        );
    }

    @Bean(name = "audit.inspectionDriverSupportDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<InspectionDriverSupport> inspectionDriverSupportDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                inspectionDriverSupportDao
        );
    }

    @Bean(name = "audit.inspectionTaskCustomBatchCrudService")
    public CustomBatchCrudService<LongIdKey, InspectionTask> inspectionTaskCustomBatchCrudService() {
        return new CustomBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                inspectionTaskCrudOperation,
                generateConfiguration.snowflakeLongIdKeyGenerator()
        );
    }

    @Bean(name = "audit.inspectionTaskDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<InspectionTask> inspectionTaskDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                inspectionTaskDao
        );
    }

    @Bean(name = "audit.inspectionTaskDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<InspectionTask> inspectionTaskDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                inspectionTaskDao
        );
    }

    @Bean(name = "audit.inspectionTaskEventGeneralBatchCrudService")
    public GeneralBatchCrudService<LongIdKey, InspectionTaskEvent> inspectionTaskEventGeneralBatchCrudService() {
        return new GeneralBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                inspectionTaskEventDao,
                inspectionTaskEventCache,
                generateConfiguration.snowflakeLongIdKeyGenerator(),
                inspectionTaskEventTimeout
        );
    }

    @Bean(name = "audit.inspectionTaskEventDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<InspectionTaskEvent> inspectionTaskEventDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                inspectionTaskEventDao
        );
    }

    @Bean(name = "audit.inspectionTaskEventDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<InspectionTaskEvent> inspectionTaskEventDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                inspectionTaskEventDao
        );
    }

    @Bean(name = "audit.inspectorInfoCustomBatchCrudService")
    public CustomBatchCrudService<LongIdKey, InspectorInfo> inspectorInfoCustomBatchCrudService() {
        return new CustomBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                inspectorInfoCrudOperation,
                generateConfiguration.snowflakeLongIdKeyGenerator()
        );
    }

    @Bean(name = "audit.inspectorInfoDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<InspectorInfo> inspectorInfoDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                inspectorInfoDao
        );
    }

    @Bean(name = "audit.inspectorInfoDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<InspectorInfo> inspectorInfoDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                inspectorInfoDao
        );
    }

    @Bean(name = "audit.inspectorSupportGeneralBatchCrudService")
    public GeneralBatchCrudService<StringIdKey, InspectorSupport> inspectorSupportGeneralBatchCrudService() {
        return new GeneralBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                inspectorSupportDao,
                inspectorSupportCache,
                new ExceptionKeyGenerator<>(),
                inspectorSupportTimeout
        );
    }

    @Bean(name = "audit.inspectorSupportDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<InspectorSupport> inspectorSupportDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                inspectorSupportDao
        );
    }

    @Bean(name = "audit.inspectorSupportDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<InspectorSupport> inspectorSupportDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                inspectorSupportDao
        );
    }

    @Bean(name = "audit.inspectorVariableGeneralBatchCrudService")
    public GeneralBatchCrudService<InspectorVariableKey, InspectorVariable>
    inspectorVariableGeneralBatchCrudService() {
        return new GeneralBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                inspectorVariableDao,
                inspectorVariableCache,
                new ExceptionKeyGenerator<>(),
                inspectorVariableTimeout
        );
    }

    @Bean(name = "audit.inspectorVariableDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<InspectorVariable> inspectorVariableDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                inspectorVariableDao
        );
    }

    @Bean(name = "audit.inspectorVariableDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<InspectorVariable> inspectorVariableDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                inspectorVariableDao
        );
    }
}
