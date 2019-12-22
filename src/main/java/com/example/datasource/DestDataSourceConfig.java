package com.example.datasource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.example.**.dest.dao.mapper", sqlSessionTemplateRef  = "DestSqlSessionTemplate")
public class DestDataSourceConfig {

    @Bean("DestDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.druid.dest")
    public DataSource getDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean("DestSqlSessionFactory")
    public SqlSessionFactory getSqlSessionFactory(@Qualifier("DestDataSource") DataSource dataSource) throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        // 设置mybatis的xml所在位置
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/dest/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean("DestSqlSessionTemplate")
    public SqlSessionTemplate getSqlSessionTemplate(@Qualifier("DestSqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
