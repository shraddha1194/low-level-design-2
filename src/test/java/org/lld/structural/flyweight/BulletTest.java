package org.lld.structural.flyweight;

import org.junit.Test;
import org.lld.designPatterns.structural.flyweight.Bullet;
import org.lld.designPatterns.structural.flyweight.BulletRegistry;
import org.lld.designPatterns.structural.flyweight.FlyingBullet;

import static org.lld.designPatterns.structural.flyweight.BulletType.ELEVEN_MM;
import static org.lld.designPatterns.structural.flyweight.BulletType.NINE_MM;

public class BulletTest {

    @Test
    void createFlyweight() {
        BulletRegistry registry = new BulletRegistry();

        Bullet bullet = new Bullet("IMAGE", 0.9, 10.0, NINE_MM);
        Bullet bullet2 = new Bullet("IMAGE_2", 1.1, 20.0, ELEVEN_MM);

        registry.addBullet(bullet);
        registry.addBullet(bullet2);

        FlyingBullet flyingBullet1 = new FlyingBullet(0.0, 0.0, 0.0, -12.0, registry.getBullet(NINE_MM));
        FlyingBullet flyingBullet2 = new FlyingBullet(10.0, 10.0, 10.0, 12.0, registry.getBullet(ELEVEN_MM));
    }
}
