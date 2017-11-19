package week5;

import java.util.Scanner;

public class ex6 {
    class LinearEquation{
        private int a,b,c,d,e,f;

        LinearEquation(int a, int b, int c, int d, int e, int f){

        }

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

        public boolean isSolvable(){
            if(a*d - b*c != 0){
                return true;
            } else {
                return false;
            }
        }

        public int getX() {
            return a*d - b*c;
        }
    }

    public static void main(String[] args) {
        System.out.printf("Enter a, b, c, d, e, f");
        Scanner arr_in = new Scanner(System.in);
        String arr_scan = arr_in.nextLine();
        String[] arr_line = arr_scan.split(" ");     //split base on <space>

        int[] arr = new int[5];

        //parse the input into arr[i]
        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(arr_line[i]);
        }
    }
}
