package cz.jjaros.study.helper.exception;

public class ChildCheckedException extends CheckedException {

    private ChildCheckedException() {
        super();
    }

    public static void throwNew() throws CheckedException {
        throw new ChildCheckedException();
    }
}
