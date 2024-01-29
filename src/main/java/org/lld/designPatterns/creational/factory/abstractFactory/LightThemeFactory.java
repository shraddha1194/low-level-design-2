package org.lld.designPatterns.creational.factory.abstractFactory;

public class LightThemeFactory implements ThemeFactory {
    @Override
    public Button createButton(Double border, Double radius, Double length) {
        return new LightButton(border, length);
    }

    @Override
    public Radio createRadio() {
        return new LightRadio();
    }
}
