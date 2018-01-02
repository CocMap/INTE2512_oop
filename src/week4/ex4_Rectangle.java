package week4;

import java.util.Scanner;

public class ex4_Rectangle {
    static class Rectangle {
        double width = 1;
        double height = 1;

        public Rectangle(){             //create default rectangle
            width = 1;
            height = 1;
        }

        public Rectangle (double width, double height){
            this.width = width;
            this.height = height;
        }

        public double getArea() {
            return width * height;
        }

        public double getPerimeter() {
            return width + height;
        }
    }

    public static void main(String[] args) {
        while(true) {
            System.out.printf("Enter width: ");
            Scanner widthInput = new Scanner(System.in);
            double width = widthInput.nextDouble();

            System.out.printf("Enter height: ");
            Scanner heightInput = new Scanner(System.in);
            double height = heightInput.nextDouble();

            Rectangle rectangle = new Rectangle(width, height);
            System.out.println("Width = " + rectangle.width + "\n"
                    + "Height = " + rectangle.height + "\n"
                    + "Area = " + rectangle.getArea() + "\n"
                    + "Perimeter = " + rectangle.getPerimeter() + "\n");
        }
    }
}