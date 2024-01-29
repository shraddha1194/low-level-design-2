package org.lld.designPatterns.behavioral.observer;


import java.util.ArrayList;
import java.util.List;

public abstract class Observable {
    List<Observer> observers = new ArrayList<>();

    public void register(Observer observer) {
        observers.add(observer);
    }

    public void notifyChange() {
        for (Observer observer : observers) {
            observer.notifyChange();
        }
    }
}
