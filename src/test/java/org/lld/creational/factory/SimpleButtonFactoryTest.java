package org.lld.creational.factory;

import org.junit.Test;
import org.lld.designPatterns.creational.factory.simpleFactory.*;

import static org.junit.Assert.assertTrue;

public class SimpleButtonFactoryTest {

    @Test
    public void testButton() {
        // We are creating class based on subclass names - tight coupling
        // If we change the class name in future - the code will break
        RoundButton roundButton = new RoundButton(1.0, 10.0);
        SquareButton squareButton = new SquareButton(1.0, 10.0);
    }

    @Test
    public void testRoundButton() {
        Button button = ButtonFactory.createButton(ScreenSize.PHONE, 1.0, 1.0, null);
        assertTrue("If screen size is a phone, then button type should be round", button instanceof RoundButton);
    }

    @Test
    public void testSquareButton() {
        Button button = ButtonFactory.createButton(ScreenSize.DESKTOP, 1.0, null, 2.0);
        assertTrue("If screen size is a desktop, then button type should be round", button instanceof SquareButton);
    }
}
