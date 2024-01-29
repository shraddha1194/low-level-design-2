package org.lld.solid.bird.v2;

import org.lld.solid.bird.BirdType;
import org.lld.solid.bird.Colour;
import org.lld.solid.bird.Size;

// abstract class
public abstract class Bird {

    // all common attributes are placed here
    private String name;
    private Double weight;

    private BirdType type = BirdType.EAGLE;
    private Colour colour;
    private Size size;

    public Bird(String name, Double weight, BirdType type, Colour colour, Size size) {
        this.name = name;
        this.weight = weight;
        this.type = type;
        this.colour = colour;
        this.size = size;
    }

    // all common behavior are placed here
    public void eat() {
        System.out.println("I am hungry, let's eat!");
    }

    public void sleep() {
        System.out.println("I am tired, let's sleep!");
    }

    // abstract behavior which will differ from bird to bird
//    public abstract void fly();
}
