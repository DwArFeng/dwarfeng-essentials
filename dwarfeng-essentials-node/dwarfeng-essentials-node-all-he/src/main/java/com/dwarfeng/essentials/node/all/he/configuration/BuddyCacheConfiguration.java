package com.dwarfeng.essentials.node.all.he.configuration;

import com.dwarfeng.buddy.sdk.bean.BeanMapper;
import com.dwarfeng.buddy.sdk.bean.entity.FastJsonAvatarInfo;
import com.dwarfeng.buddy.sdk.bean.entity.FastJsonNotification;
import com.dwarfeng.buddy.sdk.bean.entity.FastJsonProfile;
import com.dwarfeng.buddy.sdk.bean.entity.FastJsonUser;
import com.dwarfeng.buddy.stack.bean.entity.AvatarInfo;
import com.dwarfeng.buddy.stack.bean.entity.Notification;
import com.dwarfeng.buddy.stack.bean.entity.Profile;
import com.dwarfeng.buddy.stack.bean.entity.User;
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
public class BuddyCacheConfiguration {

    private final RedisTemplate<String, ?> template;

    @Value("${com.dwarfeng.essentials.cache.prefix.entity.buddy.avatar_info}")
    private String avatarInfoPrefix;
    @Value("${com.dwarfeng.essentials.cache.prefix.entity.buddy.notification}")
    private String notificationPrefix;
    @Value("${com.dwarfeng.essentials.cache.prefix.entity.buddy.profile}")
    private String profilePrefix;
    @Value("${com.dwarfeng.essentials.cache.prefix.entity.buddy.user}")
    private String userPrefix;

    public BuddyCacheConfiguration(RedisTemplate<String, ?> template) {
        this.template = template;
    }

    @Bean(name = "buddy.avatarInfoRedisBatchBaseCache")
    @SuppressWarnings("unchecked")
    public RedisBatchBaseCache<StringIdKey, AvatarInfo, FastJsonAvatarInfo> avatarInfoRedisBatchBaseCache() {
        return new RedisBatchBaseCache<>(
                (RedisTemplate<String, FastJsonAvatarInfo>) template,
                new StringIdStringKeyFormatter(avatarInfoPrefix),
                new MapStructBeanTransformer<>(AvatarInfo.class, FastJsonAvatarInfo.class, BeanMapper.class)
        );
    }

    @Bean(name = "buddy.notificationRedisBatchBaseCache")
    @SuppressWarnings("unchecked")
    public RedisBatchBaseCache<LongIdKey, Notification, FastJsonNotification> notificationRedisBatchBaseCache() {
        return new RedisBatchBaseCache<>(
                (RedisTemplate<String, FastJsonNotification>) template,
                new LongIdStringKeyFormatter(notificationPrefix),
                new MapStructBeanTransformer<>(Notification.class, FastJsonNotification.class, BeanMapper.class)
        );
    }

    @Bean(name = "buddy.profileRedisBatchBaseCache")
    @SuppressWarnings("unchecked")
    public RedisBatchBaseCache<StringIdKey, Profile, FastJsonProfile> profileRedisBatchBaseCache() {
        return new RedisBatchBaseCache<>(
                (RedisTemplate<String, FastJsonProfile>) template,
                new StringIdStringKeyFormatter(profilePrefix),
                new MapStructBeanTransformer<>(Profile.class, FastJsonProfile.class, BeanMapper.class)
        );
    }

    @Bean(name = "buddy.userRedisBatchBaseCache")
    @SuppressWarnings("unchecked")
    public RedisBatchBaseCache<StringIdKey, User, FastJsonUser> userRedisBatchBaseCache() {
        return new RedisBatchBaseCache<>(
                (RedisTemplate<String, FastJsonUser>) template,
                new StringIdStringKeyFormatter(userPrefix),
                new MapStructBeanTransformer<>(User.class, FastJsonUser.class, BeanMapper.class)
        );
    }
}
