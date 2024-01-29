package org.lld.creational.factory;

import org.junit.Test;
import org.lld.designPatterns.creational.factory.abstractFactory.*;

import static org.junit.Assert.assertTrue;

public class AbstractFactoryTest {

    @Test
    public void testDarkTheme() {
        ThemeFactory factory = new DarkThemeFactory();
        Button button = factory.createButton(1.0, 10.0, null);
        Radio radio = factory.createRadio();

        assertTrue("If using dark theme, the button should be dark button", button instanceof DarkButton);
        assertTrue("If using dark theme, the radio should be dark radio", radio instanceof DarkRadio);
    }

    @Test
    public void testLightTheme() {
        ThemeFactory factory = new LightThemeFactory();
        Button button = factory.createButton(1.0, null, 4.0);
        Radio radio = factory.createRadio();

        assertTrue("If using light theme, the button should be dark button", button instanceof LightButton);
        assertTrue("If using light theme, the radio should be dark radio", radio instanceof LightRadio);
    }
}
