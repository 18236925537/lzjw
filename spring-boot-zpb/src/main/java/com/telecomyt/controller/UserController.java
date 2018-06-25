package com.telecomyt.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    /**
     * 获取用户信息
     * @param id
     * @return
     */
    @RequestMapping(value="/query/{id}",method= RequestMethod.GET)
    public String query(@PathVariable("id") String id){
        return "I am zpb "+id;
    }

}
