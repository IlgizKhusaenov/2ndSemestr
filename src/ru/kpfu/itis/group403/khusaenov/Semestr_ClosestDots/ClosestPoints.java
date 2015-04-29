package ru.kpfu.itis.group403.khusaenov.Semestr_ClosestDots;
import java.util.*;

public class ClosestPoints {
    public static void main(String[] args) {
        List<Point> points = generatePoints();
        Point[] closest = new Point[points.size()];
        Double minDist = Double.POSITIVE_INFINITY;
        Point a = null, b = null;
        Tree tree = new Tree(points);

        for (int i = 0; i < points.size(); i++) {
            closest[i] = tree.findClosest(points.get(i));
            if (points.get(i).distance(closest[i]) < minDist) {
                minDist = points.get(i).distance(closest[i]);
                a = points.get(i);
                b = closest[i];
            }
        }

        for (int i = 0; i < points.size(); i++) {
        }
        System.out.println(a + " is closest to " + b);
        System.out.println(minDist);
    }

    //Создаем 1000 точек со случайными координатами
    private static List<Point> generatePoints() {
        ArrayList<Point> points = new ArrayList<Point>();
        Random r = new Random();

        for (int i = 0; i < 1000; i++) {
            points.add(new Point(r.nextInt() % 1000, r.nextInt() % 1000));
        }

        return points;
    }
}



