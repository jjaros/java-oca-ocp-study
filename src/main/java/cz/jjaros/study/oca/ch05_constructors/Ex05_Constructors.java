package cz.jjaros.study.oca.ch05_constructors;

public class Ex05_Constructors {

    public static void main(String[] args) {
        // vysledek:
        //      ParentClass
        //      ChildClass
        new ChildClass();

        // vysledek:
        //      ParentClass with param: %d
        //      ChildClass with param: %d
        new ChildClass(1);
    }

    private static class ParentClass {
        public ParentClass() {
            // super(); // OK: vola se konstruktor java.lang.Object()
            System.out.println("ParentClass");
        }

        public ParentClass(int n) {
            System.out.println("ParentClass with param: " + n);
        }
    }

    private static class ChildClass extends ParentClass {
        public ChildClass() {
            // super(); // volani defaultniho/bezparametrickeho konstruktoru predka neni povinne uvadet
//            super().super() // NE: lze volat JEN viditelne konstruktory primeho predka
            System.out.println("ChildClass");
//            super(); // pokud je explicitne uvedeno, musi byt prvni, jinak compilation error
        }

        public ChildClass(int n) {
            super(n); // volani parametrickeho konstruktoru predka
            System.out.println("ChildClass with param: " + n);
        }
    }
}
