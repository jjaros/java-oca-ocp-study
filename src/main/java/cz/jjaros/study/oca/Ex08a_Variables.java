package cz.jjaros.study.oca;

import cz.jjaros.study.helper.Console;

import java.math.BigDecimal;

public class Ex08a_Variables {

    public static void main(String[] args) {
        literals();
        Console.lineDelimiter();

        specialLiterals();
        Console.lineDelimiter();

        realNumbersSum();
        Console.lineDelimiter();

        autoconversion();
        Console.lineDelimiter();

        errors();
    }

    private static void literals() {
        // https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html

        long longNum = 10;
//        long longNum = 10L;
//        long longNum = 10l;
        System.out.println("longNum = " + longNum); // 10

        double doubleNum = 10.0;
//        double doubleNum = 10D;
//        double doubleNum = 10d;
//        double doubleNum = 10; // literal for double is optional
        System.out.println("doubleNum = " + doubleNum); // 10.0

        float floatNum = 10F;
//        float floatNum = 10f;
        System.out.println("floatNum = " + floatNum); // 10.0

        double scientificNotation = 65.43e2;
//        double scientificNotation = 65.43e2;
        System.out.println("scientificNotation = " + scientificNotation); // 6543.0

        Console.lineDelimiter();

        int decimal = 123456789; // [0-9]
        int hexadecimal = 0x0123AbcD; // 0x[0-9A-Fa-f]
        short binary = 0b011001; // 0b[01]
//        short binaryError = 0b011001010100101011; // NE: moc velky cislo do short
        System.out.println("decimal = " + decimal); // 123456789
        System.out.println("hexadecimal = " + hexadecimal); // 19114957
        System.out.println("binary = " + binary); // 25
    }

    private static void specialLiterals() {
        // NE: compilation error
//        double a = 100.0_;
//        double b = _100.0;
//        double c = 100_.0;
//        double d = 100._0;
//        double e = 100._0;
//        double f = 100e_0;
//        double g = 100_e0;
//        double h = 100.0_F;
//        short i = 0b_011001;

        int j = 1_2__3___4;
        System.out.println("j = " + j); // 1234
        double k = 1_2.3__4e0_1;
        System.out.println("k = " + k); // 123.4
        short l = 0b0_11_0_01; // 25
        System.out.println("l = " + l);

        String specialCharInString = "S\u00eD Se\u00F1or";
        System.out.println("specialCharInString = " + specialCharInString); // Sí Señor

        System.out.println("backspace: a\bb"); // backspace: b
        System.out.println("tab: a\tb"); // tab: a [tab] b
        System.out.println("line feed: a\nb"); // line feed: a [new line] b
        System.out.println("form feed: a\fb"); // form feed: ab
        System.out.println("carriage return: a\rb"); // b
        System.out.println("single and double quotes: \" \'"); // single and double quotes: " '
        System.out.println("backslash: \\"); // backslash \
    }

    private static void realNumbersSum() {
        double badDoubleSum = 0.1d + 0.2d;
        System.out.println("badDoubleSum = " + badDoubleSum); // 0.30000000000000004

        float floatSum = 0.1f + 0.2f;
        System.out.println("floatSum = " + floatSum); // 0.3

        BigDecimal badBigDecimalSum = new BigDecimal(0.1).add(new BigDecimal(0.2));
        System.out.println("badBigDecimalSum = " + badBigDecimalSum); // 0.3000000000000000166533453693773481063544750213623046875

        // OK: valueOf(double) uvnitr vola 'new BigDecimal' se vstupem Double.toString(val)
        BigDecimal bdValueOfSum = BigDecimal.valueOf(0.1).add(BigDecimal.valueOf(0.2));
        System.out.println("bdValueOfSum = " + bdValueOfSum); // 0.3

        BigDecimal newBdSum = new BigDecimal("0.1").add(new BigDecimal("0.2"));
        System.out.println("newBdSum = " + newBdSum); // 0.3
    }

    private static void autoconversion() {
        // byte -> short -> int -> long
        byte byteNum = 10;
        short shortNum = byteNum;
        int intNum = shortNum;
        long longNum = intNum;
        System.out.println("byteNum = " + byteNum); // 10
        System.out.println("shortNum = " + shortNum); // 10
        System.out.println("intNum = " + intNum); // 10
        System.out.println("longNum = " + longNum); // 10
        Console.lineDelimiter();

        // float -> double
        float floatNum = 10f;
        double doubleNum = floatNum;
        System.out.println("floatNum = " + floatNum); // 10.0
        System.out.println("doubleNum = " + doubleNum); // 10.0

        // char <-> int
        int charToInt = 'a';
        System.out.println("charToInt = " + charToInt); // 97
        char intToChar = 97;
        System.out.println("intToChar = " + intToChar); // a

        char specialChar = '\u00f1';
//        char specialChar = '\u00F1';
        System.out.println("specialChar = " + specialChar); // ñ
    }

    private static void errors() {
        // NE; Variable might not have been initialized - compilation error
//         int a;
//         System.out.println(a);

        // NE: Incompatible types: possible lossy conversion from int to short
//        short s = 100000;
//        float s = 100000000000000000.0;
        float floatOverflow = 100000000000000000.0F; // 9.9999998E16
        System.out.println("floatOverflow = " + floatOverflow);
    }
}
