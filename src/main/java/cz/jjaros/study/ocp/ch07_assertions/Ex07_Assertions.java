package cz.jjaros.study.ocp.ch07_assertions;

import java.util.ArrayList;
import java.util.List;

public class Ex07_Assertions {

    public static void main(String[] args) {

        List<Object> list = new ArrayList<>();

        // by default jsou asserty ignorovany
        // zapnout lze prepinacem -ea nebo -enableassertions
        //
        // pokud assert selze (= assert false;) -> java.lang.AssertionError
        assert !list.isEmpty(); // Exception in thread "main" java.lang.AssertionError
        assert !list.isEmpty() : "List nemuze byt prazdny"; // Exception in thread "main" java.lang.AssertionError: List nemuze byt prazdny

    }

}
