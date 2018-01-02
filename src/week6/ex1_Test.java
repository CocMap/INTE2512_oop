package week6;

import java.io.File;
import java.util.Scanner;

public class ex1_Test {
    public static void main(String[] args) throws Exception  {
        try {
            int value = 30;
            if(value < 40)
                throw new Exception("value is too small");

        } catch (Exception ex1) {
            System.out.println(ex1.getMessage());
        }
        System.out.println("Continue after the catch block");
    }
}
