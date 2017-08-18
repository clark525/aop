package com.hang.aopxml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import java.util.Arrays;

/**
 * Created by clark on 17/8/14.
 */
public class AboutCook {


    public void doBefore(JoinPoint joinPoint) {
        System.out.println("doBefore cook");
        System.out.println(joinPoint.getSignature().toString());
        System.out.println(Arrays.toString(joinPoint.getArgs()));

    }

    public void doAfter(JoinPoint joinPoint) {
        System.out.println("doAfter cook");
        System.out.println(joinPoint.getSignature().toString());
        System.out.println(Arrays.toString(joinPoint.getArgs()));



    }

    public void doAfterReturn(JoinPoint joinPoint, Object result) {
        System.out.println("doAfterReturn cook");
        System.out.println(joinPoint.getSignature().toString());
        System.out.println(Arrays.toString(joinPoint.getArgs()));
        System.out.println("doAfterReturn cook:" + result);
    }

    public void doExcep() {
        System.out.println("doExcep cook");
    }

    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("doAround cook");
        System.out.println(joinPoint.getSignature().toString());
        System.out.println(Arrays.toString(joinPoint.getArgs()));
        Object retVal = joinPoint.proceed();
        return "you kown nothing";
    }
}
