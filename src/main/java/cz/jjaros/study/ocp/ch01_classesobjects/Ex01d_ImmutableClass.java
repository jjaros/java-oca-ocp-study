package cz.jjaros.study.ocp.ch01_classesobjects;

final class ImmutableClass {

}

// NE:
// trida neni immutable, protoze lze menit obsah pole 'nonImmutableArray'
final class NonImmutableClass {
    private final String[] nonImmutableArray;

    public NonImmutableClass(String[] nonImmutableArray) {
        this.nonImmutableArray = nonImmutableArray;
    }

    public String[] getNonImmutableArray() {
        return nonImmutableArray;
    }
}

// NE:
// tohle taky neni immutable, protoze lze pres 'nonImmutableClass'
// lze pristoupit a menit pole 'nonImmutableClass#nonImmutableArray'
class NonImmutableWrapperClass {
    private final NonImmutableClass nonImmutableClass;

    private NonImmutableWrapperClass(NonImmutableClass nonImmutableClass) {
        this.nonImmutableClass = nonImmutableClass;
    }

    public static NonImmutableWrapperClass factoryMethod(NonImmutableClass nonImmutableClass) {
        return new NonImmutableWrapperClass(nonImmutableClass);
    }

    public NonImmutableClass getNonImmutableClass() {
        return nonImmutableClass;
    }
}

// ukazkova immutable trida
final public class Ex01d_ImmutableClass {

    private final String string;

    public Ex01d_ImmutableClass(String string) {
        this.string = string;
    }

    // pridanim setteru uz by trida nebyla immutable
//    public void setString(String string) { this.string = string; }

    public String getString() {
        return string;
    }
}

final class ImmutableClassWithMutableCopies {
    private final MutableClass mutableClass;

    public ImmutableClassWithMutableCopies(MutableClass mutableClass) {
        this.mutableClass = new MutableClass(mutableClass); // create and store copy of mutable object
    }

    public MutableClass getMutableClass() {
        return new MutableClass(mutableClass); // return copy of mutable class
    }
}

final class MutableClass {
    private String string;

    public MutableClass(String string) {
        this.string = string;
    }

    // copy constructor to provide easy way
    // to copy instance of MutableClass in ImmutableClassWithMutableCopies
    // other way may be e.g. using the mapping framework
    public MutableClass(MutableClass mutableClass) {
        this.string = mutableClass.getString();
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }
}