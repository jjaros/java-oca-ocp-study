package cz.jjaros.study.ocp.ch03_functionalinterfaces;

import cz.jjaros.study.helper.Console;

import java.io.IOException;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

interface InterfaceWithException<T extends Exception> {
    void throwException() throws T;
}

public class Ex03a_FunctionalInterface {

    public static void main(String[] args) {

        function();
        Console.lineDelimiter();

        consumer();
        Console.lineDelimiter();

        predicate();
        Console.lineDelimiter();

        supplier();
        Console.lineDelimiter();

        InterfaceWithException<IOException> interfaceWithException = () -> {
            throw new IOException("InterfaceWithException#throwExeption");
        };
        try {
            interfaceWithException.throwException();
        } catch (IOException e) {
            System.out.println(e); // java.io.IOException: InterfaceWithException#throwExeption
        }
    }

    private static void function() {
        int localConstant = 2;
//        localConstant++; // toto zpusobi chybu kompilace (viz niz)

        // localConstant musi byt final nebo efectively final
        // jinak compilation error
        Function<Integer, ? extends Number> function = (integer) -> {
//            localConstant++; // compilation error (viz vys)

//            throw new Exception(); // musela by byt vzresena v ramci implementace lambdy
            return integer * localConstant;
        };

        System.out.println("function.apply(5) = " + function.apply(5)); // function.apply(5) = 10
    }

    private static void consumer() {
        Consumer<StringBuilder> consumer = (stringBuilder) -> stringBuilder.append(" -> consumed...");
        StringBuilder sb = new StringBuilder("sb");
        System.out.println("sb before:  = " + sb); // sb before:  = sb
        consumer.accept(sb);
        System.out.println("sb after:  = " + sb); // sb after:  = sb -> consumed...
    }

    private static void predicate() {
        // toto zafunguje:
        Predicate<? super Number> predicateSuper = (number) -> number instanceof Double;
        System.out.println("predicate.test(2.0) = " + predicateSuper.test(2.0)); // predicate.test(2.0) = true
        System.out.println("predicate.test(2) = " + predicateSuper.test(2)); // predicate.test(2) = false
        // NE:
        // compilation error
        Predicate<? extends Number> predicateExtends = (number) -> number instanceof Double;
//        System.out.println("predicate.test(2.0) = " + predicateSuper.test(2.0));
    }

    private static void supplier() {
        Supplier<StringBuilder> supplier = StringBuilder::new;
        System.out.println("supplier.get() = " + supplier.get()); // supplier.get() =
        System.out.println("supplier.get().append(\"string builder\") = " + supplier.get().append("string builder")); // supplier.get().append("string builder") = string builder
    }
}
