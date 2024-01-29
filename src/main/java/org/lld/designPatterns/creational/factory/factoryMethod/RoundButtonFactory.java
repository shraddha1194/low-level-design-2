package org.lld.designPatterns.creational.factory.factoryMethod;

import org.lld.designPatterns.creational.factory.simpleFactory.ScreenSize;

public class RoundButtonFactory implements ButtonFactory {
    @Override
    public Button createButton(ScreenSize screenSize, Double border, Double radius, Double length) {
        // try using builder to set params insteadof passing all attributes
        return new RoundButton(border, radius);
    }
}
