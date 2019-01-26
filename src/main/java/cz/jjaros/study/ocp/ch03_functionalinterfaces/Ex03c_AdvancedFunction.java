package cz.jjaros.study.ocp.ch03_functionalinterfaces;

import cz.jjaros.study.helper.Console;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Ex03c_AdvancedFunction {

    public static void main(String[] args) {

        advancedFunction();
        Console.lineDelimiter();

        advancedConsumer();
        Console.lineDelimiter();

        advancedPredicate();
        Console.lineDelimiter();

        AtomicInteger integer = new AtomicInteger(0);
        Supplier<Integer> supplier = integer::incrementAndGet;
        System.out.println("supplier.get() = " + supplier.get()); // 1

    }

    private static void advancedFunction() {
        Function<Integer, Integer> multiply = (i) -> i * 2;
        Function<Integer, Integer> divide = (i) -> i / 2;

        // 10 * 2
        System.out.println("multiply.apply(10) = " + multiply.apply(10)); // 20
        // 10 * 2 / 2
        System.out.println("multiply.andThen(divide).apply(10) = " + multiply.andThen(divide).apply(10)); // 10
        // 10 / 2 * 2 * 2
        System.out.println("multiply.compose(divide.andThen(multiply)).apply(10) = " + multiply.compose(divide.andThen(multiply)).apply(10)); // 20
    }

    private static void advancedConsumer() {
        final AtomicInteger consumeCount = new AtomicInteger(0);
        Consumer<String> consumer = (s) -> consumeCount.incrementAndGet(); // nemeni se objekt, ale vnitrek objektu -> ok
        consumer.andThen((s) -> consumeCount.incrementAndGet())
                .andThen(consumer.andThen((s) -> consumeCount.incrementAndGet()))
                .accept("test");
        System.out.println("consumeCount = " + consumeCount); // 4
    }

    private static void advancedPredicate() {
        Predicate<Boolean> predicate = (b) -> b;
        // true && !true
        System.out.println("predicate.and(predicate.negate()).test(true) = " + predicate.and(predicate.negate()).test(true)); // false
        // !!!true || true
        System.out.println("predicate.or(predicate.negate()).test(true) = " + predicate.negate().negate().negate().or(predicate).test(true)); // true
    }
}
