package org.lld.designPatterns.creational.factory.factoryMethod;

import lombok.Getter;

// Step 2 - create a concrete product classes

@Getter
public class RoundButton extends Button {

    private Double radius;

    public RoundButton(Double border, Double radius) {
        super(border);
        this.radius = radius;
    }

    public void onClick() {
        System.out.println("Round Button was clicked.");
    }

    public void render() {
        System.out.println("Round Button rendered!");
    }
}
