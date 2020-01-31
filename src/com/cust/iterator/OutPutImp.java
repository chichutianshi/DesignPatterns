package com.cust.iterator;

import java.util.Iterator;
import java.util.List;

public class OutPutImp {

    List<College> collegeList;

    public OutPutImp(List<College> collegeList) {
        this.collegeList = collegeList;
    }

    public void printCollege(){
        Iterator iterator=collegeList.iterator();
        while (iterator.hasNext()){
            College college= (College) iterator.next();
            System.out.println(college.getName());
        }
    }

    public void printDepartment(Iterator iterator){
        while (iterator.hasNext()){
            Department department= (Department) iterator.next();
            System.out.println(department.getName()+"   "+department.getDesc());
        }
    }



}
