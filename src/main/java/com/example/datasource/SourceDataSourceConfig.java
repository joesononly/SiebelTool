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
@MapperScan(basePackages = "com.example.**.source.dao.mapper", sqlSessionTemplateRef  = "SourceSqlSessionTemplate")
public class SourceDataSourceConfig {

    @Primary
    @Bean("SourceDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.druid.source")
    public DataSource getDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean("SourceSqlSessionFactory")
    public SqlSessionFactory getSqlSessionFactory(@Qualifier("SourceDataSource") DataSource dataSource) throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        // 设置mybatis的xml所在位置
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/source/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Primary
    @Bean("SourceSqlSessionTemplate")
    public SqlSessionTemplate getSqlSessionTemplate(@Qualifier("SourceSqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
