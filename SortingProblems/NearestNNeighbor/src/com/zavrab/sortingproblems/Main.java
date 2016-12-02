package com.zavrab.sortingproblems;

import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {

        Point point = new Point(3, 3);
        Point[] nearestPoints = findNearestPoints(generateAllPoints(), point, 2);

        for (Point p : nearestPoints) {
            System.out.println("{" + p.x + ", " + p.y + "}" );
        }
    }

    public static Point[] findNearestPoints(Point[] allPoints, Point point, int kPoint) {
        PriorityQueue<Point> queueByDistance = new PriorityQueue<Point>(kPoint, Collections.reverseOrder());

        Point fakePoint = new Point(Integer.MAX_VALUE, Integer.MAX_VALUE); //Adding fake, so first .peek() won't throw exception
        fakePoint.setDistance(Integer.MAX_VALUE);
        queueByDistance.add(fakePoint);

        for (int i = 0; i < allPoints.length; i++) {
            double distance = euclideanDistance(point, allPoints[i]);
            allPoints[i].setDistance(distance);

            if (allPoints[i].distance <  queueByDistance.peek().distance) {
                queueByDistance.add(allPoints[i]);

                if (queueByDistance.size() > kPoint) {
                    queueByDistance.poll();
                }
            }
        }

        return getTopKPointsFromPQ(kPoint, queueByDistance);
    }

    private static double euclideanDistance(Point s, Point d) {
        double xSqr = Math.pow((s.x - d.x), 2);
        double ySqr = Math.pow((s.y - d.y), 2);

        return Math.sqrt(xSqr + ySqr);
    }

    private static Point[] getTopKPointsFromPQ(int kPoint, PriorityQueue<Point> allPoints) {
        Point[] nearestPoints = new Point[kPoint];
        int i = kPoint - 1;

        while (allPoints.size() > 0) {
            nearestPoints[i--] = allPoints.poll();
        }

        return nearestPoints;
    }

    private static Point[] generateAllPoints() {
        Point[] nPoints = new Point[5];
        nPoints[0] = new Point(0, 6);
        nPoints[1] = new Point(6, 0);
        nPoints[2] = new Point(3, 2);
        nPoints[3] = new Point(3, 6);
        nPoints[4] = new Point(5, 3);

        return nPoints;
    }

    private static class Point implements Comparable {
        int x;
        int y;
        double distance;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        void setDistance(double distance) {
            this.distance = distance;
        }

        @Override
        public int compareTo(Object o) {
            Point point = (Point) o;

            if (this.distance < point.distance) {
                return -1;
            } else if (this.distance > point.distance) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
