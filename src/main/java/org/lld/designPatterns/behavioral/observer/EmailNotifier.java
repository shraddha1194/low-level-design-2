package org.lld.designPatterns.behavioral.observer;

public class EmailNotifier implements Observer {

    @Override
    public void notifyChange() {
        System.out.println("Send email.");
    }
}
