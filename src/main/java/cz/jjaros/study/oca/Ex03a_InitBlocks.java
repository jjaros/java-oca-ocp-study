package cz.jjaros.study.oca;

public class Ex03a_InitBlocks {

    { // instancni init blok
        System.out.println("instancni init blok 1.");
    }

    static { // staticky init blok
        System.out.println("staticky init blok");
    }

    public Ex03a_InitBlocks() {
        System.out.println("konstruktor");
    }

    { // instancni init blok
        System.out.println("instancni init blok 2.");
    }

    private static void staticMethod() {
        System.out.println("static method");
    }

    public static void main(String[] args) {
        // pokud by se zde nevytvarela instance tridy Ex03a_InitBlocks, zavolal by se JEN staticky init blok

        // vysledek:
        //      staticky init blok
        //      static method
        //      instancni init blok 1.
        //      instancni init blok 2.
        //      konstruktor
        Ex03a_InitBlocks.staticMethod();
//        new Ex03a_InitBlocks(); // tento radek by zpusobil opet zavolani isntancnich init bloku + konstruktoru
        new Ex03a_InitBlocks();
    }
}
