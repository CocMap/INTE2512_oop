package week4;
import week4.Measures.*;

public class ex8_CarpetsCalculation {
    public static void main(String[] args) {
        // calculation for 200 carpets:
        System.out.println("FIRST CALCULATION: ");
        Length widthCarpet1 = new Length(4,0,0);
        Length heighCarpet1 = new Length(2, 9 ,0);
        Weight weiCarpet1 = new Weight(1.25);
        System.out.println("200 carpets: \nsize:(4 meters) by (2 meters 9 centimeters)" +
                "\nweight: 1.25 kilograms per square meter.");
        double areaOfOneCarpet1 = widthCarpet1.Area(heighCarpet1);
        double weightOfOneCarpet1 = weiCarpet1.multiplyDouble(areaOfOneCarpet1);
        System.out.println("Area of one carpet: "+ areaOfOneCarpet1 + " square meter");
        System.out.println("Weight0 of one carpet: " + weightOfOneCarpet1+ " kilograms");
        System.out.printf("Weight0 of 200 carpets: %2.3f kilograms\n\n", weightOfOneCarpet1*200);

        // calculation for 60 carpets
        System.out.println("SECOND CALCULATION: ");
        Length widthCarpet2 = new Length(3,57,0);
        Length heighCarpet2 = new Length(5, 0 ,0);
        Weight weiCarpet2 = new Weight(1.05);
        System.out.println("60 carpets: \nsize:(3 meters 57 centimeters) by (5 meters)" +
                "\nweight: 1.05 kilograms per square meter.");
        double areaOfOneCarpet2 = widthCarpet1.Area(heighCarpet1);
        double weightOfOneCarpet2 = weiCarpet1.multiplyDouble(areaOfOneCarpet2);
        System.out.println("Area of one carpet: "+ areaOfOneCarpet2 + " square meter");
        System.out.println("Weight0 of one carpet: " + weightOfOneCarpet2+ " kilograms");
        System.out.printf("Weight0 of 60 carpets: %2.3f kilograms", weightOfOneCarpet2*60 );
    }
}
