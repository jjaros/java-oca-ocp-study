package cz.jjaros.study.ocp.ch04_streams;

import cz.jjaros.study.helper.Console;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Ex04b_InfiniteStream {

    public static void main(String[] args) {
        // ukonceni nekonecneho streamu:
        //      1. osklive vyjimkou
        //      1. chytre -> allMatch, anyMatch, ...

        // Stream#generate
        AtomicInteger iter = new AtomicInteger(0);
        Stream.generate(iter::incrementAndGet)
                .peek(System.out::print)
                .allMatch(i -> i < 9);

        System.out.println();

        iter.set(0);
        Stream.generate(iter::incrementAndGet)
                .peek(System.out::print)
                .anyMatch(i -> i > 8);

        System.out.println();

        iter.set(0);
        Stream.generate(iter::incrementAndGet)
                .peek(System.out::print)
                .noneMatch(i -> i == 9);
        // end: Stream#generate

        System.out.println();
        Console.lineDelimiter();

        // Stream#iterate
        Stream.iterate(1, i -> ++i) // kdyby tady bylo i++, vypisovaly by se jenom nuly
                .limit(9)
                .forEach(System.out::print);
        // end: Stream#iterate
    }

}
