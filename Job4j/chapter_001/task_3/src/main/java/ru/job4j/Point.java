package ru.job4j;


/**
 *Class Point ��������� ���������� ����� ���������� ������� � ������� ���������.
 *
 * @author Vova Kapelyuha
 * @version 1.00
 * @since 22.01.2017
 */


public class Point {

/**
*variable x �������� ����� x � ���������� ������.
*variable y �������� ����� y � ���������� ������.
*
*/
private double x;
private double y;


/**
*@param x  ����� x � ���������� ������.
*@param y  ����� y � ���������� ������.
*
*/
public Point(double x, double y) {
this.x = x;
this.y = y;
}


/**
*@param point - ������ ����� � ������� ���������
*����� ��� ���������� ��������� ����� ����� �������
*��������� ����������� �� �������: 
*"d = Math.sqrt(Math.pow(x2-x1) + (Math.pow(y2-y1))"
*/
  public double distanceTo(Point point) {
     return Math.sqrt(Math.pow(point.x - this.x, 2) + Math.pow(point.y - this.y, 2));
  }
}