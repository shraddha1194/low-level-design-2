package org.lld.designPatterns.creational.prototype.game;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Step 2 - create concrete class with
@Setter
@Getter
@NoArgsConstructor
public class BackgroundObject implements GraphicalObject {
    private Double x;
    private Double y;
    private Double width;
    private Double height;
    private BackgroundObjectType type;

    @Setter(AccessLevel.NONE)   // do not create setter
    private List<Double> pixels = new ArrayList<>();

    private BackgroundObject(BackgroundObject reference) {
        this.x = reference.x;
        this.y = reference.y;
        this.width = reference.width;
        this.height = reference.height;
        this.type = reference.type;
        this.pixels = reference.pixels;
    }

    public BackgroundObject(Double x, Double y, Double width, Double height, BackgroundObjectType type) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.type = type;
        this.pixels = generatePixels();
    }

    private List<Double> generatePixels() {
        return Collections.emptyList();
    }

    @Override
    public BackgroundObject cloneObject() {
        return new BackgroundObject(this);
    }
}
