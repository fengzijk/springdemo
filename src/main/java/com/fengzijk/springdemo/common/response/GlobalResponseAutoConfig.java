package com.fengzijk.springdemo.common.response;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(GlobalResponseProperties.class)
@ConditionalOnProperty(value = GlobalResponseProperties.PREFIX+".enabled", havingValue = "true", matchIfMissing = true)
public class GlobalResponseAutoConfig {

    @Bean
    public GlobalExceptionHandler commonResponseDataAdvice() {
        return new GlobalExceptionHandler();
    }
}