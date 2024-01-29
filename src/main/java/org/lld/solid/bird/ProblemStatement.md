## CASE STUDY

### Design a BIRD
Create a class that has features associated with bird

### Steps:
1. Create class Bird
2. Attributes - name, color, weight, beak, type, size
3. Add data types to attributes:
    - name: String
    - color: ~~String (we can assign any string to it ex. Mumbai which is invalid)~~, Instead use enums (Color in our case)
    - weight: double
    - beak: Beak
    - type: Type
    - size: Size
4. create enum Color: a way to enforce member checking
    - green, blue, red
5. create enum Beak: 
    - sharp, curved, short, long
6. create enum Type:
    - Eagle, Sparrow, Dove, 
7. create enum Size:
    - small, medium, large
8. Add methods:
   - fly()
   - eat()
   - sleep()
```
Enum helps to document the potential values - we don't have to look at the data but just look at the enum for possible values
```

---------------------------
### Why are attributes private?
So that no one can access directly. We can have more control over it if we use setter and getter methods
Very difficult to put validations everytime someone is accessing the attribute.
----------------------------

### Will all the birds have same behavior?
Maybe sleep and eat behavior could be same but fly could be different for different birds.
Some flap wings, some glide, some don't fly.

We use type to decide how a bird will fly

------------------------------

### Problems with this version:
1. It is not readable (if-else ladder)
2. Not easy to test - if we want to test a single type of bird flying. The code is tightly coupled.
3. Merge conflicts - working on code simultaneously is not possible, high chances of conflicts
4. Not reusable - since to make eagle fly we need to import full fly method along with other type of birds.

We have too many thing in our fly method.

---------------------------------

### When to use abstract class and when to use interface?
If they only have common behavior then we will use interface. If they have common attributes plus behavior then use abstract class.