/*
  RMIT University Vietnam
  Course: INTE2512 Object-Oriented Programming
  Semester: 2017C
  Assignment: 2
  Purpose:
  Author: Tran Le Nha Tran
  ID: Your student id: s3533562
  Created date: 6/12/2017
  Acknowledgement:
  StackOverflow
  - https://stackoverflow.com/questions/6259339/how-to-read-a-text-file-directly-from-internet-using-java
  - https://stackoverflow.com/questions/33051787/how-do-i-find-a-string-lists-length-in-java

*/
package assignment2;

public class functions {
    //getData() with start/end conditions
    public static String getData(String line, String start, String end) {
        String data;
        if (line.contains(start)) {
            data = (line.split(start))[1];
            if (data.contains(end)) {
                data = (data.split(end)[0]);
            }else {
                data = (line.split(start))[0];
            }
        }
        return "no return";
    }

    //getLeftRight() to split 2 left and right parts
    public static String getLeftRight(String line, boolean left) {
        String data;
        if (line.contains("-")) {
            //get split part
            if(left) {
                data = (line.split("-"))[0];
                data = data.replaceAll("\\s", "");
                return data;
            } else {
                //get right part
                data = (line.split("-"))[1];
                data = data.replaceAll("\\s", "");
                return data;
            }
        } else {
            return "no return";
        }
    }

    //getScore()
    public static int getScore(String string, String teamCutName, boolean left) {    //string = leftSideOrRightSide
        if (string.equals(null)){
            return -1;                  //false
        } else if (left) {              //homeScore
            return Integer.parseInt(string.split(teamCutName)[1]);
        } else {                        //awayScore
            return Integer.parseInt(string.substring(0, string.length() - teamCutName.length()));
        }
    }
}
