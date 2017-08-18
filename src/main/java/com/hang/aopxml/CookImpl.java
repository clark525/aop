package com.hang.aopxml;

/**
 * Created by clark on 17/8/14.
 */
public class CookImpl implements Cook {
    @Override
    public void doCook(User u) {
        System.out.println("do Cook");
        System.out.println(u.getName());
        u.setName("cook something");
    }
}
