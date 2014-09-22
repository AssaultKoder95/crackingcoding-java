/**
 * CTCI 7.3
 */
package math_probability;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class CheckLineIntersect {

    //NOTE determine these two lines are equal, just use threshold when comparing k and b
    public static final double THRESHOLD = 1e-6;

    public static class Line {
        private double k;
        private double b;
        private boolean isVertical;
        private double xIfVertical;

        public Line(double k, double b, boolean isVertical, double xIfVertical) {
            this.k = k;
            this.b = b;
            this.isVertical = isVertical;
            this.xIfVertical = xIfVertical;
        }

    }

    public static boolean isIntersectForTwoLines(Line et1, Line et2) {
        if (et1.isVertical && et2.isVertical) {
            if (Math.abs(et1.xIfVertical - et2.xIfVertical) <= THRESHOLD) {
                return true;
            } else {
                return false;
            }
        }
        if (!et1.isVertical && !et2.isVertical) {
            if (Math.abs(et1.k - et2.k) > THRESHOLD) {
                return true;
            } else {
                if (Math.abs(et1.b - et2.b) <= THRESHOLD) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        NumberFormat formatter = new DecimalFormat("###.#######");
        String f = formatter.format(THRESHOLD);
        System.out.println(f);// NOTE
    }
}
