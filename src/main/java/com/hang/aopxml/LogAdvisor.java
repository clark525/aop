package com.hang.aopxml;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class LogAdvisor implements MethodBeforeAdvice {

	public void before(Method method, Object[] args, Object target) throws Throwable {

		System.out.println("我要打印日志喽！ [log] "+target.getClass().getName()+"."+method.getName()+"( )");
	}



}
