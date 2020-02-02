package com.cust.decorator;

public class Client {
    public static void main(String[] args) {
        //1.点一份 LongBlack
        Drink order = new LongBlack();
        System.out.println("费用1："+ order.cost());
        System.out.println("描述="+order.getDesc());

        //2.加一份牛奶
        order=new Milk(order);
        System.out.println("费用2："+ order.cost());
        System.out.println("描述="+order.getDesc());

        //3.再加一份巧克力
        order=new Chocolate(order);
        System.out.println("费用3："+ order.cost());
        System.out.println("描述="+order.getDesc());

        //4.再加一份巧克力
        order=new Chocolate(order);
        System.out.println("费用4："+ order.cost());
        System.out.println("描述="+order.getDesc());
    }
}
