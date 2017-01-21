package ru.job4j;

/**
 * Class Calculator who add, subt, mult, div numbers.
 *
 * @author Vova Kapelyuha
 */
public class Calculator {

/**
* Variable for the result operations
*
*/
private double result;

/**
* Method add the numbers.
* @param first - first value
* @param second - second value
*/
public void add(double first, double second) {
this.result = first + second;
}

/**
* Method subtract the numbers.
* @param first	- first value
* @param second - second value
*/
public void subtract(double first, double second) {
this.result = first - second;
}

/**
* Method multiple the numbers.
* @param first	- first value
* @param second - second value
*/
public void multiple(double first, double second) {
this.result = first * second;
}

/**
* Method divide the numbers.
* @param first	- first value
* @param second - second value
*/
public void divide(double first, double second) {
this.result = first / second;
}

/**
* Method return result.
*
*/
public double getResult() {
return this.result;
}

}