# 1. Classes and objects #
* some class basics is part of OCA, see:
  * [OCA, chapter 1 Classes, static classes, inner classes](../../oca/ch01_basics)
  * [OCA, chapter 10 Abstract](../../oca/ch10_abstract)
  * [OCE, chapter 11 Interfaces](../../oca/ch11_interface)
* POJO vs JavaBean: [www.geeksforgeeks.org/pojo-vs-java-beans/](https://www.geeksforgeeks.org/pojo-vs-java-beans/)
* JavaBean vs EJB: [stackoverflow.com/questions/2460048/difference-between-java-bean-and-enterprise-java-beans/](https://stackoverflow.com/a/2460071/4201399)


## Inheritance ##
* provide storing of common attributes and behavior in parent class
* child class can (depends on access privilege of attribute or method):
  * use attributes and methods from parent
  * overshadow attribute (with same name) from parent
  * expand or override methods from parent class
* it is not possible to assign instance of parent class into variable of type the child class
  * child class (used as variable reference type) may contains attributes or methods 
  which are not defined in parent class (used as variable object type)
  * similar situation is with class that implements some interfaces 

### Constructors ###
* see [OCA, chapter 5 Constructors](../../oca/ch05_constructors)
* child constructor always call (implicitly or explicitly) parent constructor first
  * explicit use `super()` or `super(param)` in case of parameterized parent constructor

### Methods ###
* override method in child class:
  * can access to first parent method implementation using `super.method();`
  * can't add other checked exception to `throws` clause
* `throws` clause of override method in child class can:
  * add unchecked exception
  * use same exception as parent method 
  * use subclass of exception used in parent method
  * hide checked exception (omit `throws` clause) 


## Immutable class ##
* see official Oracle guideline: [docs.oracle.com/javase/tutorial/essential/concurrency/imstrat](https://docs.oracle.com/javase/tutorial/essential/concurrency/imstrat.html)
* example from Java API is e.g. `java.lang.String`

### Rules of immutability ###
* make all fields final and private
* don't provide "setter" methods
* don't allow subclasses to override methods (declare the class as final or make the constructor private and construct instances in factory methods)
* if the instance fields include references to mutable objects, don't allow those objects to be changed:
  * don't provide methods that modify the mutable objects.
  * don't share references to the mutable objects
    * if necessary, create copies and return references to the copies)
  * never store references to external, mutable objects passed to the constructor 
    * if necessary, create copies, and store references to the copies) 


## Instanceof ##
* determines if object is instance of class or interface
* if the reference type of checked object is unreachable with checked class, the compilation error is caused
  * it's not relevant if reference type is interface (compilation error is not caused in this case)