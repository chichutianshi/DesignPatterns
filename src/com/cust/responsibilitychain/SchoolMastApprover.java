package com.cust.responsibilitychain;

public class SchoolMastApprover extends Approver {
    public SchoolMastApprover(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest purchaseRequest) {
        if (purchaseRequest.getPrice()>30000){
            System.out.println("请求编号："+purchaseRequest.getId()+"被"+name+"处理");

        }else {
            approver.processRequest(purchaseRequest);
        }
    }
}
