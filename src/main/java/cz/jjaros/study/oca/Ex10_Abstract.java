package cz.jjaros.study.oca;

import cz.jjaros.study.helper.exception.CheckedException;
import cz.jjaros.study.helper.exception.ChildCheckedException;
import cz.jjaros.study.helper.exception.UncheckedException;

abstract class AbstractClass {
    int state = 1;

    protected abstract String printInstanceState(int state);

    protected abstract void exception() throws CheckedException;

    public String printState() {
        return printInstanceState(state);
    }
}

class ChildOne extends AbstractClass {
    @Override
    protected String printInstanceState(int state) {
        return "State of ChildOne is: " + state;
    }

    @Override
//    protected void exception() throws SQLException { // NE: NELZE pridat checked vyjimku
    protected void exception() { // MUZE skryt checked exception z predka
        throw new UncheckedException(); // MUZE pridat unchecked vyjimku
    }
}
class ChildTwo extends AbstractClass {
    @Override
    protected String printInstanceState(int state) {
        return "State of ChildTwo is: " + state;
    }

    @Override
    protected void exception() throws CheckedException {
        ChildCheckedException.throwNew(); // pokud jde o checked vyjimku, MUZE vyhazovat pouze instanci vyjimky v 'throws'
    }
}

public class Ex10_Abstract {

    public static void main(String[] args) {
        // NE: nejde vytvorit instanci abstraktni tridy
//        AbstractClass abstractClass = new AbstractClass(); // compilation error
        AbstractClass childOne = new ChildOne();
        ChildTwo childTwo = new ChildTwo();
        AbstractClass anonymousChild = new AbstractClass() {
            @Override
            protected String printInstanceState(int state) {
                return "State of AnonymousChild is: " + state;
            }

            @Override
            protected void exception() throws CheckedException {
                // do nothing here and see below for more information
            }
        };

        System.out.println("childOne.printState() = " + childOne.printState());
        System.out.println("childTwo.printState() = " + childTwo.printState());
        System.out.println("anonymousChild.printState() = " + anonymousChild.printState());
    }
}
