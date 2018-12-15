package cz.jjaros.study.oca;

import cz.jjaros.study.helper.Person;
import cz.jjaros.study.helper.Console;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Ex07_Comparator {

    public static void main(String[] args) {
        // v "davnych" dobach...
        List<Person> collectionsSort = getPeople();
        Collections.sort(collectionsSort); // Person MUSI implementovat Comparable, jinak compilation error
        Console.printList("Collections.sort(List)", collectionsSort);

        Collections.sort(collectionsSort, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o2.getAge() - o1.getAge();
            }
        }); // Person NEMUSI implementovat Comparable, protoze se jako druhy parametr predava Comparator
        Console.printList("Collections.sort(List, Comparator)", collectionsSort);

        // od Javy 8 je sort primo na listu (navic jde zapis komparatoru zkratit diky lambda vyrazu)
        List<Person> peopleSort = getPeople();
//        peopleSort.sort((o1, o2) -> o2.getAge() - o1.getAge()); // jde to ale jeste lepe
        peopleSort.sort(Comparator.comparing(Person::getAge).reversed()); // ekvivalent predchoziho radku
        Console.printList("List.sort(lambda)", collectionsSort);

        // slozitejsi porovnani:
        peopleSort.sort(
                Comparator.comparing(Person::getLastName)
                        .thenComparing(Person::getFirstName)
                        .thenComparingInt(Person::getAge).reversed()
        ); // POZOR: reversed() tady plati pro vsechny comparatory (tzn. vsechny budou reverzni)
        Console.printList("List.sort(Comparator.comparing().thenComparing()...) - all reversed", peopleSort);

        peopleSort.sort(
                Comparator.comparing(Person::getLastName)
                        .thenComparing(Person::getFirstName)
                        .thenComparing(Comparator.comparing(Person::getAge).reversed())
        ); // POZOR: reversed() tady plati jen pro komparator podle Person::getAge
        Console.printList("List.sort(Comparator.comparing().thenComparing()...) - age reversed", peopleSort);

        // pri pouziti Streamu jde list rovnou vypsat:
        System.out.println("> List.stream().sorted().forEach() <");
        peopleSort.stream()
                .sorted(Comparator.comparing(Person::getLastName))
                .forEach(System.out::println);
    }

    private static List<Person> getPeople() {
        return Arrays.asList(
                new Person("Cumi", "Sfusaku", 23),
                new Person("Lu", "Lin", 17),
                new Person("Dole", "Nakasi", 33),
                new Person("Masako", "Namiru", 47),
                new Person("Jmeno", "Prijmeni", 10),
                new Person("Jmeno", "Prijmeni", 20),
                new Person("Meno", "Prijmeni", 10)
        );
    }

}
