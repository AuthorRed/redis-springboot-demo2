package com.mw.config.druid;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 *  druid数据库链接池配置
 * Created by mawei on 2017/6/17.
 */
@Configuration
@EnableConfigurationProperties(DruidProperties.class)
public class DruidConfiguration {
    @Autowired
    private DruidProperties properties;

    @Bean(name = "dataSource" ,destroyMethod = "close")
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(properties.getUrl());
        dataSource.setUsername(properties.getUsername());
        dataSource.setPassword(properties.getPassword());
        if (properties.getPool().getInitialSize() > 0) {
            dataSource.setInitialSize(properties.getPool().getInitialSize());
        }
        if (properties.getPool().getMinIdle() > 0) {
            dataSource.setMinIdle(properties.getPool().getMinIdle());
        }
        if (properties.getPool().getMaxActive() > 0) {
            dataSource.setMaxActive(properties.getPool().getMaxActive());
        }
        if(properties.getPool().getMaxWait()>0){
            dataSource.setMaxWait(properties.getPool().getMaxWait());
        }
        try {
            dataSource.init();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return dataSource;
    }
}
