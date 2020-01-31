package com.cust.iterator;

import java.util.ArrayList;
import java.util.Iterator;

public class client {
    public static void main(String[] args) {
        ComputerCollege computerCollege=new ComputerCollege();
        InfoCollege infoCollege=new InfoCollege();

        ArrayList<College> collegeArrayList=new ArrayList<>();

        collegeArrayList.add(computerCollege);
        collegeArrayList.add(infoCollege);
        OutPutImp outPutImp=new OutPutImp(collegeArrayList);


        outPutImp.printCollege();


        System.out.println(computerCollege.getName());
        Iterator computerIterator=computerCollege.createIterator();
        outPutImp.printDepartment(computerIterator);

        System.out.println(infoCollege.getName());
        Iterator infoIterator=infoCollege.createIterator();
        outPutImp.printDepartment(infoIterator);

    }
}
