/*
Write a program that prompts the user to enter the center coordinates and radius
of two circles and determines whether the second circle is inside the first or overlaps with the first
 */
package week1;

import java.util.Scanner;

public class ex10_CirclePosition {
    public static void main(String[] args) {
        System.out.println("Enter 1st circle parameters (x1, y1, radius1 - separated by <space>): ");
        Scanner c1Input = new Scanner(System.in);
        String[] strInput1 = c1Input.nextLine().split(" ");

        System.out.println("Enter 2nd circle parameters (x2, y2, radius2 - separated by <space>): ");
        Scanner c2Input = new Scanner(System.in);
        String[] strInput2= c2Input.nextLine().split(" ");

        double[] c1 = new double[3];
        double[] c2 = new double[3];

        //parse all the input into c1[] and c2[]
        for (int i = 0; i < 3; i++){
            c1[i] = Integer.parseInt(strInput1[i]);
            c2[i] = Integer.parseInt(strInput2[i]);
        }

        double distance = Math.sqrt(Math.pow((c1[0] - c2[0]),2) + Math.pow((c1[1] - c2[1]),2));

        if(distance <= Math.abs(c1[2] - c2[2])){
            if(c1[2] > c2[2]) System.out.println("Circle 2 is inside Circle 1");
            else System.out.println("Circle 1 is inside Circle 2");
        }
        if(distance >= (c1[2] + c2[2])) System.out.println("Two circle overlap");
        if(distance > (c1[2] + c2[2]))  System.out.println("Two circles are separated");
    }
}
