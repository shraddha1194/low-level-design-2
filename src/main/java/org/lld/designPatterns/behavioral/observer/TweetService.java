package org.lld.designPatterns.behavioral.observer;

public class TweetService implements Observer {

    @Override
    public void notifyChange() {
        System.out.println("Tweet");
    }
}
