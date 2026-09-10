package com.dwarfeng.essentials.node.all.he.configuration;

import com.dwarfeng.logicengine.impl.bean.BeanMapper;
import com.dwarfeng.logicengine.impl.bean.entity.*;
import com.dwarfeng.logicengine.impl.bean.key.HibernateStateKey;
import com.dwarfeng.logicengine.impl.bean.key.HibernateTaskVariableKey;
import com.dwarfeng.logicengine.impl.dao.preset.*;
import com.dwarfeng.logicengine.stack.bean.entity.*;
import com.dwarfeng.logicengine.stack.bean.key.StateKey;
import com.dwarfeng.logicengine.stack.bean.key.TaskVariableKey;
import com.dwarfeng.subgrade.impl.bean.MapStructBeanTransformer;
import com.dwarfeng.subgrade.impl.dao.HibernateBatchBaseDao;
import com.dwarfeng.subgrade.impl.dao.HibernateEntireLookupDao;
import com.dwarfeng.subgrade.impl.dao.HibernatePresetLookupDao;
import com.dwarfeng.subgrade.sdk.bean.key.HibernateLongIdKey;
import com.dwarfeng.subgrade.sdk.bean.key.HibernateStringIdKey;
import com.dwarfeng.subgrade.sdk.hibernate.modification.DefaultDeletionMod;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTemplate;

@Configuration
public class LogicengineDaoConfiguration {

    private final HibernateTemplate template;

    private final SectionPresetCriteriaMaker sectionPresetCriteriaMaker;
    private final StatePresetCriteriaMaker statePresetCriteriaMaker;
    private final DriverInfoPresetCriteriaMaker driverInfoPresetCriteriaMaker;
    private final DriverSupportPresetCriteriaMaker driverSupportPresetCriteriaMaker;
    private final GuarderInfoPresetCriteriaMaker guarderInfoPresetCriteriaMaker;
    private final GuarderSupportPresetCriteriaMaker guarderSupportPresetCriteriaMaker;
    private final PerformerInfoPresetCriteriaMaker performerInfoPresetCriteriaMaker;
    private final PerformerSupportPresetCriteriaMaker performerSupportPresetCriteriaMaker;
    private final TaskPresetCriteriaMaker taskPresetCriteriaMaker;
    private final TaskEventPresetCriteriaMaker taskEventPresetCriteriaMaker;
    private final TaskVariablePresetCriteriaMaker taskVariablePresetCriteriaMaker;

    @Value("${com.dwarfeng.essentials.hibernate.jdbc.batch_size}")
    private int batchSize;

    public LogicengineDaoConfiguration(
            HibernateTemplate template,
            SectionPresetCriteriaMaker sectionPresetCriteriaMaker,
            StatePresetCriteriaMaker statePresetCriteriaMaker,
            DriverInfoPresetCriteriaMaker driverInfoPresetCriteriaMaker,
            DriverSupportPresetCriteriaMaker driverSupportPresetCriteriaMaker,
            GuarderInfoPresetCriteriaMaker guarderInfoPresetCriteriaMaker,
            GuarderSupportPresetCriteriaMaker guarderSupportPresetCriteriaMaker,
            PerformerInfoPresetCriteriaMaker performerInfoPresetCriteriaMaker,
            PerformerSupportPresetCriteriaMaker performerSupportPresetCriteriaMaker,
            TaskPresetCriteriaMaker taskPresetCriteriaMaker,
            TaskEventPresetCriteriaMaker taskEventPresetCriteriaMaker,
            TaskVariablePresetCriteriaMaker taskVariablePresetCriteriaMaker
    ) {
        this.template = template;
        this.sectionPresetCriteriaMaker = sectionPresetCriteriaMaker;
        this.statePresetCriteriaMaker = statePresetCriteriaMaker;
        this.driverInfoPresetCriteriaMaker = driverInfoPresetCriteriaMaker;
        this.driverSupportPresetCriteriaMaker = driverSupportPresetCriteriaMaker;
        this.guarderInfoPresetCriteriaMaker = guarderInfoPresetCriteriaMaker;
        this.guarderSupportPresetCriteriaMaker = guarderSupportPresetCriteriaMaker;
        this.performerInfoPresetCriteriaMaker = performerInfoPresetCriteriaMaker;
        this.performerSupportPresetCriteriaMaker = performerSupportPresetCriteriaMaker;
        this.taskPresetCriteriaMaker = taskPresetCriteriaMaker;
        this.taskEventPresetCriteriaMaker = taskEventPresetCriteriaMaker;
        this.taskVariablePresetCriteriaMaker = taskVariablePresetCriteriaMaker;
    }

    @Bean(name = "logicengine.sectionHibernateBatchBaseDao")
    public HibernateBatchBaseDao<LongIdKey, HibernateLongIdKey, Section, HibernateSection>
    sectionHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(LongIdKey.class, HibernateLongIdKey.class, BeanMapper.class),
                new MapStructBeanTransformer<>(Section.class, HibernateSection.class, BeanMapper.class),
                HibernateSection.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean(name = "logicengine.sectionHibernateEntireLookupDao")
    public HibernateEntireLookupDao<Section, HibernateSection> sectionHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(Section.class, HibernateSection.class, BeanMapper.class),
                HibernateSection.class
        );
    }

    @Bean(name = "logicengine.sectionHibernatePresetLookupDao")
    public HibernatePresetLookupDao<Section, HibernateSection> sectionHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(Section.class, HibernateSection.class, BeanMapper.class),
                HibernateSection.class,
                sectionPresetCriteriaMaker
        );
    }

    @Bean(name = "logicengine.stateHibernateBatchBaseDao")
    public HibernateBatchBaseDao<StateKey, HibernateStateKey, State, HibernateState> stateHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(StateKey.class, HibernateStateKey.class, BeanMapper.class),
                new MapStructBeanTransformer<>(State.class, HibernateState.class, BeanMapper.class),
                HibernateState.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean(name = "logicengine.stateHibernateEntireLookupDao")
    public HibernateEntireLookupDao<State, HibernateState> stateHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(State.class, HibernateState.class, BeanMapper.class),
                HibernateState.class
        );
    }

    @Bean(name = "logicengine.stateHibernatePresetLookupDao")
    public HibernatePresetLookupDao<State, HibernateState> stateHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(State.class, HibernateState.class, BeanMapper.class),
                HibernateState.class,
                statePresetCriteriaMaker
        );
    }

    @Bean(name = "logicengine.driverInfoHibernateBatchBaseDao")
    public HibernateBatchBaseDao<LongIdKey, HibernateLongIdKey, DriverInfo, HibernateDriverInfo>
    driverInfoHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(LongIdKey.class, HibernateLongIdKey.class, BeanMapper.class),
                new MapStructBeanTransformer<>(DriverInfo.class, HibernateDriverInfo.class, BeanMapper.class),
                HibernateDriverInfo.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean(name = "logicengine.driverInfoHibernateEntireLookupDao")
    public HibernateEntireLookupDao<DriverInfo, HibernateDriverInfo> driverInfoHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(DriverInfo.class, HibernateDriverInfo.class, BeanMapper.class),
                HibernateDriverInfo.class
        );
    }

    @Bean(name = "logicengine.driverInfoHibernatePresetLookupDao")
    public HibernatePresetLookupDao<DriverInfo, HibernateDriverInfo> driverInfoHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(DriverInfo.class, HibernateDriverInfo.class, BeanMapper.class),
                HibernateDriverInfo.class,
                driverInfoPresetCriteriaMaker
        );
    }

    @Bean(name = "logicengine.driverSupportHibernateBatchBaseDao")
    public HibernateBatchBaseDao<StringIdKey, HibernateStringIdKey, DriverSupport, HibernateDriverSupport>
    driverSupportHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(StringIdKey.class, HibernateStringIdKey.class, BeanMapper.class),
                new MapStructBeanTransformer<>(DriverSupport.class, HibernateDriverSupport.class, BeanMapper.class),
                HibernateDriverSupport.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean(name = "logicengine.driverSupportHibernateEntireLookupDao")
    public HibernateEntireLookupDao<DriverSupport, HibernateDriverSupport>
    driverSupportHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(DriverSupport.class, HibernateDriverSupport.class, BeanMapper.class),
                HibernateDriverSupport.class
        );
    }

    @Bean(name = "logicengine.driverSupportHibernatePresetLookupDao")
    public HibernatePresetLookupDao<DriverSupport, HibernateDriverSupport> driverSupportHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(DriverSupport.class, HibernateDriverSupport.class, BeanMapper.class),
                HibernateDriverSupport.class,
                driverSupportPresetCriteriaMaker
        );
    }

    @Bean(name = "logicengine.guarderInfoHibernateBatchBaseDao")
    public HibernateBatchBaseDao<LongIdKey, HibernateLongIdKey, GuarderInfo, HibernateGuarderInfo>
    guarderInfoHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(LongIdKey.class, HibernateLongIdKey.class, BeanMapper.class),
                new MapStructBeanTransformer<>(GuarderInfo.class, HibernateGuarderInfo.class, BeanMapper.class),
                HibernateGuarderInfo.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean(name = "logicengine.guarderInfoHibernateEntireLookupDao")
    public HibernateEntireLookupDao<GuarderInfo, HibernateGuarderInfo> guarderInfoHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(GuarderInfo.class, HibernateGuarderInfo.class, BeanMapper.class),
                HibernateGuarderInfo.class
        );
    }

    @Bean(name = "logicengine.guarderInfoHibernatePresetLookupDao")
    public HibernatePresetLookupDao<GuarderInfo, HibernateGuarderInfo> guarderInfoHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(GuarderInfo.class, HibernateGuarderInfo.class, BeanMapper.class),
                HibernateGuarderInfo.class,
                guarderInfoPresetCriteriaMaker
        );
    }

    @Bean(name = "logicengine.guarderSupportHibernateBatchBaseDao")
    public HibernateBatchBaseDao<StringIdKey, HibernateStringIdKey, GuarderSupport, HibernateGuarderSupport>
    guarderSupportHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(StringIdKey.class, HibernateStringIdKey.class, BeanMapper.class),
                new MapStructBeanTransformer<>(GuarderSupport.class, HibernateGuarderSupport.class, BeanMapper.class),
                HibernateGuarderSupport.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean(name = "logicengine.guarderSupportHibernateEntireLookupDao")
    public HibernateEntireLookupDao<GuarderSupport, HibernateGuarderSupport> guarderSupportHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(GuarderSupport.class, HibernateGuarderSupport.class, BeanMapper.class),
                HibernateGuarderSupport.class
        );
    }

    @Bean(name = "logicengine.guarderSupportHibernatePresetLookupDao")
    public HibernatePresetLookupDao<GuarderSupport, HibernateGuarderSupport> guarderSupportHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(GuarderSupport.class, HibernateGuarderSupport.class, BeanMapper.class),
                HibernateGuarderSupport.class,
                guarderSupportPresetCriteriaMaker
        );
    }

    @Bean(name = "logicengine.performerInfoHibernateBatchBaseDao")
    public HibernateBatchBaseDao<LongIdKey, HibernateLongIdKey, PerformerInfo, HibernatePerformerInfo>
    performerInfoHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(LongIdKey.class, HibernateLongIdKey.class, BeanMapper.class),
                new MapStructBeanTransformer<>(PerformerInfo.class, HibernatePerformerInfo.class, BeanMapper.class),
                HibernatePerformerInfo.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean(name = "logicengine.performerInfoHibernateEntireLookupDao")
    public HibernateEntireLookupDao<PerformerInfo, HibernatePerformerInfo> performerInfoHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(PerformerInfo.class, HibernatePerformerInfo.class, BeanMapper.class),
                HibernatePerformerInfo.class
        );
    }

    @Bean(name = "logicengine.performerInfoHibernatePresetLookupDao")
    public HibernatePresetLookupDao<PerformerInfo, HibernatePerformerInfo> performerInfoHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(PerformerInfo.class, HibernatePerformerInfo.class, BeanMapper.class),
                HibernatePerformerInfo.class,
                performerInfoPresetCriteriaMaker
        );
    }

    @Bean(name = "logicengine.performerSupportHibernateBatchBaseDao")
    public HibernateBatchBaseDao<StringIdKey, HibernateStringIdKey, PerformerSupport, HibernatePerformerSupport>
    performerSupportHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(StringIdKey.class, HibernateStringIdKey.class, BeanMapper.class),
                new MapStructBeanTransformer<>(
                        PerformerSupport.class, HibernatePerformerSupport.class, BeanMapper.class
                ),
                HibernatePerformerSupport.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean(name = "logicengine.performerSupportHibernateEntireLookupDao")
    public HibernateEntireLookupDao<PerformerSupport, HibernatePerformerSupport>
    performerSupportHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(
                        PerformerSupport.class, HibernatePerformerSupport.class, BeanMapper.class
                ),
                HibernatePerformerSupport.class
        );
    }

    @Bean(name = "logicengine.performerSupportHibernatePresetLookupDao")
    public HibernatePresetLookupDao<PerformerSupport, HibernatePerformerSupport>
    performerSupportHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(
                        PerformerSupport.class, HibernatePerformerSupport.class, BeanMapper.class
                ),
                HibernatePerformerSupport.class,
                performerSupportPresetCriteriaMaker
        );
    }

    @Bean(name = "logicengine.taskHibernateBatchBaseDao")
    public HibernateBatchBaseDao<LongIdKey, HibernateLongIdKey, Task, HibernateTask> taskHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(LongIdKey.class, HibernateLongIdKey.class, BeanMapper.class),
                new MapStructBeanTransformer<>(Task.class, HibernateTask.class, BeanMapper.class),
                HibernateTask.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean(name = "logicengine.taskHibernateEntireLookupDao")
    public HibernateEntireLookupDao<Task, HibernateTask> taskHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(Task.class, HibernateTask.class, BeanMapper.class),
                HibernateTask.class
        );
    }

    @Bean(name = "logicengine.taskHibernatePresetLookupDao")
    public HibernatePresetLookupDao<Task, HibernateTask> taskHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(Task.class, HibernateTask.class, BeanMapper.class),
                HibernateTask.class,
                taskPresetCriteriaMaker
        );
    }

    @Bean(name = "logicengine.taskEventHibernateBatchBaseDao")
    public HibernateBatchBaseDao<LongIdKey, HibernateLongIdKey, TaskEvent, HibernateTaskEvent>
    taskEventHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(LongIdKey.class, HibernateLongIdKey.class, BeanMapper.class),
                new MapStructBeanTransformer<>(TaskEvent.class, HibernateTaskEvent.class, BeanMapper.class),
                HibernateTaskEvent.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean(name = "logicengine.taskEventHibernateEntireLookupDao")
    public HibernateEntireLookupDao<TaskEvent, HibernateTaskEvent> taskEventHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(TaskEvent.class, HibernateTaskEvent.class, BeanMapper.class),
                HibernateTaskEvent.class
        );
    }

    @Bean(name = "logicengine.taskEventHibernatePresetLookupDao")
    public HibernatePresetLookupDao<TaskEvent, HibernateTaskEvent> taskEventHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(TaskEvent.class, HibernateTaskEvent.class, BeanMapper.class),
                HibernateTaskEvent.class,
                taskEventPresetCriteriaMaker
        );
    }

    @Bean(name = "logicengine.taskVariableHibernateBatchBaseDao")
    public HibernateBatchBaseDao<TaskVariableKey, HibernateTaskVariableKey, TaskVariable, HibernateTaskVariable>
    taskVariableHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(TaskVariableKey.class, HibernateTaskVariableKey.class, BeanMapper.class),
                new MapStructBeanTransformer<>(TaskVariable.class, HibernateTaskVariable.class, BeanMapper.class),
                HibernateTaskVariable.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean(name = "logicengine.taskVariableHibernateEntireLookupDao")
    public HibernateEntireLookupDao<TaskVariable, HibernateTaskVariable> taskVariableHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(TaskVariable.class, HibernateTaskVariable.class, BeanMapper.class),
                HibernateTaskVariable.class
        );
    }

    @Bean(name = "logicengine.taskVariableHibernatePresetLookupDao")
    public HibernatePresetLookupDao<TaskVariable, HibernateTaskVariable> taskVariableHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(TaskVariable.class, HibernateTaskVariable.class, BeanMapper.class),
                HibernateTaskVariable.class,
                taskVariablePresetCriteriaMaker
        );
    }
}
