package cz.jjaros.study.oca;

interface InterfaceA {
    public static final int INT_CONSTANT = 0; // 'public static final' is redundant in interface

    public abstract void noProblem(); // 'public abstract' is redundant in interface

    public static void staticMethod() { // 'public' is redundant in interface
//        defaultMethod(); // NE: non-static method cannot be referenced from static context
    }

    public default void defaultMethod() { // 'public' is redundant in interface
        staticMethod();
    }

    default void getProblem() {
        System.out.println("problem from InterfaceA...");
    }
}

interface InterfaceB {
    void noProblem();

    default void getProblem() {
        System.out.println("problem from InterfaceB...");
    }
}

public class Ex11_Interface implements InterfaceA, InterfaceB {

    @Override
    public void noProblem() {
        // no probllem...metoda je preci abstraktni a implementuje se az tady
    }

    // neni jasne, z ktereho interface se ma metoda zavolat
    // reseni: override metody zde a volani metody primo z interface, viz niz
    @Override
    public void getProblem() {
        InterfaceA.super.getProblem();
        InterfaceB.super.getProblem();
        System.out.println("problem solved in Ex11_Interface#getProblem...");
    }

    public static void main(String[] args) {
        new Ex11_Interface().getProblem();
        // vysledek:
        // problem from InterfaceA...
        // problem from InterfaceB...
        // problem solved in Ex11_Interface#getProblem...
    }
}
