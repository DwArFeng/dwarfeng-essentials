package com.dwarfeng.essentials.node.all.he.configuration;

import com.dwarfeng.settingrepo.sdk.bean.BeanMapper;
import com.dwarfeng.settingrepo.sdk.bean.entity.*;
import com.dwarfeng.settingrepo.sdk.bean.key.formatter.IahnNodeLocaleStringKeyFormatter;
import com.dwarfeng.settingrepo.sdk.bean.key.formatter.IahnNodeMekStringKeyFormatter;
import com.dwarfeng.settingrepo.sdk.bean.key.formatter.IahnNodeMessageStringKeyFormatter;
import com.dwarfeng.settingrepo.sdk.bean.key.formatter.KvNodeItemStringKeyFormatter;
import com.dwarfeng.settingrepo.stack.bean.entity.*;
import com.dwarfeng.settingrepo.stack.bean.key.IahnNodeLocaleKey;
import com.dwarfeng.settingrepo.stack.bean.key.IahnNodeMekKey;
import com.dwarfeng.settingrepo.stack.bean.key.IahnNodeMessageKey;
import com.dwarfeng.settingrepo.stack.bean.key.KvNodeItemKey;
import com.dwarfeng.subgrade.impl.bean.MapStructBeanTransformer;
import com.dwarfeng.subgrade.impl.cache.RedisBatchBaseCache;
import com.dwarfeng.subgrade.sdk.redis.formatter.LongIdStringKeyFormatter;
import com.dwarfeng.subgrade.sdk.redis.formatter.StringIdStringKeyFormatter;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class SettingrepoCacheConfiguration {

    private final RedisTemplate<String, ?> template;

    @Value("${com.dwarfeng.essentials.cache.prefix.entity.settingrepo.formatter_support}")
    private String formatterSupportPrefix;
    @Value("${com.dwarfeng.essentials.cache.prefix.entity.settingrepo.setting_category}")
    private String settingCategoryPrefix;
    @Value("${com.dwarfeng.essentials.cache.prefix.entity.settingrepo.setting_node}")
    private String settingNodePrefix;
    @Value("${com.dwarfeng.essentials.cache.prefix.entity.settingrepo.text_node}")
    private String textNodePrefix;
    @Value("${com.dwarfeng.essentials.cache.prefix.entity.settingrepo.text_list_node}")
    private String textListNodePrefix;
    @Value("${com.dwarfeng.essentials.cache.prefix.entity.settingrepo.text_list_node_item}")
    private String textListNodeItemPrefix;
    @Value("${com.dwarfeng.essentials.cache.prefix.entity.settingrepo.image_node}")
    private String imageNodePrefix;
    @Value("${com.dwarfeng.essentials.cache.prefix.entity.settingrepo.image_list_node}")
    private String imageListNodePrefix;
    @Value("${com.dwarfeng.essentials.cache.prefix.entity.settingrepo.image_list_node_item}")
    private String imageListNodeItemPrefix;
    @Value("${com.dwarfeng.essentials.cache.prefix.entity.settingrepo.iahn_node}")
    private String iahnNodePrefix;
    @Value("${com.dwarfeng.essentials.cache.prefix.entity.settingrepo.iahn_node_locale}")
    private String iahnNodeLocalePrefix;
    @Value("${com.dwarfeng.essentials.cache.prefix.entity.settingrepo.iahn_node_mek}")
    private String iahnNodeMekPrefix;
    @Value("${com.dwarfeng.essentials.cache.prefix.entity.settingrepo.iahn_node_message}")
    private String iahnNodeMessagePrefix;
    @Value("${com.dwarfeng.essentials.cache.prefix.entity.settingrepo.long_text_node}")
    private String longTextNodePrefix;
    @Value("${com.dwarfeng.essentials.cache.prefix.entity.settingrepo.file_node}")
    private String fileNodePrefix;
    @Value("${com.dwarfeng.essentials.cache.prefix.entity.settingrepo.file_list_node}")
    private String fileListNodePrefix;
    @Value("${com.dwarfeng.essentials.cache.prefix.entity.settingrepo.file_list_node_item}")
    private String fileListNodeItemPrefix;
    @Value("${com.dwarfeng.essentials.cache.prefix.entity.settingrepo.navigation_node}")
    private String navigationNodePrefix;
    @Value("${com.dwarfeng.essentials.cache.prefix.entity.settingrepo.navigation_node_item}")
    private String navigationNodeItemPrefix;
    @Value("${com.dwarfeng.essentials.cache.prefix.entity.settingrepo.kv_node}")
    private String kvNodePrefix;
    @Value("${com.dwarfeng.essentials.cache.prefix.entity.settingrepo.kv_node_item}")
    private String kvNodeItemPrefix;
    @Value("${com.dwarfeng.essentials.cache.prefix.entity.settingrepo.warmup_setting}")
    private String warmupSettingPrefix;
    @Value("${com.dwarfeng.essentials.cache.prefix.entity.settingrepo.warmup_driver_info}")
    private String warmupDriverInfoPrefix;
    @Value("${com.dwarfeng.essentials.cache.prefix.entity.settingrepo.warmup_driver_support}")
    private String warmupDriverSupportPrefix;
    @Value("${com.dwarfeng.essentials.cache.prefix.entity.settingrepo.video_node}")
    private String videoNodePrefix;
    @Value("${com.dwarfeng.essentials.cache.prefix.entity.settingrepo.video_list_node}")
    private String videoListNodePrefix;
    @Value("${com.dwarfeng.essentials.cache.prefix.entity.settingrepo.video_list_node_item}")
    private String videoListNodeItemPrefix;

    public SettingrepoCacheConfiguration(RedisTemplate<String, ?> template) {
        this.template = template;
    }

    @Bean(name = "settingrepo.formatterSupportRedisBatchBaseCache")
    @SuppressWarnings("unchecked")
    public RedisBatchBaseCache<StringIdKey, FormatterSupport, FastJsonFormatterSupport>
    formatterSupportRedisBatchBaseCache() {
        return new RedisBatchBaseCache<>(
                (RedisTemplate<String, FastJsonFormatterSupport>) template,
                new StringIdStringKeyFormatter(formatterSupportPrefix),
                new MapStructBeanTransformer<>(
                        FormatterSupport.class, FastJsonFormatterSupport.class, BeanMapper.class
                )
        );
    }

    @Bean(name = "settingrepo.settingCategoryRedisBatchBaseCache")
    @SuppressWarnings("unchecked")
    public RedisBatchBaseCache<StringIdKey, SettingCategory, FastJsonSettingCategory>
    settingCategoryRedisBatchBaseCache() {
        return new RedisBatchBaseCache<>(
                (RedisTemplate<String, FastJsonSettingCategory>) template,
                new StringIdStringKeyFormatter(settingCategoryPrefix),
                new MapStructBeanTransformer<>(
                        SettingCategory.class, FastJsonSettingCategory.class, BeanMapper.class
                )
        );
    }

    @Bean(name = "settingrepo.settingNodeRedisBatchBaseCache")
    @SuppressWarnings("unchecked")
    public RedisBatchBaseCache<StringIdKey, SettingNode, FastJsonSettingNode> settingNodeRedisBatchBaseCache() {
        return new RedisBatchBaseCache<>(
                (RedisTemplate<String, FastJsonSettingNode>) template,
                new StringIdStringKeyFormatter(settingNodePrefix),
                new MapStructBeanTransformer<>(
                        SettingNode.class, FastJsonSettingNode.class, BeanMapper.class
                )
        );
    }

    @Bean(name = "settingrepo.textNodeRedisBatchBaseCache")
    @SuppressWarnings("unchecked")
    public RedisBatchBaseCache<StringIdKey, TextNode, FastJsonTextNode> textNodeRedisBatchBaseCache() {
        return new RedisBatchBaseCache<>(
                (RedisTemplate<String, FastJsonTextNode>) template,
                new StringIdStringKeyFormatter(textNodePrefix),
                new MapStructBeanTransformer<>(
                        TextNode.class, FastJsonTextNode.class, BeanMapper.class
                )
        );
    }

    @Bean(name = "settingrepo.textListNodeRedisBatchBaseCache")
    @SuppressWarnings("unchecked")
    public RedisBatchBaseCache<StringIdKey, TextListNode, FastJsonTextListNode> textListNodeRedisBatchBaseCache() {
        return new RedisBatchBaseCache<>(
                (RedisTemplate<String, FastJsonTextListNode>) template,
                new StringIdStringKeyFormatter(textListNodePrefix),
                new MapStructBeanTransformer<>(
                        TextListNode.class, FastJsonTextListNode.class, BeanMapper.class
                )
        );
    }

    @Bean(name = "settingrepo.textListNodeItemRedisBatchBaseCache")
    @SuppressWarnings("unchecked")
    public RedisBatchBaseCache<LongIdKey, TextListNodeItem, FastJsonTextListNodeItem>
    textListNodeItemRedisBatchBaseCache() {
        return new RedisBatchBaseCache<>(
                (RedisTemplate<String, FastJsonTextListNodeItem>) template,
                new LongIdStringKeyFormatter(textListNodeItemPrefix),
                new MapStructBeanTransformer<>(
                        TextListNodeItem.class, FastJsonTextListNodeItem.class, BeanMapper.class
                )
        );
    }

    @Bean(name = "settingrepo.imageNodeRedisBatchBaseCache")
    @SuppressWarnings("unchecked")
    public RedisBatchBaseCache<StringIdKey, ImageNode, FastJsonImageNode> imageNodeRedisBatchBaseCache() {
        return new RedisBatchBaseCache<>(
                (RedisTemplate<String, FastJsonImageNode>) template,
                new StringIdStringKeyFormatter(imageNodePrefix),
                new MapStructBeanTransformer<>(
                        ImageNode.class, FastJsonImageNode.class, BeanMapper.class
                )
        );
    }

    @Bean(name = "settingrepo.imageListNodeRedisBatchBaseCache")
    @SuppressWarnings("unchecked")
    public RedisBatchBaseCache<StringIdKey, ImageListNode, FastJsonImageListNode> imageListNodeRedisBatchBaseCache() {
        return new RedisBatchBaseCache<>(
                (RedisTemplate<String, FastJsonImageListNode>) template,
                new StringIdStringKeyFormatter(imageListNodePrefix),
                new MapStructBeanTransformer<>(
                        ImageListNode.class, FastJsonImageListNode.class, BeanMapper.class
                )
        );
    }

    @Bean(name = "settingrepo.imageListNodeItemRedisBatchBaseCache")
    @SuppressWarnings("unchecked")
    public RedisBatchBaseCache<LongIdKey, ImageListNodeItem, FastJsonImageListNodeItem>
    imageListNodeItemRedisBatchBaseCache() {
        return new RedisBatchBaseCache<>(
                (RedisTemplate<String, FastJsonImageListNodeItem>) template,
                new LongIdStringKeyFormatter(imageListNodeItemPrefix),
                new MapStructBeanTransformer<>(
                        ImageListNodeItem.class, FastJsonImageListNodeItem.class, BeanMapper.class
                )
        );
    }

    @Bean(name = "settingrepo.iahnNodeRedisBatchBaseCache")
    @SuppressWarnings("unchecked")
    public RedisBatchBaseCache<StringIdKey, IahnNode, FastJsonIahnNode> iahnNodeRedisBatchBaseCache() {
        return new RedisBatchBaseCache<>(
                (RedisTemplate<String, FastJsonIahnNode>) template,
                new StringIdStringKeyFormatter(iahnNodePrefix),
                new MapStructBeanTransformer<>(
                        IahnNode.class, FastJsonIahnNode.class, BeanMapper.class
                )
        );
    }

    @Bean(name = "settingrepo.iahnNodeLocaleRedisBatchBaseCache")
    @SuppressWarnings("unchecked")
    public RedisBatchBaseCache<IahnNodeLocaleKey, IahnNodeLocale, FastJsonIahnNodeLocale>
    iahnNodeLocaleRedisBatchBaseCache() {
        return new RedisBatchBaseCache<>(
                (RedisTemplate<String, FastJsonIahnNodeLocale>) template,
                new IahnNodeLocaleStringKeyFormatter(iahnNodeLocalePrefix),
                new MapStructBeanTransformer<>(
                        IahnNodeLocale.class, FastJsonIahnNodeLocale.class, BeanMapper.class
                )
        );
    }

    @Bean(name = "settingrepo.iahnNodeMekRedisBatchBaseCache")
    @SuppressWarnings("unchecked")
    public RedisBatchBaseCache<IahnNodeMekKey, IahnNodeMek, FastJsonIahnNodeMek>
    iahnNodeMekRedisBatchBaseCache() {
        return new RedisBatchBaseCache<>(
                (RedisTemplate<String, FastJsonIahnNodeMek>) template,
                new IahnNodeMekStringKeyFormatter(iahnNodeMekPrefix),
                new MapStructBeanTransformer<>(
                        IahnNodeMek.class, FastJsonIahnNodeMek.class, BeanMapper.class
                )
        );
    }

    @Bean(name = "settingrepo.iahnNodeMessageRedisBatchBaseCache")
    @SuppressWarnings("unchecked")
    public RedisBatchBaseCache<IahnNodeMessageKey, IahnNodeMessage, FastJsonIahnNodeMessage>
    iahnNodeMessageRedisBatchBaseCache() {
        return new RedisBatchBaseCache<>(
                (RedisTemplate<String, FastJsonIahnNodeMessage>) template,
                new IahnNodeMessageStringKeyFormatter(iahnNodeMessagePrefix),
                new MapStructBeanTransformer<>(
                        IahnNodeMessage.class, FastJsonIahnNodeMessage.class, BeanMapper.class
                )
        );
    }

    @Bean(name = "settingrepo.longTextNodeRedisBatchBaseCache")
    @SuppressWarnings("unchecked")
    public RedisBatchBaseCache<StringIdKey, LongTextNode, FastJsonLongTextNode> longTextNodeRedisBatchBaseCache() {
        return new RedisBatchBaseCache<>(
                (RedisTemplate<String, FastJsonLongTextNode>) template,
                new StringIdStringKeyFormatter(longTextNodePrefix),
                new MapStructBeanTransformer<>(
                        LongTextNode.class, FastJsonLongTextNode.class, BeanMapper.class
                )
        );
    }

    @Bean(name = "settingrepo.fileNodeRedisBatchBaseCache")
    @SuppressWarnings("unchecked")
    public RedisBatchBaseCache<StringIdKey, FileNode, FastJsonFileNode> fileNodeRedisBatchBaseCache() {
        return new RedisBatchBaseCache<>(
                (RedisTemplate<String, FastJsonFileNode>) template,
                new StringIdStringKeyFormatter(fileNodePrefix),
                new MapStructBeanTransformer<>(
                        FileNode.class, FastJsonFileNode.class, BeanMapper.class
                )
        );
    }

    @Bean(name = "settingrepo.fileListNodeRedisBatchBaseCache")
    @SuppressWarnings("unchecked")
    public RedisBatchBaseCache<StringIdKey, FileListNode, FastJsonFileListNode> fileListNodeRedisBatchBaseCache() {
        return new RedisBatchBaseCache<>(
                (RedisTemplate<String, FastJsonFileListNode>) template,
                new StringIdStringKeyFormatter(fileListNodePrefix),
                new MapStructBeanTransformer<>(FileListNode.class, FastJsonFileListNode.class, BeanMapper.class)
        );
    }

    @Bean(name = "settingrepo.fileListNodeItemRedisBatchBaseCache")
    @SuppressWarnings("unchecked")
    public RedisBatchBaseCache<LongIdKey, FileListNodeItem, FastJsonFileListNodeItem>
    fileListNodeItemRedisBatchBaseCache() {
        return new RedisBatchBaseCache<>(
                (RedisTemplate<String, FastJsonFileListNodeItem>) template,
                new LongIdStringKeyFormatter(fileListNodeItemPrefix),
                new MapStructBeanTransformer<>(FileListNodeItem.class, FastJsonFileListNodeItem.class, BeanMapper.class)
        );
    }

    @Bean(name = "settingrepo.navigationNodeRedisBatchBaseCache")
    @SuppressWarnings("unchecked")
    public RedisBatchBaseCache<StringIdKey, NavigationNode, FastJsonNavigationNode>
    navigationNodeRedisBatchBaseCache() {
        return new RedisBatchBaseCache<>(
                (RedisTemplate<String, FastJsonNavigationNode>) template,
                new StringIdStringKeyFormatter(navigationNodePrefix),
                new MapStructBeanTransformer<>(
                        NavigationNode.class, FastJsonNavigationNode.class, BeanMapper.class
                )
        );
    }

    @Bean(name = "settingrepo.navigationNodeItemRedisBatchBaseCache")
    @SuppressWarnings("unchecked")
    public RedisBatchBaseCache<LongIdKey, NavigationNodeItem, FastJsonNavigationNodeItem>
    navigationNodeItemRedisBatchBaseCache() {
        return new RedisBatchBaseCache<>(
                (RedisTemplate<String, FastJsonNavigationNodeItem>) template,
                new LongIdStringKeyFormatter(navigationNodeItemPrefix),
                new MapStructBeanTransformer<>(
                        NavigationNodeItem.class, FastJsonNavigationNodeItem.class, BeanMapper.class
                )
        );
    }

    @Bean(name = "settingrepo.kvNodeCacheDelegate")
    @SuppressWarnings("unchecked")
    public RedisBatchBaseCache<StringIdKey, KvNode, FastJsonKvNode> kvNodeCacheDelegate() {
        return new RedisBatchBaseCache<>(
                (RedisTemplate<String, FastJsonKvNode>) template,
                new StringIdStringKeyFormatter(kvNodePrefix),
                new MapStructBeanTransformer<>(KvNode.class, FastJsonKvNode.class, BeanMapper.class)
        );
    }

    @Bean(name = "settingrepo.kvNodeItemCacheDelegate")
    @SuppressWarnings("unchecked")
    public RedisBatchBaseCache<KvNodeItemKey, KvNodeItem, FastJsonKvNodeItem> kvNodeItemCacheDelegate() {
        return new RedisBatchBaseCache<>(
                (RedisTemplate<String, FastJsonKvNodeItem>) template,
                new KvNodeItemStringKeyFormatter(kvNodeItemPrefix),
                new MapStructBeanTransformer<>(KvNodeItem.class, FastJsonKvNodeItem.class, BeanMapper.class)
        );
    }

    @Bean(name = "settingrepo.warmupSettingCacheDelegate")
    @SuppressWarnings("unchecked")
    public RedisBatchBaseCache<LongIdKey, WarmupSetting, FastJsonWarmupSetting> warmupSettingCacheDelegate() {
        return new RedisBatchBaseCache<>(
                (RedisTemplate<String, FastJsonWarmupSetting>) template,
                new LongIdStringKeyFormatter(warmupSettingPrefix),
                new MapStructBeanTransformer<>(WarmupSetting.class, FastJsonWarmupSetting.class, BeanMapper.class)
        );
    }

    @Bean(name = "settingrepo.warmupDriverInfoCacheDelegate")
    @SuppressWarnings("unchecked")
    public RedisBatchBaseCache<LongIdKey, WarmupDriverInfo, FastJsonWarmupDriverInfo>
    warmupDriverInfoCacheDelegate() {
        return new RedisBatchBaseCache<>(
                (RedisTemplate<String, FastJsonWarmupDriverInfo>) template,
                new LongIdStringKeyFormatter(warmupDriverInfoPrefix),
                new MapStructBeanTransformer<>(
                        WarmupDriverInfo.class, FastJsonWarmupDriverInfo.class, BeanMapper.class
                )
        );
    }

    @Bean(name = "settingrepo.warmupDriverSupportCacheDelegate")
    @SuppressWarnings("unchecked")
    public RedisBatchBaseCache<StringIdKey, WarmupDriverSupport, FastJsonWarmupDriverSupport>
    warmupDriverSupportCacheDelegate() {
        return new RedisBatchBaseCache<>(
                (RedisTemplate<String, FastJsonWarmupDriverSupport>) template,
                new StringIdStringKeyFormatter(warmupDriverSupportPrefix),
                new MapStructBeanTransformer<>(
                        WarmupDriverSupport.class, FastJsonWarmupDriverSupport.class, BeanMapper.class
                )
        );
    }

    @Bean(name = "settingrepo.videoNodeRedisBatchBaseCache")
    @SuppressWarnings("unchecked")
    public RedisBatchBaseCache<StringIdKey, VideoNode, FastJsonVideoNode> videoNodeRedisBatchBaseCache() {
        return new RedisBatchBaseCache<>(
                (RedisTemplate<String, FastJsonVideoNode>) template,
                new StringIdStringKeyFormatter(videoNodePrefix),
                new MapStructBeanTransformer<>(
                        VideoNode.class, FastJsonVideoNode.class, BeanMapper.class
                )
        );
    }

    @Bean(name = "settingrepo.videoListNodeRedisBatchBaseCache")
    @SuppressWarnings("unchecked")
    public RedisBatchBaseCache<StringIdKey, VideoListNode, FastJsonVideoListNode> videoListNodeRedisBatchBaseCache() {
        return new RedisBatchBaseCache<>(
                (RedisTemplate<String, FastJsonVideoListNode>) template,
                new StringIdStringKeyFormatter(videoListNodePrefix),
                new MapStructBeanTransformer<>(
                        VideoListNode.class, FastJsonVideoListNode.class, BeanMapper.class
                )
        );
    }

    @Bean(name = "settingrepo.videoListNodeItemRedisBatchBaseCache")
    @SuppressWarnings("unchecked")
    public RedisBatchBaseCache<LongIdKey, VideoListNodeItem, FastJsonVideoListNodeItem>
    videoListNodeItemRedisBatchBaseCache() {
        return new RedisBatchBaseCache<>(
                (RedisTemplate<String, FastJsonVideoListNodeItem>) template,
                new LongIdStringKeyFormatter(videoListNodeItemPrefix),
                new MapStructBeanTransformer<>(
                        VideoListNodeItem.class, FastJsonVideoListNodeItem.class, BeanMapper.class
                )
        );
    }
}
