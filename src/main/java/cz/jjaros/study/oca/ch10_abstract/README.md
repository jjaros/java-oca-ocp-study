# 10. Abstract #

## Abstract method ##
* parent (abstract) class contains only method definition
* each child branch must implement all abstract methods from abstract parent
* specific implementation in child class must not add the propagation of checked exception (no problem with unchecked exception)
* on the contrary, is it possible to hide checked exception in here

## Abstract class ##
* is the class with `abstract` modifier
* when trying to create instance of abstract class the compilation error will occur
* if at least one abstract method is contained in class the class must be abstract too
* on the contrary, the abstract class may have no abstract method