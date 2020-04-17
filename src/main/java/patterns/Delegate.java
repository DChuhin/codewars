package main.java.patterns;

public class Delegate {


    public static void main(String[] args) {
        B b = new B();
        b.print();
    }
}

/**
 * У нас есть класс со сложным методом
 */
class A {
    void print() {
        // сложный метод
        System.out.println("Complex method a");
    }
}

/**
 * и нам в классе B нужен функционал A, тогда внедрим его и делегируем
 */
class B {
    private A a = new A();
    void print() {
        // делегируем
        a.print();
    }
}