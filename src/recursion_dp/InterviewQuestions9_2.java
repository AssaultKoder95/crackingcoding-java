package recursion_dp;

import java.util.ArrayList;

public class InterviewQuestions9_2 {

    /**
     * the last two function for finding path from (0,0) to (n,n) need test
     * TODO
     */

    /**
     * from (0,0) to (x,y); this path will have x+y steps total.
     * so we can have a binomial expression:
     * (x+y) = (x+y)!/x!y!
     * ( x )
     * this is recursive way to solve this DP problem.
     * f(x, y) = f(x-1, y) + f(x, y-1)
     * 
     * @param x
     * @param y
     */
    public static int countPaths1(int x, int y) {
        if (x == 0 && y == 0)
            return 0;
        else if (((x == 1) && (y == 0)) || ((x == 0) && (y == 1)))
            return 1;
        else if (x < 0 || y < 0)
            return 0;
        return countPaths1(x - 1, y) + countPaths1(x, y - 1);
    }

    /**
     * this is the iterative solution
     * 
     * @param x
     * @param y
     * @return
     */
    public static int countPaths2(int x, int y) {
        int[] lastLine = new int[x + 1]; //NOTE last Line
        int[] lastColumn = new int[y + 1];//Note last column
        //init these two array!
        lastLine[0] = 0;
        for (int i = 1; i <= x; i++)
            lastLine[i] = 1;
        for (int j = 1; j <= y; j++)
            lastColumn[j] = 1;
        int output = 0;
        for (int i = 1; i <= y; i++) {//NOTE start from 1
            for (int j = 1; j <= x; j++) {//NOTE start from 1
                output = lastLine[j] + lastColumn[i];//NOTE the index of lastLine and lastColumn
                lastLine[j] = output;//NOTE after I get the new value of this position, I should update the lastLIne and LastColumn
                lastColumn[i] = output;//NOTE
            }
        }
        return output;
    }

    public static void findAPathRecursive(int n) {
        int[][] flagMatrix = new int[n + 1][n + 1];
        findAPathRecursive(n, n, flagMatrix);
    }

    public static void printRoute(int n, int[][] flagMatrix) {
        int x = n;
        int y = n;
        System.out.println("<" + x + " " + y + ">");
        while (x != 0 || y != 0) {
            if (flagMatrix[x - 1][y] > 0) {
                System.out.println("<" + (x - 1) + " " + y + ">");
                x = x - 1;
            } else if (flagMatrix[x][y - 1] > 0) {
                System.out.println("<" + x + " " + (y - 1) + ">");
                y = y - 1;
            } else {
                if (x != 0 || y != 0)
                    System.out.println("can not find the path!");
                break;
            }
        }
    }

    /**
     * this is a DP solution (cache + recursive)
     * iterative formula: if leftPoint ==true, curPoint = true; if(!leftPoint&&upPoint) curPoint=true; if(!leftPoint&&!upPoint) curPoint=false
     * DP the key is throught iterative formula, the bigger sub-solution could be got by accumulation of smaller sub-solution
     * 
     * @param x
     * @param y
     * @param flagMatrix
     * @return
     */
    public static boolean findAPathRecursive(int x, int y, int[][] flagMatrix) {
        if (flagMatrix[x][y] != 0)
            return flagMatrix[x][y] < 0 ? false : true;
        if (x == 0 && y == 0) {
            flagMatrix[x][y] = 1;
            return true;
        } else if (x < 0 || y < 0) {
            flagMatrix[x][y] = -1;
            return false;
        }
        if (findAPathRecursive(x - 1, y, flagMatrix)) {
            flagMatrix[x][y] = 1;
            return true;
        } else if (findAPathRecursive(x, y - 1, flagMatrix)) {
            flagMatrix[x][y] = 1;
            return true;
        } else
            return false;

    }

    /**
     * this is iterative solution for finding path from (0,0) to (n,n)
     * @param n
     * @param flagMatrix
     */
    public static void findAPathIterative(int n, int[][] flagMatrix) {
        //init
        flagMatrix[0][0] = 1;
        for (int i = 1; i < n + 1; i++) {
            flagMatrix[i][0] = flagMatrix[i - 1][0] > 1 ? 1 : -1;
        }
        for (int i = 1; i < n + 1; i++) {
            flagMatrix[0][i] = flagMatrix[0][i - 1] > 1 ? 1 : -1;
        }
        //compute
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (flagMatrix[i][j] == 0) {
                    if (flagMatrix[i - 1][j] > 0) {
                        flagMatrix[i][j] = 1;
                    } else if (flagMatrix[i][j - 1] > 0) {
                        flagMatrix[i][j] = 1;
                    } else
                        flagMatrix[i][j] = -1;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(InterviewQuestions9_2.countPaths1(5, 3));
        System.out.println(InterviewQuestions9_2.countPaths2(5, 3));
    }
}
