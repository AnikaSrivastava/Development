package org.example;

public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        t.print(10);
        t.print(new Integer(10));
        t.print(new Float(5) + new Double(5));

    }
    <T> T print(T t1) {
        System.out.println(t1);
        return t1;
    }
}
