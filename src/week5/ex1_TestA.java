package week5;

public class ex1_TestA {
    public static void main(String[] args) {
        B b = new B();
    }
}
class A{
    public A(){
        System.out.println("A's no-arg constructor is invoked");
    }
}
class B extends A {
}
