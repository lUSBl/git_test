package ru.job4j;

import org.junit.Test;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.*;

/**
 * Class PointTest test class Point.
 *
 * @author Vova Kapelyuha
 * @version 1.00
 * @since 22.01.2017
 */


public class PointTest {


/**
*
*The method is determining whether the distance is calculated correctly
*between points.
*/
@Test
public void whenDistanceWasCalculatedBetweenTwoPointsThanResultTwo() {
Point p = new Point(6,8);
double result = p.distanceTo(new Point(8,8));
double except = 2d;
assertThat(result, closeTo(except, 0.01));
}

}