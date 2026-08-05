package com.dwarfeng.essentials.sdk.spring;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;

import javax.annotation.Nonnull;

/**
 * 基于组件类规范名生成 Bean 名称的生成器。
 *
 * <p>
 * 该生成器用于聚合运行时扫描来源服务的实现包，直接使用组件类的全限定名作为 Bean 名称，避免不同来源服务中同名实现类发生 Bean 名称冲突。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class CanonicalNameBeanNameGenerator implements BeanNameGenerator {

    @Nonnull
    @Override
    public String generateBeanName(@Nonnull BeanDefinition definition, @Nonnull BeanDefinitionRegistry registry) {
        String beanClassName = definition.getBeanClassName();
        if (beanClassName == null || beanClassName.isEmpty()) {
            throw new IllegalStateException("无法获取 Bean 类的全限定名");
        }
        return beanClassName;
    }
}
