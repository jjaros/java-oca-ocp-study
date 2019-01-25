# 11. Interfaces #
* redundant modifiers for constants in interface:
  * `public`
  * `static`
  * `final`
* redundant modifiers for methods in interface:
  * `public`
  * `final`
  * `abstract`
* default and static methods can't be `final` - occurs compilation error in other case
* in interface can be defined:
  * constant fields
  * abstract methods
  * static methods
  * default methods (since Java 8)

## Default methods ##
* since Java 8
* it provides problem with "inherits unrelated defaults"
  * **solution:** override method in class that implement interface 
  and explicitly call required method from interface - `MyInterface.super.myDefaultMethod()`

## Functional interface ##
* is interface that **has exactly one abstract method**
* it provides secure usage in lambda expressions
* should be annotated with `@FunctionalInterface` (it has informational purpose only)