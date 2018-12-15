package cz.jjaros.study.oca;

import java.util.Arrays;
import java.util.List;

@FunctionalInterface
interface Printer {
    void print(int value);
//    void empty(); // NE: toto znemozni pouziti interface jako lambda vyrazu
    default void empty() {
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

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        for (Integer integer : integers) {
            start.print(integer);
            // ...
            end.print(integer);
            end.empty();
        }
    }

}
