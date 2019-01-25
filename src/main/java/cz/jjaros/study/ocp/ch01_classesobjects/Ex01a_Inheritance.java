package cz.jjaros.study.ocp.ch01_classesobjects;

import cz.jjaros.study.helper.Console;

class Parent {
}
class Child extends Parent {
}

interface Interface {
    void method();
}
class Implementation implements Interface {
    public void method() {
    }
}

public class Ex01a_Inheritance {

    public static void main(String[] args) {
        parentChild();
        Console.lineDelimiter();
        classInterface();
    }

    private static void parentChild() {
        // ok
        Parent parentParent = new Parent();
        // ok - Child bude mit vzdy spolecne vlasnosti s Parent
        Parent parentChild = new Child();
        // ok
        Child childChild = new Child();

        // NE:
        // objekt Parent nemusi mit vsechny vlastnosti tridy Child
        // proto to takto nelze vyuzit
//        Child childParent = new Parent(); // compilation error

        System.out.println("parentParent = " + parentParent); // cz.jjaros.study.ocp.ch01_classesobjects.Parent@511d50c0
        System.out.println("parentChild = " + parentChild); // cz.jjaros.study.ocp.ch01_classesobjects.Child@60e53b93
        System.out.println("childChild = " + childChild); // cz.jjaros.study.ocp.ch01_classesobjects.Child@5e2de80c
    }

    private static void classInterface() {
        // ok
        Interface intImpl = new Implementation();
        // ok - ale je potreba implementovat abstraktni metody interface

        Interface intInt = new Interface() {
            @Override
            public void method() {

            }
        };
//        Interface intInt = () -> {}; // slo by i takto jako lambda

        // ok
        Implementation implImpl = new Implementation();

        // NE:
        // Implementation muze obsahovat vlasnosti, ktere neimplementuje instance vytvorena pomoci new Interface(){};
//        Implementation implInt = new Interface() { // compilation error
//            @Override
//            public void method() {
//            }
//        };

        System.out.println("intImpl = " + intImpl); // cz.jjaros.study.ocp.ch01_classesobjects.Implementation@1d44bcfa
        System.out.println("intInt = " + intInt); // cz.jjaros.study.ocp.ch01_classesobjects.Ex01a_Inheritance$1@266474c2
        System.out.println("implImpl = " + implImpl); // cz.jjaros.study.ocp.ch01_classesobjects.Implementation@6f94fa3e
    }
}
