package com.mw.service;

import com.mw.dao.UserMapper;
import com.mw.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

/**
 * Created by mawei on 2017/8/23.
 */
@Service
public class UserService {

    public static final Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisTemplate redisTemplate;

    @Cacheable(value = "user")
    public User findByID(Long id){
        log.info("从数据库获取值===="+id);
        return userMapper.selectByPrimaryKey(id);
    }

   @CacheEvict(value = "user")
   public void deleteFromCache(long id){
        log.info("从缓存中删除==="+id);
   }

   public void redisTemplateTest(){
       ValueOperations<String,String> valueOperations = redisTemplate.opsForValue();
       valueOperations.set("mawei","random="+Math.random());
       log.info(valueOperations.get("mawei"));
   }
    @CachePut(value = "user")
   public void cachePut(Long id){
       User user = userMapper.selectByPrimaryKey(id);
       user.setLogin("mawei1");
       user.setPassword("password");
       userMapper.updateByPrimaryKey(user);
   }
}
