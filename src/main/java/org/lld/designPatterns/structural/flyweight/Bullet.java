package org.lld.designPatterns.structural.flyweight;

// Step 1 - Intrinsic state

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Bullet {
    private String image;
    private Double radius;
    private Double weight;

    private BulletType bulletType;
}
