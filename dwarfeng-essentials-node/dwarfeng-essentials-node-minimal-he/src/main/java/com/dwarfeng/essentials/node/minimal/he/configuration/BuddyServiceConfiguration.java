package com.dwarfeng.essentials.node.minimal.he.configuration;

import com.dwarfeng.buddy.impl.service.operation.AvatarInfoCrudOperation;
import com.dwarfeng.buddy.impl.service.operation.UserCrudOperation;
import com.dwarfeng.buddy.stack.bean.entity.AvatarInfo;
import com.dwarfeng.buddy.stack.bean.entity.Notification;
import com.dwarfeng.buddy.stack.bean.entity.Profile;
import com.dwarfeng.buddy.stack.bean.entity.User;
import com.dwarfeng.buddy.stack.cache.NotificationCache;
import com.dwarfeng.buddy.stack.cache.ProfileCache;
import com.dwarfeng.buddy.stack.dao.AvatarInfoDao;
import com.dwarfeng.buddy.stack.dao.NotificationDao;
import com.dwarfeng.buddy.stack.dao.ProfileDao;
import com.dwarfeng.buddy.stack.dao.UserDao;
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
public class BuddyServiceConfiguration {

    private final ServiceExceptionMapperConfiguration serviceExceptionMapperConfiguration;
    private final GenerateConfiguration generateConfiguration;

    private final AvatarInfoDao avatarInfoDao;
    private final AvatarInfoCrudOperation avatarInfoCrudOperation;
    private final NotificationDao notificationDao;
    private final NotificationCache notificationCache;
    private final ProfileDao profileDao;
    private final ProfileCache profileCache;
    private final UserCrudOperation userCrudOperation;
    private final UserDao userDao;

    @Value("${com.dwarfeng.essentials.cache.timeout.entity.buddy.notification}")
    private long notificationTimeout;
    @Value("${com.dwarfeng.essentials.cache.timeout.entity.buddy.profile}")
    private long profileTimeout;

    public BuddyServiceConfiguration(
            ServiceExceptionMapperConfiguration serviceExceptionMapperConfiguration,
            GenerateConfiguration generateConfiguration,
            AvatarInfoDao avatarInfoDao,
            AvatarInfoCrudOperation avatarInfoCrudOperation,
            NotificationDao notificationDao,
            NotificationCache notificationCache,
            ProfileDao profileDao,
            ProfileCache profileCache,
            UserCrudOperation userCrudOperation,
            UserDao userDao
    ) {
        this.serviceExceptionMapperConfiguration = serviceExceptionMapperConfiguration;
        this.generateConfiguration = generateConfiguration;
        this.avatarInfoDao = avatarInfoDao;
        this.avatarInfoCrudOperation = avatarInfoCrudOperation;
        this.notificationDao = notificationDao;
        this.notificationCache = notificationCache;
        this.profileDao = profileDao;
        this.profileCache = profileCache;
        this.userCrudOperation = userCrudOperation;
        this.userDao = userDao;
    }

    @Bean(name = "buddy.avatarInfoCustomBatchCrudService")
    public CustomBatchCrudService<StringIdKey, AvatarInfo> avatarInfoCustomBatchCrudService() {
        return new CustomBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                avatarInfoCrudOperation,
                new ExceptionKeyGenerator<>()
        );
    }

    @Bean(name = "buddy.avatarInfoDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<AvatarInfo> avatarInfoDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                avatarInfoDao
        );
    }

    @Bean(name = "buddy.avatarInfoDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<AvatarInfo> avatarInfoDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                avatarInfoDao
        );
    }

    @Bean(name = "buddy.notificationGeneralBatchCrudService")
    public GeneralBatchCrudService<LongIdKey, Notification> notificationGeneralBatchCrudService() {
        return new GeneralBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                notificationDao,
                notificationCache,
                generateConfiguration.snowflakeLongIdKeyGenerator(),
                notificationTimeout
        );
    }

    @Bean(name = "buddy.notificationDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<Notification> notificationDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                notificationDao
        );
    }

    @Bean(name = "buddy.notificationDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<Notification> notificationDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                notificationDao
        );
    }

    @Bean(name = "buddy.profileGeneralBatchCrudService")
    public GeneralBatchCrudService<StringIdKey, Profile> profileGeneralBatchCrudService() {
        return new GeneralBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                profileDao,
                profileCache,
                new ExceptionKeyGenerator<>(),
                profileTimeout
        );
    }

    @Bean(name = "buddy.profileDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<Profile> profileDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                profileDao
        );
    }

    @Bean(name = "buddy.profileDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<Profile> profileDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                profileDao
        );
    }

    @Bean(name = "buddy.userCustomBatchCrudService")
    public CustomBatchCrudService<StringIdKey, User> userCustomBatchCrudService() {
        return new CustomBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                userCrudOperation,
                new ExceptionKeyGenerator<>()
        );
    }

    @Bean(name = "buddy.userDaoOnlyEntireLookupService")
    public DaoOnlyEntireLookupService<User> userDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                userDao
        );
    }

    @Bean(name = "buddy.userDaoOnlyPresetLookupService")
    public DaoOnlyPresetLookupService<User> userDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                userDao
        );
    }
}
