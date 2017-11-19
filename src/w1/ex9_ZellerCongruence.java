/*
Zeller’s congruence is an algorithm developed by Christian Zeller to calculate the day of the week. The formula is:
https://docs.google.com/document/d/1n6Ek0RLjDal6Om_VUrum5usHzh76jOudfc7cUcpejdA/edit

where
h is the day of the week (0: Saturday, 1: Sunday, 2: Monday, 3: Tuesday, 4: Wednesday, 5: Thursday, 6: Friday).
q is the day of the month.
m is the month (3: March, 4: April, . . ., 12: December). January and February are counted as months 13 and 14 of the previous year.
j is the century (i.e.  year1000 ).
k is the year of the century (i.e., year % 100).
 */
package w1;

import java.util.Scanner;

public class ex9_ZellerCongruence {
    public static void main(String[] args) {
        while (true) {
            //YEAR
            System.out.printf("Enter year: (e.g., 2012): ");
            Scanner yearInput = new Scanner(System.in);
            int k = yearInput.nextInt() % 100;

            //MONTH
            System.out.printf("Enter month: 1-12: ");
            Scanner monthInput = new Scanner(System.in);
            int m = monthInput.nextInt();

            //DAY OF MONTH
            System.out.printf("Enter the day of the month: 1-31: ");
            Scanner dayInput = new Scanner(System.in);
            int q = dayInput.nextInt();

            //CENTURY
            int j = k / 1000;

            //convert YEAR and JAN, FEB (special case - reading the spec)
            if(m == 1 || m == 2){
                k -= 1;                 //convert to previous year
                m += 12;                //convert Jan->13 and Feb->14
            }


            //Zeller's congruence to calculate the day of the week
            int h = ((q + ((26 * (m + 1)) / 10) + k + k / 4 + j / 4 + 5 * j) % 7);

            //convert h to Mon-Sun
            String dayOfWeek;
            switch (h) {
                case 0:
                    dayOfWeek = "Saturday";
                    break;
                case 1:
                    dayOfWeek = "Sunday";
                    break;
                case 2:
                    dayOfWeek = "Monday";
                    break;
                case 3:
                    dayOfWeek = "Tuesday";
                    break;
                case 4:
                    dayOfWeek = "Wednesday";
                    break;
                case 5:
                    dayOfWeek = "Thursday";
                    break;
                case 6:
                    dayOfWeek = "Friday";
                    break;
                default:
                    dayOfWeek = "Invalid";
                    break;
            }

            //print out the result
            System.out.println("Day of the week is " + dayOfWeek + "\n");
        }
    }
}
