package org.lld.designPatterns.creational.factory.abstractFactory;

import lombok.Getter;

// Step 2 - create a concrete product classes

@Getter
public class DarkButton extends Button {

    private Double radius;

    public DarkButton(Double border, Double radius) {
        super(border);
        this.radius = radius;
    }

    public void onClick() {
        System.out.println("Dark Button was clicked.");
    }

    public void render() {
        System.out.println("Dark Button rendered!");
    }
}
