### Facade
> A facade is an object that provides a simplified interface to a larger body of code, such as a class library.

> Facade is a structural design pattern that provides a simplified interface to a library, a framework, or any other complex set of classes.

Facade means "face" in French. It is a front-facing building that is the main entrance to a building. The facade is the first thing that a visitor sees when they enter a building. The facade hides the complexity of the building from the visitor. The facade provides a simple interface to the building. The facade is a single point of entry to the building.

Suppose we are on e-commerce site, and we have created an order, and now we want to check out:
what will happen in system in order for us to check out ?
* check inventory
* get payment gateway
* generate bill
* update the inventory
* schedule delivery
* send a notification to customer

For each functionality we ha have services:
* Inventory service
* Payment service
* Notification service
* Delivery service

Now Order Manager who has checkout functionality will have to deal with all of these classes

Problem:
* Violets SRP and becomes monster method
* Makes it not reusable
* Not very testable
* Not maintainable since the same code will be duplicated at many places. ex to send notification, everytime we need to update the notification related functionality we may have to update at a lot of places.

Wherever we have complex subsystem, create simpler interface so that it becomes easy for it to be reused.

Facade means face in french.
A house might have a lot of people inside, everything is hidden from outer world by the outer wall of the house which is facade in this case.
The facade provides a simple interface to the building. The facade is a single point of entry.

The complex implementation is abstracted/hidden with facade pattern.

Having a facade is handy when you need to integrate your app with a sophisticated library that has dozens of features, but you just need a tiny bit of its functionality.

### Problem
Let us take the example of an e-commerce application. The application has a lot of functionality.
It has a product catalog, a shopping cart, a payment system, a shipping system, etc. The application has a lot of classes and a lot of dependencies between them.
The application is complex and it is hard to understand how all the classes work together.
When you make an order, you have to do the following:
* call payment gateway to charge the credit card
* update the inventory
* email the customer
* add the order to the shipping queue
* update analytics

The above steps are not trivial. The application has a lot of classes and a lot of dependencies between them.
The application is complex, and it is hard to understand how all the classes work together.
The application is also hard to maintain. If you want to change the way the application sends emails, you will have to change the code in multiple places,
If you want to add a new feature, you will have to change the code in multiple places, image how the class looks:
```java
public class Order {
    private PaymentGateway paymentGateway;
    private Inventory inventory;
    private EmailService emailService;
    private ShippingService shippingService;
    private AnalyticsService analyticsService;
    
    public void checkout() {
        paymentGateway.charge();
        inventory.update();
        emailService.send();
        shippingService.add();
        analyticsService.update();
    }
}
```
Here we have a lot of dependencies, some of which might be external vendors. The business logic of your classes whould become tightly coupled to th eimplementation details of 3rd-party classes,
making it hard to comprehend and maintain. The Order class is hard to test.
You will have to mock all the dependencies. The Order class is also hard to reuse. If you want to reuse the Order class in another application, 
you will have to change the code. Everytime one of the logic changes you will have to change the code in multiple places and hence violating SOLID principles.

A facade is a class that provides a simple interface to a complex subsystem which contains lots of moving parts. A facade might provide limited functionality in comparison to working with the subsystem directly.
However, it includes only those features that clients really care about.

Having a facade is handy when you need to integrate your app with a sophisticated library that has dozens of features, but you just need a tiny bit of its functionality.

### Solution
The Facade pattern suggests that you wrap a complex subsystem with a simpler interface. The facade pattern provides a higher-level interface that makes the subsystem easier to user,
The facade pattern provides a higher-level interface that makes the subsystem easier to use.
The Facade pattern is implemented by simply creating a new class that encapsulates the complex logic of the existing classes.
For the example above, we will mov ethe complex logic to a new class called OrderProcessor.

```java
public class OrderProcessor {
    private PaymentGateway paymentGateway;
    private Inventory inventory;
    private EmailService emailService;
    private ShippingService shippingService;
    private AnalyticsService analyticsService;
    
    public void process() {
        paymentGateway.charge();
        inventory.update();
        emailService.send();
        shippingService.add();
        analyticsService.update();
    }
}
```
We are simply moving the code from one place to another just so that it is easier to process orders from one interface.

Now we can use OrderProcessor class in our Order class and delegate the complex logic to the OrderProcessor class.
```java
public class Order {
    private OrderProcessor orderProcessor;
    
    public void checkout() {
        orderProcessor.process();
    }
}
```

The Order class is now much simpler. It has a single responsibility of creating an order.
The Order class is also easier to test. You can mocj the OrderProcessor class.
The Order class is also easier to reuse.
You can reuse the ORder class in another application without changing the code.
