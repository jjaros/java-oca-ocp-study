package cz.jjaros.study.oca.ch12_lambda;

import java.util.Arrays;
import java.util.List;

@FunctionalInterface
interface Printer {
    // funkcionalni interface ma prave jednu abstraktni metodu
    void print(int value);
//    void empty(); // NE: toto znemozni pouziti interface jako lambda vyrazu
    static void empty() {
        System.out.println();
    }
    // compilation error kdyz: default void empty()
    // nesmi byt stejna signatura metody
    default void defaultEmpty() {
        System.out.println();
    }
}

public class Ex12_Lambda {

    private static Printer start = new Printer() {
        @Override
        public void print(int value) {
            System.out.println("start value is: " + value);
        }
    };

    // jeden argument lambdy: (e) pripadne jen e
    // zadny argument lambdy: ()
    // vice  argumentu lambdy: (a, b)
    // take je moznost dat nazev + typ argumentu!!!: (String a, Integer b)
    private static Printer end = value -> System.out.println("end value is: " + value);

    private static Printer newLine = v -> Printer.empty();
    // kdyby staticka metoda Printer#empty mela vstup int, slo by zapsat jako method reference
//    private static Printer newLine = Printer::empty;

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        for (Integer integer : integers) {
            start.print(integer);
            // ...
            end.print(integer);
            newLine.print(integer);
        }
    }

}
