package com.example.springboot.config;


import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
// 扫描 Mapper 接口并容器管理
@MapperScan(basePackages = MybatisDB.PACKAGE, sqlSessionFactoryRef = "localSqlSessionFactory")
public class MybatisDB {
    // 精确到 local 目录，以便跟其他数据源隔离
    static final String PACKAGE = "com.example.springboot.dao";
    static final String MAPPER_LOCATION = "classpath:mapper/*.xml";

    @Value("${local.datasource.url}")
    private String url;

    @Value("${local.datasource.username}")
    private String user;

    @Value("${local.datasource.password}")
    private String password;

    @Value("${local.datasource.driverClassName}")
    private String driverClass;

    @Bean(name = "localDataSource")
    public DataSource localDataSource() {
        DruidDataSource localSource = new DruidDataSource();
        localSource.setDriverClassName(driverClass);
        localSource.setUrl(url);
        localSource.setUsername(user);
        localSource.setPassword(password);
        return localSource;
    }

    @Bean(name = "localTransactionManager")
    public DataSourceTransactionManager localTransactionManager() {
        return new DataSourceTransactionManager(localDataSource());
    }

    @Bean(name = "localSqlSessionFactory")
    public SqlSessionFactory localSqlSessionFactory(@Qualifier("localDataSource") DataSource localDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(localDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(MybatisDB.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
}
