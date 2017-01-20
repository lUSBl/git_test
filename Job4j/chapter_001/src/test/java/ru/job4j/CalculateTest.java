package ru.job4j;

 import org.junit.Test;
 import java.io.ByteArrayOutputStream;
 import java.io.PrintStream;
 import static org.hamcrest.core.Is.is;
 import static org.junit.Assert.assertThat;

/**
* Test for Calculate class.
*
* @author Vova Kapelyuha
* @since  1.0
* @version $Id$
*/
public class CalculateTest {
	
	/**
	* Test check print to console 'Hello World!'.
	*/
	@Test
	public void whenExecuteMainThenPrintToConsole() {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		Calculate.main(null);
		assertThat(out.toString(), is("Hello World\r\n"));
	}
	
}
