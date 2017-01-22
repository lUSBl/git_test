package ru.job4j;

/**
 * Class Triangle вычисляет площадь треугольника.
 *
 * @author Vova Kapelyuha
 */
public class Triangle {

public Point a;
public Point b;
public Point c;

/**
*@param a  точка a в системе координат
*@param b  точка b в системе координат
*@param c  точка c в системе координат
*
*/
public Triangle(Point a, Point b, Point c) {
this.a = a;
this.b = b;
this.c = c;
}

/**
*Метод для вычисления площади треугольника
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
    System.out.println("Треугольник невозможно создать");
}
 return result;
}
}
