package org.lld.designPatterns.creational.factory.abstractFactory;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class Button {
    private Double border;
    public abstract void onClick();
    public abstract void render();
}
