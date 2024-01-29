package org.lld.designPatterns.structural.flyweight;

//Step 2 - Extrinsic states

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class FlyingBullet {
    private Double x, y, z;
    private Double direction;

    // Step 3 - Add a has-a relation
    private Bullet bullet;

}
