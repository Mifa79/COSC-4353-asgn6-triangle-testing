import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class PointTest {
	@Test
	public void test_equals_1() {
		double x = 1;
		double y = 1;
		Point point1 = new Point(x, y);
		Point point2 = new Point(1, 1);
		assertTrue(point1.equals(point2));
	}
	
	@Test
	public void test_equals_2() {
		Point point1 = new Point(1, 1);
		Point point2 = null;
		assertFalse(point1.equals(point2));
	}
	
	@Test
	public void test_equals_3() {
		Point point1 = new Point(1, 1);
		Triangle triangle = new Triangle(3, 4, 5);
//		assertFalse(point1.getClass().equals(triangle.getClass()));
		assertFalse(point1.equals(triangle));
	}

}
