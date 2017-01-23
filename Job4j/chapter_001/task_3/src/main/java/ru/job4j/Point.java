package ru.job4j;


/**
 *Class Point calculates the distance between points in the coordinate system.
 *
 * @author Vova Kapelyuha
 * @version 1.00
 * @since 22.01.2017
 */


public class Point {

/**
*variable x value of point x in the coordinate system.
*variable y value of point y in the coordinate system.
*
*/
private double x;
private double y;


/**
*@param x  point x in the coordinate system.
*@param y  point y in the coordinate system.
*
*/
public Point(double x, double y) {
this.x = x;
this.y = y;
}


/**
*@param point - another point in the coordinate system
*The method for calculating the distance between two points
*The distance is calculated by the formula: 
*"d = Math.sqrt(Math.pow(x2-x1) + (Math.pow(y2-y1))"
*/
  public double distanceTo(Point point) {
     return Math.sqrt(Math.pow(point.x - this.x, 2) + Math.pow(point.y - this.y, 2));
  }
}