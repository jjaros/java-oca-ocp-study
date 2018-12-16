package cz.jjaros.study.oca.ch01_basics;

public class Ex01c_AnonymousInnerClass {

    public static void main(String[] args) {

        // pouziti anonymni tridy
        AnonymousInnerClass anonymousInnerClass = new AnonymousInnerClass() {
            @Override
            void sayHello(String name) {
                System.out.println("Hey " + name + "! Hello from anonymous inner class.");
            }
        };
        anonymousInnerClass.sayHello("Mr.");

        // pouziti anonymni tridy jako vstup metody
        foo(new AnonymousInnerClass() {
            @Override
            void sayHello(String greet) {
                System.out.println(greet);

//                privateMember = ""; // NE: nelze pristupovat k privatnim atributum/metodam
                publicMember = "";
//                privateMethod(); // NE: nelze pristupovat k privatnim atributum/metodam
                publicMethod();
            }
        });

        // takova hezka ficurka od Java 8
        lambdaFoo((name) -> System.out.println("Greet for " + name + " from anonymous inner interface..."));
        lambdaFoo2(System.out::println);
    }

    // anonymni tridy na vstupu metody
    private static void foo(AnonymousInnerClass anonymousInnerClass) {
        anonymousInnerClass.sayHello("Hello from foo() method...");
    }

    private static void lambdaFoo(AnonymousInnerInterface anonymousInnerInterface) {
        anonymousInnerInterface.sayHello("all");
    }

    private static void lambdaFoo2(AnonymousInnerInterface anonymousInnerInterface) {
        anonymousInnerInterface.sayHello("Greet for all from anonymous inner interface (using method reference)...");
    }
}

abstract class AnonymousInnerClass {

    private String privateMember;
    public String publicMember;

    abstract void sayHello(String greet);

    private void privateMethod() {
    }

    public void publicMethod() {
    }
}

//@FunctionalInterface
interface AnonymousInnerInterface {
    void sayHello(String name);
}