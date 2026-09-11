package com.dwarfeng.essentials.node.minimal.he.handler;

import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.config.DubboShutdownHook;
import org.apache.dubbo.rpc.Protocol;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Nonnull;

/**
 * Dubbo 协议关闭处理器。
 *
 * <p>聚合节点同时运行 Dubbo 与 Hessian 协议。Spring 销毁服务 Bean 时只会反注册服务，Dubbo 的全局协议服务器则由
 * JVM 关闭钩子统一销毁。节点通过终止器主动关闭 Spring 上下文时，Hessian 使用的 Jetty 会话清理线程可能先于 JVM
 * 关闭钩子阻止进程退出，因此需要在上下文关闭事件中提前销毁 Dubbo 的注册中心与协议服务器。</p>
 *
 * @author DwArFeng
 * @since 1.0.0
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class DubboProtocolShutdownHandler implements ApplicationListener<ContextClosedEvent> {

    private static final String HESSIAN_PROTOCOL_NAME = "hessian";

    @Override
    public void onApplicationEvent(@Nonnull ContextClosedEvent event) {
        ExtensionLoader.getExtensionLoader(Protocol.class).getExtension(HESSIAN_PROTOCOL_NAME).destroy();
        DubboShutdownHook.destroyAll();
    }
}
