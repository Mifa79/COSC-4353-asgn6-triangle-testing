import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.InputMismatchException;
import org.junit.Test;

public class TriangleTest {
	Point point1 = new Point(0, 0);
	Point point2 = new Point(0, 2);
	Point point3 = new Point(2, 0);
	double side1 = 2;
	double side2 = 2;
	double side3 = Math.pow((point3.getX() - point2.getX()) * (point3.getX() - point2.getX()) + (point3.getY() - point2.getY()) * (point3.getY() - point2.getY()), 0.5);
	
	
	@Test
	public void test_create_Triangle_from_points() {
		Triangle calculated_triangle = new Triangle(point1, point2, point3);
		double calculated_side1 = calculated_triangle.getSide1();
		double calculated_side2 = calculated_triangle.getSide2();
		double calculated_side3 = calculated_triangle.getSide3();
		boolean equal = false;
		if (side1 == calculated_side1 && side2 == calculated_side2 && side3 == calculated_side3) {
			equal = true;
		}
		assertTrue("Correct triangle", equal);
	}
	
	@Test
	public void test_calSide() {
		Triangle calculated_triangle = new Triangle(point1, point2, point3);
		double calculatedSide = calculated_triangle.calSide(point1, point2);
		boolean equal = false;
		if (side1 == calculatedSide) {
			equal = true;
		}
		assertTrue("The side length", equal);
    }
	
	@Test
	public void test_defType_1() {
		OutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		Triangle triangle = new Triangle(2, 2, 3);
		triangle.defType();
		assertEquals("The triangle is isoceles.\n", os.toString());
	}
	
	@Test
	public void test_defType_2() {
		OutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		Triangle triangle = new Triangle(2, 3, 4);
		triangle.defType();
		assertEquals("The triangle is scalene.\n", os.toString());
	}
	
	@Test
	public void test_defType_3() {
		OutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		Triangle triangle = new Triangle(3, 3, 3);
		triangle.defType();
		assertEquals("The triangle is equilateral.\n", os.toString());
	}
	
	@Test
	public void test_defType_4() {
		OutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		Triangle triangle = new Triangle(3, 4, 5);
		triangle.defType();
		assertEquals("The triangle is scalene.\nThe triangle is right.\n", os.toString());
	}
	
	@Test
	public void test_defType_5() {
		OutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		Triangle triangle = new Triangle(3, 2, 2);
		triangle.defType();
		assertEquals("The triangle is isoceles.\n", os.toString());
	}
	
	@Test
	public void test_defType_6() {
		OutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		Triangle triangle = new Triangle(2, 3, 2);
		triangle.defType();
		assertEquals("The triangle is isoceles.\n", os.toString());
	}
	
	@Test
	public void test_defType_7() {
		OutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		Triangle triangle = new Triangle(4, 5, 3);
		triangle.defType();
		assertEquals("The triangle is scalene.\nThe triangle is right.\n", os.toString());
	}
	
	@Test
	public void test_defType_8() {
		OutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		Triangle triangle = new Triangle(5, 3, 4);
		triangle.defType();
		assertEquals("The triangle is scalene.\nThe triangle is right.\n", os.toString());
	}
	
	
	@Test
    public void test_getSemiPerimeter() {
		Triangle triangle = new Triangle(3, 4, 5);
        double expected_semiPerimeter = 6.0;
        assertEquals("SemiPerimeter", expected_semiPerimeter, triangle.getSemiPerimeter(), 0.1);
    }
	
	
	@Test
	public void test_getArea() {
		Triangle triangle = new Triangle(3, 4, 5);
		double expected_area = 6;
        assertEquals("Area", expected_area, triangle.getArea(), 0.1);
	}
	
	@Test(expected = InputMismatchException.class)
	public void test_InputMismatchException_1() {
		Triangle triangle = new Triangle(-1, 1, 2);
	}
	
	@Test(expected = InputMismatchException.class)
	public void test_InputMismatchException_2() {
		Triangle triangle = new Triangle(1, 0, 2);
	}
	
	@Test(expected = InputMismatchException.class)
	public void test_InputMismatchException_3() {
		Triangle triangle = new Triangle(1, 2, 0);
	}
	
	@Test(expected = InputMismatchException.class)
	public void test_InputMismatchException_4() {
		Triangle triangle = new Triangle(1, 2, 3);
	}
	
	@Test(expected = InputMismatchException.class)
	public void test_InputMismatchException_5() {
		Triangle triangle = new Triangle(1, 3, 2);
	}
	
	@Test(expected = InputMismatchException.class)
	public void test_InputMismatchException_6() {
		Triangle triangle = new Triangle(3, 1, 2);
	}
	
	@Test(expected = InputMismatchException.class)
	public void test_InputMismatchException_7() {
		Point pointA = new Point(1, 1);
		Point pointB = new Point(1, 1);
		Point pointC = new Point(0, 0);
		Triangle triangle = new Triangle(pointA, pointB, pointC);
	}
	
	@Test(expected = InputMismatchException.class)
	public void test_InputMismatchException_8() {
		Point pointA = new Point(0, 0);
		Point pointB = new Point(1, 1);
		Point pointC = new Point(1, 1);
		Triangle triangle = new Triangle(pointA, pointB, pointC);
	}
	
	@Test(expected = InputMismatchException.class)
	public void test_InputMismatchException_9() {
		Point pointA = new Point(1, 1);
		Point pointB = new Point(0, 0);
		Point pointC = new Point(1, 1);
		Triangle triangle = new Triangle(pointA, pointB, pointC);
	}
	
	@Test(expected = InputMismatchException.class)
	public void test_InputMismatchException_10() {
		Point pointA = new Point(1, 1);
		Point pointB = new Point(0, 0);
		Point pointC = new Point(2, 2);
		Triangle triangle = new Triangle(pointA, pointB, pointC);
	}
	
	@Test(expected = InputMismatchException.class)
	public void test_InputMismatchException_11() {
		Point pointA = new Point(0, 0);
		Point pointB = new Point(1, 1);
		Point pointC = new Point(2, 2);
		Triangle triangle = new Triangle(pointA, pointB, pointC);
	}
	
	@Test(expected = InputMismatchException.class)
	public void test_InputMismatchException_12() {
		Point pointA = new Point(2, 2);
		Point pointB = new Point(0, 0);
		Point pointC = new Point(1, 1);
		Triangle triangle = new Triangle(pointA, pointB, pointC);
	}

}
