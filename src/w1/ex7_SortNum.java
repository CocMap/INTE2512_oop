/*
Exercise 7 - The integers are entered from the input dialogs and stored in variables
num1, num2, and num3. The program sorts the numbers so that num1 ≤ num2 ≤ num3
 */

package w1;

import java.util.Arrays;
import java.util.Scanner;

public class ex7_SortNum {
    public static void main(String[] args) {
        System.out.printf("Enter three number: ");
        Scanner input = new Scanner(System.in);
        String[] strInput = input.nextLine().split(" ");

        int[] arrNum = new int[3];

        //parse input into arrNum[]
        for(int i = 0; i < strInput.length; i++){
            arrNum[i] = Integer.parseInt(strInput[i]);
        }
        System.out.println("The initial array is: " + Arrays.toString(arrNum));

        for(int i = 0; i < 3; i++){
            for(int j = i + 1; j < 3; j++) {
                if(arrNum[i] > arrNum[j]) {         //swap position
                    int temp = arrNum[i];
                    arrNum[i] = arrNum[j];
                    arrNum[j] = temp;
                }
            }
        }
        System.out.println("Tne sorted array is: " + Arrays.toString(arrNum));
    }
}
