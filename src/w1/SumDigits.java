package w1;
import java.util.Scanner;

public class SumDigits {
    public static void main(String[] args) {
        System.out.println("Please input number from 0 to 1000: ");

        Scanner input = new Scanner(System.in);
        int i, sum, digit;

        i = input.nextInt();
        sum = 0;
        digit = i%10;

        if(i > 1000){
            System.out.println("Number not in range");
        }
        else{
            //hundred digit
            digit = i/100;
            sum += digit;

            //ten digit
            digit = i/10;
            sum += digit;

            //unit digit
            digit = i%10;
            sum += digit;



            System.out.println("The input number is: " + i);
            System.out.println("The sum of digits is: " + sum);
        }




    }
}
