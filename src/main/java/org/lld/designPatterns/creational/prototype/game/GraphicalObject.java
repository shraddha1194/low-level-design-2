package org.lld.designPatterns.creational.prototype.game;

// Step 1 -  create clonable interface
@FunctionalInterface
public interface GraphicalObject {
    public GraphicalObject cloneObject();
}
