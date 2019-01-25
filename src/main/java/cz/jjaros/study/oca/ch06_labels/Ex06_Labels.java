package cz.jjaros.study.oca.ch06_labels;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex06_Labels {

    public static void main(String[] args) {

        myBlockCode: {
            // pojmenovany blok kodu
        }

        List<Integer> integers = Stream.of(0, 1, 2, 3, 4, 5).collect(Collectors.toList());

        OUTER_LABEL: for (Integer integer : integers) { // cyklus s labelem: OUTER_LABEL
            System.out.println("OUTER_LABEL");

            int middleI = 0;
            FIRST_MIDDLE_LABEL: do { // cyklus s labelem: FIRST_MIDDLE_LABEL
                if (middleI == 1) {
                    break OUTER_LABEL; // ukonci cyklus OUTER_LABEL
                }
                middleI++;
                System.out.println("FIRST_MIDDLE_LABEL");

                SECOND_MIDDLE_LABEL: while (true) { // cyklus s labelem: SECOND_MIDDLE_LABEL
                    System.out.println("SECOND_MIDDLE_LABEL");

                    INNER_LABEL: for (int i = 0; i < 5; i++) { // cyklus s labelem: INNER_LABEL
                        System.out.println("INNER_LABEL");
                        switch (i) {
                            case 0:
                                continue FIRST_MIDDLE_LABEL; // vynuti dalsi iteraci cyklu s labelem FIRST_MIDDLE_LABEL
                            default:
                                break OUTER_LABEL; // ukonci cyklus s labelem OUTER_LABEL
                        }
                    }
                }
            } while (true);
        }

    }
}
