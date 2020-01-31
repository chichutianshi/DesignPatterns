package com.cust.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InfoCollege implements College {

    List<Department> departmentList;

    public InfoCollege(){
        departmentList=new ArrayList<>();
        addDepartment("信息安全1","信息安全1");
        addDepartment("信息安全2","信息安全2");
        addDepartment("信息安全3","信息安全3");
    }
    @Override
    public String getName() {
        return "信息工程学院";
    }

    @Override
    public void addDepartment(String name, String desc) {
        Department department = new Department(name, desc);
        departmentList.add(department);
    }

    @Override
    public Iterator createIterator() {
        return new InfoCollegeIterator(departmentList);
    }
}
