# Observer Pattern

> The observer pattern is a software design pattern in which an object, called the subject, maintains a list of its dependents, called observers, and notifies them automatically of any state changes, usually by calling one of their methods.

Imagine it is iPhone season again, where Apple releases a new version of th eiPhone and millions of individuals can't wait to get there hands on it.
The stock at the local store has not yet been updated, but you want tto be the first to know when the new iPhone is available.
You can go to the store every day to check if the stock has been updated, but that is wasteful.
Another option is that the tsore sends everyone an email when the new phones come in.
Again, it is wasteful since not everyone is interested in the new iPhone.
The best option is that you register or subscribe to the store's mailing list.
When the new iPhone comes in, the store sends an email to everyone on the mailing list.
This is the motivation behind the Observer pattern.

We now want to build a Bitcoin tracker application that sends out emails or tweets when the price of Bitcoin changes.
We have a data model for Bitcoin that contains the current proce of Bitcoin.
Apart from this we have a BitcoinTracker class that is responsible for setting th eprice of the Bitcoin

```java
public class BitcoinTracker {
    private Bitcoin bitcoin;
    
    public void setPrice(double price) {
        bitcoin.setPrice(price);
    }
}
```

Now we want to send an email when the price of Bitcoin changes.
We can do this by calling the sendEmail method in the setter method of BitcoinTracker class.

```java
public class BitcoinTracker {
    private Bitcoin bitcoin;
    
    public void setPrice(double price) {
        bitcoin.setPrice(price);
        sendEmail();
    }
}
```

The above implementation works but is not ideal.
The BitcoinTracker class has two responsibilities.
It is responsible for setting the price of Bitcoin and it is responsible for sending an email.
The BitcoinTracker class violets the Single Responsibility Principle.
Similarly, we can also send a tweet when the price of Bitcoin changes.
We can do this by calling the sendTweet method in the setter method of BitcoinTracker class.
This, now violets the Open-Closed Principle. 
We have to change the code in multiple places if we want to add a new feature.

```java
public class BitcoinPoller {
    private BitcoinTracker bitcoinTracker;
    private Bitcoin bitcoin;
    
    public void poll() {
        Bitcoin currentBitcoin = bitcoinTracker.getBitcoin();
        if (currentBitcoin.getPrice() != previousBitcoin.getPRice()) {
            sendEmail();
        }
        this.previousBitcoin = currentBitcoin;
    }
}
```

The two approaches we have discussed so far are not ideal. 
The first approach violets the Single Responsibility Principle,
The second approach is wasteful.

The Observer pattern suggests that you  define a one-to-many dependency between objects so that when one object changes state, all its dependent are notified and updated automatically.

### Implementation
1. `Observable interface` - The interface defines the methods that the subject class must implement.
The subject class is responsible for notifying the observers when the state of the subject changes.
```java
public interface class Observable {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
```

2. `Observer interface` - This interface defines th emethod that the observer class must implement.
The observer class is responsible for updating itself when the state of the subject changes.
```java
public interface class Observer {
    void notify();
}
```
3. `Concrete observables` - These are the classes that implement the Observables interface. The BitconTracker class is a concrete observable.
The BitcoinTracker class is responsible for notifying the observer when the state of the subject changes.
```java
public class BitcoinTracker implements Observable {
    private Bitcoin bitcoin;

    public void setPrice(double price) {
        bitcoin.setPrice(price);
        notifyObservers();
    }
}
```
To simplify the code and provide better interfaces, we can borrow from the registry pattern and register observers and even add utility methods to the Observable interface.

```java
public abstract class Observable {
    
    List<Observer> observers = new ArrayList<>();

    public void register(Observer observer) {
        observers.add(observer);
    }

    public void deregister(Observer observer) {
        observers.remove(observer);
    }

    public void notifyChange() {
        for (Observer observer : observers) {
            observer.notifyChange();
        }
    }
}
```
4. `Concrete observers` - These are the classes that implement the Observer interface. The EmailSender class is a concrete observer. The EmailSender class is responsible for updating itself when the state of the subject changes.
```java
public class EmailSender implements Observer {
    private Bitcoin coin;
    public void notifyChange() {
        sendEmail();
    }
}
```

5. `Client` - The client is responsible for creating the subject and the observers. The client is alsi responsible for registering the observers with the subject.
```java
public class Client {
    public static void main(String[] args) {
        BitcoinTracker bitcoinTracker = new BitcoinTracker();
        EmailSender emailSender = new EmailSender();
        
        bitcoinTracker.register(emailSender);
    }
}
```

### Recap
* There are often times when you want to notify other objects when the state of an object changes.The observer pattern suggests that you define a one-to-many dependency between objects so that when object changes state, all the dependents are notified and updated automatically.
* In-place updates and polling are not ideal. In-place updates violet the Single Responsibility Principle whereas polling is wasteful.
* To implement the Observer pattern, define an Observerval interface that defines the methods that the subject class must implement.
* Define an Observer interface that defines the methods that the observer class must implement. The subject class is responsible for notifying the observers when the state of the subject changes. The observer class is responsible for updating itself when the state of the subject changes.