package ru.job4j;


/**
 * Class Triangle calculates the area of a triangle.
 *
 * @author Vova Kapelyuha
 */


public class Triangle {

public Point a;
public Point b;
public Point c;


/**
*@param a  point a in the coordinate system
*@param b  point b in the coordinate system
*@param c  point c in the coordinate system
*
*/
public Triangle(Point a, Point b, Point c) {
this.a = a;
this.b = b;
this.c = c;
}


/**
*Method for calculating the area of a triangle
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
    System.out.println("Triangle can not be created!!");
}
 return result;
}
}
