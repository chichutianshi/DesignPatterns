package com.cust.responsibilitychain;

public class ViceSchoolMasterApprover extends Approver {
    public ViceSchoolMasterApprover(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest purchaseRequest) {
        if (purchaseRequest.getPrice()>10000&&purchaseRequest.getPrice()<=30000){
            System.out.println("请求编号："+purchaseRequest.getId()+"被"+name+"处理");

        }else {
            approver.processRequest(purchaseRequest);
        }
    }
}
