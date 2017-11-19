package w1;

import java.util.Scanner;

public class ex6_SavingAccount {
    private static void printBalance(int month){
        final int saving = 100;
        double interestRate = 1.00417;      //monthly interest
        double balance = 0;

        for(int i = 1; i <= month; i++) {
            balance += saving;
            balance *= interestRate;
        }

        System.out.printf("Balance account after %1d month is: %.3f \n", month, balance);
    }

    public static void main(String[] args) {
        while(true){
            System.out.printf("Number of months: ");
            Scanner monthInput = new Scanner(System.in);
            int month = monthInput.nextInt();

            if(month > 0) printBalance(month);
            else if (month == -1){
                System.exit(0);
            }
            else{
                System.out.println("Invalid value of month.");
            }
        }
    }
}
