package org.lld.designPatterns.creational.factory.abstractFactory;

import lombok.Getter;

// Step 2 - create a concrete product classes

@Getter
public class LightButton extends Button {
    private Double length;

    public LightButton(Double border, Double length) {
        super(border);
        this.length = length;
    }

    public void onClick() {
        System.out.println("Light Button was clicked.");
    }

    public void render() {
        System.out.println("Light Button rendered!");
    }
}
