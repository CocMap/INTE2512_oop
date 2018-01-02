package week5;

import javax.sound.midi.Track;
import java.util.Scanner;

public class ex5_Triangle extends SimpleGeometricObject {
    private double side1 = 1;
    private double side2 = 1;
    private double side3 = 1;

    public ex5_Triangle() {
    }

    public ex5_Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }

    public double getArea() {
        double s = (side1 + side2 + side3) /2;
        return Math.sqrt(s* (s - side1) * (s - side2) * (s - side3));
    }

    public double getPerimeter() {
        return side1+side2+side3;
    }

    @Override
    public String toString() {
        return "Triangle: side1 = " + side1 + " side2 = " + side2 + " side3 = " + side3;
    }

    public static void main(String[] args) {
        System.out.printf("Enter 3 sides of triangle: ");
        Scanner inSide1 = new Scanner(System.in);
        double side1 = inSide1.nextDouble();

        Scanner inSide2 = new Scanner(System.in);
        double side2 = inSide2.nextDouble();

        Scanner inSide3 = new Scanner(System.in);
        double side3 = inSide3.nextDouble();

        System.out.printf("Enter color: ");
        Scanner inColor = new Scanner(System.in);
        String color = inColor.next();

        System.out.printf("Filled? ");
        Scanner inFilled = new Scanner(System.in);
        Boolean filled = inFilled.nextBoolean();

        ex5_Triangle triangle = new ex5_Triangle(side1, side2, side3);

        System.out.printf("\nSet new color: ");
        Scanner inNewColor = new Scanner(System.in);
        String newColor = inNewColor.next();
        triangle.setColor(newColor);

        SimpleGeometricObject triangle0 = new SimpleGeometricObject("red", true);
        System.out.printf(triangle.toString());
        System.out.println(triangle0.toString());
    }
}

class SimpleGeometricObject {
    private String color = "white";
    private boolean filled;
    private java.util.Date dateCreated;

    //construct a default geometric object
    public SimpleGeometricObject() {
        dateCreated = new java.util.Date();
    }

    //Construct a geometric object with the specified color and filled value
    public SimpleGeometricObject(String color, boolean filled){
        dateCreated = new java.util.Date();
        this.color = color;
        this.filled = filled;
    }

    //get color
    public String getColor() {
        return color;
    }
    //set a new color
    public void setColor(String color){
        this.color = color;
    }
    //return filled, since filled is boolean, its get method is named isFilled()
    public boolean isFilled (boolean filled){
        return filled;
    }
    //set a new filled
    public void setFilled(boolean filled){
        this.filled = filled;
    }
    //get dateCreated
    public java.util.Date getDateCreated() {
        return dateCreated;
    }
    //return string representation of this object
    public String toString() {
        return "created on " + dateCreated + "\ncolor: " + color + " and filled: " + filled;
    }
}
