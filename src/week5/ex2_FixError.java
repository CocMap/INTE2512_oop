package week5;

public class ex2_FixError {

}
class Circle {
    private double radius;
    public Circle(double radius){
        this.radius = radius;
    }

    public double getRadius(){
        return radius;
    }

    public double getArea(){
        return radius * radius * Math.PI;
    }
}

class B3 extends Circle {
    private double length;

    //added
    public B3(double radius, double length) {
        super(radius);
        this.length = length;
    }

    public double getArea() {
        return getArea() * length;
    }
}

