package com.cust.observer;

public interface Subject {
     void registerObserver(Observer Observer);
     void removeObserver(Observer Observer);
     void notifyObserver();
}
