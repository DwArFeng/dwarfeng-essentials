package com.dwarfeng.essentials.node.all.he.configuration;

import com.dwarfeng.buddy.impl.bean.BeanMapper;
import com.dwarfeng.buddy.impl.bean.entity.HibernateAvatarInfo;
import com.dwarfeng.buddy.impl.bean.entity.HibernateNotification;
import com.dwarfeng.buddy.impl.bean.entity.HibernateProfile;
import com.dwarfeng.buddy.impl.bean.entity.HibernateUser;
import com.dwarfeng.buddy.impl.dao.preset.AvatarInfoPresetCriteriaMaker;
import com.dwarfeng.buddy.impl.dao.preset.NotificationPresetCriteriaMaker;
import com.dwarfeng.buddy.impl.dao.preset.ProfilePresetCriteriaMaker;
import com.dwarfeng.buddy.impl.dao.preset.UserPresetCriteriaMaker;
import com.dwarfeng.buddy.stack.bean.entity.AvatarInfo;
import com.dwarfeng.buddy.stack.bean.entity.Notification;
import com.dwarfeng.buddy.stack.bean.entity.Profile;
import com.dwarfeng.buddy.stack.bean.entity.User;
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
public class BuddyDaoConfiguration {

    private final HibernateTemplate template;

    private final AvatarInfoPresetCriteriaMaker avatarInfoPresetCriteriaMaker;
    private final NotificationPresetCriteriaMaker notificationPresetCriteriaMaker;
    private final ProfilePresetCriteriaMaker profilePresetCriteriaMaker;
    private final UserPresetCriteriaMaker userPresetCriteriaMaker;

    @Value("${com.dwarfeng.essentials.hibernate.jdbc.batch_size}")
    private int batchSize;

    public BuddyDaoConfiguration(
            HibernateTemplate template,
            AvatarInfoPresetCriteriaMaker avatarInfoPresetCriteriaMaker,
            NotificationPresetCriteriaMaker notificationPresetCriteriaMaker,
            ProfilePresetCriteriaMaker profilePresetCriteriaMaker,
            UserPresetCriteriaMaker userPresetCriteriaMaker
    ) {
        this.template = template;
        this.avatarInfoPresetCriteriaMaker = avatarInfoPresetCriteriaMaker;
        this.notificationPresetCriteriaMaker = notificationPresetCriteriaMaker;
        this.profilePresetCriteriaMaker = profilePresetCriteriaMaker;
        this.userPresetCriteriaMaker = userPresetCriteriaMaker;
    }

    @Bean(name = "buddy.avatarInfoHibernateBatchBaseDao")
    public HibernateBatchBaseDao<StringIdKey, HibernateStringIdKey, AvatarInfo, HibernateAvatarInfo>
    avatarInfoHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(StringIdKey.class, HibernateStringIdKey.class, BeanMapper.class),
                new MapStructBeanTransformer<>(AvatarInfo.class, HibernateAvatarInfo.class, BeanMapper.class),
                HibernateAvatarInfo.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean(name = "buddy.avatarInfoHibernateEntireLookupDao")
    public HibernateEntireLookupDao<AvatarInfo, HibernateAvatarInfo> avatarInfoHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(AvatarInfo.class, HibernateAvatarInfo.class, BeanMapper.class),
                HibernateAvatarInfo.class
        );
    }

    @Bean(name = "buddy.avatarInfoHibernatePresetLookupDao")
    public HibernatePresetLookupDao<AvatarInfo, HibernateAvatarInfo> avatarInfoHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(AvatarInfo.class, HibernateAvatarInfo.class, BeanMapper.class),
                HibernateAvatarInfo.class,
                avatarInfoPresetCriteriaMaker
        );
    }

    @Bean(name = "buddy.notificationHibernateBatchBaseDao")
    public HibernateBatchBaseDao<LongIdKey, HibernateLongIdKey, Notification, HibernateNotification>
    notificationHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(LongIdKey.class, HibernateLongIdKey.class, BeanMapper.class),
                new MapStructBeanTransformer<>(Notification.class, HibernateNotification.class, BeanMapper.class),
                HibernateNotification.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean(name = "buddy.notificationHibernateEntireLookupDao")
    public HibernateEntireLookupDao<Notification, HibernateNotification> notificationHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(Notification.class, HibernateNotification.class, BeanMapper.class),
                HibernateNotification.class
        );
    }

    @Bean(name = "buddy.notificationHibernatePresetLookupDao")
    public HibernatePresetLookupDao<Notification, HibernateNotification> notificationHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(Notification.class, HibernateNotification.class, BeanMapper.class),
                HibernateNotification.class,
                notificationPresetCriteriaMaker
        );
    }

    @Bean(name = "buddy.profileHibernateBatchBaseDao")
    public HibernateBatchBaseDao<StringIdKey, HibernateStringIdKey, Profile, HibernateProfile>
    profileHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(StringIdKey.class, HibernateStringIdKey.class, BeanMapper.class),
                new MapStructBeanTransformer<>(Profile.class, HibernateProfile.class, BeanMapper.class),
                HibernateProfile.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean(name = "buddy.profileHibernateEntireLookupDao")
    public HibernateEntireLookupDao<Profile, HibernateProfile> profileHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(Profile.class, HibernateProfile.class, BeanMapper.class),
                HibernateProfile.class
        );
    }

    @Bean(name = "buddy.profileHibernatePresetLookupDao")
    public HibernatePresetLookupDao<Profile, HibernateProfile> profileHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(Profile.class, HibernateProfile.class, BeanMapper.class),
                HibernateProfile.class,
                profilePresetCriteriaMaker
        );
    }

    @Bean(name = "buddy.userHibernateBatchBaseDao")
    public HibernateBatchBaseDao<StringIdKey, HibernateStringIdKey, User, HibernateUser> userHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(StringIdKey.class, HibernateStringIdKey.class, BeanMapper.class),
                new MapStructBeanTransformer<>(User.class, HibernateUser.class, BeanMapper.class),
                HibernateUser.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean(name = "buddy.userHibernateEntireLookupDao")
    public HibernateEntireLookupDao<User, HibernateUser> userHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(User.class, HibernateUser.class, BeanMapper.class),
                HibernateUser.class
        );
    }

    @Bean(name = "buddy.userHibernatePresetLookupDao")
    public HibernatePresetLookupDao<User, HibernateUser> userHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(User.class, HibernateUser.class, BeanMapper.class),
                HibernateUser.class,
                userPresetCriteriaMaker
        );
    }
}
