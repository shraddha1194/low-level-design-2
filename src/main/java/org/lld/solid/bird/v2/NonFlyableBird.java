package org.lld.solid.bird.v2;

import org.lld.solid.bird.BirdType;
import org.lld.solid.bird.Colour;
import org.lld.solid.bird.Size;

public abstract class NonFlyableBird extends Bird {
    public NonFlyableBird(String name, Double weight, BirdType type, Colour colour, Size size) {
        super(name, weight, type, colour, size);
    }
}
