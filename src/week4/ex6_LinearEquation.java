package week4;

import java.util.Scanner;

public class ex6_LinearEquation {
    private int a, b, c, d, e, f;

    public ex6_LinearEquation(int a, int b, int c, int d, int e, int f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }

    //6 get methods a,b,c,d,e,f
    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }

    public int getD() {
        return d;
    }

    public int getE() {
        return e;
    }

    public int getF() {
        return f;
    }

    public boolean isSolvable() {
        if (a * d - b * c != 0) {
            return true;
        } else {
            return false;
        }
    }

    public int getX() {
        return (e * d - b * f) / (a * d - b * c);
    }

    public int getY() {
        return (a * f - e * c) / (a * d - b * c);
    }

    public static void main(String[] args) {
        System.out.printf("Enter a, b, c, d, e, f: ");
        Scanner arr_in = new Scanner(System.in);
        String arr_scan = arr_in.nextLine();
        String[] arr_line = arr_scan.split(" ");     //split base on <space>

        int[] arr = new int[6];

        //parse the input into arr[i]
        for (int i = 0; i <= 5; i++) {
            arr[i] = Integer.parseInt(arr_line[i]);
            System.out.println(arr[i]);
        }

        ex6_LinearEquation NewEquation = new ex6_LinearEquation(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5]);
        if (!NewEquation.isSolvable()) {
            System.out.println("The equation has no solution");
        } else {
            System.out.println("The solution x = " + NewEquation.getX() + " and y = " + NewEquation.getY());
        }
    }
}