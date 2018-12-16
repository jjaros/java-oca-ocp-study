package cz.jjaros.study.oca.ch13_exception;

import cz.jjaros.study.helper.exception.CheckedException;

public class Ex13_Exception {

    private static String returnProblem() {
        try {
            System.out.println("try - #returnProblem()");
            return "result(from try) - #returnProblem()"; // toto se bude ignorovat diky return ve finally

        // pozor na poradi, pri opacnem poradi je chyba pri kompilaci
        } catch (NullPointerException npe) {
            npe.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally #returnProblem()");
            return "result(from finally) - #returnProblem()"; // POZOR: metoda vrati toto a puvodni return z try bloku se ignoruje
        }
    }

    private static String loseException() {
        try {
            System.out.println("try - #loseException()");
            CheckedException.throwNew();
        } finally {
            System.out.println("finally - #loseException()");
            // POZOR: tady se uplne ztrati *Exception - dal se pokracuje, jako by nic...
            //        bez return se vyjimka neztrati
            return "result(from finally) - #loseException()";
        }
    }

    public static void main(String[] args) {
        String returnProblemResult = returnProblem();
        String loseExceptionResult = loseException();
        System.out.println("returnProblemResult = " + returnProblemResult); // finally - #returnProblem()
        System.out.println("loseExceptionResult = " + loseExceptionResult); // finally - #loseException()
    }
}
