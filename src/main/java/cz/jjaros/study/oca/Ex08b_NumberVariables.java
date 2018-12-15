package cz.jjaros.study.oca;

import cz.jjaros.study.helper.Console;

public class Ex08b_NumberVariables {

    public static void main(String[] args) {

        integerComparison();
        Console.lineDelimiter();
        autoboxingAndUnboxing();

    }

    private static void integerComparison() {
        // NE: jedna se o dva ruzne objekty v pameti
        Integer i1 = new Integer(10);
        Integer i2 = new Integer(10);
        System.out.println(i1 == i2); // false

        // v obou promennych bude reference na stejny objekt diky cache, kterou Integer#valueOf interne pouziva
        Integer i3 = Integer.valueOf(10);
        Integer i4 = Integer.valueOf(10);
        System.out.println(i3 == i4); // true

        // naopak tady bude false, protoze cislo 1000 neni v cahce -> pokazde se bude vytvaret novy objekt
        Integer i5 = Integer.valueOf(1000);
        Integer i6 = Integer.valueOf(1000);
        System.out.println(i5 == i6); // false

        // velikost IntegerCache je by default: [-128, 127] - obdobne ostatni datove typy pro cela cisla
        // horni hranice jde nastavit parametrem JVM 'java.lang.Integer.IntegerCache.high'
    }

    private static void autoboxingAndUnboxing() {
        // https://docs.oracle.com/javase/tutorial/java/data/autoboxing.html
        Integer autoboxed = 100;
        int unboxed = new Integer(100);
        System.out.println("autoboxed = " + autoboxed);
        System.out.println("unboxed = " + unboxed);
    }

}
