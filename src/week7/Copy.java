package week7;

import java.io.*;
import java.util.Scanner;

public class Copy {
    public static void main(String[] args) throws IOException {
        Scanner kbScan = new Scanner (System.in);
        System.out.printf("File name to be copied: ");
        File sourceFile = new File(kbScan.nextLine());
        System.out.printf("Target file name: ");
        File targetFile = new File(kbScan.nextLine());

        for(int i = 0; i < args.length; i++){
            System.out.println(args[i]);
        }

        if(!sourceFile.exists()) {
            System.out.println("Source file does not exist");
            System.exit(2);
        }

        if(targetFile.exists()) {
            System.out.println("Target file " + args[0] + "already exist");
            System.exit(3);
        }

        try (
            BufferedInputStream input = new BufferedInputStream(new FileInputStream(sourceFile));
            BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(targetFile));
        ) {
            int r, numberOfBytesCopied = 0;
            while ((r = input.read()) != -1) {
                output.write((byte)r);
                numberOfBytesCopied++;
            }
            System.out.println(numberOfBytesCopied + " bytes copied");
        }
    }
}
