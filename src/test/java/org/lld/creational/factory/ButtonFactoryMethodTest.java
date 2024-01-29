package org.lld.creational.factory;

import org.junit.Test;
import org.lld.designPatterns.creational.factory.factoryMethod.*;
import org.lld.designPatterns.creational.factory.simpleFactory.ScreenSize;

import static org.junit.Assert.assertTrue;

public class ButtonFactoryMethodTest {

    @Test
    public void testRoundButtonFactory() {
        ButtonFactory buttonFactory = new RoundButtonFactory();
        Button button = buttonFactory.createButton(ScreenSize.PHONE, 1.0, 10.0, null);

        assertTrue("If screen size is a phone, then button type should be round", button instanceof RoundButton);
    }

    @Test
    public void testSquareButtonFactory() {
        ButtonFactory buttonFactory = new SquareButtonFactory();
        Button button = buttonFactory.createButton(ScreenSize.DESKTOP, 1.0, null, 4.0);

        assertTrue("If screen size is a phone, then button type should be round", button instanceof SquareButton);
    }
}
