package cz.jjaros.study.oca.ch03_initblocks;

import cz.jjaros.study.helper.exception.CheckedException;
import cz.jjaros.study.helper.exception.UncheckedException;

public class Ex03c_StaticInitBlockException {

    static {
        // tady je potreba osetrit vyjimku try-catch blokem
        try {
            CheckedException.throwNew();
        } catch (CheckedException e) {
            // unchecked exceptions jsou v pohode
            throw new UncheckedException(e);
        }
    }


}
