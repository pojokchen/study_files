package com.lagou.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKDynamicProxy implements InvocationHandler {

    // 声明被代理的对象
    private Person person;

    //构造函数
    public JDKDynamicProxy(Person person) {
        this.person = person;
    }

    //获取代理对象
    public Object getTarget(){
        Object proxyInstance = Proxy.newProxyInstance(person.getClass().getClassLoader(), person.getClass().getInterfaces(), this);

        return proxyInstance;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("对原方法进行了前置增强");
        //原方法执行
        Object invoke = method.invoke(person, args);
        System.out.println("对原方法进行了后置增强");
        return invoke;
    }
}
