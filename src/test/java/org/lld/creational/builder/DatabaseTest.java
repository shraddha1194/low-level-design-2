package org.lld.creational.builder;

import org.junit.Test;
import org.lld.designPatterns.creational.builder.database.Database;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DatabaseTest {

    @Test
    public void testDatabaseBuilder() {
        Database.Builder builder = Database.builder();

        /*
        can be replaced with method chaining
        builder.setName("rescaler");
        builder.setUserName("groot");
        builder.setPassword("pass");

        Create fluent interfaces for it - return this for each setter method
        builder.setName("rescaler")
                .setUserName("groot")
                .setPassword("pass");
         */

        Database database = builder
                .name("rescaler")
                .mysql()
                .port(3306)
                .withCredential("groot", "pass")
                .compressed()
                .build();

        assertNotNull("Failed to create database object.", database);

    }
}
