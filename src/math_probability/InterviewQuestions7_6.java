package math_probability;

import java.util.ArrayList;
import java.util.HashMap;

public class InterviewQuestions7_6 {

    static public class Point {
        float x = 0;
        float y = 0;

        public Point(float x, float y) {
            this.x = x;
            this.y = y;
        }
    }

    public static class Line {
        public static double epsilon = 10e-6;
        public double slope, intercept; //TODO if two x are equal, then intercept = x
        public boolean infinite_slop = false;

        public Line(Point p, Point q) {
            if (Math.abs(p.x - q.x) > epsilon) {
                slope = (p.y - q.y) / (p.x - q.x);
                intercept = p.y - slope * p.x;
            } else {
                infinite_slop = true;
                intercept = p.x;
            }
        }
        
        /**
         * this answer give our view about how to put double as key, firstly use epsilon as the equal condition
         * Then actual_num / epsilon, so remove all remainder, and get the integral part as how many times of epsilon
         * use how many times of epsilon as key, and when search just search key, key+epsilon, key-epsilon
         * @param d
         * @return
         */
        public static double floorToNearestEpsilon(double d) {
            int x = (int) (d / epsilon); // TODO get multipes of epsilon, and remove remainder
            //TODO hashmap use multiple of epsilon to be key of boundary; so, when searching, 
            return ((double) x) * epsilon; //times epsilon is to increase sparse of key 
        }

        public boolean isEquivalent(double a, double b) {
            return (Math.abs(a - b) < epsilon);
        }

        public boolean isEquivalent(Object o) {
            Line other = (Line) o;
            if (isEquivalent(other.slope, slope) && isEquivalent(other.intercept, intercept)
                    && infinite_slop == other.infinite_slop) {
                return true;
            }
            return false;
        }
    }

    public static Line findBestLine(Point[] points) {
        HashMap<Double, ArrayList<Line>> allLinesInfo = new HashMap<Double, ArrayList<Line>>();
        ArrayList<Line> tempList = null;
        Line curBestLine = null;
        int sum = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                Line curLine = new Line(points[i], points[j]);
                double curKey = Line.floorToNearestEpsilon(curLine.slope);
                if (allLinesInfo.containsKey(curKey)) {
                    tempList = allLinesInfo.get(curKey);
                } else {
                    tempList = new ArrayList<Line>();
                    allLinesInfo.put(curKey, tempList);
                }
                tempList.add(curLine);
                int curCount = countEquivLines(allLinesInfo, curLine);
                if (curCount > sum) {
                    sum = curCount;
                    curBestLine = curLine;
                }
            }
        }
        return curBestLine;
    }

    public static int countEquivLines(HashMap<Double, ArrayList<Line>> allLinesInfo, Line curLine) {
        double curKey = Line.floorToNearestEpsilon(curLine.slope);
        //TODO need search 3 buckets for the keys: 1.slop; 2.slop + epsilon 3.slop - epsilon)
        ArrayList<Line> tempList = allLinesInfo.get(curKey);
        int count = 0;
        for (Line iter : tempList) {
            if (iter.equals(curLine))
                count++;
        }
        tempList = allLinesInfo.get(curKey + Line.epsilon);
        for (Line iter : tempList) {
            if (iter.equals(curLine))
                count++;
        }
        tempList = allLinesInfo.get(curKey - Line.epsilon);
        for (Line iter : tempList) {
            if (iter.equals(curLine))
                count++;
        }
        return count;
    }

}
