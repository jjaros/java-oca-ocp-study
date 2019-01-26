package cz.jjaros.study.ocp.ch02_generics;

import cz.jjaros.study.helper.Console;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

interface Interface {
}

class Parent implements Interface {
}

class Child extends Parent {
}

public class Ex02b_GenericCollection {

    {
        // problem:
        // Incompatible types
//        List<Parent> listA = new ArrayList<Child>(); // compilation error

        // reseni:
        List<? extends Parent> listA = new ArrayList<Parent>();
        List<? extends Parent> listB = new ArrayList<Child>();
    }

    // !!!
    // T extends X      -> X muze byt interface nebo trida
    // T extends X & Y  -> X muze byt interface nebo trida, Y MUSI byt interface
    private <T extends Number> T extendsClass() { return null; }
    private <T extends Number & Serializable> T extendsClassAndInterface() { return null; }
    private <T extends Serializable> T extendsInterface() { return null; }
    // NE: viz pocatecni komentar...
//    private <T extends Serializable & Number> T extendsInterfaceAndClass() { return null; }
//    private <T extends Number & Integer> T extendsClassAndClass() { return null; }

    // rozdil mezi <? super T> a <? extends T>
    // http://stackoverflow.com/questions/4343202/difference-between-super-t-and-extends-t-in-java
    public static void main(String[] args) {

        parentChildList();
        Console.lineDelimiter();

        // <?>
        // da se priradit kolekce cehokoliv
        // vraci se Object
        // add() -> vzdy compilation error
        genericExtendsObject();
        Console.lineDelimiter();

        // <? extends T>
        // muze obsahovat itemy typu: T + subclasses
        // vraci se T
        // add() -> vzdy compilation error
        genericWithExtends();
        Console.lineDelimiter();

        // <? super T>
        // da se vlozit: T + subclasses
        // vraci se Object
        // add() -> lze pouzit
        genericWithSuper();
    }

    private static void genericExtendsObject() {
        // zkraceny zapis List<? extends Object>
        List<?> extendsObject = Arrays.asList(1, "1", 1.0);
//        extendsObject.add(new Object()); // mismatch type -> compilation error
//        extendsObject.add("1"); // mismatch type -> compilation error
        Object firstObject = extendsObject.get(0);
        // Integer
        System.out.println("firstObject.getClass().getSimpleName() = " + firstObject.getClass().getSimpleName());
        // Integer, String, Double
        Console.printItemsClassNames(extendsObject);
    }

    private static void parentChildList() {
        List<Parent> list = new ArrayList<>();
        list.add(new Parent());
        list.add(new Child());

        // Parent, Child
        Console.printItemsClassNames(list);
    }

    /**
     * "Producer Extends"
     * <br><br>
     * If you need a List to produce T values (you want to read Ts from the list),
     * you need to declare it with ? extends T, e.g. List<? extends Integer>.
     * But you cannot add to this list.
     */
    private static void genericWithExtends() {
        // takto vytvoreny list je immutable (samozrejme pokud list itemy jsou immutable),
        // protoze do neho pak nejde nic vlozit (viz niz)
        // je jedno, jeslti tady bude konstruktor s <>, <Parent> nebo <Child>
        List<? extends Parent> immutableClassList = new ArrayList<>();
        immutableClassList.add(null); // zafunguje, ale nedava smysl
        immutableClassList = Arrays.asList(new Parent(), new Child()); // priradit "hotovy" list je ok
//        immutableClassList.add(new Object()); // mismatch type -> compilation error
//        immutableClassList.add(new Parent()); // mismatch type -> compilation error
//        immutableClassList.add(new Child()); // mismatch type -> compilation error

        List<? extends Child> immutableChild = new ArrayList<>();
        immutableChild.add(null); // zafunguje, ale nedava smysl
        immutableChild = Arrays.asList(new Child());
//        immutableChild.add(new Object()); // mismatch type -> compilation error
//        immutableChild.add(new Parent()); // mismatch type -> compilation error
//        immutableChild.add(new Child()); // mismatch type -> compilation error

        // stejny problem s interface:
        List<? extends Interface> immutableInterfaceList = new ArrayList<Child>();
        immutableInterfaceList.add(null); // zafunguje, ale nedava smysl
        immutableInterfaceList = Arrays.asList(new Parent(), new Child()); // priradit "hotovy" list je ok
//        immutableInterfaceList.add(new Object()); // mismatch type -> compilation error
//        immutableInterfaceList.add(new Parent()); // mismatch type -> compilation error
//        immutableInterfaceList.add(new Child()); // mismatch type -> compilation error

        List<? extends Double> doubles = Arrays.asList(1.0, 2.0, 3.0);
        List<? extends Number> numbers = doubles;
//        Double firstNumber = numbers.get(0); // list numbers vraci jen Number objekty (compilation error)
        Number firstNumber = numbers.get(0);

        // firstNumber.getClass().getSimpleName() = Double
        System.out.println("firstNumber.getClass().getSimpleName() = " + firstNumber.getClass().getSimpleName());
        // Double, Double, Double
        Console.printItemsClassNames(doubles);
        // Double, Double, Double
        Console.printItemsClassNames(numbers);
    }

    /**
     * "Consumer Super"
     * <br><br>
     * If you need a List to consume T values (you want to write Ts into the list),
     * you need to declare it with ? super T, e.g. List<? super Integer>.
     * But there are no guarantees what type of object you may read from this list.
     */
    private static void genericWithSuper() {
        // konstruktor muze byt: <>, <Parent>, <Interface>, <Object>
        // NE: <Child> -> compilation error
        List<? super Parent> superParent = new ArrayList<>();
//        superParent.add(new Object()); // NE: compilation error
        superParent.add(new Parent());
        superParent.add(new Child());

        // konstruktor muze byt: <>, <Parent>, <Child>, <Interface>, <Object>
        List<? super Child> superChild = new ArrayList<>();
//        superChild.add(new Object()); // NE: compilation error
//        superChild.add(new Parent()); // NE: compilation error
        superChild.add(new Child());

        // konstruktor muze byt: <>, <Interface>, <Object>
        // NE: <Parent>, <Child> -> compilation error
        List<? super Interface> superInterface = new ArrayList<>();
//        superInterface.add(new Object()); // NE: compilation error
        superInterface.add(new Parent());
        superInterface.add(new Child());

        List<? super Number> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(2.0);
        Object firstInteger = numbers.get(0); // uskali pouziti <? super T>

        // firstInteger.getClass().getSimpleName() = Integer
        System.out.println("firstInteger.getClass().getSimpleName() = " + firstInteger.getClass().getSimpleName());
        // Integer, Double
        Console.printItemsClassNames(numbers);
    }

}