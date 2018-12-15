package cz.jjaros.study.helper;

import java.util.List;

public class Console {

    public static void printList(String intro, List<Person> list) {
        System.out.println("> " + intro + " <");
        list.forEach(System.out::println);
        lineDelimiter();
    }

    public static void lineDelimiter() {
        System.out.println("************************************");
    }

    private Console() {
    }
}
