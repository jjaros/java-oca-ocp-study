package cz.jjaros.study.oca.ch08_variables;

import cz.jjaros.study.helper.Console;

public class Ex08f_Others {

    public static void main(String[] args) {
        // switch:
        doSwitch(10); // 10 \n 20
        doSwitch(20); // 20
        doSwitch(30); // 30 \n --

        Console.lineDelimiter();

        // operators:
        // see: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/operators.html
        int a = 10;
        int b = a++;
        System.out.println("a = " + a); // 11
        System.out.println("b = " + b); // 10
        Console.lineDelimiter();

        int c = 0;
        int d = ++c;
        System.out.println("c = " + c); // 1
        System.out.println("d = " + d); // 1
        Console.lineDelimiter();

        int e = 10;
        int f = 3 + 2 * ++e;
        System.out.println("f = " + f); // 25
        Console.lineDelimiter();

        int g = 2 * 5 + 3 * 4 - 8; // 14
        System.out.println("g = " + g);
        Console.lineDelimiter();

        int h = 4 * 5^2 / 4 + 2;
        System.out.println("h = " + h); // 22

    }

    private static void doSwitch(int i) {
        // switch muze byt podle:
        //      - int (nebo mensi)
        //      - enum
        //      - String
        switch (i) {
            case 10:
                System.out.println("10");
            case 20:
                System.out.println("20");
                break;
            case 30:
                System.out.println("30");
            default:
                System.out.println("--");
        }

    }
}

