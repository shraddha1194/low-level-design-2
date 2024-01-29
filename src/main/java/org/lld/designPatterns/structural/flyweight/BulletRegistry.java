package org.lld.designPatterns.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

public class BulletRegistry {

    private Map<BulletType, Bullet> bullets = new HashMap<>();

    public void addBullet(Bullet bullet) {
        bullets.put(bullet.getBulletType(), bullet);
    }

    public Bullet getBullet(BulletType type) {
        return bullets.get(type);
    }

}
