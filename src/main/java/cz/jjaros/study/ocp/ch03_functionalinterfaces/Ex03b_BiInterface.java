package cz.jjaros.study.ocp.ch03_functionalinterfaces;

import cz.jjaros.study.helper.Console;

import java.math.BigDecimal;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

class MyObject {

}

public class Ex03b_BiInterface {

    public static void main(String[] args) {
        biFunction();
        Console.lineDelimiter();

        biConsumer();
        Console.lineDelimiter();

        biPredicate();
    }

    private static void biFunction() {
        BiFunction<String, String, BigDecimal> biFunction = (string1, string2) -> new BigDecimal(string1).add(new BigDecimal(string2));
        BiFunction<BigDecimal, BigDecimal, BigDecimal> sumLambda = (bd1, bd2) -> bd1.add(bd2);
        BiFunction<BigDecimal, BigDecimal, BigDecimal> sumMethodRef = BigDecimal::add;
        System.out.println("biFunction.apply(\"1.0\", \"2.0\") = " + biFunction.apply("1.0", "2.0")); // 3.0
        System.out.println("sumLambda.apply(BigDecimal.ONE, BigDecimal.TEN) = " + sumLambda.apply(BigDecimal.ONE, BigDecimal.TEN)); // 11
        System.out.println("sumMethodRef.apply(BigDecimal.ONE, BigDecimal.TEN) = " + sumMethodRef.apply(BigDecimal.ONE, BigDecimal.TEN)); // 11
    }

    private static void biConsumer() {
        BiConsumer<String, String> biConsumer = (string1, string2) -> {
            System.out.println("biComsumer: " + string1 + ", " + string2);
            System.out.println("consumed...");
        };
        // biComsumer: biConsumer, accept()
        // consumed...
        biConsumer.accept("biConsumer", "accept()");

        StringBuilder sb = new StringBuilder();
        BiConsumer<StringBuilder, String> appendLambda = (stringBuilder, string) -> stringBuilder.append(string);
        appendLambda.accept(sb, "lambda");
        System.out.println("sb after appendLambda: " + sb); // lambda
        BiConsumer<StringBuilder, String> appendMethodRef = StringBuilder::append;
        appendMethodRef.accept(sb, "_methodRef");
        System.out.println("sb after appendMethodRef: " + sb); // lambda_methodRef
    }

    private static void biPredicate() {
        BiPredicate<Object, MyObject> equalsLambda = (object, myObject) -> object.equals(myObject);
        BiPredicate<Object, MyObject> equalsMethodRef = Object::equals;
        System.out.println("equalsLambda.test(new Object(), new MyObject()) = " + equalsLambda.test(new Object(), new MyObject()));
        System.out.println("equalsMethodRef.test(new Object(), new MyObject()) = " + equalsMethodRef.test(new Object(), new MyObject()));
        System.out.println("equalsMethodRef.negate().test(new Object(), new MyObject()) = " + equalsMethodRef.negate().test(new Object(), new MyObject()));
    }
}
