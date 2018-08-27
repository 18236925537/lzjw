package com.telecomyt.web.conf;

import com.alibaba.druid.pool.DruidDataSource;
import com.telecomyt.web.properties.DruidPrimaryProperties;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @ProjectName: web
 * @ClassName: DruidPrimaryConf
 * @Description: primary datasource
 * @Author: dianxinyitong
 * @modified:
 * @Date: 2018/7/26 14:20
 */
@Configuration
@MapperScan(basePackages = "com.telecomyt.web.mapper.primary", sqlSessionTemplateRef  = "primarySqlSessionTemplate")
public class DruidPrimaryConf {

    @Autowired
    DruidPrimaryProperties druidPrimaryProperties;

    @Bean(name = "primaryDataSource",initMethod = "init", destroyMethod = "close")
    @Primary
    public DataSource primaryDataSource() throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(druidPrimaryProperties .getDriverClassName());
        druidDataSource.setUrl(druidPrimaryProperties.getUrl());
        druidDataSource.setUsername(druidPrimaryProperties.getUsername());
        druidDataSource.setPassword(druidPrimaryProperties.getPassword());
        druidDataSource.setInitialSize(druidPrimaryProperties.getMinIdle());
        druidDataSource.setMinIdle(druidPrimaryProperties.getMinIdle());
        druidDataSource.setMaxActive(druidPrimaryProperties.getMaxActive());
        druidDataSource.setMaxWait(druidPrimaryProperties.getMaxWait());
        druidDataSource.setTimeBetweenEvictionRunsMillis(druidPrimaryProperties.getTimeBetweenEvictionRunsMillis());
        druidDataSource.setMinEvictableIdleTimeMillis(druidPrimaryProperties.getMinEvictableIdleTimeMillis());
        druidDataSource.setValidationQuery(druidPrimaryProperties.getValidationQuery());
        druidDataSource.setTestWhileIdle(druidPrimaryProperties.getTestWhileIdle());
        druidDataSource.setTestOnBorrow(druidPrimaryProperties.getTestOnBorrow());
        druidDataSource.setTestOnReturn(druidPrimaryProperties.getTestOnReturn());
        druidDataSource.setPoolPreparedStatements(druidPrimaryProperties.getPoolPreparedStatements());
        druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(druidPrimaryProperties.getMaxPoolPreparedStatementPerConnectionSize());
        druidDataSource.setFilters(druidPrimaryProperties.getFilters());
        return druidDataSource;
    }

    @Bean(name = "primaryDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.primary")
    @Primary
    public DataSource setDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "primaryTransactionManager")
    @Primary
    public DataSourceTransactionManager setTransactionManager(@Qualifier("primaryDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "primarySqlSessionFactory")
    @Primary
    public SqlSessionFactory setSqlSessionFactory(@Qualifier("primaryDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/primary/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "primarySqlSessionTemplate")
    @Primary
    public SqlSessionTemplate setSqlSessionTemplate(@Qualifier("primarySqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
