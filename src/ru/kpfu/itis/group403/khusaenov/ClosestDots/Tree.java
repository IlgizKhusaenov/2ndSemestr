package ru.kpfu.itis.group403.khusaenov.ClosestDots;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Tree {
    private Tree childA, childB;
    private Point point; // центральная точка

    public Tree(List<Point> points) {
        childA = null;
        childB = null;
        Comparator<Point> comp = new Point.PointComp();
        Collections.sort(points, comp);

        int median = (points.size() - 1) / 2;
        point = points.get(median);
        if (median > 0) {
            childA = new Tree(
                    points.subList(0, median));
        }
        if (median + 1 < points.size()) {
            childB = new Tree(
                    points.subList(median + 1, points.size()));
        }
    }

    //ищем ближайшую точку к данной точке
    public Point findClosest(Point target) {
        Point closest = point.equals(target) ? Point.INFINITY : point; //если на вход пришла эта же точка, то помечаем расстояние бесконечностью(т.к. когда проходм по всем точкам, то 1 раз за цикл на сравнение приходит сама же точка)
        double bestDist = closest.distance(target); // начальная дистанция между точками
        double spacing = target.coord[0] - point.coord[0]; // определяем, по правую или по левую сторону от нашей точки лежит входная точка
        Tree trueSide = (spacing < 0) ? childA : childB; // сторона, по которую лежит входная точка
        Tree otherSide = (spacing < 0) ? childB : childA; // другая сторона

        // ниже 2 этих условия отвечают за нахождение ближайшей точки.
        // рекурсивно обходим true сторону
        if (trueSide != null) {
            Point candidate = trueSide.findClosest(target);
            if (candidate.distance(target) < bestDist) {
                closest = candidate;
                bestDist = closest.distance(target);
            }
        }
        // и другую сторону тоже
        if (otherSide != null && (Math.abs(spacing) < bestDist)) {
            Point candidate = otherSide.findClosest(target);
            if (candidate.distance(target) < bestDist) {
                closest = candidate;
            }
        }

        return closest;
    }
}