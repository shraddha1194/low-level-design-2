## Singleton Design Pattern

The singleton pattern is a software design pattern that restricts the instantiation of a class to one object. This is useful when exactly one object is needed to coordinate actions across the system.

### Why?
Problem with shared resources and single access point.

* `Shared resource` - Imagine you have a class that is responsible for managing the database connection. You want to make sure that only one instance of this class exists in your application. If you create multiple instances of this class, you will end up with multiple database connections, which is not what you want. Similarly, there can be a class that is responsible for managing the logging mechanism. You want to make sure that only one instance of this class exists in your application. If you create multiple instances of this class, you will end up with multiple log files, which is not what you want.
* `Single access point` - Applications often require configuration. For example, you might want to configure the database connection parameters. You want to make sure that only one instance of this class exists in your application. A configuration class should have a single access point to the configuration parameters. If you create multiple instances of this class, you will end up with multiple configuration files.

creating the multiple unnecessary instances may lead to memory overhead, CPU overhead also at time we need single source of truth (single access point).

### What?
Shared resource - connection pool, log file, state container

### How?
1. How to create a class where we create zero objects for it?
    - abstract class - we will never be able to create an object
    - #### Alternate Methods
      - `create a private constructor` - constructor hiding.  The constructor of the singleton class should be private or protected. This will prevent other classes from instantiating the singleton class.
      - `Global access point` - The singleton class should provide a global access point to get the instance of the singleton class. This global access point should be static and should return the same instance of the singleton class every time it is called. If the instance does not exist, it should create the instance and then return it.
      - 

### Use case:
- ThreadPool - Suppose we have 3 classes and in each of these we want thread pool
    ```java
    class A {
        ThreadPool tp = new ThreadPool(); 
    }

    class B {
        ThreadPool tp = new ThreadPool();
    }

    class C {
        ThreadPool tp = new ThreadPool();
    }
    ```
Thread from class A will not be reused by class B or class C. Similar for class B and class C.

Ideally we should reuse same thread pools across the classes.


- Similar to threadPool we have connectionPool.
When we run a query on database, a new database connection is opened/initiated/established. For each query if we create a new connection it will create memory overhead plus it's a little complex. Better to reuse these connections.
Hikari Connection Pools - Spring uses
CP3O

- Logging - prints debug, info, error statements to and warnings to a file
    ```java
    class log {
        log(String x) {
            //prints to the file
        }
    }
    ```
Suppose we have n classes and each class wants to log details. Instead of creating separate objects, use one instance and pass it to all the classes 


- Redux—State management library on UI.
redux datastore—stores events state in DB (login scenario when clicking sign in)
We cannot have multiple states (i.e. user logged-in and we cannot have another state with user not logged in)
We need only one source of truth

- In Spring every single object is singleton and hence we call it beans.

### Simple Singleton
1. The first step is to hide the constructor by making it provate. This will prevent other classes from instantiating the singleton class.
```java
public class Database {
    private Database() {
    }
}
```
This restricts the instantiation of the Database class.

2. Provide a global access point to get the instance of the Database class.
Create a static method that returns the instance of the Database class. If instance does not exist, it should create the instance and then return it.

```java
public class Database {
    private static Database instance = new Database();
    
    private Database() {
    }

    public static Database getInstance() {
        return instance;
    }
}
```

3. To implement getInstance() method, we need to create a static variable of the database class. This variable will hold the instance of the Database class.
We will initialize this variable to null. The getInstance() method will check if the instance variable is null. If it is nnull, it will create a new instance of the class and assign it to the instance variable.
Finally, it will return the instance variable. This is known as lazy initialization.

```java
public class Database {
    private static Database instance = null;

    private Database() {
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }
}
```
### Thread-safe singleton

The above code is not thread-safe. If two threads call getInnstane() method at the same time, both threads will check if the instance variable is null.
Both will find that the instance variable is null. Both threads will create a new instance of Database class. This will result in two instances of the Database class. To make the above code thread-safe, we can make getInstance() method synchronized.

```java
public class Database {
    private static Database instance = null;

    private Database() {
    }

    public static synchronized Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }
}
```

### Double-checked locking
The above code is thread-safe. However, it is not efficient.
If two threads call the getInstance() method at the same time, both threads will check if the instance variable is null. Both threads will find that the instance variable is null.
Both threads will wait for the lock to be released. Once the lock is released, one thread will create a new instance of the Database class. The other thread will wait for the lock to be released. Once the lock is released, it will create a new instance of the Database class. This will result in two instances of the Database class. To make the above code efficient, we can use double-checked locking.

```java
public class Database {
    private static Database instance = null;

    private Database() {
    }

    public static Database getInstance() {
        if (instance == null) {
            synchronized (Database.class) {
                if (instance == null) {
                    instance = new Database();
                }
            }
        }
        return instance;
    }
}
```

https://github.com/kanmaytacker/design-patterns/blob/june-2023/notes/01-singleton.md

https://github.com/kanmaytacker/design-patterns/blob/master/src/main/java/com/scaler/lld/design/creational/singleton/ConnectionPool.java