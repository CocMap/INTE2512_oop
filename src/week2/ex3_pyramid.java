package week2;

import java.util.Scanner;

public class ex3_pyramid {
    public static void main(String[] args) {
        while(true) {
            System.out.printf("Enter number of lines: ");
            Scanner numInput = new Scanner(System.in);
            int num = numInput.nextInt();

            if (num < 0 || num > 15){
                System.out.println("Invalid number of lines");
                break;
            }

            for(int i = 1; i <= num; i++){
                System.out.println("\t" + i + "\b");
            }

        }
    }
}
