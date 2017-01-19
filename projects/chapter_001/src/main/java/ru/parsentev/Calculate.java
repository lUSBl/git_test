package ru.parsentev;

/**
* Class  ласс создающий повторение строки.
* @author Vova
* @since 19.07.2017
* @version 1
*/
public class Calculate{
     public static void main(final String[] args) {
         Calculate calc = new Calculate();
         System.out.println(calc.echo("aaah"));
     }

/**
* ѕовторение строки.
* @param value аргумент, который в последствии утроитс€.
* @return результат.
*/
     public String echo(final String value) {
         return String.format("%s %s %s", value, value, value);
     }
}