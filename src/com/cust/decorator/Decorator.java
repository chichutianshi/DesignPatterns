package com.cust.decorator;



public class Decorator extends Drink {
    private Drink obj;
    public  Decorator(Drink obj){
        this.obj=obj;
    }
    @Override
    public float cost() {
        return getPrice()+obj.cost();
    }

    @Override
    public String getDesc() {
        return super.getDesc()+" "+getPrice()+"  &&  "+obj.getDesc();
    }
}
