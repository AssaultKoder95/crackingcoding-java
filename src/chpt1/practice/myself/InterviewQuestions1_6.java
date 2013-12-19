package chpt1.practice.myself;

public class InterviewQuestions1_6 {
    
    /**
     * rotate a matrix 90 degree
     * FIXME this is the answer for rotation, rotate left, top, right, bottom 4 points at once
     * tricky: don't forget offset: relative distance for computing two coressponding points
     * @param et1
     * @return
     */
    public static int[][] rotateMatrixCorrectly(int[][] et1) {
        for(int i = 0; i < et1.length / 2; i ++) {
            int first = i;
            int last = et1.length - 1 - i;
            int temp = 0;
            for(int j = first, offset = last - first; j < last; j ++, offset --) {
                //assign top to tmp
                temp = et1[first][j];
                //assign left to top
                et1[first][j] = et1[first + offset][first];
                //assign bottom to left
                et1[first + offset][first] = et1[last][first + offset];
                //assign right to bottom
                et1[last][first + offset] = et1[last - offset][last];
                //assign top to right
                et1[last - offset][last] = temp;
            }
        }
        return et1;
    }
    
    public static enum RotType {
        TOPTORIGHT,
        RIGHTTOBOTTOM,
        BOTTOMTOLEFT,
        LEFTTOTOP
    }
    
    public static void rotateLineByLine(int first, int last, RotType type, int[][] et1, int[] temp) {
        switch(type) {
            case TOPTORIGHT:
                for(int i = last; i >= first; i--) {
                    et1[i][last] = temp[i]; // et1[first][i]
                }
                break;
            case RIGHTTOBOTTOM:
                for(int i = last; i >= first; i--) {
                    et1[last][last - i + first] = et1[i][last];//tricky: not last -i, should be last - i + first
                }
                break;
            case BOTTOMTOLEFT:
                for(int i = first; i <= last; i++) {
                    et1[i][first] = et1[last][i];
                }
                break;
            case LEFTTOTOP:
                for(int i = first + 1; i <= last; i++) {// TODO tricky: should be first + 1 in case of overwrite right up corner point
                    et1[first][last - i + first] = et1[i][first];//TODO tricky: not last -i, should last-i+first
                }
                break;
        }
    }
    
    /**
     * this my correct second thought for this question. using temp array rotate left, bottom, right, top 4 arrays each time
     * much more complicated!
     * @param et1
     * @return
     */
    public static int[][] rotateMatrixMyThought(int[][] et1) {
        int[] temp = new int[et1.length];
        for(int i = 0; i < et1.length / 2; i ++) {
            int first = i;
            int last = et1.length - 1 - i;
            for(int j = first; j <= last; j++) {
                temp[j] = et1[first][j];
            }
            rotateLineByLine(first, last, RotType.LEFTTOTOP, et1, temp);
            rotateLineByLine(first, last, RotType.BOTTOMTOLEFT,et1, temp);
            rotateLineByLine(first, last, RotType.RIGHTTOBOTTOM, et1, temp);
            rotateLineByLine(first, last, RotType.TOPTORIGHT, et1, temp);
        }
        return et1;
    }
    
    /**
     * TODO this my first thought. it is not correct. this is solve how to get transposed matrix
     * @param et1
     * @return
     */
    public static int[][] rotateMatrixIncorrectly(int[][] et1) {
        int temp = 0;
        for (int i = 0; i < et1.length; i++) {
            for (int j = i; j < et1.length; j++) {
                temp = et1[j][i];
                et1[j][i] = et1[i][j];
                et1[i][j] = temp;
            }
        }
        return et1;
    }

    public static void main(String[] args) {
        //TODO this is a way to initialize a 2D array 
        int[][] test = new int[][] { { 1, 2, 3, 4, 5}, { 6, 7, 8, 9, 10}, {11, 12, 13, 14, 15 }, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        InterviewQuestions1_6.rotateMatrixMyThought(test);
        //TODO no one line code to print 2D array
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(test[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}
