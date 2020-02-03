package com.cust.proxy.cglib;

public class Client {
    public static void main(String[] args) {
        TeacherDao teacherDao=new TeacherDao();
        
        ProxyFactory proxyFactory=new ProxyFactory(teacherDao);
        TeacherDao proxyInstance = (TeacherDao) proxyFactory.getProxyInstance();

        proxyInstance.teach();

    }
}
