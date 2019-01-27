package cz.jjaros.study.ocp.ch04_streams;

import cz.jjaros.study.helper.Console;

import java.math.BigDecimal;
import java.util.stream.Stream;

public class Ex04d_Reduce {

    public static void main(String[] args) {
        // Performs a reduction on the elements of this stream,
        // using the provided identity value and an associative accumulation function,
        // and returns the reduced value.

        int totalSum = Stream.of(1, 2, 3, 4, 5)
                // 0 (prvni argument reduce()) -> pocatecni hodnota
                // sum -> prubezny vysledek
                // actual -> aktualni zaznam
                .reduce(0, (sum, actual) -> {
                    System.out.println("sum = " + sum);
                    System.out.println("actual = " + actual);
                    return sum + actual;
                });
        System.out.println("totalSum = " + totalSum); // 15

        Console.lineDelimiter();

        int count = Stream.of(1, 2, 3, 4, 5)
                .reduce(0, (a, b) -> ++a);
        System.out.println("count = " + count); // 5

        Console.lineDelimiter();

        // muze se hodit napr. pro soucet/min/max... nekolika BigDecimalu:
        BigDecimal bigDecimalSum = Stream.of(BigDecimal.ONE, new BigDecimal("5.0"), BigDecimal.TEN)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("bigDecimalSum = " + bigDecimalSum); // 16.0
    }

}
