package org.lld.creational.prototype;

import org.junit.Test;
import org.lld.designPatterns.creational.prototype.game.BackgroundObject;
import org.lld.designPatterns.creational.prototype.game.BackgroundObjectRegistry;
import org.lld.designPatterns.creational.prototype.game.BackgroundObjectType;

import static junit.framework.TestCase.*;

public class BackgroundObjectTest {
    @Test
    public void testClone() {
        //  Step 3 - create prototype + clone and modify it
        BackgroundObject prototype = new BackgroundObject(0.0, 0.0, 10.0, 10.0, BackgroundObjectType.TREE);
        BackgroundObject clone = prototype.cloneObject();

        assertNotSame("New Object was created", prototype, clone);
        assertEquals("If clone is called type of both object is same", prototype.getType(), clone.getType());

        // Modify clone
        clone.setX(10.0);
        clone.setY(10.0);
    }

    @Test
    public void testRegistry() {
        // Create a prototype
        BackgroundObject prototype = new BackgroundObject(0.0, 0.0, 10.0, 10.0, BackgroundObjectType.TREE);

        // Register prototype to Registry
        BackgroundObjectRegistry registry = new BackgroundObjectRegistry();
        registry.registerPrototype(prototype);

        // Fetch prototype
        BackgroundObject backgroundObject = registry.getPrototype(prototype.getType());

        assertNotNull("If prototype is stored, it should return the object", backgroundObject);


    }

}
