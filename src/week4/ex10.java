// The two endpoints for the first line segment are (x1, y1) and (x2, y2)
// and for the second line segment are (x3, y3) and (x4, y4).
// Write a program that prompts the user to enter these four endpoints and displays the intersecting point.

package week4;

import java.util.Arrays;
import java.util.Scanner;

public class ex10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("FIRST LINE");
        System.out.print("Enter x1: ");
        int x1 = input.nextInt();
        System.out.print("Enter y1: ");
        int y1 = input.nextInt();
        System.out.print("Enter x2: ");
        int x2 = input.nextInt();
        System.out.print("Enter y2: ");
        int y2 = input.nextInt();

        int[] line1 = getLineEqt(x1,y1,x2,y2);
        System.out.println();

        System.out.println("SECOND LINE");
        System.out.print("Enter x1: ");
        x1 = input.nextInt();
        System.out.print("Enter y1: ");
        y1 = input.nextInt();
        System.out.print("Enter x2: ");
        x2 = input.nextInt();
        System.out.print("Enter y2: ");
        y2 = input.nextInt();

        int[] line2 = getLineEqt(x1,y1,x2,y2);

        System.out.println();
        System.out.println("Parameters for line 1: " + Arrays.toString(line1));
        System.out.println("Parameters for line 2: " + Arrays.toString(line2));
        System.out.println();

        ex6_LinearEquation eqt = new ex6_LinearEquation(line1[0], line1[1], line1[2], line2[0], line2[1], line2[2]);

        if (!eqt.isSolvable()) System.out.println("Not solvable");
        else System.out.printf("Intersecting point: (%.2f,%.2f)\n", eqt.getX(), eqt.getY());
    }

    private static int[] getLineEqt(int x1, int y1, int x2, int y2) {
        // Normal vector of line
        int xn = y2 - y1;
        int yn = - (x2 - x1);

        // Coefficients ax, by
        int a = xn;
        int b = yn;

        // Constant e
        int e = xn*x1 + yn*y1;

        int[] arr = {a,b,e};

        return arr;
    }
}
