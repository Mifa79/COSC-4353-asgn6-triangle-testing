import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.lang.*;
import java.util.InputMismatchException;

public class Triangle {
    private double side1, side2, side3;
    private Point point1, point2, point3;
    private double semiPerimeter;
    private double area;

    public Triangle(double s1, double s2, double s3) {
        if ((s1 <= 0) || (s2 <=0) || (s3 <= 0))
            throw new InputMismatchException("invalid input");

        if (((s1 + s2) <= s3) || ((s2 + s3) <= s1) || ((s1 + s3) <= s2))
            throw new InputMismatchException("invalid input");

        side1 = s1;
        side2 = s2;
        side3 = s3;
    }

    public Triangle(Point pt1, Point pt2, Point pt3) {
        if (pt1.equals(pt2) || pt1.equals(pt3) || pt2.equals(pt3))
            throw new InputMismatchException("invalid input");

        // Compare the side length of the triangle to see if it is an invalid triangle
        if (calSide(pt1, pt2) + calSide(pt1, pt3) <= calSide(pt2, pt3) ||
                calSide(pt1, pt2) + calSide(pt2, pt3) <= calSide(pt1, pt3) ||
                calSide(pt1, pt3) + calSide(pt2, pt3) <= calSide(pt1, pt2))
            throw new InputMismatchException("invalid input");

        point1 = pt1;
        point2 = pt2;
        point3 = pt3;

        double side12 = calSide(point1, point2);
        double side13 = calSide(point1, point3);
        double side23 = calSide(point2, point3);

        side1 = side12;
        side2 = side13;
        side3 = side23;
    }

    public double calSide(Point pt1, Point pt2) {
        double sideSquare = (pt2.getX() - pt1.getX()) * (pt2.getX() - pt1.getX()) + (pt2.getY() - pt1.getY()) * (pt2.getY() - pt1.getY());
        double side = Math.pow(sideSquare, 0.5);
        return side;
    }


    public void defType() {
//        System.out.println(side1*side1);
//        System.out.println(side2*side2);
//        System.out.println(side3*side3);
        if (side1 == side2 && side2 == side3)
            System.out.println("The triangle is equilateral.");
        if ((side1 == side2 && side3 != side1) || (side2 == side3 && side1 != side2) || (side1 == side3 && side2 != side1))
            System.out.println("The triangle is isoceles.");
        if (side1 != side2 && side2 != side3 && side3 != side1)
            System.out.println("The triangle is scalene.");

        double side1Square = side1*side1;
        double side2Square = side2*side2;
        double side3Square = side3*side3;
        double truncatedSide1Square = BigDecimal.valueOf(side1Square).setScale(5, RoundingMode.HALF_UP).doubleValue();
        double truncatedSide2Square = BigDecimal.valueOf(side2Square).setScale(5, RoundingMode.HALF_UP).doubleValue();
        double truncatedSide3Square = BigDecimal.valueOf(side3Square).setScale(5, RoundingMode.HALF_UP).doubleValue();

        if ((truncatedSide1Square == truncatedSide2Square + truncatedSide3Square) ||
                (truncatedSide2Square == truncatedSide1Square + truncatedSide3Square) ||
                (truncatedSide3Square == truncatedSide1Square + truncatedSide2Square))
            System.out.println("The triangle is right.");
    }


    public double getSemiPerimeter() {
        semiPerimeter = (side1 + side2 + side3)/2;
        return semiPerimeter;
    }

    public double getArea() {
        this.getSemiPerimeter();
        double areaSquare = semiPerimeter * (semiPerimeter - side1) * (semiPerimeter - side2) * (semiPerimeter - side3);
        area = Math.pow(areaSquare, 0.5);
        return area;
    }
    
    public double getSide1(){
    	return side1;
    }
    
    public double getSide2() {
    	return side2;
    }
    
    public double getSide3() {
    	return side3;
    }


}