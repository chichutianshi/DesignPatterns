package com.cust.iterator;

import java.util.Iterator;
import java.util.List;

public class InfoCollegeIterator implements Iterator {

    List<Department> departmentList;
    int index=0;

    public InfoCollegeIterator(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    @Override
    public boolean hasNext() {
        if (index>departmentList.size()-1)
        return false;
        else return true;
    }

    @Override
    public Object next() {
        Department department = departmentList.get(index);
        index++;
        return department;

    }
}
