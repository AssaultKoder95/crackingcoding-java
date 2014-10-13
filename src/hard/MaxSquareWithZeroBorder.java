/**
 * CTCI 18.11
 */
package hard;

public class MaxSquareWithZeroBorder {

    //Time Complexity: O(n^3)
    public void findMaxSquare(int[][] input) {
        int[][] right0s = new int[input.length][input[0].length];
        int[][] below0s = new int[input.length][input[0].length];
        preprocess(input, right0s, below0s);
        for (int edge = input.length; edge >= 1; edge--) {
            int count = input.length - edge + 1;
            for (int leftTopX = 0; leftTopX < count; leftTopX++) {
                for (int leftTopY = 0; leftTopY < count; leftTopY++) {
                    if (valid(right0s, below0s, leftTopX, leftTopY, edge)) {
                        System.out.println(leftTopX + " " + leftTopY + " " + edge);
                    }
                }
            }
        }
    }

    public static boolean valid(int[][] right0s, int[][] below0s, int leftTopX, int leftTopY, int edge) {
        int left = below0s[leftTopX][leftTopY], top = right0s[leftTopX][leftTopY];
        int right = below0s[leftTopX][leftTopY + edge - 1];
        int bottom = right0s[leftTopX  + edge - 1][leftTopY];
        if (left < edge || top < edge || right < edge || bottom < edge) {
            return false;
        }else{
            return true;
        }
    }

    public static void preprocess(int[][] input, int[][] right0s, int[][] below0s) {
        for (int r = input.length - 1; r >= 0; r--) {
            for (int c = input.length - 1; c >= 0; c--) {
                if (input[r][c] == 0) {
                    right0s[r][c]++;
                    below0s[r][c]++;
                    if (c < input.length - 1) {
                        right0s[r][c] += right0s[r][c + 1];
                    }
                    if (r < input.length - 1) {
                        below0s[r][c] += below0s[r + 1][c];
                    }
                }
            }
        }
    }
}
