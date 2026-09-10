package com.dwarfeng.essentials.node.all.he.configuration;

import com.dwarfeng.essentials.sdk.spring.PackagePrefixAutowireCandidateResolverConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 来源服务限定符候选解析器的配置。
 *
 * <p>
 * 该配置用于聚合运行时安装 {@link PackagePrefixAutowireCandidateResolverConfigurer}，
 * 使来源服务的限定符 Bean 名称根据包前缀进行隔离。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
@Configuration
public class PackagePrefixAutowireCandidateResolverConfiguration {

    @Bean
    public static PackagePrefixAutowireCandidateResolverConfigurer packagePrefixAutowireCandidateResolverConfigurer() {
        return new PackagePrefixAutowireCandidateResolverConfigurer();
    }
}
