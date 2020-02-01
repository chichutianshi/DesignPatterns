package com.cust.observer;

import java.util.ArrayList;

/**
 * 被观察者
 */
public class WeatherDate implements Subject {

    private float temperature;
    private float pressure;
    private float humidity;
    private ArrayList<Observer> observers;

    public WeatherDate(){
        observers=new ArrayList<>();
    }

    public void setData(float temperature,float pressure,float humidity){
        this.temperature=temperature;
        this.pressure=pressure;
        this.humidity=humidity;
        notifyObserver();
    }
    @Override
    public void registerObserver(Observer Observer) {
        observers.add(Observer);
    }

    @Override
    public void removeObserver(Observer Observer) {
        if (observers.contains(observers))
            observers.remove(observers);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer1:observers) {
            observer1.upDate(temperature,pressure,humidity);
        }
    }


}
