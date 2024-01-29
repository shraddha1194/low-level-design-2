# Strategy Design pattern

> The strategy design pattern (also known as the policy pattern) is a software design pattern that enables an algorithm's behavior to be selected at runtime.
> The strategy patten encapsulates alternative algorithms or strategies for a specific task and supports their interchangeable use.
> The strategy patten lets the algorithm vary independently from clients that use it.

 Today we are building a navigation system for a car. The navigation system should be able to calculate the shortest route between two points and tell the driver how to get there.
 We start with simple implementation that only supports driving on roads and hence we design a simple `RoadNavigation` class that calculates the shortest route between two points on a road.
 
```java
public class Navigator {
    public void navigate(Point from, Point to) {
        ...
    }
}
```

Our application is hit and we got multiple requets to support other types of navigation such as using bike or walking.
To support various types of navigation we introduce a new `ModeType` enums that defines the different types of navigation.

```java
public class Navigator {
    public void navigate(Point from, Point to, ModeType mode) {
        if (mode == ModeType.BIKE) {
            ...
        } else if (mode == ModeType.WALK) {
            ...
        }
    }
}
```

This works but it is not veru flexible. If we want to add a new type of navigation we have to modify the navigate method.
This is an example of a violation of the open-close principle.
Similarly, the method has multiple reasons to change, and we have to test for all the different types of navigation.

We could create an interface and have separate class for each type of navigation.
This would solve the problem of having to modify the `navigate` method, but inheritance is tatic and we cannot cange the behavior of the navigate method at runtime.
Also, code duplication is a problem.
This is where strategy pattern comes in.
The strategy pattern allows us to encapsulate the different types of navigation in separate classes and select the appropriate one at runtime.
The Strategy pattern suggests that you take a aclass that does something specific in a lot of different ways and extract all of these algorithms into seperate classes called strategies.
The original class, called context, must have a field for storing a reference to one of strategies.
The context delegates the work to linked strategy object instead of executing it on its own.

### Implementation
1. `Strategy interface` - defines an alogithm interface common to all supported versions.
```java
public interface NavigationStrategy {
    void navigate(Point from, Point to);
}
```

2. `Concrete strategy classes` - implement the algorithm using the strategy interface.
```java
public class RoadNavigation implements NavigationStrategy {
    @Override
    public void navigate(Point from, Point to) {
        ...
    }
}
```

3. `Context class` - maintains a reference to Strategy object and defines an interface that lets the strategy access its data.
```java
public class Navigator {
    private NavigatorStrategy strategy;
    
    public Navigator(NavigatorStrategy strategy) {
        this.strategy = strategy;
    }
    
    public void navigate(Point from, Point to) {
        strategy.navigate(from, to);
    }
}
```

4. `Client` - creates and configure the context and the strategy objects.

```java
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Navigator navigator = new Navigator(new RoadNavigator());
        navigator.navigate(new Point(0, 0), new Point(10, 10));
    }
}
```
To create a strategy object we can use factory method.

### Recap
* The strategy pattern encapsulates alternative algorithm for a specific task n supports their interchangeable use.
* implementing it in place violetes the open-closed principle and make the code harder to maintain
* inheritance is static and we cannot change the behavior of the system at runtime
* To use the strategy pattern we can create a strategy interface and a set of classes that implement it
* The context class maintains a reference to a strategy object and delegates the work to it.
