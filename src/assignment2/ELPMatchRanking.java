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
import static assignment2.functions.*;

import java.io.*;
import java.net.URL;
import java.util.*;

public class ELPMatchRanking {
    public static void main(String[] args) throws Exception {
        //--------------------data field initialization--------------------
        //global vars - initialization
        int countLine = 0;
        int scoreHome = 0;
        int scoreAway = 0;

        //team vars
        String[] teamName = {"Chelsea FC", "Arsenal FC", "Tottenham Hotspur", "West Ham United", "Crystal Palace",
                "Manchester United", "Manchester City", "Everton FC", "Liverpool FC", "West Bromwich Albion",
                "Newcastle United", "Stoke City", "Southampton FC", "Leicester City", "AFC Bournemouth",
                "Watford FC", "Brighton & Hove Albion", "Burnley FC", "Huddersfield Town", "Swansea City"};
        int teamLength = teamName.length;
        Integer[] descedingOrder = new Integer[teamLength];

        //teamObjects vars
        Team[] teamObject = new Team[teamLength];
        for (int i = 0; i < 20; i++) {
            teamObject[i] = new Team();
            teamObject[i].setName(teamName[i]);
        }
        int refLeft = 0;
        int refRight = 0;

        //--------------------step 1: read file from https--------------------
        //test local
//        URL path = ELPMatchRanking.class.getResource("1-premierleague-i.txt");
//        Scanner scan = new Scanner(path.openStream());

        //read txt file from internet
        Scanner scan = null;
        try {
        URL url = new URL("https://raw.githubusercontent.com/openfootball/eng-england/master/2017-18/1-premierleague-i.txt");
        scan = new Scanner(url.openStream());
        } catch (IOException e){
            //check if connection problem occurs or not existing file
            e.printStackTrace();                //print out the error on console
        }

        //--------------------step 2: filter unnecessary line--------------------
        String[] monthList = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

        //find last line to read (up to current day) - ignore the rest
        Date today = new Date();
        String currentMonth = monthList[today.getMonth()];
        int currentDay = today.getDate();

        //scan line by line
        while (scan.hasNext()) {
            String line = scan.nextLine();
            countLine++;

            //----------step 3: put the condition to read the correct info----------
            //split the line into leftPart and rightPart
            String left = getLeftRight(line, true);
            String right = getLeftRight(line, false);

            //condition to end (no need to get data anymore)
            if (line.contains(currentMonth)) {
                //take month from txt file
                String month = getData(line, currentMonth + "/", "]");
                if (!month.equals("no return")) {
                    int lastMatchDay = Integer.parseInt(month);
                    String lastMatchMonth = getData(line, " ", "/");

                    if (lastMatchMonth.equals(currentMonth) && lastMatchDay > currentDay)
                        break;  //don't read line anymore

                }
            } else if (!line.contains("-"))                 //ignore no info contained line
                continue;

                //----------step 4: extract left, right, homeScore, awayScore, leftName, rightName----------
                //----------START TO EXTRACT DATA HERE----------
            else {
                for (int i = 0; i < teamLength; i++) {
                    //shorten the team name for better search/match/split
                    String cutName = teamName[i].replaceAll("\\s", "");

                    //if leftPart/rightPart contains shorten name of FC team,
                    //get the nameHome and scoreHome
                    //refLeft is used to track back the index in teamName[]
                    //refLeft is recorded if cutName is matched
                    //scoreName is extracted by getScore()
                    if (left.contains(cutName)) {
                        refLeft = i;
                        scoreHome = getScore(left, cutName, true);

//                        System.out.println(" -scoreLeft " + scoreHome);
                    }

                    //get the nameAway and scoreAway
                    if (right.contains(cutName)) {
                        refRight = i;
                        scoreAway = getScore(right, cutName, false);

//                        System.out.println(" -scoreRight " + scoreAway);
                    }
                }

                //----------step 5: calculate all parameters of object----------
                //winHome, drawHome, lostHome, forHome, againstHome
                //winAway, drawAway, lostAway, forAway, againstAway
                if (scoreHome > scoreAway) {
                    //update winHome and lostAway
                    teamObject[refLeft].updateWinHome();
                    teamObject[refRight].updateLostAway();

                    //update forHome and againstAway
                    teamObject[refLeft].updateForHome(scoreHome);
                    teamObject[refLeft].updateAgainstHome(scoreAway);
                    teamObject[refRight].updateAgainstAway(scoreHome);
                    teamObject[refRight].updateForAway(scoreAway);

                } else if (scoreHome == scoreAway) {
                    //update drawHome and drawAway
                    teamObject[refLeft].updateDrawHome();
                    teamObject[refRight].updateDrawAway();

                    //update forHome and awayHome
                    teamObject[refLeft].updateForHome(scoreHome);
                    teamObject[refRight].updateForAway(scoreAway);

                } else if (scoreHome < scoreAway) {
                    //update lostHome and winAway
                    teamObject[refLeft].updateLostHome();
                    teamObject[refRight].updateWinAway();

                    //update againstHome and forAway
                    teamObject[refLeft].updateForHome(scoreHome);
                    teamObject[refLeft].updateAgainstHome(scoreAway);
                    teamObject[refRight].updateForAway(scoreAway);
                    teamObject[refRight].updateAgainstAway(scoreHome);
                }
            }
        }
        //----------step 6: update all parameters (total, pld, pts and others)----------
        for (int i = 0; i < teamLength; i++)
            teamObject[i].updateAll();

        //----------step 7: sort pts in descending order----------

        for (int i = 0; i < teamLength; i++){
            descedingOrder[i] = teamObject[i].getPts();
        }
        Arrays.sort(descedingOrder, Collections.reverseOrder());

        List<String> sortedName = new ArrayList<String>();
        while(sortedName.size() <= teamLength){
            for(int i = 0; i < teamLength; i++)
                for(int j = 0; j < teamLength; j++)
                    if (teamObject[j].getPts() == descedingOrder[i])
                        sortedName.add(teamObject[j].getName());
        }

        //sorted pld
        List<Integer> sortedPld = new ArrayList<Integer>();
        while(sortedPld.size() <= teamLength){
            for(int i = 0; i < teamLength; i++)
                for(int j = 0; j < teamLength; j++)
                    if (teamObject[j].getPts() == descedingOrder[i])
                        sortedPld.add(teamObject[j].getPld());
        }

        //sorted winTotal
        List<Integer> sortedWinTotal = new ArrayList<Integer>();
        while(sortedWinTotal.size() <= teamLength){
            for(int i = 0; i < teamLength; i++)
                for(int j = 0; j < teamLength; j++)
                    if (teamObject[j].getPts() == descedingOrder[i])
                        sortedWinTotal.add(teamObject[j].getWinTotal());
        }

        //sorted drawTotal
        List<Integer> sortedDrawTotal = new ArrayList<Integer>();
        while(sortedDrawTotal.size() <= teamLength){
            for(int i = 0; i < teamLength; i++)
                for(int j = 0; j < teamLength; j++)
                    if (teamObject[j].getPts() == descedingOrder[i])
                        sortedDrawTotal.add(teamObject[j].getDrawTotal());
        }

        //sorted lostTotal
        List<Integer> sortedLostTotal = new ArrayList<Integer>();
        while(sortedLostTotal.size() <= teamLength){
            for(int i = 0; i < teamLength; i++)
                for(int j = 0; j < teamLength; j++)
                    if (teamObject[j].getPts() == descedingOrder[i])
                        sortedLostTotal.add(teamObject[j].getLostTotal());
        }

        //sorted forTotal
        List<Integer> sortedForTotal = new ArrayList<Integer>();
        while(sortedForTotal.size() <= teamLength)
            for(int i = 0; i < teamLength; i++)
                for(int j = 0; j < teamLength; j++) {
                    if (teamObject[j].getPts() == descedingOrder[i])
                        sortedForTotal.add(teamObject[j].getForTotal());
        }

        //sorted AgainstTotal
        List<Integer> sortedAgainstTotal = new ArrayList<Integer>();
        while(sortedAgainstTotal.size() <= teamLength){
            for(int i = 0; i < teamLength; i++)
                for(int j = 0; j < teamLength; j++)
                    if (teamObject[j].getPts() == descedingOrder[i])
                        sortedAgainstTotal.add(teamObject[j].getAgainstTotal());
        }

        //sorted diff
        List<String> sortedDiff = new ArrayList<String>();
        while(sortedDiff.size() <= teamLength)
            for(int i = 0; i < teamLength; i++)
                for(int j = 0; j < teamLength; j++) {
                    if (teamObject[j].getPts() == descedingOrder[i])
                        sortedDiff.add(teamObject[j].getDiff());
        }

        //sorted winHome
        List<Integer> sortedWinHome = new ArrayList<Integer>();
        while(sortedWinHome.size() <= teamLength)
            for(int i = 0; i < teamLength; i++)
                for(int j = 0; j < teamLength; j++) {
                    if (teamObject[j].getPts() == descedingOrder[i])
                        sortedWinHome.add(teamObject[j].getWinHome());
        }

        //sorted drawHome
        List<Integer> sortedDrawHome = new ArrayList<Integer>();
        while(sortedDrawHome.size() <= teamLength){
            for(int i = 0; i < teamLength; i++)
                for(int j = 0; j < teamLength; j++)
                    if (teamObject[j].getPts() == descedingOrder[i])
                        sortedDrawHome.add(teamObject[j].getDrawHome());
        }

        //sorted lostHome
        List<Integer> sortedLostHome = new ArrayList<Integer>();
        while(sortedLostHome.size() <= teamLength){
            for(int i = 0; i < teamLength; i++)
                for(int j = 0; j < teamLength; j++)
                    if (teamObject[j].getPts() == descedingOrder[i])
                        sortedLostHome.add(teamObject[j].getLostHome());
        }

        //sorted forHome
        List<Integer> sortedForHome = new ArrayList<Integer>();
        while(sortedForHome.size() <= teamLength){
            for(int i = 0; i < teamLength; i++)
                for(int j = 0; j < teamLength; j++)
                    if (teamObject[j].getPts() == descedingOrder[i])
                        sortedForHome.add(teamObject[j].getForHome());
        }

        //sorted againstHome
        List<Integer> sortedAgainstHome = new ArrayList<Integer>();
        while(sortedAgainstHome.size() <= teamLength){
            for(int i = 0; i < teamLength; i++)
                for(int j = 0; j < teamLength; j++)
                    if (teamObject[j].getPts() == descedingOrder[i])
                        sortedAgainstHome.add(teamObject[j].getAgainstHome());
        }

        //sorted winAway
        List<Integer> sortedWinAway = new ArrayList<Integer>();
        while(sortedWinAway.size() <= teamLength){
            for(int i = 0; i < teamLength; i++)
                for(int j = 0; j < teamLength; j++)
                    if (teamObject[j].getPts() == descedingOrder[i])
                        sortedWinAway.add(teamObject[j].getWinAway());
        }

        //sorted drawAway
        List<Integer> sortedDrawAway = new ArrayList<Integer>();
        while(sortedDrawAway.size() <= teamLength){
            for(int i = 0; i < teamLength; i++)
                for(int j = 0; j < teamLength; j++)
                    if (teamObject[j].getPts() == descedingOrder[i])
                        sortedDrawAway.add(teamObject[j].getDrawAway());
        }

        //sorted lostAway
        List<Integer> sortedLostAway = new ArrayList<Integer>();
        while(sortedLostAway.size() <= teamLength){
            for(int i = 0; i < teamLength; i++)
                for(int j = 0; j < teamLength; j++)
                    if (teamObject[j].getPts() == descedingOrder[i])
                        sortedLostAway.add(teamObject[j].getLostAway());
        }

        //sorted forAway
        List<Integer> sortedForAway = new ArrayList<Integer>();
        while(sortedForAway.size() <= teamLength){
            for(int i = 0; i < teamLength; i++)
                for(int j = 0; j < teamLength; j++)
                    if (teamObject[j].getPts() == descedingOrder[i])
                        sortedForAway.add(teamObject[j].getForAway());
        }



        //sorted againstAway
        List<Integer> sortedAgainstAway = new ArrayList<Integer>();
        while(sortedAgainstAway.size() <= teamLength){
            for(int i = 0; i < teamLength; i++)
                for(int j = 0; j < teamLength; j++)
                    if (teamObject[j].getPts() == descedingOrder[i])
                        sortedAgainstAway.add(teamObject[j].getAgainstAway());
        }

        //----------step 8: write to standings.txt----------
        System.out.println("\t\t\t\t\t\t\t\t\t\t - Total - \t\t\t\t\t - Home - \t\t\t - Away -");
        System.out.println("\t\t\t\t\t\t\t Pld   W   D   L   F:A      +/-   Pts   W   D   L    F:A     W   D   L   F:A");

        String formatStr = "%-28s %-5s %-3s %-3s %-3s %-8s %-5s %-5s %-3s %-3s %-3s %-8s %-3s %-3s %-3s %-3s %n";
        for (int i = 1; i <= teamLength; i++){
            System.out.println(String.format(formatStr,i + ". " + sortedName.get(i-1),
                    sortedPld.get(i-1),
                    sortedWinTotal.get(i-1),
                    sortedDrawTotal.get(i-1),
                    sortedLostTotal.get(i-1),
                    sortedForTotal.get(i-1) + ":" + sortedAgainstTotal.get(i-1),
                    sortedDiff.get(i-1),
                    descedingOrder[i-1],
                    sortedWinHome.get(i-1),
                    sortedDrawHome.get(i-1),
                    sortedLostHome.get(i-1),
                    sortedForHome.get(i-1) + ":" + sortedAgainstHome.get(i-1),
                    sortedWinAway.get(i-1),
                    sortedDrawAway.get(i-1),
                    sortedLostAway.get(i-1),
                    sortedForAway.get(i-1)  + ":" + sortedAgainstAway.get(i-1)));
        }
        PrintWriter writer = new PrintWriter("standings.txt", "UTF-8");
        writer.println("\t\t\t\t\t\t\t\t\t\t - Total - \t\t\t\t\t - Home - \t\t\t - Away -");
        writer.println("\t\t\t\t\t\t\t Pld   W   D   L   F:A      +/-   Pts   W   D   L    F:A     W   D   L   F:A");

        for (int i = 1; i <= teamLength; i++){
            writer.println(String.format(formatStr,i + ". " + sortedName.get(i-1),
                    sortedPld.get(i-1),
                    sortedWinTotal.get(i-1),
                    sortedDrawTotal.get(i-1),
                    sortedLostTotal.get(i-1),
                    sortedForTotal.get(i-1) + ":" + sortedAgainstTotal.get(i-1),
                    sortedDiff.get(i-1),
                    descedingOrder[i-1],
                    sortedWinHome.get(i-1),
                    sortedDrawHome.get(i-1),
                    sortedLostHome.get(i-1),
                    sortedForHome.get(i-1) + ":" + sortedAgainstHome.get(i-1),
                    sortedWinAway.get(i-1),
                    sortedDrawAway.get(i-1),
                    sortedLostAway.get(i-1),
                    sortedForAway.get(i-1)  + ":" + sortedAgainstAway.get(i-1)));
        }
        writer.close();
    }
}
