# 8. Variables #
* see [docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html)

## Primitive data types ##
* in case of usage non-initialized variable of primitive data type is compilation error occurred

| Data Type | Default Value (for fields) | Literal Suffix |
| ------------- | ------------- | ----- |
| `byte` | 0 |  |
| `short` | 0 |  |
| `int` | 0 |  |
| `long` | 0L | L or l |
| `float` | 0.0f | F or f |
| `double` | 0.0d | D or d, E or e |
| `char` | '\u0000' |  |
| `String` (or any `Object`) | null |  |
| `boolean` | false |  |

## Literals ##
### Integers ###
* literals **L** (recommended due to readability) or **l**
* default type is `int` (if is not explicitly mentioned)
* examples of usage some numerical systems:
  * **decimal (default):** 123456789
  * **hexadecimal:** prefix `0x` + hexadecimal number (allowed numbers are `[0-9A-Fa-f]`)
  * **binary (since Java 7):** prefix `0b` + binary number (allowed numbers are `[01]`)

### Real numbers ###
* literals **F**, **f** or optionally **D** or **d**
* beware, after overlay will be e.g. _100000000000000000.0F_
* equivalent to _x10<sup>n</sup>_ is literal **E** or **e**
  * only for `double`

### Character and String ###
* "unicode escape" -> `\u00eD`
* special sequences and characters:
  * **backspace:** `\b`
  * **tabulator:** `\t`
  * **new line:** `\n`
  * **form feed:** `\f`
  * **carriage return:** `\r`
  * **quotes:** `\“`
  * **single quotes:** `\‘`
  * **backslash:** `\\`

### Specialities ###
* since Java 7 exists numeric separator `_`
  * can't be at the start or end of number -> _compilation error_
  * can't be before or after decimal point -> _compilation error_
  * count is unlimited (if is in the middle of number)
  * compilator removes this separator characters (purpose is only readability)
* `null` - null value representation
  * it is possible to assign to all variables that are not of primitive data type
* `.class`
  * `java.class.Class`
  * reference to object type

## Numeric variables ##
* object types for integer numbers uses internal cache for "mostly" used values
  * default is **[-128, 127]**
  * upper limit can be changed with JVM parameter `java.lang.Integer.IntegerCache.high`

### Autoboxing and unboxing ###
* automatic conversion of data types (primitive <-> object)
* see [docs.oracle.com/javase/tutorial/java/data/autoboxing](https://docs.oracle.com/javase/tutorial/java/data/autoboxing.html)

| Primitive type | Wrapper class |
| -------------- | ------------- |
| `boolean` | `Boolean` |
| `byte` | `Byte` |
| `char` | `Character` |
| `float` | `Float` |
| `int` | `Integer` |
| `long` | `Long` |
| `short` | `Short` |
| `double` | `Double` |

## String ##
* if the `String` constructor isn't used object is stored in stack as follows:
  * new object is created if the equal doesn't exist
  * if equal object doesn't exist new one is created
* usage of `new String()` **constructor always creates new object to heap**
  * `String#intern()` - explicit swap String object from heap to stack (optimization as above works too) 

### String concatenation ###
* the worse case is usage String concatenation with `+=`
* choices of concatenation:
  * **plus:** the worse performance because after each `+` is new object in stack created
  * `StringBuilder`: the fastest choice but isn't thread safe
  * `StringBuffer`: is thread safe (is synchronized) and slower then `StringBuilder`

## Array ##
<span style='color:red'>**...TBD...**</span>

## Enum ##
* `enum` in Java is actually implementation of class `public abstract class Enum<E extends Enum<E>>`
* is singleton
* can have attributes and methods
* corresponding constructor must exist in case of attributes are used in enum

## Others ##
### Operators ###
* see [docs.oracle.com/javase/tutorial/java/nutsandbolts/operators](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/operators.html)

### Switch ###
* as condition can e used:
  * `int`/`Integer` or lower type
  * `enum`
  * `String`