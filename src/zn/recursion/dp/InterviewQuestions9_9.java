package zn.recursion.dp;

import java.util.Arrays;

public class InterviewQuestions9_9 {

    /**
     * find all possible arrangement for eightQueen in chessboard where sharing same row, same line and same diagonal are not allowed!
     * chessboard: use 2D array to represent it; (x, y) means chessboard[y][x]
     * trace: use 1D array to store all trace which elements are taken previously
     * layer: the line current recursive function processes for
     * n: 8
     * problem scale: exponential
     * so still take recursive tree (8 layer, each tree node are to make decision according to last layers' decision)
     * plus dfs search
     * 
     * @param chessboard
     * @param trace
     * @param layer
     * @param n
     */
    public static void eightQueen(int[][] chessboard, int[] trace, int layer, int n) {
        if (layer < n) {
            for (int i = 0; i < n; i++) {
                boolean valid = true;
                if (trace[i] == -1) {
                    trace[i] = layer;
                    for (int j = 0; j < n; j++) {
                        if ((j != i) && (trace[j] != -1)) {
                            //NOTE (int)/(int) sill int(1.3 --> 1). so if want to be float; then change minuend to float firstly!!!!
                            //NOTE!!!!!!
                            //NOTE!!!!!
                            if ((((float) (trace[i] - trace[j]) / (i - j)) == 1.0)//NOTE!!!!!!!
                                    || (((float) (trace[i] - trace[j]) / (i - j)) == -1.0)) {
                                valid = false;
                                break;
                            }
                        }
                    }
                    if (valid) {
                        eightQueen(chessboard, trace, layer + 1, n);
                    }
                    trace[i] = -1;//NOTE: after recursive, recover this layer point
                }
            }
        } else {
            for (int i = 0; i < n; i++) {
                if (trace[i] != -1) {
                    System.out.print("(" + trace[i] + " " + i + ")"); //chessboard[y][x]
                }
            }
            System.out.println();
        }
    }

    public static void eightQueen(int n) {
        int[][] chessboard = new int[n][n];
        int[] trace = new int[n];
        for (int i = 0; i < n; i++)
            trace[i] = -1;
        eightQueen(chessboard, trace, 0, n);
    }

    public static void main(String[] args) {
        InterviewQuestions9_9.eightQueen(8);
        System.out.println("test complete!");
    }
}
