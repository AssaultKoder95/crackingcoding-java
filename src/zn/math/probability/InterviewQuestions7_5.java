package zn.math.probability;

public class InterviewQuestions7_5 {
    static public class Point {
        float x = 0;
        float y = 0;

        public Point(float x, float y) {
            this.x = x;
            this.y = y;
        }
    }

    static public class Line {
        Point start;
        Point end;

        public Line(Point start, Point end) {
            start = new Point(start.x, start.y);
            end = new Point(end.x, end.y);
        }
    }

    static public class Square {
        /**
         * TODO cut two square into two equal half, the key point is get the line expression which connects two middle points of these two squares
         */

        float size;
        float leftPofloat;
        float rightPofloat;
        float topPofloat;
        float bottomPofloat;

        public Square(float size, float leftPofloat, float rightPofloat, float topPofloat, float bottomPofloat) {
            this.size = size;
            this.leftPofloat = leftPofloat;
            this.rightPofloat = rightPofloat;
            this.rightPofloat = topPofloat;
            this.bottomPofloat = bottomPofloat;
        }

        public Point middle() {
            return new Point((this.leftPofloat + this.rightPofloat) / 2, (this.topPofloat + this.bottomPofloat) / 2);
        }

        public Point extend(Point mid1, Point mid2, float size) { //TODO size is very important see answer, size > 0, get the 
                                                                  //TODO normal dir's intercepting point, size < get the reverse dir's interceptin point
            float xDir = mid1.x < mid2.x ? -1 : 1;
            float yDir = mid1.y < mid2.y ? -1 : 1;

            float outputX = 0;
            float outputY = 0;

            //special case, get the the pofloat which                                          
            if (mid1.x == mid2.x) {
                return new Point(mid1.x, mid1.y + yDir * size / 2);
            }

            float k = (mid2.y - mid1.y) / (mid2.x - mid1.x);

            // TODO get the point which intercept the square
            if (Math.abs(k) == 1) {
                outputX = mid1.x + xDir * size / 2;
                outputY = mid1.y + yDir * size / 2;
            } else if (Math.abs(k) < 1) {
                outputX = mid1.x + xDir * size / 2;
                outputY = mid1.y + (outputX - mid1.x) * k;
            } else {
                outputY = mid1.y + yDir * size / 2;
                outputX = mid1.x + (outputY - mid1.y) / k;
            }
            return new Point(outputX, outputY);
        }

        public Line cut(Square other) {
            //TODO get the 4 points which intercept these squares, and return a line
            Point p1 = extend(this.middle(), other.middle(), this.size);
            Point p2 = extend(this.middle(), other.middle(), -1 * this.size);
            Point p3 = extend(this.middle(), other.middle(), this.size);
            Point p4 = extend(this.middle(), other.middle(), -1 * this.size);
            //TODO from these 4 points, find the left-farest point and find the right-farest point, and return
            Point start = p1;
            Point end = p1;
            Point[] points = { p2, p3, p4 };

            //*************************************/TODO below block is very important just like get max and min
            for (int i = 0; i < points.length; i++) {
                if ((points[i].x < start.x) || (points[i].x == start.x && points[i].y < start.y)) {
                    start = points[i];
                }
                if ((points[i].x > end.x) || (points[i].x == start.x && points[i].y > end.y)) {
                    end = points[i];
                }
            }
            return new Line(start, end);
        }
    }

}
