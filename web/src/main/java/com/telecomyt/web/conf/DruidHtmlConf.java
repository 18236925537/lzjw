package com.telecomyt.web.conf;

import com.alibaba.druid.pool.DruidDataSource;
import com.telecomyt.web.properties.DruidHtmlProperties;
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

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @ProjectName: web
 * @ClassName: DruidHtmlConf
 * @Description: html数据源的druid配置
 * @Author: dianxinyitong
 * @modified:
 * @Date: 2018/7/26 14:17
 */
@Configuration
@MapperScan(basePackages = "com.telecomyt.web.mapper.html", sqlSessionTemplateRef  = "htmlSqlSessionTemplate")
public class DruidHtmlConf {

    @Autowired
    DruidHtmlProperties druidHtmlProperties;

    @Bean(name = "htmlDataSource",initMethod = "init", destroyMethod = "close")
    public DataSource testDataSource() throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(druidHtmlProperties .getDriverClassName());
        druidDataSource.setUrl(druidHtmlProperties.getUrl());
        druidDataSource.setUsername(druidHtmlProperties.getUsername());
        druidDataSource.setPassword(druidHtmlProperties.getPassword());
        druidDataSource.setInitialSize(druidHtmlProperties.getMinIdle());
        druidDataSource.setMinIdle(druidHtmlProperties.getMinIdle());
        druidDataSource.setMaxActive(druidHtmlProperties.getMaxActive());
        druidDataSource.setMaxWait(druidHtmlProperties.getMaxWait());
        druidDataSource.setTimeBetweenEvictionRunsMillis(druidHtmlProperties.getTimeBetweenEvictionRunsMillis());
        druidDataSource.setMinEvictableIdleTimeMillis(druidHtmlProperties.getMinEvictableIdleTimeMillis());
        druidDataSource.setValidationQuery(druidHtmlProperties.getValidationQuery());
        druidDataSource.setTestWhileIdle(druidHtmlProperties.getTestWhileIdle());
        druidDataSource.setTestOnBorrow(druidHtmlProperties.getTestOnBorrow());
        druidDataSource.setTestOnReturn(druidHtmlProperties.getTestOnReturn());
        druidDataSource.setPoolPreparedStatements(druidHtmlProperties.getPoolPreparedStatements());
        druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(druidHtmlProperties.getMaxPoolPreparedStatementPerConnectionSize());
        druidDataSource.setFilters(druidHtmlProperties.getFilters());
        return druidDataSource;
    }

    @Bean(name = "htmlTransactionManager")
    public DataSourceTransactionManager setTransactionManager(@Qualifier("htmlDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "htmlSqlSessionFactory")
    public SqlSessionFactory setSqlSessionFactory(@Qualifier("htmlDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/html/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "htmlSqlSessionTemplate")
    public SqlSessionTemplate setSqlSessionTemplate(@Qualifier("htmlSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }


}
