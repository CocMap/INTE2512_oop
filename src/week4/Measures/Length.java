//Acknowledgement:
//https://stackoverflow.com/questions/10734106/how-to-override-tostring-properly-in-java

package week4.Measures;

import java.lang.Math;

public class Length {
    // data field of the class Length
    private int lenMeter;
    private int lenCentimeter;
    private int lenMilimeter;
    // constants for converting meter to milimeter, meter to centimeter and centimeter to milimeter
    static final int MET_TO_MILI = 1000;
    static final int MET_TO_CENTI = 100;
    static final int CENTI_TO_MILI = 10;

    // a constructor with no arguments (create the objects which the length set to zero)
    public Length() {
        lenCentimeter = 0;
        lenMeter = 0;
        lenMilimeter = 0;
    }

    // a constructor takes three int arguments meter, centimeter, milimeter.
    // 3m 190cm 1055mm = 5m 95cm 5mm
    public Length(int meter, int centimeter, int milimeter) {
        lenMeter = meter + centimeter / MET_TO_CENTI + milimeter / MET_TO_MILI;
        lenCentimeter = centimeter % MET_TO_CENTI + (milimeter % MET_TO_MILI) / CENTI_TO_MILI;
        lenMilimeter = milimeter % MET_TO_MILI % CENTI_TO_MILI;
    }

    // a constructor takes an int arguments milimeters.
    /* public Length(int milimeter) {
        lenMilimeter = milimeter % MET_TO_MILI % CENTI_TO_MILI;
        lenCentimeter = milimeter % MET_TO_MILI / CENTI_TO_MILI;
        lenMeter = milimeter / MET_TO_MILI;
    } */

    // a constructor takes a double arguments centimeters
    /* public Length(double centimeter) {
        lenMeter = (int) centimeter / MET_TO_CENTI;
        lenCentimeter = (int) centimeter % MET_TO_CENTI;
        lenMilimeter = (int) ( Math.round((centimeter - (int) centimeter) * CENTI_TO_MILI));
    } */

    // return a String representation of the Object.
    @Override
    public String toString() {
        return lenMeter + "m " + lenCentimeter + "cm " + lenMilimeter + " mm";
    }

    // convert all the measures to milimeter
    public int convertToMm() {
        return lenMeter * MET_TO_MILI + lenCentimeter * CENTI_TO_MILI + lenMilimeter;
    }

    // convert all the measures to centimeter
    public double convertToCm() {
        return lenMeter * MET_TO_CENTI + lenCentimeter + lenMilimeter / 10.0;
    }

    //Addition:
    public Length add(Length Obj) {
        int totalMeter = lenMeter + Obj.lenMeter;
        int totalCenti = lenCentimeter + Obj.lenCentimeter;
        int totalMili = lenMilimeter + Obj.lenMilimeter;
        Length addition = new Length(totalMeter, totalCenti, totalMili);
        return addition;
    }

    // Subtraction - print the difference between the lengths of the objects
    // avoid the negative number using the absolute, so the final result will be the difference between two lengths
    // uncomment this code if there is the constructor Length(int milimeter)
    /*public Length Subtract(Length Obj) {
        int a = this.convertToMm();
        int b = Obj.convertToMm();
        int diff = Math.abs(a - b);
        Length subtraction = new Length(diff);
        return subtraction;
    }*/
    public Length Subtract(Length Obj){
        int a = this.convertToMm();
        int b = Obj.convertToMm();
        int diff = Math.abs(a - b);
        Length subtraction =  new Length();
        subtraction.lenMilimeter = diff % MET_TO_MILI % CENTI_TO_MILI;
        subtraction.lenCentimeter = diff % MET_TO_MILI / CENTI_TO_MILI;
        subtraction.lenMeter = diff / MET_TO_MILI;
        return subtraction;
    }

    // divide integer. return the round value
    // use the code with if there is the constructor Length(double centimeter)
    /*public Length DivideInteger(int i) {
        double a = this.convertToCm();
        double div = a / i;
        Length division = new Length(div);
        return division;
    }*/
    public Length DivideInteger(int i){
        Length division  = new Length();
        double a = this. convertToCm();
        double result = a / i;
        division.lenMeter = (int) result/ MET_TO_CENTI;
        division.lenCentimeter = (int) result % MET_TO_CENTI;
        division.lenMilimeter = (int) ( Math.round((result - (int) result) * CENTI_TO_MILI));
        return division;
    }
    // multiply integer
    // use this code when there is the constructor Length(int millimeter)
    /*public Length MultiplyInteger(int i) {
        int a = this.convertToMm();
        int mul = a * i;
        Length multiplication = new Length(mul);
        return multiplication;
    }*/
    public Length MultiplyInteger(int i){
        int a = this.convertToMm();
        int mul = a * i;
        Length multiplication = new Length();
        multiplication.lenMilimeter = mul % MET_TO_MILI % CENTI_TO_MILI;
        multiplication.lenCentimeter = mul % MET_TO_MILI / CENTI_TO_MILI;
        multiplication.lenMeter = mul / MET_TO_MILI;
        return multiplication;
    }

    // calculate the area in square meter
    public double Area(Length Obj) {
        int a = this.convertToMm();
        int b = Obj.convertToMm();
        double result = a * b;
        return result / 1000000.0;
    }

    //Compare two length
    public void Compare(Length Obj) {
        int a = this.convertToMm();
        int b = Obj.convertToMm();
        if (a > b) System.out.println("The length of " + this.toString() + " is greater than the length of "
                + Obj.toString() + " (greater than " + this.Subtract(Obj) + ") ");
        else if (a < b) System.out.println("The length of " + this.toString() + " is smaller than the length of "
                + Obj.toString() + " (smaller than " + this.Subtract(Obj) + ")");
        else System.out.println("Two lengths are equal (" + this.toString() + ")");
    }


    // main method
    public static void main(String[] args) {
        System.out.println("TESTING PROGRAM: ");
        Length length1 = new Length(3, 190, 1055);
        Length length2 = new Length();
        Length length3 = new Length(10, 89, 88);
        System.out.println("Print the features of Length1, Length2, Length3");
        System.out.println("Length 1's measure is: " + length1.toString());
        System.out.println("Length 2's measure is: " + length2.toString());
        System.out.println("Length 3's measure is: " + length3.toString());
        System.out.println("\nTesting functionality:");
        // area of length 1 and length 2. expect: 70.33 square meter
        System.out.println("The area which is the product of Length 1 and Length 2 is " + length1.Area(length2) + " square meter");
        // addition of length 1 and length 2. expect: 17m 76cm 6mm
        System.out.println("Addition of Length 1 and Length 2: " + length2.add(length1));
        // subtraction of length 1 and length 2. expect: 5856 mm = 5m 85cm 6mm
        System.out.println("Difference between Length 1 and Length 2 is: " + length2.Subtract(length1));
        // division of length 3 and 5. expect: 6.8 = 7 mm
        System.out.println("Length 3 divide 5: " + length3.DivideInteger(5));
        // multiplication of length 3 and 3. expect: 102mm = 10 cm 2mm
        System.out.println("Length 3 multiply 3: " + length3.MultiplyInteger(3));
        // comparision of length 3 and length 2. expect length 3 is smaller than length 2
        System.out.println("Compare Length 3 and Length 2: " );
        length3.Compare(length2);

    }
}
