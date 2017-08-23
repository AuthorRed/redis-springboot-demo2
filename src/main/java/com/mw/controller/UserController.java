package com.mw.controller;

import com.mw.domain.User;
import com.mw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

/**
 * Created by mawei on 2017/8/23.
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/cacheable" , method = RequestMethod.GET)
    public ResponseEntity<User> findUserByID(@RequestParam(value = "id" ,required = true) Long id){
        User user = userService.findByID(id);
        return new ResponseEntity<User>(user, HttpStatus.OK);
}

   @RequestMapping(value = "/cacheEvict",method = RequestMethod.GET)
    public void deleteUserByID(@RequestParam(value = "id" ,required = true) Long id){
        userService.deleteFromCache(id);
   }

   @RequestMapping(value = "/cacheput" ,method = RequestMethod.GET)
   public void cachePut(@RequestParam(value = "id" ,required = true)long id){
        userService.cachePut(id);
   }
   @RequestMapping(value = "/test" ,method = RequestMethod.GET)
    public void test(){
        userService.redisTemplateTest();
   }
}
