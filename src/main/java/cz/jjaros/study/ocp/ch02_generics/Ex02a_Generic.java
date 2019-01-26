package cz.jjaros.study.ocp.ch02_generics;

import cz.jjaros.study.helper.Console;

import java.io.Serializable;

interface GenericInterface<T> {
    // NE:
    // T cannot be referenced from static context
//    T type;

    <U> T doStuff(U u);

    default <U> T defaultDoStuff(T t) {return t;}

    // NE:
    // T cannot be referenced from static context
//    static  <U> T staticDoStuff(U u) {}
}

// T muze byt cokoliv
// U musi byt Number nebo potomek
// V musi implementovat Serializable
// v techto pripadech nejde pouzit super nebo implements -> pouze extends
class GenericClass<T, U extends Number, V extends Serializable> {

    private T localT;
    private U localU;
    private V localV;

    // NE:
    // T cannot be reference from static context
//    private static T staticT;

    // tady nejde pouzit T, U ani V
    // pro statickou metodu se musi genericky typ definovat primo u metody
    // staticke fieldy generalizovat nelze
    // v techto pripadech nejde pouzit super nebo implements -> pouze extends
    public static <G, H extends Number, I extends Serializable> I staticGenericMethod(G g, H h, I i) {
        H tmpH = h;
        System.out.println(g.getClass().getSimpleName());
        System.out.println(h.getClass().getSimpleName());
        System.out.println(i.getClass().getSimpleName());
        return i;
    }

    void foo(T t, U u, V v) {
        System.out.println(t.getClass().getSimpleName());
        System.out.println(u.getClass().getSimpleName());
        System.out.println(v.getClass().getSimpleName());
    }

    // X muze byt cokoliv
    // Y musi byt Number nebo potomek
    // Z musi implementovat Serializable
    // v techto pripadech nejde pouzit super nebo implements -> pouze extends
    <X, Y extends Number, Z extends Serializable> X genericMethod(X x, Y y, Z z, T t, U u, V v) {
        System.out.println("> call GenericClass#genericMethod:");
        System.out.println(x.getClass().getSimpleName());
        System.out.println(y.getClass().getSimpleName());
        System.out.println(z.getClass().getSimpleName());
        System.out.println("> call GenericClass#foo:");
        foo(t, u, v);
        return x;
    }
}

interface MyInterface {}

public class Ex02a_Generic<A> {

    public static void main(String[] args) {
        GenericClass<String, Integer, SerializableClass> objectGenericClass = new GenericClass<>();

        // String
        // Integer
        // SerializableClass
        objectGenericClass.foo("test foo", 1, new SerializableClass());
        Console.lineDelimiter();

        // > call GenericClass#genericMethod
        // Object
        // Double
        // SerializableClass
        // > call GenericClass#foo:
        // String
        // Integer
        // SerializableClass
        objectGenericClass.genericMethod(new Object(), 2.0, new SerializableClass(), "test foo", 1, new SerializableClass());
    }

}

class SerializableClass implements Serializable {
}