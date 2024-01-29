## Builder Pattern 

Enables on demand initialization

### What?

Builder is a creational design pattern that lets you construct complex objects step by step. The pattern allows you to produce different types and representations of an object using the same construction code.

### Why?
- On demand initialization - initialize with data I have not necessarily all the fields
- Global validation - we can validate multiple fields at a time
- We want to have immutable objects

* `Complex object creation`

There are multiple ways to create an object, but constructors are the primary technique used for creating instances of a class. However, constructor become unmanagable when there is a need to create objects with many parameters.
This is known as the telescoping constructor anti-pattern.
The telescoping constructor anti-pattern is a code smell that indicates that the class has too many constructors.This ia a code smell because it is difficult to maintain and extend the class.


If a student class has more than 20 fields (it's not maintainable, more likely to make mistake, not readable, bad developer experience, compiler will not give error)

when a class has a different set of requirements, we can create overloaded constructors (user can be student, teacher and TA)

**Telescoping Constructors**: Anti-patterns (something we don't do) issue with maintainability

students()
- name, email
- name, email, phone
- name, email, phone, psp

Constructors provide fix contract that we need to follow.

* `Validation and failing object creation`

There are cases when we want to validate the parameters before creating an object. For example, you might want to validate the parameters before creating an object. For example, you might want to validate the parameters before creating a database connection.
If the parameters are invalid, we might want to throw an exception.
However, if we use the default constructor, we cannot fail object creation.

* `Immutability`

Mutable objects are objects whose state can be changed after they are created.
Immutable objects are objects whose state cannot be changed after they are created.
Immutable objects are easier to maintain and extend whereas mutable objects can lead to bugs.
However, if we use the default constructor, we cannot create immutable objects.
-----------------------------------

### How?

#### Constructor with a hash map
The above problems can be solved using a constructor with a hash map. The constructor will take a hash map as a parameter. The hash map will contain the parameters and their values.
The constructor will validate the parameters and create the object.

```java
public class Database {
    private String host;
    private int port;
    private String username;
    private String password;

    public Database(Map<String, String> config) {
        if (config.containsKey("host")) {
            this.host = config.get("host");
        }
        if (config.containsKey("port")) {
            this.port = Integer.parseInt(config.get("port"));
        }
        if (config.containsKey("username")) {
            this.username = config.get("username");
        }
        if (config.containsKey("password")) {
            this.password = config.get("password");
        }
    }
}
```
Some problems with the above code are:
* `Type safety` - A hash map cannot have values with different types. If we want to use different types, we need to use map with string key and object value.
However, this will result in a runtime error if we try to cast the object to the wrong type.
* `Defined parameters` - With the above approach, identifying the parameter is difficult. We need to read the code to identify the parameters. 
This is not a good approach because it is difficult to maintain and extend the code.

#### Inner class
Instead of using a hash map, we can use a class to accept parameters for the object. Thi parameter class is type safe, and it is easy to identify the parameter.

```java
public class Database {
    private String host;
    private int port;
    private String username;
    private String password;

    public Database(DatabaseParameters parameter) {
        this.host = parameter.host;
        this.port = parameter.port;
        this.username = parameter.username;
        this.password = parameter.password;
    }
}

class DatabaseParameters {
    public String host;
    public int port;
    public String username;
    public String password;
}
```

The above code is type safe. However, it is not easy to use.
We need to create an instance of DatabaseParameters class and then pass it ti Database class.
This is not good approach because it is difficult to maintain and extend the code.

Similarly, if we even want to change a single parameter name, we have to open Database class for modification.
Instead, we should move the destructing of the parameter class and validation logic to the Parameter class.
This will require creating Databse constructor with all the fields, 
Again, why would developers not just want to use the constructor instead?

So we need a way to allow the parameter class to create the Database object whilwe not exposing a constructor.
This is done using an inner class. This inner class is known as builder class.

```java
public class Database {
    private String host;
    private int port;
    private String username;
    private String password;

    private Database() {
    }

    public static class DatabaseBuilder {
        private String host;
        private int port;
        private String username;
        private String password;

        public Database build() {
            Database database = new Database();
            database.host = this.host;
            database.port = this.port;
            database.username = this.username;
            database.password = this.password;
            return database;
        }
    }
}
```

The above code now allows us to create a Database object using DatabaseBuilder class.
We can fail object creation by adding a validation hook to the build method.
The objects created are immutable because the Database class does not have any setters.
And the developer can create objects with any permutation of parameters.

```java
Database database = new Database.DatabaseBuilder()
    .host("localhost")
    .port(3306)
    .username("root")
    .password("password")
    .build();
```
#### Steps:
1. create a class and a static Builder class
    ```
    class Student {
        static class Builder {
        } 
    }
   ```
2. Copy all the fields of the outer class to inner class
    ```
    class Student {
        String name;
        String email;
        int psp;
   
         static class Builder {
            String name;
            String email;
            int psp;
         } 
    }
    ```
3. Expose setter on the builder
4. Call lifecycle method build/ hook

We can add validations before build hook

- Builder pattern uses concept of friend class (instead of map)
- Static class in the main class—static builder class (inner-outer class)
- main class—outer class
- static class—inner class
- exposes lifecycle methods (hooks) on call of which it creates the object
- we need to not have public constructors
- we can implement without inner static class—but in that case, we will have to expose constructors and then people will simply use constructors instead of builder class

--------------------------------------------------------------
### What is another approach?
**- Setters**
``` 
Student s = new Students();
s.setName();
s.setPsp();
```

This makes our object mutable - the value of fields can be changed.

We usually prefer immutable objects - why?
- not to have side effects
- very hard to debug when a value changes for a paramater

---------------------------------------

### Summary
* The builder pattern is a creational design pattern that lets you construct complex objects step by step. The pattern allows you to produce different types and representations of an object using the same construction code.
* Use cases of builder pattern
  * Complex object creation - Telescoping constructor anti-pattern
  * Validation and failing object creation
  * Immutability
* Add a static inner class to the class that you want to create. This inner class is known as the builder class.
* Add a private constructor to the class that you want to create. This constructor will be used by the builder class to create the object.
* Implement the build() method in the builder class. This method will return the object created by the private constructor.
* Add a method for each parameter in the builder class. This method will set the parameter value and return the builder class instance.


**Why the inner class needs to be static?**

The inner class needs to be static otherwise we would need a parent class instance to access the builder class.

https://github.com/kanmaytacker/design-patterns/blob/june-2023/notes/02-builder.md