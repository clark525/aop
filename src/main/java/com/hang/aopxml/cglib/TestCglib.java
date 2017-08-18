package com.hang.aopxml.cglib;

import net.sf.cglib.proxy.*;

import java.lang.reflect.Method;

public class TestCglib {
    public static void main(String args[]) throws Exception{
		Enhancer enhancer =new Enhancer();
		enhancer.setSuperclass(TargetObject.class);
		CallbackFilter callbackFilter = new TargetMethodCallbackFilter();

		/**
		 * (1)callback1：方法拦截器
		 (2)NoOp.INSTANCE：这个NoOp表示no operator，即什么操作也不做，代理类直接调用被代理的方法不进行拦截。
		 (3)FixedValue：表示锁定方法返回值，无论被代理类的方法返回什么值，回调方法都返回固定值。
		 */
		Callback noopCb= NoOp.INSTANCE;
		Callback callback1=new TargetInterceptor();
		Callback fixedValue=new TargetResultFixed();
		Callback[] cbarray=new Callback[]{callback1,noopCb,fixedValue};
		//enhancer.setCallback(new TargetInterceptor());
		enhancer.setCallbacks(cbarray);
		enhancer.setCallbackFilter(callbackFilter);
		TargetObject targetObject2=(TargetObject)enhancer.create();
		System.out.println(targetObject2);
		System.out.println(targetObject2.method1("mmm1"));
		System.out.println(targetObject2.method2(100));
		System.out.println(targetObject2.method3(100));
		System.out.println(targetObject2.method3(200));


		InterfaceMaker interfaceMaker =new InterfaceMaker();
		//抽取某个类的方法生成接口方法
		interfaceMaker.add(TargetObject.class);
		Class<?> targetInterface=interfaceMaker.create();
		for(Method method : targetInterface.getMethods()){
			System.out.println(method.getName());
		}
		//接口代理并设置代理接口方法拦截
		Object object = Enhancer.create(Object.class, new Class[]{targetInterface}, new MethodInterceptor(){
			@Override
			public Object intercept(Object obj, Method method, Object[] args,
									MethodProxy methodProxy) throws Throwable {
				if(method.getName().equals("method1")){
					System.out.println("filter method1 ");
					return "mmmmmmmmm";
				}
				if(method.getName().equals("method2")){
					System.out.println("filter method2 ");
					return 1111111;
				}
				if(method.getName().equals("method3")){
					System.out.println("filter method3 ");
					return 3333;
				}
				return "default";
			}});
		Method targetMethod1=object.getClass().getMethod("method3",new Class[]{int.class});
		int i=(int)targetMethod1.invoke(object, new Object[]{33});
		Method targetMethod=object.getClass().getMethod("method1",new Class[]{String.class});
		System.out.println(targetMethod.invoke(object, new Object[]{"sdfs"}));
	}
}