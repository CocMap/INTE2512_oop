package week4;

import java.util.Scanner;

public class ex7_Location {
    static class Location {
        public int row, col;
        public double maxValue;

        public Location(int row, int col, double maxValue) {
            this.row = row;
            this.col = col;
            this.maxValue = maxValue;
        }

        public static Location locateLargest(double[][] a) {
            int maxRow = 0;
            int maxCol = 0;
            double maxValue = a[0][0];
            for (int i = 0; i < a.length; i++){                         //i = a.length = row
                for(int j = 0; j < a[i].length; j++){                   //j = a[i].length = column
                    if(maxValue <=  a[i][j]){
                        maxRow = i;
                        maxCol = j;
                        maxValue = a[i][j];
                    }
                }
            }
            return new Location(maxRow, maxCol, maxValue);
        }
    }

    public static void main(String[] args) {
        System.out.printf("Enter the number of rows and columns in the array: ");
        Scanner inputArrSize = new Scanner(System.in);
        String[] strSize = inputArrSize.nextLine().split(" ");

        int row = Integer.parseInt(strSize[0]);
        int col = Integer.parseInt(strSize[1]);
        double[][] a = new double[row][col];

        //insert the content of array
        System.out.println("Enter the array: ");
        for(int i = 0; i < row; i++) {
            Scanner inputArrContent = new Scanner(System.in);
            String[] strContent = inputArrContent.nextLine().split(" ");
            for (int j = 0; j < col; j++){
                a[i][j] = Double.parseDouble(strContent[j]);
            }
        }

        Location result = Location.locateLargest(a);

        System.out.println("The location of the largest element is " + result.maxValue +
                            " at " + "(" + result.row + ", " + result.col + ")");
    }
}


