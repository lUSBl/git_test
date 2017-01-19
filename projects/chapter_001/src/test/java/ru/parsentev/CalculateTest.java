package ru.parsentev;
 import org.junit.Test;
 import static org.hamcrest.core.Is.is;
 import static org.junit.Assert.assertThat;

public class CalculateTest{
	
	@Test
	public void whenSetStopInEchoThenThreeStops(){
		Calculate calc = new Calculate();
		String result = calc.echo("stop");
		assertThat(result, is("stop stop stop"));
	}
	@Test
	public void whenSetNullInEchoThenReturnTwoSpaces(){
		Calculate calc = new Calculate();
		String result = calc.echo(null);
		assertThat(result, is("null null null"));
	}
}
