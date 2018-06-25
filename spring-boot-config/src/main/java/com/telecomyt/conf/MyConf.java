package com.telecomyt.conf;

import com.telecomyt.service.PersonService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration 指明当前的类是spring的配置类--》相当于spring.xml
 */
@Configuration
public class MyConf {

    @Bean
    public PersonService personService(){
        System.out.println("@Bean给容器中注入组件了");
        return new PersonService();
    }

}
