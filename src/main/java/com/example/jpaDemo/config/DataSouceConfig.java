package com.example.jpaDemo.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

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
@MapperScan(basePackages = "com.example.jpaDemo.mapper", sqlSessionTemplateRef = "sqlSessionTemplate")
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

    /*@Bean(name = "dataSource")
    @ConfigurationProperties(prefix = "spring.datasource.master")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }*/

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        bean.setMapperLocations(resolver.getResources(MAPPER_LOCATION));
        bean.setConfigLocation(resolver.getResource(MYBATIS_CONFIG));
        return bean.getObject();
    }

    @Bean(name = "sqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean(name = "dataSourceTransactionManager")
    public DataSourceTransactionManager dataSourceTransactionManager(@Qualifier("dataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}
