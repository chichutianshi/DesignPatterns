package com.cust.observer;

/**
 * 这就是一个观察者
 */
public class CurrentConditions implements Observer {

    private float temperature;
    private float pressure;
    private float humidity;

    @Override
    public void upDate(float temperature, float pressure, float humidity) {
        this.temperature=temperature;
        this.pressure=pressure;
        this.humidity=humidity;
        display();
    }

    public void display() {
        System.out.println("CurrentConditions{" +
                "temperature=" + temperature +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                '}');
    }
}
