package com.cust.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib 不需要实现接口
 *       而是继承
 *
 *
 *JDK代理 需要实现接口
 */
public class ProxyFactory implements MethodInterceptor {

    private Object target;//被代理对象

    public ProxyFactory(Object target) {
        this.target = target;
    }


    public Object getProxyInstance(){
        Enhancer enhancer = new Enhancer();//创建一个工具类
        enhancer.setSuperclass(target.getClass());//设置父类
        enhancer.setCallback(this);//设置回调函数
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("caglib 代理开始");
        return method.invoke(target,objects);
    }
}
