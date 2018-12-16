package cz.jjaros.study.oca.ch03_initblocks;

import cz.jjaros.study.helper.exception.CheckedException;

public class Ex03b_InstanceInitBlockException {

    // bez 'throws CheckedException' by to mohlo byt v pripade osetreni checked vyjimky v init bloku pomoci try-catch
//    private InstanceInitBlockClass() {
    private Ex03b_InstanceInitBlockException() throws CheckedException {
    }

    // bez 'throws CheckedException' by to mohlo byt v pripade osetreni checked vyjimky v init bloku pomoci try-catch
//    private InstanceInitBlockClass(int a) {
    public Ex03b_InstanceInitBlockException(int a) throws CheckedException {
    }

    {
        // jedno reseni je odchyceni vyjimky try-catch blokem:
//        try {
//            CheckedException.throwNew();
//        } catch (CheckedException e) {
//            throw new UncheckedException(e);
//        }

        // druhym resenim je pridani 'throws CheckedException' ke VSEM konstruktorum tridy
        CheckedException.throwNew();
    }

}
