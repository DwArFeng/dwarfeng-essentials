package com.dwarfeng.essentials.node.all.he.configuration;

import com.dwarfeng.fileio.impl.service.operation.*;
import com.dwarfeng.fileio.stack.bean.entity.*;
import com.dwarfeng.fileio.stack.bean.key.TaskItemKey;
import com.dwarfeng.fileio.stack.bean.key.TaskSettingItemKey;
import com.dwarfeng.fileio.stack.cache.*;
import com.dwarfeng.fileio.stack.dao.*;
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
public class FileioServiceConfiguration {

    private final ServiceExceptionMapperConfiguration serviceExceptionMapperConfiguration;
    private final GenerateConfiguration generateConfiguration;

    private final ExportConfDao exportConfDao;
    private final ExportConfCache exportConfCache;
    private final ExporterInfoDao exporterInfoDao;
    private final ExporterInfoCache exporterInfoCache;
    private final ExporterSupportDao exporterSupportDao;
    private final ExporterSupportCache exporterSupportCache;
    private final ExportFileInfoCrudOperation exportFileInfoCrudOperation;
    private final ExportFileInfoDao exportFileInfoDao;
    private final ExportTaskCrudOperation exportTaskCrudOperation;
    private final ExportTaskDao exportTaskDao;
    private final ExportTaskSettingCrudOperation exportTaskSettingCrudOperation;
    private final ExportTaskSettingDao exportTaskSettingDao;
    private final ExportTemplateInfoCrudOperation exportTemplateInfoCrudOperation;
    private final ExportTemplateInfoDao exportTemplateInfoDao;
    private final ImportConfDao importConfDao;
    private final ImportConfCache importConfCache;
    private final ImporterInfoDao importerInfoDao;
    private final ImporterInfoCache importerInfoCache;
    private final ImporterSupportDao importerSupportDao;
    private final ImporterSupportCache importerSupportCache;
    private final ImportFileInfoCrudOperation importFileInfoCrudOperation;
    private final ImportFileInfoDao importFileInfoDao;
    private final ImportTaskCrudOperation importTaskCrudOperation;
    private final ImportTaskDao importTaskDao;
    private final ImportTaskSettingCrudOperation importTaskSettingCrudOperation;
    private final ImportTaskSettingDao importTaskSettingDao;
    private final ImportTemplateInfoCrudOperation importTemplateInfoCrudOperation;
    private final ImportTemplateInfoDao importTemplateInfoDao;
    private final ReaderInfoDao readerInfoDao;
    private final ReaderInfoCache readerInfoCache;
    private final ReaderSupportDao readerSupportDao;
    private final ReaderSupportCache readerSupportCache;
    private final WriterInfoDao writerInfoDao;
    private final WriterInfoCache writerInfoCache;
    private final WriterSupportDao writerSupportDao;
    private final WriterSupportCache writerSupportCache;
    private final ExportMetadataDao exportMetadataDao;
    private final ExportMetadataCache exportMetadataCache;
    private final ImportMetadataDao importMetadataDao;
    private final ImportMetadataCache importMetadataCache;
    private final UserCrudOperation userCrudOperation;
    private final UserDao userDao;

    @Value("${com.dwarfeng.essentials.cache.timeout.entity.fileio.export_conf}")
    private long exportConfTimeout;
    @Value("${com.dwarfeng.essentials.cache.timeout.entity.fileio.exporter_info}")
    private long exporterInfoTimeout;
    @Value("${com.dwarfeng.essentials.cache.timeout.entity.fileio.exporter_support}")
    private long exporterSupportTimeout;
    @Value("${com.dwarfeng.essentials.cache.timeout.entity.fileio.import_conf}")
    private long importConfTimeout;
    @Value("${com.dwarfeng.essentials.cache.timeout.entity.fileio.importer_info}")
    private long importerInfoTimeout;
    @Value("${com.dwarfeng.essentials.cache.timeout.entity.fileio.importer_support}")
    private long importerSupportTimeout;
    @Value("${com.dwarfeng.essentials.cache.timeout.entity.fileio.reader_info}")
    private long readerInfoTimeout;
    @Value("${com.dwarfeng.essentials.cache.timeout.entity.fileio.reader_support}")
    private long readerSupportTimeout;
    @Value("${com.dwarfeng.essentials.cache.timeout.entity.fileio.writer_info}")
    private long writerInfoTimeout;
    @Value("${com.dwarfeng.essentials.cache.timeout.entity.fileio.writer_support}")
    private long writerSupportTimeout;
    @Value("${com.dwarfeng.essentials.cache.timeout.entity.fileio.export_metadata}")
    private long exportMetadataTimeout;
    @Value("${com.dwarfeng.essentials.cache.timeout.entity.fileio.import_metadata}")
    private long importMetadataTimeout;

    public FileioServiceConfiguration(
            ServiceExceptionMapperConfiguration serviceExceptionMapperConfiguration,
            GenerateConfiguration generateConfiguration,
            ExportConfDao exportConfDao,
            ExportConfCache exportConfCache,
            ExporterInfoDao exporterInfoDao,
            ExporterInfoCache exporterInfoCache,
            ExporterSupportDao exporterSupportDao,
            ExporterSupportCache exporterSupportCache,
            ExportFileInfoCrudOperation exportFileInfoCrudOperation,
            ExportFileInfoDao exportFileInfoDao,
            ExportTaskCrudOperation exportTaskCrudOperation,
            ExportTaskDao exportTaskDao,
            ExportTaskSettingCrudOperation exportTaskSettingCrudOperation,
            ExportTaskSettingDao exportTaskSettingDao,
            ExportTemplateInfoCrudOperation exportTemplateInfoCrudOperation,
            ExportTemplateInfoDao exportTemplateInfoDao,
            ImportConfDao importConfDao,
            ImportConfCache importConfCache,
            ImporterInfoDao importerInfoDao,
            ImporterInfoCache importerInfoCache,
            ImporterSupportDao importerSupportDao,
            ImporterSupportCache importerSupportCache,
            ImportFileInfoCrudOperation importFileInfoCrudOperation,
            ImportFileInfoDao importFileInfoDao,
            ImportTaskCrudOperation importTaskCrudOperation,
            ImportTaskDao importTaskDao,
            ImportTaskSettingCrudOperation importTaskSettingCrudOperation,
            ImportTaskSettingDao importTaskSettingDao,
            ImportTemplateInfoCrudOperation importTemplateInfoCrudOperation,
            ImportTemplateInfoDao importTemplateInfoDao,
            ReaderInfoDao readerInfoDao,
            ReaderInfoCache readerInfoCache,
            ReaderSupportDao readerSupportDao,
            ReaderSupportCache readerSupportCache,
            WriterInfoDao writerInfoDao,
            WriterInfoCache writerInfoCache,
            WriterSupportDao writerSupportDao,
            WriterSupportCache writerSupportCache,
            ExportMetadataDao exportMetadataDao,
            ExportMetadataCache exportMetadataCache,
            ImportMetadataDao importMetadataDao,
            ImportMetadataCache importMetadataCache,
            UserCrudOperation userCrudOperation,
            UserDao userDao
    ) {
        this.serviceExceptionMapperConfiguration = serviceExceptionMapperConfiguration;
        this.generateConfiguration = generateConfiguration;
        this.exportConfDao = exportConfDao;
        this.exportConfCache = exportConfCache;
        this.exporterInfoDao = exporterInfoDao;
        this.exporterInfoCache = exporterInfoCache;
        this.exporterSupportDao = exporterSupportDao;
        this.exporterSupportCache = exporterSupportCache;
        this.exportFileInfoCrudOperation = exportFileInfoCrudOperation;
        this.exportFileInfoDao = exportFileInfoDao;
        this.exportTaskCrudOperation = exportTaskCrudOperation;
        this.exportTaskDao = exportTaskDao;
        this.exportTaskSettingCrudOperation = exportTaskSettingCrudOperation;
        this.exportTaskSettingDao = exportTaskSettingDao;
        this.exportTemplateInfoCrudOperation = exportTemplateInfoCrudOperation;
        this.exportTemplateInfoDao = exportTemplateInfoDao;
        this.importConfDao = importConfDao;
        this.importConfCache = importConfCache;
        this.importerInfoDao = importerInfoDao;
        this.importerInfoCache = importerInfoCache;
        this.importerSupportDao = importerSupportDao;
        this.importerSupportCache = importerSupportCache;
        this.importFileInfoCrudOperation = importFileInfoCrudOperation;
        this.importFileInfoDao = importFileInfoDao;
        this.importTaskCrudOperation = importTaskCrudOperation;
        this.importTaskDao = importTaskDao;
        this.importTaskSettingCrudOperation = importTaskSettingCrudOperation;
        this.importTaskSettingDao = importTaskSettingDao;
        this.importTemplateInfoCrudOperation = importTemplateInfoCrudOperation;
        this.importTemplateInfoDao = importTemplateInfoDao;
        this.readerInfoDao = readerInfoDao;
        this.readerInfoCache = readerInfoCache;
        this.readerSupportDao = readerSupportDao;
        this.readerSupportCache = readerSupportCache;
        this.writerInfoDao = writerInfoDao;
        this.writerInfoCache = writerInfoCache;
        this.writerSupportDao = writerSupportDao;
        this.writerSupportCache = writerSupportCache;
        this.exportMetadataDao = exportMetadataDao;
        this.exportMetadataCache = exportMetadataCache;
        this.importMetadataDao = importMetadataDao;
        this.importMetadataCache = importMetadataCache;
        this.userCrudOperation = userCrudOperation;
        this.userDao = userDao;
    }

    @Bean(name = "fileio.exportConfGeneralBatchCrudService")
    public GeneralBatchCrudService<TaskSettingItemKey, ExportConf> exportConfGeneralBatchCrudService() {
        return new GeneralBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                exportConfDao,
                exportConfCache,
                new ExceptionKeyGenerator<>(),
                exportConfTimeout
        );
    }

    @Bean(name = "fileio.exportConfDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<ExportConf> exportConfDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                exportConfDao
        );
    }

    @Bean(name = "fileio.exportConfDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<ExportConf> exportConfDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                exportConfDao
        );
    }

    @Bean(name = "fileio.exporterInfoGeneralBatchCrudService")
    public GeneralBatchCrudService<TaskSettingItemKey, ExporterInfo> exporterInfoGeneralBatchCrudService() {
        return new GeneralBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                exporterInfoDao,
                exporterInfoCache,
                new ExceptionKeyGenerator<>(),
                exporterInfoTimeout
        );
    }

    @Bean(name = "fileio.exporterInfoDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<ExporterInfo> exporterInfoDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                exporterInfoDao
        );
    }

    @Bean(name = "fileio.exporterInfoDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<ExporterInfo> exporterInfoDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                exporterInfoDao
        );
    }

    @Bean(name = "fileio.exporterSupportGeneralBatchCrudService")
    public GeneralBatchCrudService<StringIdKey, ExporterSupport> exporterSupportGeneralBatchCrudService() {
        return new GeneralBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                exporterSupportDao,
                exporterSupportCache,
                new ExceptionKeyGenerator<>(),
                exporterSupportTimeout
        );
    }

    @Bean(name = "fileio.exporterSupportDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<ExporterSupport> exporterSupportDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                exporterSupportDao
        );
    }

    @Bean(name = "fileio.exporterSupportDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<ExporterSupport> exporterSupportDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                exporterSupportDao
        );
    }

    @Bean(name = "fileio.exportFileInfoCustomBatchCrudService")
    public CustomBatchCrudService<TaskItemKey, ExportFileInfo> exportFileInfoCustomBatchCrudService() {
        return new CustomBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                exportFileInfoCrudOperation,
                new ExceptionKeyGenerator<>()
        );
    }

    @Bean(name = "fileio.exportFileInfoDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<ExportFileInfo> exportFileInfoDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                exportFileInfoDao
        );
    }

    @Bean(name = "fileio.exportFileInfoDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<ExportFileInfo> exportFileInfoDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                exportFileInfoDao
        );
    }

    @Bean(name = "fileio.exportTaskCustomBatchCrudService")
    public CustomBatchCrudService<LongIdKey, ExportTask> exportTaskCustomBatchCrudService() {
        return new CustomBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                exportTaskCrudOperation,
                generateConfiguration.snowflakeLongIdKeyGenerator()
        );
    }

    @Bean(name = "fileio.exportTaskDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<ExportTask> exportTaskDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                exportTaskDao
        );
    }

    @Bean(name = "fileio.exportTaskDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<ExportTask> exportTaskDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                exportTaskDao
        );
    }

    @Bean(name = "fileio.exportTaskSettingCustomBatchCrudService")
    public CustomBatchCrudService<LongIdKey, ExportTaskSetting> exportTaskSettingCustomBatchCrudService() {
        return new CustomBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                exportTaskSettingCrudOperation,
                generateConfiguration.snowflakeLongIdKeyGenerator()
        );
    }

    @Bean(name = "fileio.exportTaskSettingDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<ExportTaskSetting> exportTaskSettingDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                exportTaskSettingDao
        );
    }

    @Bean(name = "fileio.exportTaskSettingDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<ExportTaskSetting> exportTaskSettingDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                exportTaskSettingDao
        );
    }

    @Bean(name = "fileio.exportTemplateInfoCustomBatchCrudService")
    public CustomBatchCrudService<TaskSettingItemKey, ExportTemplateInfo> exportTemplateInfoCustomBatchCrudService() {
        return new CustomBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                exportTemplateInfoCrudOperation,
                new ExceptionKeyGenerator<>()
        );
    }

    @Bean(name = "fileio.exportTemplateInfoDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<ExportTemplateInfo> exportTemplateInfoDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                exportTemplateInfoDao
        );
    }

    @Bean(name = "fileio.exportTemplateInfoDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<ExportTemplateInfo> exportTemplateInfoDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                exportTemplateInfoDao
        );
    }

    @Bean(name = "fileio.importConfGeneralBatchCrudService")
    public GeneralBatchCrudService<TaskSettingItemKey, ImportConf> importConfGeneralBatchCrudService() {
        return new GeneralBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                importConfDao,
                importConfCache,
                new ExceptionKeyGenerator<>(),
                importConfTimeout
        );
    }

    @Bean(name = "fileio.importConfDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<ImportConf> importConfDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                importConfDao
        );
    }

    @Bean(name = "fileio.importConfDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<ImportConf> importConfDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                importConfDao
        );
    }

    @Bean(name = "fileio.importerInfoGeneralBatchCrudService")
    public GeneralBatchCrudService<TaskSettingItemKey, ImporterInfo> importerInfoGeneralBatchCrudService() {
        return new GeneralBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                importerInfoDao,
                importerInfoCache,
                new ExceptionKeyGenerator<>(),
                importerInfoTimeout
        );
    }

    @Bean(name = "fileio.importerInfoDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<ImporterInfo> importerInfoDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                importerInfoDao
        );
    }

    @Bean(name = "fileio.importerInfoDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<ImporterInfo> importerInfoDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                importerInfoDao
        );
    }

    @Bean(name = "fileio.importerSupportGeneralBatchCrudService")
    public GeneralBatchCrudService<StringIdKey, ImporterSupport> importerSupportGeneralBatchCrudService() {
        return new GeneralBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                importerSupportDao,
                importerSupportCache,
                new ExceptionKeyGenerator<>(),
                importerSupportTimeout
        );
    }

    @Bean(name = "fileio.importerSupportDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<ImporterSupport> importerSupportDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                importerSupportDao
        );
    }

    @Bean(name = "fileio.importerSupportDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<ImporterSupport> importerSupportDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                importerSupportDao
        );
    }

    @Bean(name = "fileio.importFileInfoCustomBatchCrudService")
    public CustomBatchCrudService<TaskItemKey, ImportFileInfo> importFileInfoCustomBatchCrudService() {
        return new CustomBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                importFileInfoCrudOperation,
                new ExceptionKeyGenerator<>()
        );
    }

    @Bean(name = "fileio.importFileInfoDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<ImportFileInfo> importFileInfoDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                importFileInfoDao
        );
    }

    @Bean(name = "fileio.importFileInfoDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<ImportFileInfo> importFileInfoDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                importFileInfoDao
        );
    }

    @Bean(name = "fileio.importTaskCustomBatchCrudService")
    public CustomBatchCrudService<LongIdKey, ImportTask> importTaskCustomBatchCrudService() {
        return new CustomBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                importTaskCrudOperation,
                generateConfiguration.snowflakeLongIdKeyGenerator()
        );
    }

    @Bean(name = "fileio.importTaskDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<ImportTask> importTaskDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                importTaskDao
        );
    }

    @Bean(name = "fileio.importTaskDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<ImportTask> importTaskDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                importTaskDao
        );
    }

    @Bean(name = "fileio.importTaskSettingCustomBatchCrudService")
    public CustomBatchCrudService<LongIdKey, ImportTaskSetting> importTaskSettingCustomBatchCrudService() {
        return new CustomBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                importTaskSettingCrudOperation,
                generateConfiguration.snowflakeLongIdKeyGenerator()
        );
    }

    @Bean(name = "fileio.importTaskSettingDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<ImportTaskSetting> importTaskSettingDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                importTaskSettingDao
        );
    }

    @Bean(name = "fileio.importTaskSettingDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<ImportTaskSetting> importTaskSettingDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                importTaskSettingDao
        );
    }

    @Bean(name = "fileio.importTemplateInfoCustomBatchCrudService")
    public CustomBatchCrudService<TaskSettingItemKey, ImportTemplateInfo> importTemplateInfoCustomBatchCrudService() {
        return new CustomBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                importTemplateInfoCrudOperation,
                new ExceptionKeyGenerator<>()
        );
    }

    @Bean(name = "fileio.importTemplateInfoDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<ImportTemplateInfo> importTemplateInfoDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                importTemplateInfoDao
        );
    }

    @Bean(name = "fileio.importTemplateInfoDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<ImportTemplateInfo> importTemplateInfoDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                importTemplateInfoDao
        );
    }

    @Bean(name = "fileio.readerInfoGeneralBatchCrudService")
    public GeneralBatchCrudService<TaskSettingItemKey, ReaderInfo> readerInfoGeneralBatchCrudService() {
        return new GeneralBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                readerInfoDao,
                readerInfoCache,
                new ExceptionKeyGenerator<>(),
                readerInfoTimeout
        );
    }

    @Bean(name = "fileio.readerInfoDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<ReaderInfo> readerInfoDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                readerInfoDao
        );
    }

    @Bean(name = "fileio.readerInfoDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<ReaderInfo> readerInfoDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                readerInfoDao
        );
    }

    @Bean(name = "fileio.readerSupportGeneralBatchCrudService")
    public GeneralBatchCrudService<StringIdKey, ReaderSupport> readerSupportGeneralBatchCrudService() {
        return new GeneralBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                readerSupportDao,
                readerSupportCache,
                new ExceptionKeyGenerator<>(),
                readerSupportTimeout
        );
    }

    @Bean(name = "fileio.readerSupportDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<ReaderSupport> readerSupportDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                readerSupportDao
        );
    }

    @Bean(name = "fileio.readerSupportDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<ReaderSupport> readerSupportDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                readerSupportDao
        );
    }

    @Bean(name = "fileio.writerInfoGeneralBatchCrudService")
    public GeneralBatchCrudService<TaskSettingItemKey, WriterInfo> writerInfoGeneralBatchCrudService() {
        return new GeneralBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                writerInfoDao,
                writerInfoCache,
                new ExceptionKeyGenerator<>(),
                writerInfoTimeout
        );
    }

    @Bean(name = "fileio.writerInfoDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<WriterInfo> writerInfoDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                writerInfoDao
        );
    }

    @Bean(name = "fileio.writerInfoDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<WriterInfo> writerInfoDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                writerInfoDao
        );
    }

    @Bean(name = "fileio.writerSupportGeneralBatchCrudService")
    public GeneralBatchCrudService<StringIdKey, WriterSupport> writerSupportGeneralBatchCrudService() {
        return new GeneralBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                writerSupportDao,
                writerSupportCache,
                new ExceptionKeyGenerator<>(),
                writerSupportTimeout
        );
    }

    @Bean(name = "fileio.writerSupportDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<WriterSupport> writerSupportDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                writerSupportDao
        );
    }

    @Bean(name = "fileio.writerSupportDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<WriterSupport> writerSupportDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                writerSupportDao
        );
    }

    @Bean(name = "fileio.exportMetadataGeneralBatchCrudService")
    public GeneralBatchCrudService<TaskItemKey, ExportMetadata> exportMetadataGeneralBatchCrudService() {
        return new GeneralBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                exportMetadataDao,
                exportMetadataCache,
                new ExceptionKeyGenerator<>(),
                exportMetadataTimeout
        );
    }

    @Bean(name = "fileio.exportMetadataDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<ExportMetadata> exportMetadataDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                exportMetadataDao
        );
    }

    @Bean(name = "fileio.exportMetadataDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<ExportMetadata> exportMetadataDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                exportMetadataDao
        );
    }

    @Bean(name = "fileio.importMetadataGeneralBatchCrudService")
    public GeneralBatchCrudService<TaskItemKey, ImportMetadata> importMetadataGeneralBatchCrudService() {
        return new GeneralBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                importMetadataDao,
                importMetadataCache,
                new ExceptionKeyGenerator<>(),
                importMetadataTimeout
        );
    }

    @Bean(name = "fileio.importMetadataDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<ImportMetadata> importMetadataDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                importMetadataDao
        );
    }

    @Bean(name = "fileio.importMetadataDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<ImportMetadata> importMetadataDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                importMetadataDao
        );
    }

    @Bean(name = "fileio.userCustomBatchCrudService")
    public CustomBatchCrudService<StringIdKey, User> userCustomBatchCrudService() {
        return new CustomBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                userCrudOperation,
                new ExceptionKeyGenerator<>()
        );
    }

    @Bean(name = "fileio.userDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<User> userDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                userDao
        );
    }

    @Bean(name = "fileio.userDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<User> userDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                userDao
        );
    }
}
