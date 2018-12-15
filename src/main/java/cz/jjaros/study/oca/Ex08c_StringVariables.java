package cz.jjaros.study.oca;

import cz.jjaros.study.helper.Console;

import java.util.Random;

public class Ex08c_StringVariables {

    public static void main(String[] args) {

        stringCreation();
        Console.lineDelimiter();

        stringCreationPerf();
        Console.lineDelimiter();

        stringIntern();

    }

    private static void stringCreation() {
        String s1 = "test"; // vytvori a ulozi novy objekt na stack
        String s2 = "test"; // bude ukazovat na stejny objekt na stacku (Java optimalizace)
        String s3 = new String("test"); // vytvori novy objekt na heap
        String s4 = s3; // bude ukazovat na stejny objekt na heap

        System.out.println(s1 == s2); // true
        System.out.println(s1 == s3); // false
        System.out.println(s3 == s4); // true
    }

    private static void stringCreationPerf() {
        concatWithPlus(20_000); // stovky ms (nejpomalejsi)
        concatWithStringBuilder(20_000); // jednotky ms (nejrychlejsi)
        concatWithStringBuffer(20_000); // jednotky az desitky ms (cca 2x pomalejsi nez StringBuilder) - StringBuffer je thread safe
    }

    private static void concatWithPlus(int count) {
        long start = System.currentTimeMillis();
        
        String str = "";
        for (int j = 0; j < count; j++) {
            str += new Random().nextInt(10); // NE: tady bobtna stack - s kazdym provedenim tohoto radku se vytvori novy objekt
        }
        
        long end = System.currentTimeMillis();
        System.out.println("Time (concat with +=): " + (end - start) + "ms");
    }
    
    private static void concatWithStringBuilder(int count) {
        long start = System.currentTimeMillis();

        StringBuilder stringBuilder = new StringBuilder();
        for (int j = 0; j < count; j++) {
            stringBuilder.append(new Random().nextInt(10));
        }
        String finalString = stringBuilder.toString();

        long end = System.currentTimeMillis();
        System.out.println("Time (concat with StringBuilder): " + (end - start) + "ms");
    }

    private static void concatWithStringBuffer(int count) {
        long start = System.currentTimeMillis();

        StringBuffer stringBuffer = new StringBuffer();
        for (int j = 0; j < count; j++) {
            stringBuffer.append(new Random().nextInt(10));
        }
        String finalString = stringBuffer.toString();

        long end = System.currentTimeMillis();
        System.out.println("Time (concat with StringBuffer): " + (end - start) + "ms");
    }

    private static void stringIntern() {
        String s1 = new String("test"); // novy objekt na heap
        String s2 = new String("test"); // dalsi novy objekt na heap

        System.out.println(s1 == s2); // false -> dva ruzne objekty

        String internS1 = s1.intern();
        String internS2 = s2.intern();
        System.out.println(internS1 == internS2); // true -> diky intern() obe  promenne ukazuji na stejny objekt na stack
    }
}
