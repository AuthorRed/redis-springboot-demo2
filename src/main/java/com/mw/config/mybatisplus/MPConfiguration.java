package com.mw.config.mybatisplus;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.spring.MybatisSqlSessionFactoryBean;
import com.baomidou.mybatisplus.spring.boot.starter.MybatisPlusProperties;
import liquibase.integration.spring.SpringLiquibase;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;

/**
 * Created by mawei on 2017/8/9.
 */
@Configuration
@EnableConfigurationProperties(LiquibaseProperties.class)
@MapperScan("com.mw.dao*")
public class MPConfiguration {
    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;
    @Autowired
    private MybatisPlusProperties mybatisPlusProperties;


    @Bean
    public SqlSessionFactory getMybatisSqlSessionFactoryBean() throws Exception {
        MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        //实体类文件位置
        if (!StringUtils.isEmpty(mybatisPlusProperties.getTypeAliasesPackage())) {
            bean.setTypeAliasesPackage(mybatisPlusProperties.getTypeAliasesPackage());
        }
        //指定mapper.xml文件位置
        if (!StringUtils.isEmpty(mybatisPlusProperties.getMapperLocations())) {
            bean.setMapperLocations(mybatisPlusProperties.resolveMapperLocations());
        }
        //增加分页插件
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        bean.setPlugins(new Interceptor[]{
                paginationInterceptor
        });
        return bean.getObject();
    }

    /**
     * liquibase配置文件
     *
     * @param liquibaseProperties
     * @return
     */
    @Bean
    public SpringLiquibase liquibase(LiquibaseProperties liquibaseProperties) {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(dataSource);
        liquibase.setChangeLog("classpath:config/liquibase/master.xml");
        liquibase.setContexts(liquibaseProperties.getContexts());
        liquibase.setDefaultSchema(liquibaseProperties.getDefaultSchema());
        liquibase.setDropFirst(liquibaseProperties.isDropFirst());
        liquibase.setShouldRun(liquibaseProperties.isEnabled());
        return liquibase;
    }
}
