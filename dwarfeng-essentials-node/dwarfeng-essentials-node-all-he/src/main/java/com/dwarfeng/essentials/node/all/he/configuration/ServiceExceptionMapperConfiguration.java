package com.dwarfeng.essentials.node.all.he.configuration;

import com.dwarfeng.subgrade.impl.exception.MapServiceExceptionMapper;
import com.dwarfeng.subgrade.sdk.exception.ServiceExceptionHelper;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class ServiceExceptionMapperConfiguration {

    @Bean(name = "mapServiceExceptionMapper")
    public MapServiceExceptionMapper mapServiceExceptionMapper() {
        Map<Class<? extends Exception>, ServiceException.Code> des = ServiceExceptionHelper.putDefaultDestination(null);
        des = com.dwarfeng.springtelqos.sdk.util.ServiceExceptionHelper.putDefaultDestination(des);
        des = com.dwarfeng.springterminator.sdk.util.ServiceExceptionHelper.putDefaultDestination(des);
        des = com.dwarfeng.datamark.sdk.util.ServiceExceptionHelper.putDefaultDestination(des);
        des = com.dwarfeng.ftp.sdk.util.ServiceExceptionHelper.putDefaultDestination(des);
        des = com.dwarfeng.acckeeper.sdk.util.ServiceExceptionHelper.putDefaultDestination(des);
        des = com.dwarfeng.rbacds.sdk.util.ServiceExceptionHelper.putDefaultDestination(des);
        des = com.dwarfeng.buddy.sdk.util.ServiceExceptionHelper.putDefaultDestination(des);
        des = com.dwarfeng.settingrepo.sdk.util.ServiceExceptionHelper.putDefaultDestination(des);
        des = com.dwarfeng.notify.sdk.util.ServiceExceptionHelper.putDefaultDestination(des);
        des = com.dwarfeng.logicengine.sdk.util.ServiceExceptionHelper.putDefaultDestination(des);
        des = com.dwarfeng.audit.sdk.util.ServiceExceptionHelper.putDefaultDestination(des);
        des = com.dwarfeng.fileio.sdk.util.ServiceExceptionHelper.putDefaultDestination(des);
        des = com.dwarfeng.voucher.sdk.util.ServiceExceptionHelper.putDefaultDestination(des);
        return new MapServiceExceptionMapper(des, com.dwarfeng.subgrade.sdk.exception.ServiceExceptionCodes.UNDEFINED);
    }
}
