## Factory Design Pattern

The factory pattern is a creational design pattern that can be used to create objects without specifying the exact class of the object that will be created. The pattern is used to avoid dependencies on the class of the object that needs to be created.

the factory method pattern is reational pattern that uses factory methods to deal with the problem of creating objects without having to specify the exact class of the object that will be created.
This id sone by creating objects bycaling a factory method--either specified in an interface and implemented by child classes, or implemented in a base class and optionally overridden by derived classes--rather than by calling a constructor.
### Simple factory
Why Factory Pattern? What was the motivation
* SRP and OCP - factory will be client code
* If-else ladder is not required at all the places to create the button. We have common implementation
* Reduce the usage of subclass - if in future we are changing the name of Round button then this will not impact the client code a lot

What are downside of simple factory pattern?
* Parameter - Factory is required to have all teh parameters (How to use builder pattern here)
* SRP + OCP is still violated in the lib/ factory class code

### Factory method
We will break the factory class in hierarchy.

```plantuml
  

class ButtonFactory {
<<interface>>
}

class RoundButtonFactory{}
class SquareButtonFactory{}

RoundButtonFactory .> ButtonFactory : implements
SquareButtonFactory .> ButtonFactory : implements
```

* RoundButtonFactory will be responsible to create RoundButton
* SquareButtonFactory will be responsible to create SquareButton

What is downside of the factory method?
* class explosion - if we have too many concrete products we will have separate factory for each

### Abstract Factory
Factory of factories.

It allows us to create a family of product ie. Product of 1 family cannot be created with another family
ex. Dark theme factory will create dark button. dark radio and dark select button.
Similar for light theme factory which will create set of light theme products.

* Create common product interfaces = Button, radio etc
* Create concrete product classes
* Create Factory interface - componentFactory (createButton, createRadio)
* Create concrete Factories - darkThemeFactory, lightThemeFactory

