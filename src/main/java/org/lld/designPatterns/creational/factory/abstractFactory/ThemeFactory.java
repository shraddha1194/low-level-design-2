package org.lld.designPatterns.creational.factory.abstractFactory;

public interface ThemeFactory {

    Button createButton(Double border, Double radius, Double length);

    Radio createRadio();
}
