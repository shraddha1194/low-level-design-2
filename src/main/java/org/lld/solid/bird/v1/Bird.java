package org.lld.solid.bird.v1;

import org.lld.solid.bird.BirdType;
import org.lld.solid.bird.Colour;
import org.lld.solid.bird.Size;

public class Bird {
    private String name;
    private Double weight;
    private BirdType type = BirdType.EAGLE;
    private Colour colour;
    private Size size;

    public void fly() {

        // if-else ladder
        if (type == BirdType.EAGLE) {
            System.out.println("Eagle is flying.");
        } else if (type == BirdType.PARROT) {
            System.out.println("Parrot is flying");
        } else if (type == BirdType.PEACOCK) {
            System.out.println("Peacock is flying");
        }
    }

    public void eat() {
        System.out.println("I am hungry, let's eat!");
    }

    public void sleep() {
        System.out.println("I am tired, let's sleep!");
    }

}



