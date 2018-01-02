//Acknowledgement:
//https://stackoverflow.com/questions/10734106/how-to-override-tostring-properly-in-java

package week4.Measures;

import java.lang.Math;

public class Weight {
    // data field of the class Weight
    private int weiTons;
    private int weiKg;
    private int weiGrams;
    // constants for converting tons to grams, tons to kilograms and kilograms to grams
    static final int TONS_TO_GRAMS = 1000000;
    static final int TONS_TO_KG = 1000;
    static final int KG_TO_GRAMS = 1000;

    // a constructor with no arguments (create the objects which the Weight set to zero)
    public Weight() {
        weiKg = 0;
        weiTons = 0;
        weiGrams = 0;
    }

    // a constructor takes three int arguments tons, kilograms, grams.
    // 3tons 1900kg 1055grams = 5tons
    public Weight(int tons, int kilograms, int grams) {
        weiTons = tons + kilograms / TONS_TO_KG + grams /TONS_TO_GRAMS;
        weiKg = kilograms % TONS_TO_KG + (grams % TONS_TO_GRAMS) / KG_TO_GRAMS;
        weiGrams = grams % TONS_TO_GRAMS % KG_TO_GRAMS;
    }

    // a constructor takes an int arguments grams.
    /* public Weight(int grams) {
        weiGrams = grams % TONS_TO_GRAMS % KG_TO_GRAMS;
        weiKg = grams % TONS_TO_GRAMS / KG_TO_GRAMS;
        weiTons = grams / TONS_TO_GRAMS;
    }*/

    // a constructor takes a double arguments kilograms (this is use for the calculating the carpets weight later
    public Weight(double kilograms) {
        weiTons = (int) kilograms / TONS_TO_KG;
        weiKg = (int) kilograms % TONS_TO_KG;
        weiGrams = (int) ( Math.round((kilograms - (int) kilograms) * KG_TO_GRAMS));
    }

    // return a String representation of the Object.
    @Override
    public String toString() {
        return weiTons + " tons " + weiKg + " kg " + weiGrams + " grams";
    }

    // convert all the measures to Grams
    public int convertToGrams() {
        return weiTons * TONS_TO_GRAMS + weiKg * KG_TO_GRAMS + weiGrams;
    }

    // convert all the measures to Kilograms
    public double convertToKg() {
        return weiTons * TONS_TO_KG + weiKg + weiGrams / 1000.0;
    }
    public double convertToTons(){
        return weiTons + weiKg/1000.0 + weiGrams/1000000.0;
    }
    //Addition:
    public Weight add(Weight Obj) {
        int totalMeter = weiTons + Obj.weiTons;
        int totalCenti = weiKg + Obj.weiKg;
        int totalMili = weiGrams + Obj.weiGrams;
        Weight addition = new Weight(totalMeter, totalCenti, totalMili);
        return addition;
    }

    // Subtraction - print the difference between the Weights of the objects
    // avoid the negative number using the absolute, so the final result will be the difference between two Weights
    // uncomment below code if there is the constructor Weight(int grams)
    /*public Weight Subtract(Weight Obj) {
        int a = this.convertToMm();
        int b = Obj.convertToMm();
        int diff = Math.abs(a - b);
        Weight subtraction = new Weight(diff);
        return subtraction;
    }*/
    public Weight Subtract(Weight Obj){
        int a = this.convertToGrams();
        int b = Obj.convertToGrams();
        int diff = Math.abs(a - b);
        Weight subtraction =  new Weight();
        subtraction.weiGrams = diff % TONS_TO_GRAMS % KG_TO_GRAMS;
        subtraction.weiKg = diff % TONS_TO_GRAMS / KG_TO_GRAMS;
        subtraction.weiTons = diff / TONS_TO_GRAMS;
        return subtraction;
    }

    // divide integer. return the round value
    // use the code with if there is the constructor Weight(double kilograms)
    /*public Weight DivideInteger(int i) {
        double a = this.convertToKg();
        double div = a / i;
        Weight division = new Weight(div);
        return division;
    } */
    public Weight divideInteger(int i){
        Weight division  = new Weight();
        double a = this. convertToKg();
        double result = a / i;
        division.weiTons = (int) result/ TONS_TO_KG;
        division.weiKg = (int) result % TONS_TO_KG;
        division.weiGrams = (int) ( Math.round((result - (int) result) * KG_TO_GRAMS));
        return division;
    }
    // multiply integer
    // use this code when there is the constructor Weight(int grams)
    /*public Weight MultiplyInteger(int i) {
        int a = this.convertToMm();
        int mul = a * i;
        Weight multiplication = new Weight(mul);
        return multiplication;
    }*/
    public Weight multiplyInteger(int i){
        int a = this.convertToGrams();
        int mul = a * i;
        Weight multiplication = new Weight();
        multiplication.weiGrams = mul % TONS_TO_GRAMS % KG_TO_GRAMS;
        multiplication.weiKg = mul % TONS_TO_GRAMS / KG_TO_GRAMS;
        multiplication.weiTons = mul / TONS_TO_GRAMS;
        return multiplication;
    }

    // calculate the product of two weights
    public double productOfTwoWeights (Weight Obj) {
        double a = this.convertToTons();
        double b = Obj.convertToTons();
        double result = a * b;
        return result ;
    }
    public double multiplyDouble(double d){
        double a = this.convertToKg();
        double result = a*d;
        return result;
    }
    //Compare two Weight
    public void Compare(Weight Obj) {
        int a = this.convertToGrams();
        int b = Obj.convertToGrams();
        if (a > b) System.out.println("The Weight of " + this.toString() + " is greater than the Weight of "
                + Obj.toString() + " (greater than " + this.Subtract(Obj) + ") ");
        else if (a < b) System.out.println("The Weight of " + this.toString() + " is smaller than the Weight of "
                + Obj.toString() + " (smaller than " + this.Subtract(Obj) + ")");
        else System.out.println("Two Weights are equal (" + this.toString() + ")");
    }


    // main method
    public static void main(String[] args) {
        System.out.println("TESTING PROGRAM: ");
        Weight Weight1 = new Weight(3, 1900, 1055);
        Weight Weight2 = new Weight(0, 900,0);
        Weight Weight3 = new Weight();
        System.out.println("Print the features of Weight1, Weight2, Weight3");
        System.out.println("Weight 1's measure is: " + Weight1.toString());
        System.out.println("Weight 2's measure is: " + Weight2.toString());
        System.out.println("Weight 3's measure is: " + Weight3.toString());
        System.out.println("\nTesting functionality:");
        // product of Weight 1 and Weight 2. expect:
        System.out.printf("The product of Weight 1 and Weigth 2 is %2.3f tons\n", Weight1.productOfTwoWeights(Weight2) );
        // addition of Weight 1 and Weight 2. expect:
        System.out.println("Addition of Weight 1 and Weight 2: " + Weight2.add(Weight1));
        // subtraction of Weight 1 and Weight 2. expect:
        System.out.println("Difference between Weight 1 and Weight 2 is: " + Weight2.Subtract(Weight1));
        // division of Weight 3 and 5. expect:
        System.out.println("Weight 3 divide 5: " + Weight3.divideInteger(5));
        // multiplication of Weight 3 and 3. expect:
        System.out.println("Weight 3 multiply 3: " + Weight3.multiplyInteger(3));
        // comparision of Weight 3 and Weight 2. expect Weight 3
        System.out.println("Compare Weight 3 and Weight 2: " );
        Weight3.Compare(Weight2);

    }
}
