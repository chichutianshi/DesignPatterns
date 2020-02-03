package com.cust.responsibilitychain;

public class Client {
    public static void main(String[] args) {
        PurchaseRequest purchaseRequest = new PurchaseRequest(1, 5000, 1);

        DepartmentApprover departmentApprover = new DepartmentApprover("张主任");
        CollegeApprover collegeApprover=new CollegeApprover("李院长");
        ViceSchoolMasterApprover viceSchoolMasterApprover=new ViceSchoolMasterApprover("王副校");
        SchoolMastApprover schoolMastApprover=new SchoolMastApprover("佟校长");

        //设置职责链。。并成环
        departmentApprover.setApprover(collegeApprover);
        collegeApprover.setApprover(viceSchoolMasterApprover);
        viceSchoolMasterApprover.setApprover(schoolMastApprover);
        schoolMastApprover.setApprover(departmentApprover);

        schoolMastApprover.processRequest(purchaseRequest);
    }
}
