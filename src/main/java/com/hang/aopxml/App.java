package com.hang.aopxml;

/**
 * 利用Spring aop的组件， 实现简单的打印日志，拦截方法以修改方法，体验spring的轻量级。
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        ApplicationContext factory = new ClassPathXmlApplicationContext("aop.xml");
        ServiceBean service = (ServiceBean) factory.getBean("service");
        service.addUser("hehe", "111");
        service.addUser("haha", "222");
        service.findUser("haha");
        service.deleteUser("haha");
        service.addUser("heihei", "333");
        System.out.println("hehe's password is " + service.getPassword("hehe"));

        Look look = (Look) factory.getBean("look");
        look.doLook();
        look.getSet().forEach(s -> System.out.println(s));

        User user = (User) factory.getBean("user");
        user.setName("mm");
        user.setAge("22");
        look.getUsers().add(1, user);

        look.getUsers().forEach(s -> System.out.println(s.toString()));

        System.out.println(look.getMap().get("ok"));

        Cook cook = (Cook) factory.getBean("cook");
        cook.doCook(user);


    }
}

