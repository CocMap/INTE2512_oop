package week4;

import week4.Measures.*;

public class ex8 {
    public static void main(String[] args) {
        Length obj1 = new Length(10, 20, 30);
        Length obj2 = new Length(20, 40, 60);

        Length obj3 = new Length(0, 0, 0);
        obj3 = obj3.add(obj1, obj2);

        System.out.println("cen = " + obj3.cm);
    }
}
