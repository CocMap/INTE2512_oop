package week5;

public class ex3_ShowOutput2 {
    public static void main(String[] args) {
        new Person2().printPerson();                //print Person
        new Student2().printPerson();               //print Student

    }
}

class Student2 extends Person2 {
    String getInfo() {
        return "Student";
    }
}

class Person2 {
    String getInfo() {
        return "Person";
    }

    public void printPerson() {
        System.out.println(getInfo());
    }
}