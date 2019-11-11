import java.util.*;
import java.io.*;


public class Main {
    public static void main (String[] args) throws IOException {

    	String result = calculateArea();
    	printResult(result);
    }
    
    public static String calculateArea() throws InputMismatchException {
    	 String result = "";
    	 
    	 Scanner keyboard = new Scanner(System.in);
         System.out.println("Please choose to enter the side lengths or the point coodinates of the triangle.");
         System.out.println("Enter 1 for sides, 2 for points: ");
         int method = keyboard.nextInt();
         

         if (method == 1) {
             System.out.println("Enter first side length: ");
             double side1 = keyboard.nextDouble();

             System.out.println("Enter second side length: ");
             double side2 = keyboard.nextDouble();

             System.out.println("Enter third side length: ");
             double side3 = keyboard.nextDouble();

             Triangle yourTriangle = new Triangle(side1, side2, side3);
             yourTriangle.defType();
             result = "The area of the triangle is: " + yourTriangle.getArea();
         }

         if (method == 2) {
             System.out.println("Enter x value of the first point: ");
             double x1 = keyboard.nextDouble();
             System.out.println("Enter y value of the first point: ");
             double y1 = keyboard.nextDouble();
             Point yourPoint1 = new Point(x1, y1);

             System.out.println("Enter x value of the second point: ");
             double x2 = keyboard.nextDouble();
             System.out.println("Enter y value of the second point: ");
             double y2 = keyboard.nextDouble();
             Point yourPoint2 = new Point(x2, y2);

             System.out.println("Enter x value of the third point: ");
             double x3 = keyboard.nextDouble();
             System.out.println("Enter y value of the third point: ");
             double y3 = keyboard.nextDouble();
             Point yourPoint3 = new Point(x3, y3);

             Triangle yourTriangle = new Triangle(yourPoint1, yourPoint2, yourPoint3);
             yourTriangle.defType();
             result = "The area of the triangle is: " + yourTriangle.getArea();
         }
    	 
    	 return result;
    }
    
    
    
    public static void printResult(String result) {
    	System.out.println(result);
    }
    
    
    
    public static double getNextDouble(String instruction, Scanner keyboard) {
    	System.out.println(instruction);
        double var = keyboard.nextDouble();
        return var;
    }


}
