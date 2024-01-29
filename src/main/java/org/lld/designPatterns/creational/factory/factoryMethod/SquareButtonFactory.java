package org.lld.designPatterns.creational.factory.factoryMethod;

import org.lld.designPatterns.creational.factory.simpleFactory.ScreenSize;

public class SquareButtonFactory implements ButtonFactory {
    @Override
    public Button createButton(ScreenSize screenSize, Double border, Double radius, Double length) {
        return new SquareButton(border, length);
    }
}
