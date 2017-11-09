package shape;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class TestShapes {
	static Circle circle;
	static Square square;
	static Rectangle rectangle;
	
	@Before
	public void prepareShapes() {
		circle = new Circle(0, 0, 1);
		square = new Square(0, 0, 1);
		rectangle = new Rectangle(0, 0, 1, 1);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testCreateCricle() {
		new Circle(10, 10, -2);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testCreateSquare() {
		new Square(0, 0, -20);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testCreateRectangle1() {
		new Rectangle(0, 0, 0, 2);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testCreateRectangle2() {
		new Rectangle(0, 0, 2, -1);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testCreateRectangle3() {
		new Rectangle(0, 0, -1, -2);
	}
	
	@Test
	public void testMoveCircle() {
		//test illegal move to the east
		circle.moveEastWest(2);
		assertEquals(circle.getX(), 0);
		//test illegal move to the west
		circle.moveEastWest(-4);
		assertEquals(circle.getX(), 0);
		//test move to the north
		circle.moveNorthSouth(2);
		assertEquals(circle.getY(), 2);
		//test illegal move to the south
		circle.moveNorthSouth(-4);
		assertEquals(circle.getY(), 2);
	}
	
	@Test
	public void testMoveSquare() {
		//test move to the east
		square.moveEastWest(2);
		assertEquals(square.getX(), 2);
		//test illegal move to the west
		square.moveEastWest(-4);
		assertEquals(square.getX(), 2);
		//test illegal move to the north
		square.moveNorthSouth(2);
		assertEquals(square.getY(), 0);
		//test illegal move to the south
		square.moveNorthSouth(-4);
		assertEquals(square.getY(), 0);
	}
	
	@Test
	public void testMoveRectangle() {
		//test illegal move to the east
		rectangle.moveEastWest(2);
		assertEquals(rectangle.getX(), 0);
		//test move to the west
		rectangle.moveEastWest(-4);
		assertEquals(rectangle.getX(), 0);
		//test move to the north
		rectangle.moveNorthSouth(2);
		assertEquals(rectangle.getY(), 0);
		//test illegal move to the south
		rectangle.moveNorthSouth(-4);
		assertEquals(rectangle.getY(), 0);
	}
}
