# OCA&OCP Java SE 8 Study materials #
This project contains summarized notes and Java classes for studying the Oracle certification - **OCA and OCP Java SE 8**. 

**_Note:_** The materials are not 100% exhaustive and should not be used as main study materials 
but it can be good start point or support for your studying.
Great preparation is e.g. question bank from the [Enthuware](http://enthuware.com/java-certification-mock-exams/oracle-certified-professional/java-se-8-1z0-809).

## Introduction ##
The main points in project structure are:
* [`doc`](doc) directory - notes for each chapter summarized to one document
* [`src/main/java/cz/jjaros/study/oca`](src/main/java/cz/jjaros/study/oca) - examples for [Oracle Certified Associate](https://education.oracle.com/oracle-certified-associate-java-se-8-programmer/trackp_333)
* [`src/main/java/cz/jjaros/study/ocp`](src/main/java/cz/jjaros/study/ocp) - examples for [Oracle Certified Professional](https://education.oracle.com/oracle-certified-professional-java-se-8-programmer/trackp_357)
* [`src/main/java/cz/jjaros/study/helper`](src/main/java/cz/jjaros/study/helper) - helper classes for examples

Examples are structured to chapters. Each chapter is stored in separate package. 
Each package contains **README.md** file with notes of concrete chapter. 
It provides easy way how to show notes here on GitHub. 
If you want to get all notes at one place, you can read [`java_oca_ocp_notes.odt`](doc/java_oca_ocp_notes.odt). 

Java classes with examples contains a lot of comments. 
Is it good to use examples in Java classes with notes at GitHub or notes in [`java_oca_ocp_notes.odt`](doc/java_oca_ocp_notes.odt) together.

Each Java class with examples contain `main` method. Examples provides a lot of text printed to standard output. 
You can easy verify the behavior of code. 

### Prerequisites ###
You should have Oracle Java 8 SDK installed.

### Clone repository ###
```
git clone https://github.com/jjaros/lombok-example.git
```

## OCA chapters ##
1. [Basics](src/main/java/cz/jjaros/study/oca/ch01_basics) - Classes, Static classes, Inner classes, Anonymous classes
2. [Varargs](src/main/java/cz/jjaros/study/oca/ch02_varargs)
3. [Init blocks](src/main/java/cz/jjaros/study/oca/ch03_initblocks)
4. [Packages](src/main/java/cz/jjaros/study/oca/ch04_packages) - Packages and imports
5. [Constructors](src/main/java/cz/jjaros/study/oca/ch05_constructors)
6. [Labels](src/main/java/cz/jjaros/study/oca/ch06_labels)
7. [Comparators](src/main/java/cz/jjaros/study/oca/ch07_comparators)
8. [Variables](src/main/java/cz/jjaros/study/oca/ch08_variables) - Numeric, String or Arrays variables, Enums and operators
9. [DateTime API](src/main/java/cz/jjaros/study/oca/ch09_datetime) - Java 8 DateTime API
10. [Abstract](src/main/java/cz/jjaros/study/oca/ch10_abstract) - Abstract classes and methods
11. [Interface](src/main/java/cz/jjaros/study/oca/ch11_interface)
12. [Lambda expressions](src/main/java/cz/jjaros/study/oca/ch12_lambda) - Basics of Lambda expressions (_for more info see chapter about Lambdas and Streams in OCP_)
13. [Exceptions](src/main/java/cz/jjaros/study/oca/ch13_exception)

## OCP chapters ##
**...TBD...**
