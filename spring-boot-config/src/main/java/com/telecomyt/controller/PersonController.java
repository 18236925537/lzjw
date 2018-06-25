package com.telecomyt.controller;

import com.telecomyt.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @Autowired
    private Person person;

    @ResponseBody
    @RequestMapping(value="/query",method= RequestMethod.GET)
    public String query(){
        System.out.println(person.toString());
        return person.toString();
    }

}
