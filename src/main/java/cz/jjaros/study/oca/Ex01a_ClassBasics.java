package cz.jjaros.study.oca;

// NE! v jednom soubboru muze byt pouze jedna public trida, navic jeji nazev musi odpovidat nazvu souboru
// vysledek: compilation error
//public class FailedClass1 {
//}

// NE! private nema vyznam!!!
// vysledek: compilation error
//private class FailedClass2 {
//}

import cz.jjaros.study.helper.exception.CheckedException;
import cz.jjaros.study.helper.exception.UncheckedException;

// tohle je Ok:
class BasicClass {

    // 'throws CheckedException' tady musi byt jen v pripade, ze by v instancnim init bloku nebyl catch checked vyjimky
//    public BasicClass() throws CheckedException {
    public BasicClass() {
        System.out.println("konstruktor");
    }

    {
        System.out.println("instancni init blok");

        // checked vyjimka tady dela bordel
        // reseni:
        // 1. catch
        // 2. ke VSEM konstruktorum pridat 'throws *Exception' -> celkem voser pri dalsim pouziti
        try {
            CheckedException.throwNew();
        } catch (CheckedException e) {
            throw new UncheckedException(e);
        }
    }

    static {
        System.out.println("staticky init blok");

        // checked vyjimka tady dela neplechu
        // jedine reseni tady je catch...
        try {
            CheckedException.throwNew();
        } catch (CheckedException e) {
            throw new UncheckedException(e);
        }
    }
}

public class Ex01a_ClassBasics {

    // vsechny moznosti zapisu jsou mozne:
//    public static void main(String[]args) {
//    public static void main(String... arguments) {
//    public static void main(String...arguments) {
//    public static void main(String args[]) {
    public static void main(String[] args) {

        // vypise:
        //      staticky init blok
        //      instancni init blok
        //      konstruktor
        BasicClass basicClass = new BasicClass();
    }

}
