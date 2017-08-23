package com.mw.config.druid.View;

import com.alibaba.druid.support.http.StatViewServlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

/**
 * druid数据分析监测
 * Created by mawei on 2017/8/9.
 */
@WebServlet(urlPatterns = "/druid/*",
            initParams = {
              @WebInitParam(name="allow",value = "127.0.0.1,127.0.0.2"),//IP白名单（没有配置或者为空，允许所有访问)
              @WebInitParam(name="deny" , value = "127.0.0.3,127.0.0.4"),//IP黑名单（存在共同时，deny优先于allow)
              @WebInitParam(name="loginUsername",value = "mawei"),//用户名
              @WebInitParam(name="loginPassword",value = "123"),//密码
              @WebInitParam(name="resetEnable",value = "false")//禁止HTML页面上的resetAll功能

            })
public class DruidWatchServlet extends StatViewServlet{

}
