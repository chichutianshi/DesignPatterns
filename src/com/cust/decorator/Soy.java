package com.cust.decorator;

public class Soy extends Decorator {
    public Soy(Drink obj) {
        super(obj);
        setDesc("豆浆");
        setPrice(1.5f);
    }
}
