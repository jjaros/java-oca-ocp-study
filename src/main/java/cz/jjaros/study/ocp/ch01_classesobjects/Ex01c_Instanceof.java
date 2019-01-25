package cz.jjaros.study.ocp.ch01_classesobjects;

import cz.jjaros.study.helper.Console;

class Animal {
}

class Cat extends Animal {
}

class Dog extends Animal implements DogBehavior{
}

interface DogBehavior {
    default void bark() {}
}

interface BirdBehavior {
    void fly();
}

public class Ex01c_Instanceof {

    public static void main(String[] args) {
        Cat cat = new Cat();
        System.out.println(cat instanceof Cat); // true
        System.out.println(cat instanceof Animal); // true
        System.out.println(cat instanceof Object); // true
        System.out.println(cat instanceof DogBehavior); // false
        System.out.println(cat instanceof BirdBehavior); // false
        // NE:
        // Inconvertible types
//        System.out.println(cat instanceof Dog); // compilation error

        Console.lineDelimiter();

        Animal dog = new Dog();
        System.out.println(dog instanceof Dog); // true
        System.out.println(dog instanceof Animal); // true
        System.out.println(dog instanceof DogBehavior); // true
        System.out.println(dog instanceof Cat); // false
        System.out.println(dog instanceof BirdBehavior); // false
    }

}
