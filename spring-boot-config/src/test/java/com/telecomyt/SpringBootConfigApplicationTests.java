package com.telecomyt;

import com.telecomyt.entity.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * spring boot 的单元测试
 * 可以在测试期间很方便的进行自动注入到容器的功能
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootConfigApplicationTests {

	@Autowired
	Person person;

    @Autowired
    ApplicationContext ioc;

	@Test
	public void contextLoads() {

		System.out.println("\n\n"+person.toString()+"\n\n");

	}

    /**
     * 测试@Bean注解
     */
	@Test
    public void testBean(){
        boolean hasOrNo = ioc.containsBean("personService");
        System.out.println(hasOrNo);
    }

}
