package com.cust.observer;

public class Client {
    public static void main(String[] args) {
        WeatherDate weatherDate = new WeatherDate();//被观察

        Observer currentConditions=new CurrentConditions();//观察者
        Observer currentConditions2=new CurrentConditions();//观察者

        weatherDate.registerObserver(currentConditions);
        weatherDate.registerObserver(currentConditions2);

        System.out.println("通知各个观察者");
        weatherDate.setData(26.4f,30000f,30.4f);
    }
}
