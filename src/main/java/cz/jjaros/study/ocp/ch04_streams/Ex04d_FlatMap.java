package cz.jjaros.study.ocp.ch04_streams;

import cz.jjaros.study.helper.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex04d_FlatMap {

    public static void main(String[] args) {

        // bude vypisovat listy;
        // [0][0, 1][0, 1, 2]
        Stream.of(1, 2, 3)
                .map(mapper)
                .forEach(System.out::print);

        System.out.println();
        Console.lineDelimiter();

        // provede transformaci (diky flatMap()) a bude vypisovat hodnoty ze vsech listu
        // 001012
        Stream.of(1, 2, 3)
                .map(mapper)
                .flatMap(List::stream)// provede transformaci z Strem<List<String>> na Stream<String>
                .forEach(System.out::print);

        System.out.println();
        Console.lineDelimiter();

        Stream.concat(Stream.of(1, 2, 3), Stream.of("2", "3", "4"))
                .distinct() // nevylouci duplicity, protoze napr. "2".equals(2) -> false
                .forEach(System.out::print); // 123234
        System.out.println();
        Stream.of(Stream.of(1, 2, 3), Stream.of("2", "3", "4"))
                .flatMap(e -> e.map(String::valueOf))
                .distinct() // diky predeslemu mapovani se tu budou porovnavat vzdy stringy => duplicity se vylouci
                .forEach(System.out::print); // 1234
    }

    // pomocna funkce pro mapovani hodnot na list
    private static Function<Integer, List<String>> mapper = i -> {
        ArrayList<String> result = new ArrayList<>();
        for (int j = 0; j < i; j++) {
            result.add(String.valueOf(j));
        }
        return result;
    };

}
