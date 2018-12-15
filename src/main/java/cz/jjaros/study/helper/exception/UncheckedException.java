package cz.jjaros.study.helper.exception;

public class UncheckedException extends RuntimeException {

    public UncheckedException() {
    }

    public UncheckedException(Throwable e) {
        super(e);
    }
}
