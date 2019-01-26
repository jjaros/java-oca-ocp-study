package cz.jjaros.study.helper;

import java.util.List;
import java.util.stream.Collectors;

public final class Console {

    private Console() {
    }

    public static void printList(String intro, List<?> list) {
        System.out.println("> " + intro + " <");
        list.forEach(System.out::println);
        lineDelimiter();
    }

    public static void lineDelimiter() {
        System.out.println("************************************");
    }

    public static void printItemsClassNames(List<?> list) {
        String itemsClassNames = list.stream()
                .map(Object::getClass)
                .map(Class::getSimpleName)
                .collect(Collectors.joining(", "));
        System.out.println(itemsClassNames);
    }
}
