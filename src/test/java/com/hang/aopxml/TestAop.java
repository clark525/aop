package com.hang.aopxml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by clark on 17/8/15.
 */

public class TestAop {
    public static void main(String[] args) {
        ApplicationContext factory = new ClassPathXmlApplicationContext("applicationContext.xml");

        CustomerManager serviceBean = (CustomerManager) factory.getBean("customerManager");

        serviceBean.getCustomerById(666);
    }
}
