package math_probability;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class InterviewQuestions7_3 {

    public static final double THRESHOLD = 1e-6; //TODO determine these two lines are equal, just use threshold when comparing k and b

    public static class Line {
        private double k;
        private double b;
        private boolean isVertical;
        private double xValIfVertical;

        public Line(double k, double b, boolean isVertical, double xValIfVertical) {
            this.k = k;
            this.b = b;
            this.isVertical = isVertical;
            this.xValIfVertical = xValIfVertical;
        }

    }

    public static boolean isIntersectForTwoLines(Line et1, Line et2) {
        if (et1.isVertical && et2.isVertical) {
            if (Math.abs(et1.xValIfVertical - et2.xValIfVertical) <= THRESHOLD)
                return true;
            else
                return false;
        }

        if (!et1.isVertical && !et2.isVertical) {
            if (Math.abs(et1.k - et2.k) > THRESHOLD)
                return true;
            else {
                if (Math.abs(et1.b - et2.b) <= THRESHOLD)
                    return true;
                else
                    return false;
            }
        }

        return false; //TODO include two cases which et1.isVertical == true or et2.isVertical == true
    }

    public static void main(String[] args) {

        /***********/
        NumberFormat formatter = new DecimalFormat("###.#######");
        String f = formatter.format(THRESHOLD);
        System.out.println(f);// TODO  
    }
}
