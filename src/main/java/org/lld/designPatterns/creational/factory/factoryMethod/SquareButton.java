package org.lld.designPatterns.creational.factory.factoryMethod;

import lombok.Getter;

// Step 2 - create a concrete product classes

@Getter
public class SquareButton extends Button {
    private Double length;

    public SquareButton(Double border, Double length) {
        super(border);
        this.length = length;
    }

    public void onClick() {
        System.out.println("Square Button was clicked.");
    }

    public void render() {
        System.out.println("Square Button rendered!");
    }
}
