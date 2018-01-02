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
public class Team {
    //data fields
    private String name;
    private int pld, pts;
    private String diff;
    private int winHome, drawHome, lostHome, forHome, againstHome;
    private int winAway, drawAway, lostAway, forAway, againstAway;
    private int winTotal, drawTotal, lostTotal, forTotal, againstTotal;

    //a constructor with no arguments (create the objects which all parameters set to 0)
    public Team() {
        pld = 0; pts = 0;
        String diff = "";
        winHome = 0; drawHome = 0; lostHome = 0; forHome = 0; againstHome = 1;
        winAway = 0; drawAway = 0; lostAway = 0; forAway = 0; againstAway = 0;
        winTotal = 0; drawTotal = 0; lostTotal = 0; forTotal = 0; againstTotal = 0;
    }

     public Team(String name,
                 int winHome, int drawHome, int lostHome, int forHome, int againstHome,
                 int winAway, int drawAway, int lostAway, int forAway, int againstAway) {
        //var
        this.name = name;
        this.winHome = winHome;
        this.drawHome = drawHome;
        this.lostHome = lostHome;
        this.forHome = forHome;
        this.againstHome = againstHome;
        this.winAway = winAway;
        this.drawAway = drawAway;
        this.lostAway = lostAway;
        this.forAway = forAway;
        this.againstAway = againstAway;

        //vars properties
         winTotal = winHome + winAway;
         drawTotal = drawHome + drawAway;
         lostTotal = lostHome + lostAway;
         pld = winTotal + drawTotal + lostTotal;

         forTotal = forHome + forAway;
         againstTotal = againstHome + againstAway;

         if(forTotal - againstTotal == 0) diff = "0";
         else if (forTotal - againstTotal > 0) diff = "+" + Math.abs(forTotal-againstTotal);
         else diff = "-" + Math.abs(forTotal-againstTotal);

         pts = winTotal*3 + drawTotal;
     }

     //set value of parameter
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    //update parameters after scan text file
    //winHome, drawHome, lostHome
    public void updateWinHome() {
        winHome++;
    }

    public void updateDrawHome() {
        drawHome++;
    }

    public void updateLostHome() {
        lostHome++;
    }

    //calculate forHome and againstHome
    public void updateForHome(int forHome) {
        this.forHome += forHome;
    }

    public void updateAgainstHome(int againstHome) {
        this.againstHome += againstHome;
    }

    //winAway, drawAway, lostAway
    public void updateWinAway() {
        winAway++;
    }

    public void updateDrawAway() {
        drawAway++;
    }

    public void updateLostAway() {
        lostAway++;
    }

    //calculate forAway, againstAway
    public void updateForAway(int forAway) {
        this.forAway += forAway;
    }

    //calculate away against
    public void updateAgainstAway(int againstAway){
        this.againstAway += againstAway;
    }


    //get all parameters
    //get() winHome, drawHome, lostHome, forHome, againstHome
    public int getWinHome() {
        return winHome;
    }

    public int getDrawHome() {
        return drawHome;
    }

    public int getLostHome() {
        return lostHome;
    }

    public int getForHome() {
        return forHome;
    }

    public int getAgainstHome() {
        return againstHome;
    }

    //get() winAway, drawAway, lostAway, forAway, againstAway
    public int getWinAway() {
        return winAway;
    }

    public int getDrawAway() {
        return drawAway;
    }

    public int getLostAway() {
        return lostAway;
    }

    public int getForAway() {
        return forAway;
    }

    public int getAgainstAway() {
        return againstAway;
    }

    //get other parameters pld, pts, diff
    public int getPld() {
        return pld;
    }

    public int getPts() {
        return pts;
    }

    public String getDiff() {
        return diff;
    }

    //get total parameters
    //get() winTotal, drawTotal, lostTotal, forTotal, againstTotal
    public int getWinTotal() {
        return winTotal;
    }

    public int getDrawTotal() {
        return drawTotal;
    }

    public int getLostTotal() {
        return lostTotal;
    }

    public int getForTotal() {
        return forTotal;
    }

    public int getAgainstTotal() {
        return againstTotal;
    }

    //update all parameters
    public void updateAll() {
        winTotal = winHome + winAway;
        drawTotal = drawHome + drawAway;
        lostTotal = lostHome + lostAway;
        pld = winTotal + drawTotal + lostTotal;

        forTotal = forHome + forAway;
        againstTotal = againstHome + againstAway;

        if(forTotal - againstTotal == 0) diff = "0";
        else if (forTotal - againstTotal > 0) diff = "+" + Math.abs(forTotal-againstTotal);
        else diff = "-" + Math.abs(forTotal-againstTotal);

        pts = winTotal*3 + drawTotal;
    }

    //print functions
    public void printResult() {
        System.out.println("pld = " + pld
                + "\nwinTotal = " + winTotal
                + "\ndrawTotal = " + drawTotal
                + "\nlostTotal = " + lostTotal
                + "\nforTotal = " + forTotal
                + "\nagainstTotal = " + againstTotal
                + "\ndiff = " + diff
                + "\npts = " + pts);
    }

    public void printParameters() {
        System.out.println("winHome = " + winHome
                + "\ndrawHome = " + drawHome
                + "\nlostHome = " + lostHome
                + "\nforHome = " + forHome
                + "\nagainstHome = " + againstHome
                + "\nwinAway = " + winAway
                + "\ndrawAway = " + drawAway
                + "\nlostAway = " + lostAway
                + "\nforAway = " + forAway
                + "\nagainstAway = " + againstAway);
    }

    public static void main(String[] args) {
        Team Chelsea = new Team("Chelsea",17,0,2,55,17,13,3,3,30,16);
        Chelsea.updateForHome(10);
        Chelsea.updateAgainstHome(20);

        Chelsea.updateForAway(5);
        Chelsea.updateAgainstAway(10);

        Chelsea.printParameters();

        Chelsea.printResult();

    }
}
