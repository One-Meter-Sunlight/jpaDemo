package com.example.jpaDemo.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.annotation.PersistenceExceptionTranslationAdvisor;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.Entity;

/**
 * JPA相关配置
 *
 * @author ck
 * 2018/1/22 10:26
 */
@Configuration
@Order(Ordered.HIGHEST_PRECEDENCE)
@EnableTransactionManagement(proxyTargetClass = true)
@EnableJpaRepositories(basePackages = "com.example.jpaDemo.resp")
@EntityScan(basePackages = "com.example.jpaDemo.entity")
public class JpaConfig {

    @Bean
    PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationAdvisor () {
        return new PersistenceExceptionTranslationPostProcessor();
    }

}
