package com.dwarfeng.essentials.sdk.spring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.config.DependencyDescriptor;
import org.springframework.beans.factory.support.SimpleBeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;
import org.springframework.context.annotation.ContextAnnotationAutowireCandidateResolver;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Nonnull;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 基于注入点包名前缀解析自动装配候选 Bean 的解析器。
 *
 * <p>
 * 由于聚合运行时可能同时装配多个来源服务中名称相同的 Bean，故需要在 1 型后端中对这些名称相同的 Bean 进行区分。
 *
 * <p>
 * 该解析器根据注入点所在类的全限定名识别来源服务，并在限定符指定的 Bean 名称前追加服务前缀，
 * 从而将不同来源服务的 Bean 隔离到各自的命名空间中。
 * 无法匹配来源服务时，保留 Spring 默认的候选解析行为。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class PackagePrefixAutowireCandidateResolver extends ContextAnnotationAutowireCandidateResolver {

    private static final Map<String, String> PACKAGE_PREFIX_MAP;

    static {
        Map<String, String> packagePrefixMap = new LinkedHashMap<>();
        packagePrefixMap.put("com.dwarfeng.acckeeper.", "acckeeper");
        packagePrefixMap.put("com.dwarfeng.rbacds.", "rbacds");
        packagePrefixMap.put("com.dwarfeng.buddy.", "buddy");
        packagePrefixMap.put("com.dwarfeng.settingrepo.", "settingrepo");
        packagePrefixMap.put("com.dwarfeng.notify.", "notify");
        PACKAGE_PREFIX_MAP = Collections.unmodifiableMap(packagePrefixMap);
    }

    @Override
    public boolean isAutowireCandidate(
            @Nonnull BeanDefinitionHolder bdHolder, @Nonnull DependencyDescriptor descriptor
    ) {
        String qualifier = resolveQualifier(descriptor);
        String beanPrefix = resolveBeanPrefix(resolveInjectionClass(descriptor));
        if (!StringUtils.hasText(qualifier) || !StringUtils.hasText(beanPrefix)) {
            return super.isAutowireCandidate(bdHolder, descriptor);
        }

        String expectedBeanName = beanPrefix + "." + qualifier;
        String candidateBeanName = resolveCandidateBeanName(bdHolder);
        if (!expectedBeanName.equals(candidateBeanName)) {
            return super.isAutowireCandidate(bdHolder, descriptor);
        }

        BeanDefinitionHolder compatibilityHolder = new BeanDefinitionHolder(
                bdHolder.getBeanDefinition(), qualifier, bdHolder.getAliases()
        );
        return super.isAutowireCandidate(compatibilityHolder, descriptor);
    }

    public static Map<String, String> packagePrefixMap() {
        return PACKAGE_PREFIX_MAP;
    }

    private static String resolveQualifier(DependencyDescriptor descriptor) {
        String qualifier = resolveQualifier(descriptor.getAnnotations());
        if (StringUtils.hasText(qualifier)) {
            return qualifier;
        }

        MethodParameter methodParameter = descriptor.getMethodParameter();
        if (methodParameter != null) {
            qualifier = resolveQualifier(methodParameter.getMethodAnnotations());
        }
        return qualifier;
    }

    private static String resolveQualifier(java.lang.annotation.Annotation[] annotations) {
        for (java.lang.annotation.Annotation annotation : annotations) {
            Qualifier qualifier = AnnotationUtils.getAnnotation(annotation, Qualifier.class);
            if (qualifier != null && StringUtils.hasText(qualifier.value())) {
                return qualifier.value();
            }
        }
        return null;
    }

    private static Class<?> resolveInjectionClass(DependencyDescriptor descriptor) {
        if (descriptor.getField() != null) {
            return descriptor.getField().getDeclaringClass();
        }

        MethodParameter methodParameter = descriptor.getMethodParameter();
        return methodParameter == null ? null : methodParameter.getContainingClass();
    }

    private static String resolveCandidateBeanName(BeanDefinitionHolder bdHolder) {
        BeanDefinition beanDefinition = bdHolder.getBeanDefinition();
        String beanClassName = beanDefinition.getBeanClassName();
        String beanPrefix = resolveBeanPrefix(beanClassName);
        if (!StringUtils.hasText(beanPrefix)) {
            return bdHolder.getBeanName();
        }

        String originalBeanName = AnnotationBeanNameGenerator.INSTANCE.generateBeanName(
                beanDefinition, new SimpleBeanDefinitionRegistry()
        );
        return beanPrefix + "." + originalBeanName;
    }

    private static String resolveBeanPrefix(Class<?> beanClass) {
        return beanClass == null ? null : resolveBeanPrefix(beanClass.getName());
    }

    private static String resolveBeanPrefix(String className) {
        if (!StringUtils.hasText(className)) {
            return null;
        }
        for (Map.Entry<String, String> entry : PACKAGE_PREFIX_MAP.entrySet()) {
            if (className.startsWith(entry.getKey())) {
                return entry.getValue();
            }
        }
        return null;
    }
}
