package org.lld.designPatterns.creational.factory.simpleFactory;

import lombok.AllArgsConstructor;
import lombok.Getter;

// step 1 - create a common product interface/ abstract class
@AllArgsConstructor
@Getter
public abstract class Button {
    private Double border;
    public abstract void onClick();
    public abstract void render();
}
