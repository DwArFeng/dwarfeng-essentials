package com.dwarfeng.essentials.node.minimal.he.configuration;

import com.dwarfeng.settingrepo.impl.bean.BeanMapper;
import com.dwarfeng.settingrepo.impl.bean.entity.*;
import com.dwarfeng.settingrepo.impl.bean.key.HibernateIahnNodeLocaleKey;
import com.dwarfeng.settingrepo.impl.bean.key.HibernateIahnNodeMekKey;
import com.dwarfeng.settingrepo.impl.bean.key.HibernateIahnNodeMessageKey;
import com.dwarfeng.settingrepo.impl.bean.key.HibernateKvNodeItemKey;
import com.dwarfeng.settingrepo.impl.dao.preset.*;
import com.dwarfeng.settingrepo.stack.bean.entity.*;
import com.dwarfeng.settingrepo.stack.bean.key.IahnNodeLocaleKey;
import com.dwarfeng.settingrepo.stack.bean.key.IahnNodeMekKey;
import com.dwarfeng.settingrepo.stack.bean.key.IahnNodeMessageKey;
import com.dwarfeng.settingrepo.stack.bean.key.KvNodeItemKey;
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
public class SettingrepoDaoConfiguration {

    private final HibernateTemplate template;

    private final FormatterSupportPresetCriteriaMaker formatterSupportPresetCriteriaMaker;
    private final SettingCategoryPresetCriteriaMaker settingCategoryPresetCriteriaMaker;
    private final SettingNodePresetCriteriaMaker settingNodePresetCriteriaMaker;
    private final TextNodePresetCriteriaMaker textNodePresetCriteriaMaker;
    private final ImageNodePresetCriteriaMaker imageNodePresetCriteriaMaker;
    private final ImageListNodePresetCriteriaMaker imageListNodePresetCriteriaMaker;
    private final ImageListNodeItemPresetCriteriaMaker imageListNodeItemPresetCriteriaMaker;
    private final IahnNodePresetCriteriaMaker iahnNodePresetCriteriaMaker;
    private final IahnNodeLocalePresetCriteriaMaker iahnNodeLocalePresetCriteriaMaker;
    private final IahnNodeMekPresetCriteriaMaker iahnNodeMekPresetCriteriaMaker;
    private final IahnNodeMessagePresetCriteriaMaker iahnNodeMessagePresetCriteriaMaker;
    private final LongTextNodePresetCriteriaMaker longTextNodePresetCriteriaMaker;
    private final FileNodePresetCriteriaMaker fileNodePresetCriteriaMaker;
    private final FileListNodePresetCriteriaMaker fileListNodePresetCriteriaMaker;
    private final FileListNodeItemPresetCriteriaMaker fileListNodeItemPresetCriteriaMaker;
    private final NavigationNodePresetCriteriaMaker navigationNodePresetCriteriaMaker;
    private final NavigationNodeItemPresetCriteriaMaker navigationNodeItemPresetCriteriaMaker;
    private final KvNodePresetCriteriaMaker kvNodePresetCriteriaMaker;
    private final KvNodeItemPresetCriteriaMaker kvNodeItemPresetCriteriaMaker;

    @Value("${com.dwarfeng.essentials.hibernate.jdbc.batch_size}")
    private int batchSize;

    public SettingrepoDaoConfiguration(
            HibernateTemplate template,
            FormatterSupportPresetCriteriaMaker formatterSupportPresetCriteriaMaker,
            SettingCategoryPresetCriteriaMaker settingCategoryPresetCriteriaMaker,
            SettingNodePresetCriteriaMaker settingNodePresetCriteriaMaker,
            TextNodePresetCriteriaMaker textNodePresetCriteriaMaker,
            ImageNodePresetCriteriaMaker imageNodePresetCriteriaMaker,
            ImageListNodePresetCriteriaMaker imageListNodePresetCriteriaMaker,
            ImageListNodeItemPresetCriteriaMaker imageListNodeItemPresetCriteriaMaker,
            IahnNodePresetCriteriaMaker iahnNodePresetCriteriaMaker,
            IahnNodeLocalePresetCriteriaMaker iahnNodeLocalePresetCriteriaMaker,
            IahnNodeMekPresetCriteriaMaker iahnNodeMekPresetCriteriaMaker,
            IahnNodeMessagePresetCriteriaMaker iahnNodeMessagePresetCriteriaMaker,
            LongTextNodePresetCriteriaMaker longTextNodePresetCriteriaMaker,
            FileNodePresetCriteriaMaker fileNodePresetCriteriaMaker,
            FileListNodePresetCriteriaMaker fileListNodePresetCriteriaMaker,
            FileListNodeItemPresetCriteriaMaker fileListNodeItemPresetCriteriaMaker,
            NavigationNodePresetCriteriaMaker navigationNodePresetCriteriaMaker,
            NavigationNodeItemPresetCriteriaMaker navigationNodeItemPresetCriteriaMaker,
            KvNodePresetCriteriaMaker kvNodePresetCriteriaMaker,
            KvNodeItemPresetCriteriaMaker kvNodeItemPresetCriteriaMaker
    ) {
        this.template = template;
        this.formatterSupportPresetCriteriaMaker = formatterSupportPresetCriteriaMaker;
        this.settingCategoryPresetCriteriaMaker = settingCategoryPresetCriteriaMaker;
        this.settingNodePresetCriteriaMaker = settingNodePresetCriteriaMaker;
        this.textNodePresetCriteriaMaker = textNodePresetCriteriaMaker;
        this.imageNodePresetCriteriaMaker = imageNodePresetCriteriaMaker;
        this.imageListNodePresetCriteriaMaker = imageListNodePresetCriteriaMaker;
        this.imageListNodeItemPresetCriteriaMaker = imageListNodeItemPresetCriteriaMaker;
        this.iahnNodePresetCriteriaMaker = iahnNodePresetCriteriaMaker;
        this.iahnNodeLocalePresetCriteriaMaker = iahnNodeLocalePresetCriteriaMaker;
        this.iahnNodeMekPresetCriteriaMaker = iahnNodeMekPresetCriteriaMaker;
        this.iahnNodeMessagePresetCriteriaMaker = iahnNodeMessagePresetCriteriaMaker;
        this.longTextNodePresetCriteriaMaker = longTextNodePresetCriteriaMaker;
        this.fileNodePresetCriteriaMaker = fileNodePresetCriteriaMaker;
        this.fileListNodePresetCriteriaMaker = fileListNodePresetCriteriaMaker;
        this.fileListNodeItemPresetCriteriaMaker = fileListNodeItemPresetCriteriaMaker;
        this.navigationNodePresetCriteriaMaker = navigationNodePresetCriteriaMaker;
        this.navigationNodeItemPresetCriteriaMaker = navigationNodeItemPresetCriteriaMaker;
        this.kvNodePresetCriteriaMaker = kvNodePresetCriteriaMaker;
        this.kvNodeItemPresetCriteriaMaker = kvNodeItemPresetCriteriaMaker;
    }

    @Bean(name = "settingrepo.formatterSupportHibernateBatchBaseDao")
    public HibernateBatchBaseDao<StringIdKey, HibernateStringIdKey, FormatterSupport, HibernateFormatterSupport>
    formatterSupportHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(StringIdKey.class, HibernateStringIdKey.class, BeanMapper.class),
                new MapStructBeanTransformer<>(
                        FormatterSupport.class, HibernateFormatterSupport.class, BeanMapper.class
                ),
                HibernateFormatterSupport.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean(name = "settingrepo.formatterSupportHibernateEntireLookupDao")
    public HibernateEntireLookupDao<FormatterSupport, HibernateFormatterSupport>
    formatterSupportHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(
                        FormatterSupport.class, HibernateFormatterSupport.class, BeanMapper.class
                ),
                HibernateFormatterSupport.class
        );
    }

    @Bean(name = "settingrepo.formatterSupportHibernatePresetLookupDao")
    public HibernatePresetLookupDao<FormatterSupport, HibernateFormatterSupport>
    formatterSupportHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(
                        FormatterSupport.class, HibernateFormatterSupport.class, BeanMapper.class
                ),
                HibernateFormatterSupport.class,
                formatterSupportPresetCriteriaMaker
        );
    }

    @Bean(name = "settingrepo.settingCategoryHibernateBatchBaseDao")
    public HibernateBatchBaseDao<StringIdKey, HibernateStringIdKey, SettingCategory, HibernateSettingCategory>
    settingCategoryHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(StringIdKey.class, HibernateStringIdKey.class, BeanMapper.class),
                new MapStructBeanTransformer<>(
                        SettingCategory.class, HibernateSettingCategory.class, BeanMapper.class
                ),
                HibernateSettingCategory.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean(name = "settingrepo.settingCategoryHibernateEntireLookupDao")
    public HibernateEntireLookupDao<SettingCategory, HibernateSettingCategory>
    settingCategoryHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(
                        SettingCategory.class, HibernateSettingCategory.class, BeanMapper.class
                ),
                HibernateSettingCategory.class
        );
    }

    @Bean(name = "settingrepo.settingCategoryHibernatePresetLookupDao")
    public HibernatePresetLookupDao<SettingCategory, HibernateSettingCategory>
    settingCategoryHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(
                        SettingCategory.class, HibernateSettingCategory.class, BeanMapper.class
                ),
                HibernateSettingCategory.class,
                settingCategoryPresetCriteriaMaker
        );
    }

    @Bean(name = "settingrepo.settingNodeHibernateBatchBaseDao")
    public HibernateBatchBaseDao<StringIdKey, HibernateStringIdKey, SettingNode, HibernateSettingNode>
    settingNodeHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(StringIdKey.class, HibernateStringIdKey.class, BeanMapper.class),
                new MapStructBeanTransformer<>(SettingNode.class, HibernateSettingNode.class, BeanMapper.class),
                HibernateSettingNode.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean(name = "settingrepo.settingNodeHibernateEntireLookupDao")
    public HibernateEntireLookupDao<SettingNode, HibernateSettingNode> settingNodeHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(SettingNode.class, HibernateSettingNode.class, BeanMapper.class),
                HibernateSettingNode.class
        );
    }

    @Bean(name = "settingrepo.settingNodeHibernatePresetLookupDao")
    public HibernatePresetLookupDao<SettingNode, HibernateSettingNode> settingNodeHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(SettingNode.class, HibernateSettingNode.class, BeanMapper.class),
                HibernateSettingNode.class,
                settingNodePresetCriteriaMaker
        );
    }

    @Bean(name = "settingrepo.textNodeHibernateBatchBaseDao")
    public HibernateBatchBaseDao<StringIdKey, HibernateStringIdKey, TextNode, HibernateTextNode>
    textNodeHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(StringIdKey.class, HibernateStringIdKey.class, BeanMapper.class),
                new MapStructBeanTransformer<>(TextNode.class, HibernateTextNode.class, BeanMapper.class),
                HibernateTextNode.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean(name = "settingrepo.textNodeHibernateEntireLookupDao")
    public HibernateEntireLookupDao<TextNode, HibernateTextNode> textNodeHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(TextNode.class, HibernateTextNode.class, BeanMapper.class),
                HibernateTextNode.class
        );
    }

    @Bean(name = "settingrepo.textNodeHibernatePresetLookupDao")
    public HibernatePresetLookupDao<TextNode, HibernateTextNode> textNodeHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(TextNode.class, HibernateTextNode.class, BeanMapper.class),
                HibernateTextNode.class,
                textNodePresetCriteriaMaker
        );
    }

    @Bean(name = "settingrepo.imageNodeHibernateBatchBaseDao")
    public HibernateBatchBaseDao<StringIdKey, HibernateStringIdKey, ImageNode, HibernateImageNode>
    imageNodeHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(StringIdKey.class, HibernateStringIdKey.class, BeanMapper.class),
                new MapStructBeanTransformer<>(ImageNode.class, HibernateImageNode.class, BeanMapper.class),
                HibernateImageNode.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean(name = "settingrepo.imageNodeHibernateEntireLookupDao")
    public HibernateEntireLookupDao<ImageNode, HibernateImageNode> imageNodeHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(ImageNode.class, HibernateImageNode.class, BeanMapper.class),
                HibernateImageNode.class
        );
    }

    @Bean(name = "settingrepo.imageNodeHibernatePresetLookupDao")
    public HibernatePresetLookupDao<ImageNode, HibernateImageNode> imageNodeHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(ImageNode.class, HibernateImageNode.class, BeanMapper.class),
                HibernateImageNode.class,
                imageNodePresetCriteriaMaker
        );
    }

    @Bean(name = "settingrepo.imageListNodeHibernateBatchBaseDao")
    public HibernateBatchBaseDao<StringIdKey, HibernateStringIdKey, ImageListNode, HibernateImageListNode>
    imageListNodeHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(StringIdKey.class, HibernateStringIdKey.class, BeanMapper.class),
                new MapStructBeanTransformer<>(
                        ImageListNode.class, HibernateImageListNode.class, BeanMapper.class
                ),
                HibernateImageListNode.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean(name = "settingrepo.imageListNodeHibernateEntireLookupDao")
    public HibernateEntireLookupDao<ImageListNode, HibernateImageListNode> imageListNodeHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(
                        ImageListNode.class, HibernateImageListNode.class, BeanMapper.class
                ),
                HibernateImageListNode.class
        );
    }

    @Bean(name = "settingrepo.imageListNodeHibernatePresetLookupDao")
    public HibernatePresetLookupDao<ImageListNode, HibernateImageListNode> imageListNodeHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(
                        ImageListNode.class, HibernateImageListNode.class, BeanMapper.class
                ),
                HibernateImageListNode.class,
                imageListNodePresetCriteriaMaker
        );
    }

    @Bean(name = "settingrepo.imageListNodeItemHibernateBatchBaseDao")
    public HibernateBatchBaseDao<LongIdKey, HibernateLongIdKey, ImageListNodeItem, HibernateImageListNodeItem>
    imageListNodeItemHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(LongIdKey.class, HibernateLongIdKey.class, BeanMapper.class),
                new MapStructBeanTransformer<>(
                        ImageListNodeItem.class, HibernateImageListNodeItem.class, BeanMapper.class
                ),
                HibernateImageListNodeItem.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean(name = "settingrepo.imageListNodeItemHibernateEntireLookupDao")
    public HibernateEntireLookupDao<ImageListNodeItem, HibernateImageListNodeItem>
    imageListNodeItemHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(
                        ImageListNodeItem.class, HibernateImageListNodeItem.class, BeanMapper.class
                ),
                HibernateImageListNodeItem.class
        );
    }

    @Bean(name = "settingrepo.imageListNodeItemHibernatePresetLookupDao")
    public HibernatePresetLookupDao<ImageListNodeItem, HibernateImageListNodeItem>
    imageListNodeItemHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(
                        ImageListNodeItem.class, HibernateImageListNodeItem.class, BeanMapper.class
                ),
                HibernateImageListNodeItem.class,
                imageListNodeItemPresetCriteriaMaker
        );
    }

    @Bean(name = "settingrepo.iahnNodeHibernateBatchBaseDao")
    public HibernateBatchBaseDao<StringIdKey, HibernateStringIdKey, IahnNode, HibernateIahnNode>
    iahnNodeHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(StringIdKey.class, HibernateStringIdKey.class, BeanMapper.class),
                new MapStructBeanTransformer<>(IahnNode.class, HibernateIahnNode.class, BeanMapper.class),
                HibernateIahnNode.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean(name = "settingrepo.iahnNodeHibernateEntireLookupDao")
    public HibernateEntireLookupDao<IahnNode, HibernateIahnNode> iahnNodeHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(IahnNode.class, HibernateIahnNode.class, BeanMapper.class),
                HibernateIahnNode.class
        );
    }

    @Bean(name = "settingrepo.iahnNodeHibernatePresetLookupDao")
    public HibernatePresetLookupDao<IahnNode, HibernateIahnNode> iahnNodeHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(IahnNode.class, HibernateIahnNode.class, BeanMapper.class),
                HibernateIahnNode.class,
                iahnNodePresetCriteriaMaker
        );
    }

    @Bean(name = "settingrepo.iahnNodeLocaleHibernateBatchBaseDao")
    public HibernateBatchBaseDao<IahnNodeLocaleKey, HibernateIahnNodeLocaleKey, IahnNodeLocale, HibernateIahnNodeLocale>
    iahnNodeLocaleHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(
                        IahnNodeLocaleKey.class, HibernateIahnNodeLocaleKey.class, BeanMapper.class
                ),
                new MapStructBeanTransformer<>(
                        IahnNodeLocale.class, HibernateIahnNodeLocale.class, BeanMapper.class
                ),
                HibernateIahnNodeLocale.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean(name = "settingrepo.iahnNodeLocaleHibernateEntireLookupDao")
    public HibernateEntireLookupDao<IahnNodeLocale, HibernateIahnNodeLocale>
    iahnNodeLocaleHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(
                        IahnNodeLocale.class, HibernateIahnNodeLocale.class, BeanMapper.class
                ),
                HibernateIahnNodeLocale.class
        );
    }

    @Bean(name = "settingrepo.iahnNodeLocaleHibernatePresetLookupDao")
    public HibernatePresetLookupDao<IahnNodeLocale, HibernateIahnNodeLocale>
    iahnNodeLocaleHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(
                        IahnNodeLocale.class, HibernateIahnNodeLocale.class, BeanMapper.class
                ),
                HibernateIahnNodeLocale.class,
                iahnNodeLocalePresetCriteriaMaker
        );
    }

    @Bean(name = "settingrepo.iahnNodeMekHibernateBatchBaseDao")
    public HibernateBatchBaseDao<IahnNodeMekKey, HibernateIahnNodeMekKey, IahnNodeMek, HibernateIahnNodeMek>
    iahnNodeMekHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(
                        IahnNodeMekKey.class, HibernateIahnNodeMekKey.class, BeanMapper.class
                ),
                new MapStructBeanTransformer<>(
                        IahnNodeMek.class, HibernateIahnNodeMek.class, BeanMapper.class
                ),
                HibernateIahnNodeMek.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean(name = "settingrepo.iahnNodeMekHibernateEntireLookupDao")
    public HibernateEntireLookupDao<IahnNodeMek, HibernateIahnNodeMek>
    iahnNodeMekHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(
                        IahnNodeMek.class, HibernateIahnNodeMek.class, BeanMapper.class
                ),
                HibernateIahnNodeMek.class
        );
    }

    @Bean(name = "settingrepo.iahnNodeMekHibernatePresetLookupDao")
    public HibernatePresetLookupDao<IahnNodeMek, HibernateIahnNodeMek>
    iahnNodeMekHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(
                        IahnNodeMek.class, HibernateIahnNodeMek.class, BeanMapper.class
                ),
                HibernateIahnNodeMek.class,
                iahnNodeMekPresetCriteriaMaker
        );
    }

    @Bean(name = "settingrepo.iahnNodeMessageHibernateBatchBaseDao")
    public HibernateBatchBaseDao<IahnNodeMessageKey, HibernateIahnNodeMessageKey, IahnNodeMessage,
            HibernateIahnNodeMessage> iahnNodeMessageHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(
                        IahnNodeMessageKey.class, HibernateIahnNodeMessageKey.class, BeanMapper.class
                ),
                new MapStructBeanTransformer<>(
                        IahnNodeMessage.class, HibernateIahnNodeMessage.class, BeanMapper.class
                ),
                HibernateIahnNodeMessage.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean(name = "settingrepo.iahnNodeMessageHibernateEntireLookupDao")
    public HibernateEntireLookupDao<IahnNodeMessage, HibernateIahnNodeMessage>
    iahnNodeMessageHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(
                        IahnNodeMessage.class, HibernateIahnNodeMessage.class, BeanMapper.class
                ),
                HibernateIahnNodeMessage.class
        );
    }

    @Bean(name = "settingrepo.iahnNodeMessageHibernatePresetLookupDao")
    public HibernatePresetLookupDao<IahnNodeMessage, HibernateIahnNodeMessage>
    iahnNodeMessageHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(
                        IahnNodeMessage.class, HibernateIahnNodeMessage.class, BeanMapper.class
                ),
                HibernateIahnNodeMessage.class,
                iahnNodeMessagePresetCriteriaMaker
        );
    }

    @Bean(name = "settingrepo.longTextNodeHibernateBatchBaseDao")
    public HibernateBatchBaseDao<StringIdKey, HibernateStringIdKey, LongTextNode, HibernateLongTextNode>
    longTextNodeHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(StringIdKey.class, HibernateStringIdKey.class, BeanMapper.class),
                new MapStructBeanTransformer<>(LongTextNode.class, HibernateLongTextNode.class, BeanMapper.class),
                HibernateLongTextNode.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean(name = "settingrepo.longTextNodeHibernateEntireLookupDao")
    public HibernateEntireLookupDao<LongTextNode, HibernateLongTextNode> longTextNodeHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(LongTextNode.class, HibernateLongTextNode.class, BeanMapper.class),
                HibernateLongTextNode.class
        );
    }

    @Bean(name = "settingrepo.longTextNodeHibernatePresetLookupDao")
    public HibernatePresetLookupDao<LongTextNode, HibernateLongTextNode> longTextNodeHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(LongTextNode.class, HibernateLongTextNode.class, BeanMapper.class),
                HibernateLongTextNode.class,
                longTextNodePresetCriteriaMaker
        );
    }

    @Bean(name = "settingrepo.fileNodeHibernateBatchBaseDao")
    public HibernateBatchBaseDao<StringIdKey, HibernateStringIdKey, FileNode, HibernateFileNode>
    fileNodeHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(StringIdKey.class, HibernateStringIdKey.class, BeanMapper.class),
                new MapStructBeanTransformer<>(FileNode.class, HibernateFileNode.class, BeanMapper.class),
                HibernateFileNode.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean(name = "settingrepo.fileNodeHibernateEntireLookupDao")
    public HibernateEntireLookupDao<FileNode, HibernateFileNode> fileNodeHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(FileNode.class, HibernateFileNode.class, BeanMapper.class),
                HibernateFileNode.class
        );
    }

    @Bean(name = "settingrepo.fileNodeHibernatePresetLookupDao")
    public HibernatePresetLookupDao<FileNode, HibernateFileNode> fileNodeHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(FileNode.class, HibernateFileNode.class, BeanMapper.class),
                HibernateFileNode.class,
                fileNodePresetCriteriaMaker
        );
    }

    @Bean(name = "settingrepo.fileListNodeHibernateBatchBaseDao")
    public HibernateBatchBaseDao<StringIdKey, HibernateStringIdKey, FileListNode, HibernateFileListNode>
    fileListNodeHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(StringIdKey.class, HibernateStringIdKey.class, BeanMapper.class),
                new MapStructBeanTransformer<>(FileListNode.class, HibernateFileListNode.class, BeanMapper.class),
                HibernateFileListNode.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean(name = "settingrepo.fileListNodeHibernateEntireLookupDao")
    public HibernateEntireLookupDao<FileListNode, HibernateFileListNode> fileListNodeHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(FileListNode.class, HibernateFileListNode.class, BeanMapper.class),
                HibernateFileListNode.class
        );
    }

    @Bean(name = "settingrepo.fileListNodeHibernatePresetLookupDao")
    public HibernatePresetLookupDao<FileListNode, HibernateFileListNode> fileListNodeHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(FileListNode.class, HibernateFileListNode.class, BeanMapper.class),
                HibernateFileListNode.class,
                fileListNodePresetCriteriaMaker
        );
    }

    @Bean(name = "settingrepo.fileListNodeItemHibernateBatchBaseDao")
    public HibernateBatchBaseDao<LongIdKey, HibernateLongIdKey, FileListNodeItem, HibernateFileListNodeItem>
    fileListNodeItemHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(LongIdKey.class, HibernateLongIdKey.class, BeanMapper.class),
                new MapStructBeanTransformer<>(
                        FileListNodeItem.class, HibernateFileListNodeItem.class, BeanMapper.class
                ),
                HibernateFileListNodeItem.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean(name = "settingrepo.fileListNodeItemHibernateEntireLookupDao")
    public HibernateEntireLookupDao<FileListNodeItem, HibernateFileListNodeItem>
    fileListNodeItemHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(
                        FileListNodeItem.class, HibernateFileListNodeItem.class, BeanMapper.class
                ),
                HibernateFileListNodeItem.class
        );
    }

    @Bean(name = "settingrepo.fileListNodeItemHibernatePresetLookupDao")
    public HibernatePresetLookupDao<FileListNodeItem, HibernateFileListNodeItem>
    fileListNodeItemHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(
                        FileListNodeItem.class, HibernateFileListNodeItem.class, BeanMapper.class
                ),
                HibernateFileListNodeItem.class,
                fileListNodeItemPresetCriteriaMaker
        );
    }

    @Bean(name = "settingrepo.navigationNodeHibernateBatchBaseDao")
    public HibernateBatchBaseDao<StringIdKey, HibernateStringIdKey, NavigationNode, HibernateNavigationNode>
    navigationNodeHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(StringIdKey.class, HibernateStringIdKey.class, BeanMapper.class),
                new MapStructBeanTransformer<>(NavigationNode.class, HibernateNavigationNode.class, BeanMapper.class),
                HibernateNavigationNode.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean(name = "settingrepo.navigationNodeHibernateEntireLookupDao")
    public HibernateEntireLookupDao<NavigationNode, HibernateNavigationNode> navigationNodeHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(NavigationNode.class, HibernateNavigationNode.class, BeanMapper.class),
                HibernateNavigationNode.class
        );
    }

    @Bean(name = "settingrepo.navigationNodeHibernatePresetLookupDao")
    public HibernatePresetLookupDao<NavigationNode, HibernateNavigationNode> navigationNodeHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(NavigationNode.class, HibernateNavigationNode.class, BeanMapper.class),
                HibernateNavigationNode.class,
                navigationNodePresetCriteriaMaker
        );
    }

    @Bean(name = "settingrepo.navigationNodeItemHibernateBatchBaseDao")
    public HibernateBatchBaseDao<LongIdKey, HibernateLongIdKey, NavigationNodeItem, HibernateNavigationNodeItem>
    navigationNodeItemHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(LongIdKey.class, HibernateLongIdKey.class, BeanMapper.class),
                new MapStructBeanTransformer<>(
                        NavigationNodeItem.class, HibernateNavigationNodeItem.class, BeanMapper.class
                ),
                HibernateNavigationNodeItem.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean(name = "settingrepo.navigationNodeItemHibernateEntireLookupDao")
    public HibernateEntireLookupDao<NavigationNodeItem, HibernateNavigationNodeItem>
    navigationNodeItemHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(
                        NavigationNodeItem.class, HibernateNavigationNodeItem.class, BeanMapper.class
                ),
                HibernateNavigationNodeItem.class
        );
    }

    @Bean(name = "settingrepo.navigationNodeItemHibernatePresetLookupDao")
    public HibernatePresetLookupDao<NavigationNodeItem, HibernateNavigationNodeItem>
    navigationNodeItemHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(
                        NavigationNodeItem.class, HibernateNavigationNodeItem.class, BeanMapper.class
                ),
                HibernateNavigationNodeItem.class,
                navigationNodeItemPresetCriteriaMaker
        );
    }

    @Bean(name = "settingrepo.kvNodeSupportHibernateBatchBaseDao")
    public HibernateBatchBaseDao<StringIdKey, HibernateStringIdKey, KvNode, HibernateKvNode>
    kvNodeSupportHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(StringIdKey.class, HibernateStringIdKey.class, BeanMapper.class),
                new MapStructBeanTransformer<>(KvNode.class, HibernateKvNode.class, BeanMapper.class),
                HibernateKvNode.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean(name = "settingrepo.kvNodeSupportHibernateEntireLookupDao")
    public HibernateEntireLookupDao<KvNode, HibernateKvNode> kvNodeSupportHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(KvNode.class, HibernateKvNode.class, BeanMapper.class),
                HibernateKvNode.class
        );
    }

    @Bean(name = "settingrepo.kvNodeSupportHibernatePresetLookupDao")
    public HibernatePresetLookupDao<KvNode, HibernateKvNode> kvNodeSupportHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(KvNode.class, HibernateKvNode.class, BeanMapper.class),
                HibernateKvNode.class,
                kvNodePresetCriteriaMaker
        );
    }

    @Bean(name = "settingrepo.kvNodeItemSupportHibernateBatchBaseDao")
    public HibernateBatchBaseDao<KvNodeItemKey, HibernateKvNodeItemKey, KvNodeItem, HibernateKvNodeItem>
    kvNodeItemSupportHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(KvNodeItemKey.class, HibernateKvNodeItemKey.class, BeanMapper.class),
                new MapStructBeanTransformer<>(KvNodeItem.class, HibernateKvNodeItem.class, BeanMapper.class),
                HibernateKvNodeItem.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean(name = "settingrepo.kvNodeItemSupportHibernateEntireLookupDao")
    public HibernateEntireLookupDao<KvNodeItem, HibernateKvNodeItem> kvNodeItemSupportHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(KvNodeItem.class, HibernateKvNodeItem.class, BeanMapper.class),
                HibernateKvNodeItem.class
        );
    }

    @Bean(name = "settingrepo.kvNodeItemSupportHibernatePresetLookupDao")
    public HibernatePresetLookupDao<KvNodeItem, HibernateKvNodeItem> kvNodeItemSupportHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(KvNodeItem.class, HibernateKvNodeItem.class, BeanMapper.class),
                HibernateKvNodeItem.class,
                kvNodeItemPresetCriteriaMaker
        );
    }
}
