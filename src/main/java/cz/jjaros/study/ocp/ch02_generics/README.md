# 2. Generics and Collections #
* it is possible to define common data type for which is specific type selected 
at the point of use of class/method/interface
* it is possible to enforce that the used specific data type must be type of 
required class or implements required interface
  * `<T extends Number>` -> `T` must be `Number` or child
  * `<T extends Serializable>` -> `T` must implement `Serializable`
  * `<T>` -> equivalent to `<T extends Object>`
* it can be defined more parents: `<T extends Number & Serializable>`
  * as first (between `extends` and `&`) can be class or interface
  * another (after the `&`) MUST be interface

***Note:*** Similar usage is for collections. 
In these cases the `?` is used instead of `T` (see below or examples in java class).


## Generics for class, method and interface ##
* it allows to define common data for class, method or interface
* specific type selected at the point of use of class/method/interface
* generics for static fields is not allowed (it causes compilation error)

### Generics for class ###
* the common data type is defined at the class level
* it can be used for:
  * any instance field
  * any instance method as input argument type
  * any instance method as return type
  * any local variable in non-static context

### Generics for method  ###
* the common data type is defined at the method level (applies to classes and interfaces)
* it is allowed for instance even static methods
* it can be used for:
  * this method as input argument type
  * this method as return type
  * local variable in this method
  
### Generics for interface ###
* common data type is defined at interface level 
and specific data type is selected at the point of interface implementation
* the common data type can be used for:
  * abstract methods as input argument, return type and type of local variable
  * default methods as input argument, return type and type of local variable


## Generics for Collections ##
* **beware** to type compatibility of reference and object type 
(e.g. is not possible to have `List<Parent> list = new ArrayList<Child>()`)
* solution is: `List<? extends Parent> list = new ArrayList<Child>()`
* as generics for collection is possible to use: `<?>`, `<? extends X>` or `<? super X>`
* for differences between `super` and `extends` see: 
[stackoverflow.com/questions/4343202/difference-between-super-t-and-extends-t-in-java](http://stackoverflow.com/questions/4343202/difference-between-super-t-and-extends-t-in-java)

### Collection with `<?>` ###
* equivalent to `<? extends Object>`
* to `Collection<?>` is allowed to assign collection of `Object` (any object)
* `add()` operation causes **compilation error**
* `get()` operation returns always object of reference type `Object`

### Collection with `<? extends X>` ###
* `Collection<? extends X>` should contains objects of type `X` (that is `X` or child class)
* `add()` operation causes **compilation error**
* `get()` operation returns always object of reference type `X`

### Collection with `<? super X>` ###
* to `Collection<? super X>` is allowed to add objects of type `X` (that is `X` or child class)
* `add()` causes no error if the point above is passed
* `get()` operation returns always object of reference type `Object`