package com.dwarfeng.essentials.node.minimal.he.configuration;

import com.dwarfeng.settingrepo.impl.service.operation.*;
import com.dwarfeng.settingrepo.stack.bean.entity.*;
import com.dwarfeng.settingrepo.stack.bean.key.IahnNodeLocaleKey;
import com.dwarfeng.settingrepo.stack.bean.key.IahnNodeMekKey;
import com.dwarfeng.settingrepo.stack.bean.key.IahnNodeMessageKey;
import com.dwarfeng.settingrepo.stack.bean.key.KvNodeItemKey;
import com.dwarfeng.settingrepo.stack.cache.FormatterSupportCache;
import com.dwarfeng.settingrepo.stack.cache.IahnNodeMessageCache;
import com.dwarfeng.settingrepo.stack.cache.KvNodeItemCache;
import com.dwarfeng.settingrepo.stack.cache.TextNodeCache;
import com.dwarfeng.settingrepo.stack.dao.*;
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
public class SettingrepoServiceConfiguration {

    private final ServiceExceptionMapperConfiguration serviceExceptionMapperConfiguration;
    private final GenerateConfiguration generateConfiguration;

    private final FormatterSupportDao formatterSupportDao;
    private final FormatterSupportCache formatterSupportCache;
    private final SettingCategoryCrudOperation settingCategoryCrudOperation;
    private final SettingCategoryDao settingCategoryDao;
    private final SettingNodeCrudOperation settingNodeCrudOperation;
    private final SettingNodeDao settingNodeDao;
    private final TextNodeDao textNodeDao;
    private final TextNodeCache textNodeCache;
    private final ImageNodeCrudOperation imageNodeCrudOperation;
    private final ImageNodeDao imageNodeDao;
    private final ImageListNodeCrudOperation imageListNodeCrudOperation;
    private final ImageListNodeDao imageListNodeDao;
    private final ImageListNodeItemCrudOperation imageListNodeItemCrudOperation;
    private final ImageListNodeItemDao imageListNodeItemDao;
    private final IahnNodeCrudOperation iahnNodeCrudOperation;
    private final IahnNodeDao iahnNodeDao;
    private final IahnNodeLocaleCrudOperation iahnNodeLocaleCrudOperation;
    private final IahnNodeLocaleDao iahnNodeLocaleDao;
    private final IahnNodeMekCrudOperation iahnNodeMekCrudOperation;
    private final IahnNodeMekDao iahnNodeMekDao;
    private final IahnNodeMessageDao iahnNodeMessageDao;
    private final IahnNodeMessageCache iahnNodeMessageCache;
    private final LongTextNodeCrudOperation longTextNodeCrudOperation;
    private final LongTextNodeDao longTextNodeDao;
    private final FileNodeCrudOperation fileNodeCrudOperation;
    private final FileNodeDao fileNodeDao;
    private final FileListNodeCrudOperation fileListNodeCrudOperation;
    private final FileListNodeDao fileListNodeDao;
    private final FileListNodeItemCrudOperation fileListNodeItemCrudOperation;
    private final FileListNodeItemDao fileListNodeItemDao;
    private final NavigationNodeCrudOperation navigationNodeCrudOperation;
    private final NavigationNodeDao navigationNodeDao;
    private final NavigationNodeItemCrudOperation navigationNodeItemCrudOperation;
    private final NavigationNodeItemDao navigationNodeItemDao;
    private final KvNodeCrudOperation kvNodeCrudOperation;
    private final KvNodeDao kvNodeDao;
    private final KvNodeItemDao kvNodeItemDao;
    private final KvNodeItemCache kvNodeItemCache;

    @Value("${com.dwarfeng.essentials.cache.timeout.entity.settingrepo.formatter_support}")
    private long formatterSupportTimeout;
    @Value("${com.dwarfeng.essentials.cache.timeout.entity.settingrepo.text_node}")
    private long textNodeTimeout;
    @Value("${com.dwarfeng.essentials.cache.timeout.entity.settingrepo.iahn_node_message}")
    private long iahnNodeMessageTimeout;
    @Value("${com.dwarfeng.essentials.cache.timeout.entity.settingrepo.kv_node_item}")
    private long kvNodeItemTimeout;

    public SettingrepoServiceConfiguration(
            ServiceExceptionMapperConfiguration serviceExceptionMapperConfiguration,
            GenerateConfiguration generateConfiguration,
            FormatterSupportDao formatterSupportDao,
            FormatterSupportCache formatterSupportCache,
            SettingCategoryCrudOperation settingCategoryCrudOperation,
            SettingCategoryDao settingCategoryDao,
            SettingNodeCrudOperation settingNodeCrudOperation,
            SettingNodeDao settingNodeDao,
            TextNodeDao textNodeDao,
            TextNodeCache textNodeCache,
            ImageNodeCrudOperation imageNodeCrudOperation,
            ImageNodeDao imageNodeDao,
            ImageListNodeCrudOperation imageListNodeCrudOperation,
            ImageListNodeDao imageListNodeDao,
            ImageListNodeItemCrudOperation imageListNodeItemCrudOperation,
            ImageListNodeItemDao imageListNodeItemDao,
            IahnNodeCrudOperation iahnNodeCrudOperation,
            IahnNodeDao iahnNodeDao,
            IahnNodeLocaleCrudOperation iahnNodeLocaleCrudOperation,
            IahnNodeLocaleDao iahnNodeLocaleDao,
            IahnNodeMekCrudOperation iahnNodeMekCrudOperation,
            IahnNodeMekDao iahnNodeMekDao,
            IahnNodeMessageDao iahnNodeMessageDao,
            IahnNodeMessageCache iahnNodeMessageCache,
            LongTextNodeCrudOperation longTextNodeCrudOperation,
            LongTextNodeDao longTextNodeDao,
            FileNodeCrudOperation fileNodeCrudOperation,
            FileNodeDao fileNodeDao,
            FileListNodeCrudOperation fileListNodeCrudOperation,
            FileListNodeDao fileListNodeDao,
            FileListNodeItemCrudOperation fileListNodeItemCrudOperation,
            FileListNodeItemDao fileListNodeItemDao,
            NavigationNodeCrudOperation navigationNodeCrudOperation,
            NavigationNodeDao navigationNodeDao,
            NavigationNodeItemCrudOperation navigationNodeItemCrudOperation,
            NavigationNodeItemDao navigationNodeItemDao,
            KvNodeCrudOperation kvNodeCrudOperation,
            KvNodeDao kvNodeDao,
            KvNodeItemDao kvNodeItemDao,
            KvNodeItemCache kvNodeItemCache
    ) {
        this.serviceExceptionMapperConfiguration = serviceExceptionMapperConfiguration;
        this.generateConfiguration = generateConfiguration;
        this.formatterSupportDao = formatterSupportDao;
        this.formatterSupportCache = formatterSupportCache;
        this.settingCategoryCrudOperation = settingCategoryCrudOperation;
        this.settingCategoryDao = settingCategoryDao;
        this.settingNodeCrudOperation = settingNodeCrudOperation;
        this.settingNodeDao = settingNodeDao;
        this.textNodeDao = textNodeDao;
        this.textNodeCache = textNodeCache;
        this.imageNodeCrudOperation = imageNodeCrudOperation;
        this.imageNodeDao = imageNodeDao;
        this.imageListNodeCrudOperation = imageListNodeCrudOperation;
        this.imageListNodeDao = imageListNodeDao;
        this.imageListNodeItemCrudOperation = imageListNodeItemCrudOperation;
        this.imageListNodeItemDao = imageListNodeItemDao;
        this.iahnNodeCrudOperation = iahnNodeCrudOperation;
        this.iahnNodeDao = iahnNodeDao;
        this.iahnNodeLocaleCrudOperation = iahnNodeLocaleCrudOperation;
        this.iahnNodeLocaleDao = iahnNodeLocaleDao;
        this.iahnNodeMekCrudOperation = iahnNodeMekCrudOperation;
        this.iahnNodeMekDao = iahnNodeMekDao;
        this.iahnNodeMessageDao = iahnNodeMessageDao;
        this.iahnNodeMessageCache = iahnNodeMessageCache;
        this.longTextNodeCrudOperation = longTextNodeCrudOperation;
        this.longTextNodeDao = longTextNodeDao;
        this.fileNodeCrudOperation = fileNodeCrudOperation;
        this.fileNodeDao = fileNodeDao;
        this.fileListNodeCrudOperation = fileListNodeCrudOperation;
        this.fileListNodeDao = fileListNodeDao;
        this.fileListNodeItemCrudOperation = fileListNodeItemCrudOperation;
        this.fileListNodeItemDao = fileListNodeItemDao;
        this.navigationNodeCrudOperation = navigationNodeCrudOperation;
        this.navigationNodeDao = navigationNodeDao;
        this.navigationNodeItemCrudOperation = navigationNodeItemCrudOperation;
        this.navigationNodeItemDao = navigationNodeItemDao;
        this.kvNodeCrudOperation = kvNodeCrudOperation;
        this.kvNodeDao = kvNodeDao;
        this.kvNodeItemDao = kvNodeItemDao;
        this.kvNodeItemCache = kvNodeItemCache;
    }

    @Bean(name = "settingrepo.formatterSupportGeneralBatchCrudService")
    public GeneralBatchCrudService<StringIdKey, FormatterSupport> formatterSupportGeneralBatchCrudService() {
        return new GeneralBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                formatterSupportDao,
                formatterSupportCache,
                new ExceptionKeyGenerator<>(),
                formatterSupportTimeout
        );
    }

    @Bean(name = "settingrepo.formatterSupportDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<FormatterSupport> formatterSupportDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                formatterSupportDao
        );
    }

    @Bean(name = "settingrepo.formatterSupportDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<FormatterSupport> formatterSupportDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                formatterSupportDao
        );
    }

    @Bean(name = "settingrepo.settingCategoryCustomBatchCrudService")
    public CustomBatchCrudService<StringIdKey, SettingCategory> settingCategoryCustomBatchCrudService() {
        return new CustomBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                settingCategoryCrudOperation,
                new ExceptionKeyGenerator<>()
        );
    }

    @Bean(name = "settingrepo.settingCategoryDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<SettingCategory> settingCategoryDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                settingCategoryDao
        );
    }

    @Bean(name = "settingrepo.settingCategoryDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<SettingCategory> settingCategoryDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                settingCategoryDao
        );
    }

    @Bean(name = "settingrepo.settingNodeCustomBatchCrudService")
    public CustomBatchCrudService<StringIdKey, SettingNode> settingNodeCustomBatchCrudService() {
        return new CustomBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                settingNodeCrudOperation,
                new ExceptionKeyGenerator<>()
        );
    }

    @Bean(name = "settingrepo.settingNodeDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<SettingNode> settingNodeDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                settingNodeDao
        );
    }

    @Bean(name = "settingrepo.settingNodeDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<SettingNode> settingNodeDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                settingNodeDao
        );
    }

    @Bean(name = "settingrepo.textNodeGeneralBatchCrudService")
    public GeneralBatchCrudService<StringIdKey, TextNode> textNodeGeneralBatchCrudService() {
        return new GeneralBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                textNodeDao,
                textNodeCache,
                new ExceptionKeyGenerator<>(),
                textNodeTimeout
        );
    }

    @Bean(name = "settingrepo.textNodeDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<TextNode> textNodeDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                textNodeDao
        );
    }

    @Bean(name = "settingrepo.textNodeDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<TextNode> textNodeDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                textNodeDao
        );
    }

    @Bean(name = "settingrepo.imageNodeCustomBatchCrudService")
    public CustomBatchCrudService<StringIdKey, ImageNode> imageNodeCustomBatchCrudService() {
        return new CustomBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                imageNodeCrudOperation,
                new ExceptionKeyGenerator<>()
        );
    }

    @Bean(name = "settingrepo.imageNodeDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<ImageNode> imageNodeDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                imageNodeDao
        );
    }

    @Bean(name = "settingrepo.imageNodeDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<ImageNode> imageNodeDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                imageNodeDao
        );
    }

    @Bean(name = "settingrepo.imageListNodeCustomBatchCrudService")
    public CustomBatchCrudService<StringIdKey, ImageListNode> imageListNodeCustomBatchCrudService() {
        return new CustomBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                imageListNodeCrudOperation,
                new ExceptionKeyGenerator<>()
        );
    }

    @Bean(name = "settingrepo.imageListNodeDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<ImageListNode> imageListNodeDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                imageListNodeDao
        );
    }

    @Bean(name = "settingrepo.imageListNodeDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<ImageListNode> imageListNodeDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                imageListNodeDao
        );
    }

    @Bean(name = "settingrepo.imageListNodeItemCustomBatchCrudService")
    public CustomBatchCrudService<LongIdKey, ImageListNodeItem> imageListNodeItemCustomBatchCrudService() {
        return new CustomBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                imageListNodeItemCrudOperation,
                generateConfiguration.snowflakeLongIdKeyGenerator()
        );
    }

    @Bean(name = "settingrepo.imageListNodeItemDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<ImageListNodeItem> imageListNodeItemDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                imageListNodeItemDao
        );
    }

    @Bean(name = "settingrepo.imageListNodeItemDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<ImageListNodeItem> imageListNodeItemDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                imageListNodeItemDao
        );
    }

    @Bean(name = "settingrepo.iahnNodeCustomBatchCrudService")
    public CustomBatchCrudService<StringIdKey, IahnNode> iahnNodeCustomBatchCrudService() {
        return new CustomBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                iahnNodeCrudOperation,
                new ExceptionKeyGenerator<>()
        );
    }

    @Bean(name = "settingrepo.iahnNodeDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<IahnNode> iahnNodeDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                iahnNodeDao
        );
    }

    @Bean(name = "settingrepo.iahnNodeDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<IahnNode> iahnNodeDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                iahnNodeDao
        );
    }

    @Bean(name = "settingrepo.iahnNodeLocaleCustomBatchCrudService")
    public CustomBatchCrudService<IahnNodeLocaleKey, IahnNodeLocale> iahnNodeLocaleCustomBatchCrudService() {
        return new CustomBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                iahnNodeLocaleCrudOperation,
                new ExceptionKeyGenerator<>()
        );
    }

    @Bean(name = "settingrepo.iahnNodeLocaleDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<IahnNodeLocale> iahnNodeLocaleDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                iahnNodeLocaleDao
        );
    }

    @Bean(name = "settingrepo.iahnNodeLocaleDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<IahnNodeLocale> iahnNodeLocaleDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                iahnNodeLocaleDao
        );
    }

    @Bean(name = "settingrepo.iahnNodeMekCustomBatchCrudService")
    public CustomBatchCrudService<IahnNodeMekKey, IahnNodeMek> iahnNodeMekCustomBatchCrudService() {
        return new CustomBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                iahnNodeMekCrudOperation,
                new ExceptionKeyGenerator<>()
        );
    }

    @Bean(name = "settingrepo.iahnNodeMekDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<IahnNodeMek> iahnNodeMekDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                iahnNodeMekDao
        );
    }

    @Bean(name = "settingrepo.iahnNodeMekDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<IahnNodeMek> iahnNodeMekDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                iahnNodeMekDao
        );
    }

    @Bean(name = "settingrepo.iahnNodeMessageGeneralBatchCrudService")
    public GeneralBatchCrudService<IahnNodeMessageKey, IahnNodeMessage> iahnNodeMessageGeneralBatchCrudService() {
        return new GeneralBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                iahnNodeMessageDao,
                iahnNodeMessageCache,
                new ExceptionKeyGenerator<>(),
                iahnNodeMessageTimeout
        );
    }

    @Bean(name = "settingrepo.iahnNodeMessageDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<IahnNodeMessage> iahnNodeMessageDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                iahnNodeMessageDao
        );
    }

    @Bean(name = "settingrepo.iahnNodeMessageDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<IahnNodeMessage> iahnNodeMessageDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                iahnNodeMessageDao
        );
    }

    @Bean(name = "settingrepo.longTextNodeCustomBatchCrudService")
    public CustomBatchCrudService<StringIdKey, LongTextNode> longTextNodeCustomBatchCrudService() {
        return new CustomBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                longTextNodeCrudOperation,
                new ExceptionKeyGenerator<>()
        );
    }

    @Bean(name = "settingrepo.longTextNodeDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<LongTextNode> longTextNodeDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                longTextNodeDao
        );
    }

    @Bean(name = "settingrepo.longTextNodeDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<LongTextNode> longTextNodeDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                longTextNodeDao
        );
    }

    @Bean(name = "settingrepo.fileNodeCustomBatchCrudService")
    public CustomBatchCrudService<StringIdKey, FileNode> fileNodeCustomBatchCrudService() {
        return new CustomBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                fileNodeCrudOperation,
                new ExceptionKeyGenerator<>()
        );
    }

    @Bean(name = "settingrepo.fileNodeDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<FileNode> fileNodeDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                fileNodeDao
        );
    }

    @Bean(name = "settingrepo.fileNodeDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<FileNode> fileNodeDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                fileNodeDao
        );
    }

    @Bean(name = "settingrepo.fileListNodeBatchCrudService")
    public CustomBatchCrudService<StringIdKey, FileListNode> fileListNodeBatchCrudService() {
        return new CustomBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                fileListNodeCrudOperation,
                new ExceptionKeyGenerator<>()
        );
    }

    @Bean(name = "settingrepo.fileListNodeDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<FileListNode> fileListNodeDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                fileListNodeDao
        );
    }

    @Bean(name = "settingrepo.fileListNodeDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<FileListNode> fileListNodeDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                fileListNodeDao
        );
    }

    @Bean(name = "settingrepo.fileListNodeItemCustomBatchCrudService")
    public CustomBatchCrudService<LongIdKey, FileListNodeItem> fileListNodeItemCustomBatchCrudService() {
        return new CustomBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                fileListNodeItemCrudOperation,
                generateConfiguration.snowflakeLongIdKeyGenerator()
        );
    }

    @Bean(name = "settingrepo.fileListNodeItemDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<FileListNodeItem> fileListNodeItemDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                fileListNodeItemDao
        );
    }

    @Bean(name = "settingrepo.fileListNodeItemDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<FileListNodeItem> fileListNodeItemDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                fileListNodeItemDao
        );
    }

    @Bean(name = "settingrepo.navigationNodeCustomBatchCrudService")
    public CustomBatchCrudService<StringIdKey, NavigationNode> navigationNodeCustomBatchCrudService() {
        return new CustomBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                navigationNodeCrudOperation,
                new ExceptionKeyGenerator<>()
        );
    }

    @Bean(name = "settingrepo.navigationNodeDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<NavigationNode> navigationNodeDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                navigationNodeDao
        );
    }

    @Bean(name = "settingrepo.navigationNodeDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<NavigationNode> navigationNodeDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                navigationNodeDao
        );
    }

    @Bean(name = "settingrepo.navigationNodeItemCustomBatchCrudService")
    public CustomBatchCrudService<LongIdKey, NavigationNodeItem> navigationNodeItemCustomBatchCrudService() {
        return new CustomBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                navigationNodeItemCrudOperation,
                generateConfiguration.snowflakeLongIdKeyGenerator()
        );
    }

    @Bean(name = "settingrepo.navigationNodeItemDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<NavigationNodeItem> navigationNodeItemDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                navigationNodeItemDao
        );
    }

    @Bean(name = "settingrepo.navigationNodeItemDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<NavigationNodeItem> navigationNodeItemDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                navigationNodeItemDao
        );
    }

    @Bean(name = "settingrepo.kvNodeCustomBatchCrudService")
    public CustomBatchCrudService<StringIdKey, KvNode> kvNodeCustomBatchCrudService() {
        return new CustomBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                kvNodeCrudOperation,
                new ExceptionKeyGenerator<>()
        );
    }

    @Bean(name = "settingrepo.kvNodeDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<KvNode> kvNodeDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                kvNodeDao
        );
    }

    @Bean(name = "settingrepo.kvNodeDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<KvNode> kvNodeDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                kvNodeDao
        );
    }

    @Bean(name = "settingrepo.kvNodeItemGeneralBatchCrudService")
    public GeneralBatchCrudService<KvNodeItemKey, KvNodeItem> kvNodeItemGeneralBatchCrudService() {
        return new GeneralBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                kvNodeItemDao,
                kvNodeItemCache,
                new ExceptionKeyGenerator<>(),
                kvNodeItemTimeout
        );
    }

    @Bean(name = "settingrepo.kvNodeItemDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<KvNodeItem> kvNodeItemDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                kvNodeItemDao
        );
    }

    @Bean(name = "settingrepo.kvNodeItemDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<KvNodeItem> kvNodeItemDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                kvNodeItemDao
        );
    }
}
