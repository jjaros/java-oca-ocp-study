package cz.jjaros.study.ocp.ch04_streams;

import cz.jjaros.study.helper.Console;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Ex04a_StreamBasics {

    public static void main(String[] args) {
        iteratorVsStream();
        Console.lineDelimiter();

        lazyStream();
        Console.lineDelimiter();

        streamCreation();
        Console.lineDelimiter();

        others();
        // Terminal operation:
        //  reduce()
        //  min()
        //  max()
        //  count()
        //  forEach()
        //  forEachOrdered()
        //  collect()
        //  toArray()
        //  iterator()
        //  spliterator()
        // Short-circuiting terminal operation:
        //  findFirst()
        //  findAny()
        //  noneMatch()
        //  anyMatch()
        //  allMatch()


        // Intermediate operation:
        //  peek
        //  filter
        //  map
        //  flatMap
        //  parallel
        //  sequential
        //  onClose
        //  unordered
        // Stateful intermediate operation:
        //  sorted
        //  distinct
        // Short-circuiting stateful intermediate operation:
        //  limit
        //  skip
    }

    private static void streamCreation() {
        // vse krome Stream#empty vypise 1 a 2

        System.out.println("Stream.empty() = " + Stream.empty().map(Object::toString).collect(Collectors.joining(", ")));
        System.out.println("Stream.of(1, 2) = " + Stream.of(1, 2).map(Object::toString).collect(Collectors.joining(", ")));
        System.out.println("Stream.concat(Stream.of(1), Stream.of(2)) = " + Stream.concat(Stream.of(1), Stream.of(2)).map(Object::toString).collect(Collectors.joining(", ")));

        // builder:
        // NE:
        // protoze: void accept()
//        Stream.builder().add(1).accept(2).map(Object::toString).collect(Collectors.joining(", "));
        System.out.println("Stream.builder().add(1).add(2).build() = " + Stream.builder().add(1).add(2).build().map(Object::toString).collect(Collectors.joining(", ")));
        // end: builder

        // infinite Streams
        System.out.println("Stream.iterate(0, (Integer n) -> n++).limit(2) = " + Stream.iterate(1, (Integer n) -> ++n).limit(2).map(Objects::toString).collect(Collectors.joining(", ")));

        System.out.println("Stream#generate:");
        AtomicInteger iter = new AtomicInteger(0);
        Stream.generate(iter::incrementAndGet).peek(System.out::println).anyMatch(i -> i == 2);
        System.out.println("end: Stream#generate");
        // end: infinite Streams
    }

    private static void others() {
        // try with resources
        try (Stream<Integer> integerStream = Stream.of(1, 1, 1, 1)) {
            // NE: unhandled IOException
//        try (Stream<Path> integerStream = Files.list(Paths.get("dir"))) {

        }

        // toString problem:
        Stream.of(1, 2, 3, 4, 5)
                // NE:
                // No compile-time declaration for the method reference is found.
                // protoze to muze byt:
                //      new Integer(x).toString();
                // nebo
                //      Integer.toString(x);
//                .map(Integer::toString)
                // reseni:
                .map(Object::toString)
                // nebo
                .map(Objects::toString)
                // nebo
                .map(String::valueOf)
                .forEach(System.out::println);

        // Int/Long/DoubleStream to Stream
        Stream<Integer> boxed = IntStream.of(1, 2, 3, 4, 5)
                .boxed();
    }

    private static void iteratorVsStream() {
        List<String> collection = Arrays.asList("a", "b", "c", "d");

        Stream<String> stream = collection.stream();
        stream.forEach(System.out::println);
        try {
            // stream uz jednou probehl
            stream.forEach(System.out::println);
        } catch (IllegalStateException e) {
            // java.lang.IllegalStateException: stream has already been operated upon or closed
            System.out.println(e);
        }


        Iterator<String> iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        try {
            iterator.next(); // iterator uz je na konci
        } catch (NoSuchElementException e) {
            // java.util.NoSuchElementException
            System.out.println(e);
        }
    }

    private static void lazyStream() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        AtomicInteger count = new AtomicInteger(0);

        // stream se provede pouze pokud vola terminalni operaci
        integers.stream().peek(i -> count.incrementAndGet()); // nevola se zde terminal operace
        System.out.println("count = " + count); // 0
        integers.stream().forEach(i -> count.incrementAndGet());
        System.out.println("count = " + count); // 5

        // pouziji se pouze zdrojove elementy, ktere jsou skutecne potreba
        // v tomto pripade pro .count() jen dva - {1, 2}
        AtomicInteger countBefore = new AtomicInteger(0);
        AtomicInteger countAfter = new AtomicInteger(0);
        long streamCount = integers.stream()
                .peek(i -> countBefore.incrementAndGet())
                .filter(i -> i < 3)
                .peek(i -> countAfter.incrementAndGet())
                .count();
        System.out.println("countBefore = " + countBefore); // 5
        System.out.println("countAfter = " + countAfter); // 5
        System.out.println("streamCount = " + streamCount); // 5
    }

}
