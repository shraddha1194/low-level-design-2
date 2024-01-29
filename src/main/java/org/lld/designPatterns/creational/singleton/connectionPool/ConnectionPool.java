package org.lld.designPatterns.creational.singleton.connectionPool;

public class ConnectionPool {
    // Step 3 - static attribute
    private static ConnectionPool INSTANCE;

    // EAGER Initialization - object is created when class in loaded, even before runtime plus it is thread safe
    // issue when we accept attribute like name on initialization (dynamic attributes)
    //public static ConnectionPool INSTANCE = new ConnectionPool();

    // Step 1 - Constructor hiding
    private ConnectionPool() { }

    // Step 2 - global access point
    // LAZY initialization - we are creating object when method is called
    public static ConnectionPool getInstance() {
        // Step 4 - If instance present return, else crate and return
        // critical section if multiple treads are accessing then will create multiple instance at a time
        if (INSTANCE == null) {
            synchronized (ConnectionPool.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ConnectionPool();
                }
            }
        }
        return INSTANCE;
    }
}

// Drawback - Is not thread safe;
// make static method synchronized - it will become very slow, even if instance is created it will block other threads
// use synchronized block - synchronize(INSTANCE) - will fail because instance can be null
// try synchronized(ConnectionPool.class) - will work

// Double checked locking - use two ifs, if instance is created, the threads won't be blocked
//if (INSTANCE == null) {
//    synchronized(ConnectionPool.class) {
//        if (INSTANCE == null) {
//          INSTANCE = new ConnectionPool();
//        }
//    }
//}