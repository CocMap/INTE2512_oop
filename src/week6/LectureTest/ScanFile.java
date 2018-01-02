package week6.LectureTest;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ScanFile {
    public static void main(String[] args) throws Exception {
        //**********sample read IO text (slide 25 week 6)**********
        File dummyFile = new File("dummy.txt");
        try {
            dummyFile.createNewFile();              //create from "src"
        } catch (IOException e) {
            System.out.printf("Could not create new file");
        }

        //**********sample read IO text (slide 29 week 6)**********
        Scanner s = new Scanner(System.in);
        System.out.print("Type in the input file name: ");
        String inputFileName = s.nextLine();

        //check if the file exist
        File sourceFile = new File(inputFileName);
        if(!sourceFile.exists()) {
            System.out.println("Source file " + inputFileName + " does not exist");
            System.exit(1);             //something wrong -> exit
        }

        Scanner fileScan = new Scanner(sourceFile);         //may throws FileNoteFoundException
        while(fileScan.hasNext()){
            String scan = fileScan.next();
            System.out.println(scan);
        }
    }
}
