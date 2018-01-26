package com.example.jpaDemo.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

/**
 * 数据库配置文件
 *
 * @author ck
 * 2018/1/22 11:40
 */
@Configuration
public class DataSouceConfig {

    private static final String MAPPER_LOCATION = "classpath*:com/example/jpaDemo/mapper/*Mapper.xml";
    private static final String MYBATIS_CONFIG = "classpath:mybatis-config.xml";

    @Bean(name = "dbProperties")
    public Properties dbProperties() throws IOException {
        Properties properties = new Properties();
        properties.load(new ClassPathResource("db.properties").getInputStream());
        return properties;
    }

    @Bean(name = "dataSource")
    public DataSource dataSource(@Qualifier("dbProperties") Properties properties) {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.configFromPropety(properties);
        return druidDataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager();
    }

}
