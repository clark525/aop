package com.hang.aopxml;

public class LogAfter {

    public void before() {

        System.out.println("i am after");
    }


    public void doIt() {
        System.out.println("just do it");
    }
}
