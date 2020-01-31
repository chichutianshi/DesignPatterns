package com.cust.proxy;

public class Teacher implements ITeacher {
    @Override
    public void teach(String String) {
        System.out.println("开始授课"+String);
    }
}
