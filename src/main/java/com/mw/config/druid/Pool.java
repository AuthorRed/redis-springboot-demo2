package com.mw.config.druid;

import lombok.Data;

/**
 * Created by mawei on 2017/8/9.
 */
@Data
public class Pool {
    private int maxActive;
    private int minIdle;
    private int initialSize;
    private Long maxWait;
}