package org.lld.designPatterns.creational.prototype.game;

import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
public class BackgroundObjectRegistry {
    private Map<BackgroundObjectType, BackgroundObject> registry = new HashMap<>();

    public void registerPrototype(BackgroundObject backgroundObject) {
        registry.put(backgroundObject.getType(), backgroundObject);
    }

    public BackgroundObject getPrototype(BackgroundObjectType type) {
        return registry.get(type);
    }

    public void removePrototype(BackgroundObjectType type) {
        registry.remove(type);
    }

}
