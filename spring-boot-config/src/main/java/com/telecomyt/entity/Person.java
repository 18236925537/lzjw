package com.telecomyt.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Map;

/**
 *@ConfigurationProperties 默认是从全局配置文件中
 */
@Component
@Validated
@ConfigurationProperties(prefix = "person")
@PropertySource(value={"classpath:properties/person.properties"})
public class Person {

    private String name;
    private int age;
    private Map<String,String> loves;
    private List<Geade> grades;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", loves=" + loves +
                ", grades=" + grades +
                '}';
    }

    public Map<String, String> getLoves() {
        return loves;
    }

    public void setLoves(Map<String, String> loves) {
        this.loves = loves;
    }

    public List<Geade> getGrades() {
        return grades;
    }

    public void setGrades(List<Geade> grades) {
        this.grades = grades;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
