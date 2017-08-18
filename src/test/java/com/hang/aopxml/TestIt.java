package com.hang.aopxml;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by clark on 17/8/18.
 */
public class TestIt {
    @Test
    public void test(){
        ApplicationContext factory = new ClassPathXmlApplicationContext("applicationContext.xml");

        CustomerManager serviceBean = (CustomerManager) factory.getBean("customerManager");

        serviceBean.getCustomerById(666);
    }
}
