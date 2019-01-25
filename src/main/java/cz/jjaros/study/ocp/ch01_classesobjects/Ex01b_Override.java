package cz.jjaros.study.ocp.ch01_classesobjects;

class TopParent {
    void doStuff() {
        System.out.println("TopParent");
    }
}

class MiddleParent extends TopParent {
    void doStuff() {
        System.out.println("MiddleParent");
    }
}

public class Ex01b_Override extends MiddleParent {

    @Override
    void doStuff() {
        super.doStuff(); // pristupuje pouze na MiddleParent#doStuff

        // NE:
        // nefunguje nic jako (vsechno je to compilation error):
//        super.super.doStuff();
//        this.super.super.doStuff();
//        ((TopParent) super).doStuff();
    }

    public static void main(String[] args) {
        new Ex01b_Override().doStuff(); // MiddleParent
    }
}
