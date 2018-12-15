package cz.jjaros.study.helper.exception;

public class CheckedException extends Exception {

    protected CheckedException() {
    }

    public static void throwNew() throws CheckedException {
        throw new CheckedException();
    }
}
