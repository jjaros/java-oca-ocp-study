package cz.jjaros.study.ocp.ch04_streams;

import cz.jjaros.study.helper.Console;

import java.util.stream.Stream;

public class Ex04c_StatefulIntermediate {

    public static void main(String[] args) {
        // peek#1: 1
        // peek#1: 2
        // peek#1: 3
        // peek#1: 0
        // peek#1: 1
        // peek#1: 2
        // peek#2: 0
        // terminal: 0
        // peek#2: 1
        // terminal: 1
        // peek#2: 1
        // terminal: 1
        // peek#2: 2
        // terminal: 2
        // peek#2: 2
        // terminal: 2
        // peek#2: 3
        // terminal: 3
        Stream.of(1, 2, 3, 40, 50, 60, 100, 0, 1, 2)
                .filter(i -> i < 10)
                .peek(i -> System.out.println("peek#1: " + i))
                .sorted() // stateful intermediate operace
                .peek(i -> System.out.println("peek#2: " + i))
                .forEach(i -> System.out.println("terminal: " + i));

        Console.lineDelimiter();

        // peek#1: 1
        // peek#2: 1
        // terminal: 1
        // peek#1: 2
        // peek#2: 2
        // terminal: 2
        // peek#1: 3
        // peek#2: 3
        // terminal: 3
        // peek#1: 0
        // peek#2: 0
        // terminal: 0
        // peek#1: 1
        // peek#1: 2
        Stream.of(1, 2, 3, 40, 50, 60, 100, 0, 1, 2)
                .filter(i -> i < 10)
                .peek(i -> System.out.println("peek#1: " + i))
                .distinct() // stateful intermediate operace
                .peek(i -> System.out.println("peek#2: " + i))
                .forEach(i -> System.out.println("terminal: " + i));
    }

}
