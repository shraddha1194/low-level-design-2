### What is good software?
- Maintainable - easy to debug, test and understand
- Extensible - Make minimal changes to add a feature
- Scalable - It should be performant able to handle too many users

### Design Principles
Are a set of rules (ex. use Runnable to create thread instead of Thread class)
Set of guidelines to create good software

### SOLID Principles
Help us to create more Object-Oriented Systems. Are set of 5 design principles.
- S: Single Responsibility Principle (SRP)
- O: Open and Close Principle
- L: Liskov Substitution 
- I: Interface segregation principle
- D: Dependency Inversion

### CUPID & GRASP
https://www.boldare.com/blog/solid-cupid-grasp-principles-object-oriented-design/#what-is-solid-and-why-is-it-more-than-just-an-acronym?-solid-vs.-cupid---is-the-new-always-better

### What is difference between principles and design patterns?
Principles don't solve specific patterns (generic guidelines)
Design patterns are solutions to more specific cases.

### Always code to the interface or to the parent class
1. Eagle eagle = new Eagle("eagle");
2. Bird eagle = new Eagle("eagle");

Eagle class can have specific behavior
with 1. we can access but with 2. we cannot

#### Subtyping polymorphism - we can represent child classes as parent 
Eagle, Sparrow, Parrot
and we want to fly all of them 

Method:
fly(Eagle e, Sparrow s, Parrot p) - what if we want to fly any other bird

fly(Bird b) - if later any new bird needs to fly we don't need to modify

Drawback - We cannot access child specific attributes

Workaround - We can typecast the parent object to child object and use if-else cases

class explosion - too many classes created in hierarchy to help/maintain with behavior. Instead, use interface.



