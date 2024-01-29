package org.lld.solid.bird.v2;

import org.lld.solid.bird.BirdType;
import org.lld.solid.bird.Colour;
import org.lld.solid.bird.Size;

import java.util.List;

public class Runner {
    public static void main(String[] args) {

        Eagle eagle = new Eagle("Eagle", 3.00, BirdType.EAGLE, Colour.GREEN, Size.MEDIUM);
        eagle.fly();

        Sparrow sparrow = new Sparrow("Sparrow", 3.00, BirdType.SPARROW, Colour.GREEN, Size.MEDIUM);
        sparrow.fly();

        Penguin penguin = new Penguin("Penguin", 3.00, BirdType.PENGUIN, Colour.GREEN, Size.MEDIUM);

        flyAll(List.of(eagle, sparrow));
    }

    private static void flyAll(List<FlyableBird> birds) {
        birds.forEach(FlyableBird::fly);
    }
}
