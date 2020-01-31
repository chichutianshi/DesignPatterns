package com.cust.iterator;

import java.util.Iterator;

public class ComputerCollege implements College {

    int i;
    long l;
    short sh;
    float f;
    double d;
    char c;
    byte b;
    boolean boo;


    Department[] departments;
    int numOfDepartmet=0;

    public ComputerCollege(){
        departments=new Department[5];
        addDepartment("java","java");
        addDepartment("PHP","PHP");
        addDepartment("大数据","大数据");
    }

    @Override
    public String getName() {
        return "计算机学院";
    }

    @Override
    public void addDepartment(String name, String desc) {
        Department department = new Department(name, desc);
        departments[numOfDepartmet]=department;
        numOfDepartmet++;
    }

    @Override
    public Iterator createIterator() {
        return new ComputerCollegeIterator(departments);
    }
}
