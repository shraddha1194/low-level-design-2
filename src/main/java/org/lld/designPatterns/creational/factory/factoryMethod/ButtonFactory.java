package org.lld.designPatterns.creational.factory.factoryMethod;

import org.lld.designPatterns.creational.factory.simpleFactory.ScreenSize;

// Step 3 - create a static factory method
public interface ButtonFactory {

    Button createButton(ScreenSize screenSize, Double border, Double radius, Double length);
}
