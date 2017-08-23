package com.mw.config.redis;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by mawei on 2017/8/23.
 */
@ConfigurationProperties(prefix = "redis")
@Data
public class RedisProperties {
    private String host;
    private Integer port;
    private String password;
}
