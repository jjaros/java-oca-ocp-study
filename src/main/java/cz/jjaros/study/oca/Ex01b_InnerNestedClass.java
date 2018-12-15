package cz.jjaros.study.oca;

import java.io.Serializable;

public class Ex01b_InnerNestedClass {

    private String outerMember;
    public String publicOuterMember;

    private void outerFoo() {
    }

    private void publicOuterFoo() {
    }

    class InnerClass extends AbstractHelperClass implements Serializable {
        public void foo() {
            // vnitrni trida MUZE pristupovat k atributum/metodam vnejsi tridy
            outerMember = "foo() from InnerClass";
            publicOuterMember = "foo() from InnerClass";

            outerFoo();
            publicOuterFoo();
        }
    }

    static class NestedStaticClass extends AbstractHelperClass implements Serializable {
        public void foo() {
            // NE: staticka vnorena trida NEMUZE pristupovat k instancnim atributum/metodam vnejsi tridy
//            outerMember = "foo() from InnerClass";
//            publicOuterMember = "foo() from InnerClass";
//            outerFoo();
//            publicOuterFoo();
        }
    }

    public static void main(String[] args) {

        // NE: k vytvoreni instance InnerClass musi dojit pres instanci hlavni tridy Ex01b_InnerNestedClass
//        InnerClass innerClass = new InnerClass();
        InnerClass innerClass = new Ex01b_InnerNestedClass().new InnerClass();

        // staticka vnorena trida muze byt instancovana bez existujici instance vnejsi tridy
        NestedStaticClass nestedStaticClass1 = new Ex01b_InnerNestedClass.NestedStaticClass();
        NestedStaticClass nestedStaticClass2 = new NestedStaticClass();
    }
}

abstract class AbstractHelperClass {
    abstract void foo();
}