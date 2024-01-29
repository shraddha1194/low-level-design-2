package org.lld.creational.singleton;

import org.lld.designPatterns.creational.singleton.connectionPool.ConnectionPool;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ConnectionPoolTest {

//    @Test
//    public void testConstructor() {
//        ConnectionPool connectionPool = new ConnectionPool();
//        //If the ctor was called, a non-null object should be created
//        assertNotNull("If the ctor was called, a non-null object should be created", connectionPool);
//    }

    @Test
    public void testStaticInitializer() {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        assertNotNull("If the ctor was called, a non-null object should be created", connectionPool);
    }

    @Test
    public void testObject() {
        ConnectionPool connectionPool1 = ConnectionPool.getInstance();
        ConnectionPool connectionPool2 = ConnectionPool.getInstance();

        assertEquals("Objects are not equals", connectionPool1, connectionPool2);
    }

}
