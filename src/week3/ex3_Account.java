/*
 Assume that each character of “ABCDEFGHIJKLMNOPQRSTUVWXYZ” is substituted
 by a corresponding one in     “QTGABCDEFHIJKLMNOPRSUVWXYZ”.
 Write a program that prompts the user for a plain text then displays the
 cipher text which is encrypted it using the above encryption scheme.
 */

package week4;

import java.util.Scanner;

public class ex3_Account {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        final String CYP = "QTGABCDEFHIJKLMNOPRSUVWXYZ";

        // Prompt the user for the plain text
        System.out.println("ENCRYPTION PROGRAM");
        System.out.print("Enter plain text: ");
        String plain = input.nextLine();
        plain = plain.toUpperCase();      // Convert to uppercase for easy mapping

        // Construct the cipher text by mapping each character in the plain text to the corresponding
        // character in the string CYP. Non-letter characters are kept as is
        String cipher = "";
        int len = plain.length();
        char ch;
        for (int i = 0; i < len; i++) {
            ch = plain.charAt(i);
            if ('A' <= ch && ch <= 'Z')       // ch is an uppercase letter
                cipher += CYP.charAt(ch - 'A');
            else                              // ch is not a letter
                cipher += ch;
        }

        // Display the cipher text
        System.out.println("Cipher text: " + cipher);
    }

}
