package ru.job4j;

import org.junit.Test;
import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;

/**
 * Class CalculatorTest checks the correct work of class Calculator.
 *
 * @author Vova Kapelyuha
 */
public class CalculatorTest {

Calculator testCalc = new Calculator();

        /**
	 * Method checks the add of numbers.
	 *
	 */
@Test
public void whenMethodAddExecuteThenResultWasEight() {
testCalc.add(6, 2);
assertThat(testCalc.getResult(), closeTo(8,0.001));
}


        /**
	 * Method checks the add of numbers.
	 *
	 */
@Test
public void whenMethodSubtractExecuteThenResultWasEight() {
testCalc.subtract(10, 2);
assertThat(testCalc.getResult(), closeTo(8,0.001));
}


        /**
	 * Method checks the add of numbers.
	 *
	 */
@Test
public void whenMethodMultipleExecuteThenResultWasEight() {
testCalc.multiple(4, 2);
assertThat(testCalc.getResult(), closeTo(8,0.001));
}


        /**
	 * Method checks the add of numbers.
	 *
	 */
@Test
public void whenMethodDivideExecuteThenResultWasEight() {
testCalc.divide(16, 2);
assertThat(testCalc.getResult(), closeTo(8,0.001));
}
}