# SOLID

### S - Single Responsibility Principle
Single code unit should have one responsibility.

Single code unit here could be class, method. One class ex. bird should represent responsibility of bird no tiger. Single package should have a single responsibility.

Responsibility? - What does a code do?

#### Why we need SRP?
- testability, Readability, Maintainability, Extensibility

#### How to see if we need SRP?
Change - what are different reasons to change?
    - Change the fly behavior of a bird
    - Adding a new bird or removing an existing bird

If we are following SRP how many reasons do we need to change a class/method etc.
We should have one reason to change the class, method etc.

fly method in bird - should have responsibility to make the bird fly. Currently, it has responsibility to decide which bird to fly.

SRP is very subjective. It's not always 100% true.

#### Where we usually see SRP violations?
1. if-else ladder, switch
2. Monster methods/God classes - classes that are huge or methods that are too long. Usually do more than the name suggests.
    - ####  ex. SaveABirdToDataBase()
    - create a Bird
    - connect to database,
    - Write query to insert to database
    - Execute the query
    - Get the response (select query) create new Bird object to return
    - close the connection
3. Utils classes - Utility classes, unrelated or unused piece of code can be added.
ex. https://docs.oracle.com/javase/8/docs/api/java/util/package-summary.html
Cannot be changed because of backward compatibility

#### Cyclomatic complexity
How to say a method is monster method? Looking at lines of code - not very easy to follow

Cyclomatic complexity is common matrix used by various libraraies to tell our code is good or not.
How many if-else we have, indentations we have.

Cyclomatic complexity give objective measure of how complex our code is.

--------------------------

### Open - Closed Principle

The code should be open for extension but closed for modification.

When we modify a file how far the impact of changes go - Blast radius

Do not modify classes at root level but create new child classes.

ex. Bird class if we want to modify the fly method. If have implementation for eagle and sparrow. If we want to add peacock. What we have to modify?
We are modifying an already used class and method. Modifying Bird class will impact all the other classes which use bird class.

Add a functionality by creating new child classes or create new method to restrict blast radius.

#### Why?
If we create new Bird class ex. Peacock and we for forget to add fly or add new piece of code, we'll run into problem. The bird class was representing all type of birds.
Instead, create child classes Eagle, Sparrow and for each class override the fly method.

Open-Closed and SRP are closely coupled.
If we resolve open-closed problem SRP is automatically resolved.

In case of bird class, Eagle and Sparrow will have same set of attributes but behavior may differ depending on its type or beak type.
We will make bird an abstract class.

------------------------------

### Liskov Substitution Principle

Some alternatives to when child cannot implement parent's method - ex. penguin does not fly but is a bird
- Return null
- Throw an error

Substitution - replacing instead of having child class as parameter with parent class. Make sure we do not make exceptions or add handlings in the code.  