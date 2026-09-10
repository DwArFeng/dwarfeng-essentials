package com.dwarfeng.essentials.node.all.he.configuration;

import com.dwarfeng.logicengine.impl.service.operation.SectionCrudOperation;
import com.dwarfeng.logicengine.impl.service.operation.StateCrudOperation;
import com.dwarfeng.logicengine.impl.service.operation.TaskCrudOperation;
import com.dwarfeng.logicengine.stack.bean.entity.*;
import com.dwarfeng.logicengine.stack.bean.key.StateKey;
import com.dwarfeng.logicengine.stack.bean.key.TaskVariableKey;
import com.dwarfeng.logicengine.stack.cache.*;
import com.dwarfeng.logicengine.stack.dao.*;
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
public class LogicengineServiceConfiguration {

    private final ServiceExceptionMapperConfiguration serviceExceptionMapperConfiguration;
    private final GenerateConfiguration generateConfiguration;

    private final SectionCrudOperation sectionCrudOperation;
    private final SectionDao sectionDao;

    private final StateCrudOperation stateCrudOperation;
    private final StateDao stateDao;

    private final DriverInfoDao driverInfoDao;
    private final DriverInfoCache driverInfoCache;

    private final DriverSupportDao driverSupportDao;
    private final DriverSupportCache driverSupportCache;

    private final GuarderInfoDao guarderInfoDao;
    private final GuarderInfoCache guarderInfoCache;

    private final GuarderSupportDao guarderSupportDao;
    private final GuarderSupportCache guarderSupportCache;

    private final PerformerInfoDao performerInfoDao;
    private final PerformerInfoCache performerInfoCache;

    private final PerformerSupportDao performerSupportDao;
    private final PerformerSupportCache performerSupportCache;

    private final TaskCrudOperation taskCrudOperation;
    private final TaskDao taskDao;

    private final TaskEventDao taskEventDao;
    private final TaskEventCache taskEventCache;

    private final TaskVariableDao taskVariableDao;
    private final TaskVariableCache taskVariableCache;

    @Value("${com.dwarfeng.essentials.cache.timeout.entity.logicengine.driver_info}")
    private long driverInfoTimeout;
    @Value("${com.dwarfeng.essentials.cache.timeout.entity.logicengine.driver_support}")
    private long driverSupportTimeout;
    @Value("${com.dwarfeng.essentials.cache.timeout.entity.logicengine.guarder_info}")
    private long guarderInfoTimeout;
    @Value("${com.dwarfeng.essentials.cache.timeout.entity.logicengine.guarder_support}")
    private long guarderSupportTimeout;
    @Value("${com.dwarfeng.essentials.cache.timeout.entity.logicengine.performer_info}")
    private long performerInfoTimeout;
    @Value("${com.dwarfeng.essentials.cache.timeout.entity.logicengine.performer_support}")
    private long performerSupportTimeout;
    @Value("${com.dwarfeng.essentials.cache.timeout.entity.logicengine.task_event}")
    private long taskEventTimeout;
    @Value("${com.dwarfeng.essentials.cache.timeout.entity.logicengine.task_variable}")
    private long taskVariableTimeout;

    public LogicengineServiceConfiguration(
            ServiceExceptionMapperConfiguration serviceExceptionMapperConfiguration,
            GenerateConfiguration generateConfiguration,
            SectionCrudOperation sectionCrudOperation,
            SectionDao sectionDao,
            StateCrudOperation stateCrudOperation,
            StateDao stateDao,
            DriverInfoDao driverInfoDao,
            DriverInfoCache driverInfoCache,
            DriverSupportDao driverSupportDao,
            DriverSupportCache driverSupportCache,
            GuarderInfoDao guarderInfoDao,
            GuarderInfoCache guarderInfoCache,
            GuarderSupportDao guarderSupportDao,
            GuarderSupportCache guarderSupportCache,
            PerformerInfoDao performerInfoDao,
            PerformerInfoCache performerInfoCache,
            PerformerSupportDao performerSupportDao,
            PerformerSupportCache performerSupportCache,
            TaskCrudOperation taskCrudOperation,
            TaskDao taskDao,
            TaskEventDao taskEventDao,
            TaskEventCache taskEventCache,
            TaskVariableDao taskVariableDao,
            TaskVariableCache taskVariableCache
    ) {
        this.serviceExceptionMapperConfiguration = serviceExceptionMapperConfiguration;
        this.generateConfiguration = generateConfiguration;
        this.sectionCrudOperation = sectionCrudOperation;
        this.sectionDao = sectionDao;
        this.stateCrudOperation = stateCrudOperation;
        this.stateDao = stateDao;
        this.driverInfoDao = driverInfoDao;
        this.driverInfoCache = driverInfoCache;
        this.driverSupportDao = driverSupportDao;
        this.driverSupportCache = driverSupportCache;
        this.guarderInfoDao = guarderInfoDao;
        this.guarderInfoCache = guarderInfoCache;
        this.guarderSupportDao = guarderSupportDao;
        this.guarderSupportCache = guarderSupportCache;
        this.performerInfoDao = performerInfoDao;
        this.performerInfoCache = performerInfoCache;
        this.performerSupportDao = performerSupportDao;
        this.performerSupportCache = performerSupportCache;
        this.taskCrudOperation = taskCrudOperation;
        this.taskDao = taskDao;
        this.taskEventDao = taskEventDao;
        this.taskEventCache = taskEventCache;
        this.taskVariableDao = taskVariableDao;
        this.taskVariableCache = taskVariableCache;
    }

    @Bean(name = "logicengine.sectionCustomBatchCrudService")
    public CustomBatchCrudService<LongIdKey, Section> sectionCustomBatchCrudService() {
        return new CustomBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                sectionCrudOperation,
                generateConfiguration.snowflakeLongIdKeyGenerator()
        );
    }

    @Bean(name = "logicengine.sectionDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<Section> sectionDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                sectionDao
        );
    }

    @Bean(name = "logicengine.sectionDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<Section> sectionDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                sectionDao
        );
    }

    @Bean(name = "logicengine.stateCustomBatchCrudService")
    public CustomBatchCrudService<StateKey, State> stateCustomBatchCrudService() {
        return new CustomBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                stateCrudOperation,
                new ExceptionKeyGenerator<>()
        );
    }

    @Bean(name = "logicengine.stateDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<State> stateDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                stateDao
        );
    }

    @Bean(name = "logicengine.stateDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<State> stateDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                stateDao
        );
    }

    @Bean(name = "logicengine.driverInfoGeneralBatchCrudService")
    public GeneralBatchCrudService<LongIdKey, DriverInfo> driverInfoGeneralBatchCrudService() {
        return new GeneralBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                driverInfoDao,
                driverInfoCache,
                generateConfiguration.snowflakeLongIdKeyGenerator(),
                driverInfoTimeout
        );
    }

    @Bean(name = "logicengine.driverInfoDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<DriverInfo> driverInfoDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                driverInfoDao
        );
    }

    @Bean(name = "logicengine.driverInfoDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<DriverInfo> driverInfoDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                driverInfoDao
        );
    }

    @Bean(name = "logicengine.driverSupportGeneralBatchCrudService")
    public GeneralBatchCrudService<StringIdKey, DriverSupport> driverSupportGeneralBatchCrudService() {
        return new GeneralBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                driverSupportDao,
                driverSupportCache,
                new ExceptionKeyGenerator<>(),
                driverSupportTimeout
        );
    }

    @Bean(name = "logicengine.driverSupportDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<DriverSupport> driverSupportDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                driverSupportDao
        );
    }

    @Bean(name = "logicengine.driverSupportDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<DriverSupport> driverSupportDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                driverSupportDao
        );
    }

    @Bean(name = "logicengine.guarderInfoGeneralBatchCrudService")
    public GeneralBatchCrudService<LongIdKey, GuarderInfo> guarderInfoGeneralBatchCrudService() {
        return new GeneralBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                guarderInfoDao,
                guarderInfoCache,
                generateConfiguration.snowflakeLongIdKeyGenerator(),
                guarderInfoTimeout
        );
    }

    @Bean(name = "logicengine.guarderInfoDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<GuarderInfo> guarderInfoDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                guarderInfoDao
        );
    }

    @Bean(name = "logicengine.guarderInfoDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<GuarderInfo> guarderInfoDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                guarderInfoDao
        );
    }

    @Bean(name = "logicengine.guarderSupportGeneralBatchCrudService")
    public GeneralBatchCrudService<StringIdKey, GuarderSupport> guarderSupportGeneralBatchCrudService() {
        return new GeneralBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                guarderSupportDao,
                guarderSupportCache,
                new ExceptionKeyGenerator<>(),
                guarderSupportTimeout
        );
    }

    @Bean(name = "logicengine.guarderSupportDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<GuarderSupport> guarderSupportDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                guarderSupportDao
        );
    }

    @Bean(name = "logicengine.guarderSupportDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<GuarderSupport> guarderSupportDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                guarderSupportDao
        );
    }

    @Bean(name = "logicengine.performerInfoGeneralBatchCrudService")
    public GeneralBatchCrudService<LongIdKey, PerformerInfo> performerInfoGeneralBatchCrudService() {
        return new GeneralBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                performerInfoDao,
                performerInfoCache,
                generateConfiguration.snowflakeLongIdKeyGenerator(),
                performerInfoTimeout
        );
    }

    @Bean(name = "logicengine.performerInfoDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<PerformerInfo> performerInfoDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                performerInfoDao
        );
    }

    @Bean(name = "logicengine.performerInfoDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<PerformerInfo> performerInfoDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                performerInfoDao
        );
    }

    @Bean(name = "logicengine.performerSupportGeneralBatchCrudService")
    public GeneralBatchCrudService<StringIdKey, PerformerSupport> performerSupportGeneralBatchCrudService() {
        return new GeneralBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                performerSupportDao,
                performerSupportCache,
                new ExceptionKeyGenerator<>(),
                performerSupportTimeout
        );
    }

    @Bean(name = "logicengine.performerSupportDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<PerformerSupport> performerSupportDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                performerSupportDao
        );
    }

    @Bean(name = "logicengine.performerSupportDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<PerformerSupport> performerSupportDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                performerSupportDao
        );
    }

    @Bean(name = "logicengine.taskCustomBatchCrudService")
    public CustomBatchCrudService<LongIdKey, Task> taskCustomBatchCrudService() {
        return new CustomBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                taskCrudOperation,
                generateConfiguration.snowflakeLongIdKeyGenerator()
        );
    }

    @Bean(name = "logicengine.taskDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<Task> taskDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                taskDao
        );
    }

    @Bean(name = "logicengine.taskDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<Task> taskDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                taskDao
        );
    }

    @Bean(name = "logicengine.taskEventGeneralBatchCrudService")
    public GeneralBatchCrudService<LongIdKey, TaskEvent> taskEventGeneralBatchCrudService() {
        return new GeneralBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                taskEventDao,
                taskEventCache,
                generateConfiguration.snowflakeLongIdKeyGenerator(),
                taskEventTimeout
        );
    }

    @Bean(name = "logicengine.taskEventDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<TaskEvent> taskEventDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                taskEventDao
        );
    }

    @Bean(name = "logicengine.taskEventDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<TaskEvent> taskEventDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                taskEventDao
        );
    }

    @Bean(name = "logicengine.taskVariableGeneralBatchCrudService")
    public GeneralBatchCrudService<TaskVariableKey, TaskVariable> taskVariableGeneralBatchCrudService() {
        return new GeneralBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                taskVariableDao,
                taskVariableCache,
                new ExceptionKeyGenerator<>(),
                taskVariableTimeout
        );
    }

    @Bean(name = "logicengine.taskVariableDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<TaskVariable> taskVariableDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                taskVariableDao
        );
    }

    @Bean(name = "logicengine.taskVariableDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<TaskVariable> taskVariableDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                taskVariableDao
        );
    }
}
