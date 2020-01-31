package com.cust.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理之 JDK代理
 */
public class ProxyFactory {

    private Object targe;
    ProxyFactory(Object targe){
        this.targe=targe;
    }
    public Object getProxyInstance(){
        return Proxy.newProxyInstance(targe.getClass().getClassLoader(), targe.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println(args[0]);
                        Object invoke = method.invoke(targe, args);
                        return invoke;
                    }
                });
    }
}
