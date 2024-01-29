package org.lld.designPatterns.creational.factory.simpleFactory;

// Step 3 - create a static factory method
public class ButtonFactory {

    public static Button createButton(ScreenSize screenSize, Double border, Double radius, Double length) {
        switch (screenSize) {
            case PHONE:
            case TABLET: return new RoundButton(border, radius);
            case DESKTOP: return new SquareButton(border, length);
        }

        throw new IllegalArgumentException("Invalid type: " + screenSize);
    }
}
