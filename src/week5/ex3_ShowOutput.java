package week5;

public class ex3_ShowOutput {
    public static void main(String[] args) {
        new Person().printPerson();                     //print Person
        new Student().printPerson();                    //print Student (after override)
    }
}

class Student extends Person {
    @Override
    public String getInfo() {
        return "Student";
    }
}

class Person {
    public String getInfo() {
        return "Person";
    }

    public void printPerson() {
        System.out.println(getInfo());
    }
}
