package ru.job4j;

/**
 * Class Triangle ��������� ������� ������������.
 *
 * @author Vova Kapelyuha
 */
public class Triangle {

public Point a;
public Point b;
public Point c;

/**
*@param a  ����� a � ������� ���������
*@param b  ����� b � ������� ���������
*@param c  ����� c � ������� ���������
*
*/
public Triangle(Point a, Point b, Point c) {
this.a = a;
this.b = b;
this.c = c;
}

/**
*����� ��� ���������� ������� ������������
*
*/
public double area() {
 double result = 0;
 double ab = this.a.distanceTo(b);
 double bc = this.b.distanceTo(c);
 double ac = this.a.distanceTo(c);

 double halfS = (ab + bc + ac) / 2.0d;

if ((ab < (bc + ac)) && (bc < (ac + ab)) && (ac < (bc + ac))) {
 	           result = Math.sqrt(halfS * (halfS - ab) * (halfS - ac) * (halfS - bc));
} else {
    System.out.println("����������� ���������� �������");
}
 return result;
}
}
