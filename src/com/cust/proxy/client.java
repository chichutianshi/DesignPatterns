package com.cust.proxy;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class client {
    public static void main(String[] args) {
        ITeacher target=new Teacher();
        ITeacher proxyInstance=(ITeacher)new ProxyFactory(target).getProxyInstance();
        proxyInstance.teach("王老师");


    }



}
