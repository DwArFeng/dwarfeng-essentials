package com.dwarfeng.essentials.sdk.spring;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

import javax.annotation.Nonnull;

/**
 * 基于注入点包名前缀解析自动装配候选 Bean 的解析器的配置器。
 *
 * <p>
 * 该后置处理器用于聚合运行时的来源服务 Bean 装配，
 * 在 BeanFactory 初始化阶段安装 {@link PackagePrefixAutowireCandidateResolver}。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class PackagePrefixAutowireCandidateResolverConfigurer implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(@Nonnull ConfigurableListableBeanFactory beanFactory) {
        if (!(beanFactory instanceof DefaultListableBeanFactory)) {
            throw new IllegalStateException("BeanFactory 必须是 DefaultListableBeanFactory");
        }
        DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) beanFactory;
        defaultListableBeanFactory.setAutowireCandidateResolver(
                new PackagePrefixAutowireCandidateResolver()
        );
    }
}
