package cz.jjaros.study.oca;

public class Ex02_Varargs {

    // NE: muze byt maximalne jednou a musi byt posledni ve vyctu parametru
//    public static void foo1(int ... args, String str) { }
//    public static void foo2(String ... args, String str) { }
//    public static void foo3(String ... args, String ... str) { }
//    public static void foo4(String ... str, int a, String ... args) { }
//    public static void foo5(int a, String args...) { }

    // povolene varianty:
    public static void bar1(String... args) { }
    public static void bar2(int a, String... args) { }
    public static void bar3(String a, String... args) { }
    public static void bar4(String a, String...args) { }
    public static void bar5(String a, String ... args) { }
    public static void bar6(String a, String ...args) { }

    public static void main(String[] args) {
        // volani metody bez varargs
        bar1();
        bar1(null);
        bar1(new String[]{});
        bar2(1);
        bar3("first string");

        // volani metody s varargs
        bar4("first param", "first vararg");
        bar5("first param", "first vararg", "second vararg");
        bar6("first param", "first vararg", "second vararg", "...", "n-th vararg");
        bar6("first param", new String[]{"first vararg", "second vararg", "...", "n-th vararg"});
    }
}
