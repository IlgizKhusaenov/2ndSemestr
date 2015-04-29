package ru.kpfu.itis.group403.khusaenov.ClosestDots;

import java.util.Comparator;

//Класс, описывающий поведение точки
public class Point {
    static final Point INFINITY = new Point(Double.POSITIVE_INFINITY,
            Double.POSITIVE_INFINITY);

    public double[] coord; // coord[0] = x, coord[1] = y

    public Point(double x, double y) {
        coord = new double[]{x, y};
    }

    public double getX() {
        return coord[0];
    }

    public double getY() {
        return coord[1];
    }

    //Вычисление дистанции между 2 точками
    public double distance(Point p) {
        double dX = getX() - p.getX();
        double dY = getY() - p.getY();
        return Math.sqrt(dX * dX + dY * dY);
    }

    public boolean equals(Point p) {
        return (getX() == p.getX()) && (getY() == p.getY());
    }

    @Override
    public String toString() {
        return "(" + getX() + ", " + getY() + ")";
    }

    //Компаратор для  сравнения точек
    public static class PointComp implements Comparator<Point> {

        public int compare(Point a, Point b) {
            return (int) (a.coord[0] - b.coord[0]);
        }
    }
}