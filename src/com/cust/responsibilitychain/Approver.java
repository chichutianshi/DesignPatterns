package com.cust.responsibilitychain;

public abstract class Approver {
    Approver approver;//下一个处理人
    String name;

    public Approver(String name) {
        this.name = name;
    }

    public void setApprover(Approver approver) {
        this.approver = approver;
    }

    //处理请求，子类完成
    public abstract void processRequest(PurchaseRequest purchaseRequest);
}
