package org.lld.solid.bird.v2;

import org.lld.solid.bird.BirdType;
import org.lld.solid.bird.Colour;
import org.lld.solid.bird.Size;

public class Eagle extends FlyableBird{

    public Eagle(String name, Double weight, BirdType type, Colour colour, Size size) {
        super(name, weight, type,colour, size);
    }

    @Override
    public void fly() {
        System.out.println("Eagle is flying!");
    }
}
