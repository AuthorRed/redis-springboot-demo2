package com.mw.config.druid;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * druid的部分配置参数
 * Created by mawei on 2017/6/17.
 */
@Data
@ConfigurationProperties(prefix = "druid")
public class DruidProperties {
    private String url;
    private String username;
    private String password;
    private String driverClass;
    private Pool pool;
}


