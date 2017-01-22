package ru.job4j;


/**
 *Class Point вычисляет расстояние между указанными точками в системе координат.
 *
 * @author Vova Kapelyuha
 * @version 1.00
 * @since 22.01.2017
 */


public class Point {

/**
*variable x значение точки x в координате систем.
*variable y значение точки y в координате систем.
*
*/
private double x;
private double y;


/**
*@param x  точка x в координате систем.
*@param y  точка y в координате систем.
*
*/
public Point(double x, double y) {
this.x = x;
this.y = y;
}


/**
*@param point - другая точка в системе координат
*Метод для вычисления растояния между двумя точками
*Растояние вычисляется по формуле: 
*"d = Math.sqrt(Math.pow(x2-x1) + (Math.pow(y2-y1))"
*/
  public double distanceTo(Point point) {
     return Math.sqrt(Math.pow(point.x - this.x, 2) + Math.pow(point.y - this.y, 2));
  }
}