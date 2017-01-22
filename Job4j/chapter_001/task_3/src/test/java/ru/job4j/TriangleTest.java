package ru.job4j;

import org.junit.Test;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.*;

/**
 * Class TriangleTest test class Triangle.
 *
 * @author Vova Kapelyuha
 * @version 1.00
 * @since 22.01.2017
 */


public class TriangleTest {


/**
*
*The method is checking whether the area of a triangle is calculated correctly.
*
*/
@Test
public void whenAreaOfTriangleWasCalculatedThanResultSix() {
Triangle tr = new Triangle(new Point(2,2), new Point (6,5), new Point(2,5));
double result = tr.area();
double except = 6d;
assertThat(result, closeTo(except, 0.01));
}
}