package com.dwarfeng.essentials.node.all.he.configuration;

import com.alibaba.fastjson.parser.ParserConfig;
import com.dwarfeng.buddy.sdk.bean.entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BuddyFastJsonConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(BuddyFastJsonConfiguration.class);

    public BuddyFastJsonConfiguration() {
        LOGGER.info("正在配置 FastJson autotype 白名单");
        ParserConfig.getGlobalInstance().addAccept(FastJsonAvatarInfo.class.getCanonicalName());
        ParserConfig.getGlobalInstance().addAccept(JSFixedFastJsonAvatarInfo.class.getCanonicalName());
        ParserConfig.getGlobalInstance().addAccept(FastJsonNotification.class.getCanonicalName());
        ParserConfig.getGlobalInstance().addAccept(JSFixedFastJsonNotification.class.getCanonicalName());
        ParserConfig.getGlobalInstance().addAccept(FastJsonProfile.class.getCanonicalName());
        ParserConfig.getGlobalInstance().addAccept(JSFixedFastJsonProfile.class.getCanonicalName());
        ParserConfig.getGlobalInstance().addAccept(FastJsonUser.class.getCanonicalName());
        ParserConfig.getGlobalInstance().addAccept(JSFixedFastJsonUser.class.getCanonicalName());
        LOGGER.debug("FastJson autotype 白名单配置完毕");
    }
}
