package entities;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RectangleTest {

    private Rectangle r;

    @Before
    public void setUp() {
        r = new Rectangle(4.0, 3.0);
    }

    @Test
    public void testArea() {
        assertEquals(12.0, r.area(), 0.001);
    }

    @Test
    public void testPerimeter() {
        assertEquals(14.0, r.perimeter(), 0.001);
    }

    @Test
    public void testDiagonal() {
        assertEquals(5.0, r.diagonal(), 0.001);
    }

    @Test
    public void testConstructorSetsValues() {
        assertEquals(4.0, r.getWidth(), 0.001);
        assertEquals(3.0, r.getHeight(), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeWidthThrows() {
        r.setWidth(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeHeightThrows() {
        r.setHeight(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testZeroWidthThrows() {
        r.setWidth(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testZeroHeightThrows() {
        r.setHeight(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithInvalidWidth() {
        new Rectangle(-1, 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithInvalidHeight() {
        new Rectangle(4, -1);
    }

    @Test
    public void testToString() {
        assertEquals("Rectangle [width=4.0, height=3.0]", r.toString());
    }

    @Test
    public void testToStringWithDecimals() {
        Rectangle r2 = new Rectangle(4.5, 3.2);
        assertEquals("Rectangle [width=4.5, height=3.2]", r2.toString());
    }
}
