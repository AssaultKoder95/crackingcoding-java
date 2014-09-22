package recursion_dp;

public class UniquePath {
    /**
     * DP: the time complexity is C(x, x + y) 
     */
    public static int countPaths2(int rows, int cols) {
        int[] lastRow = new int[cols];
        for (int i = 0; i < cols; i++) {
            lastRow[i] = 1;
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                lastRow[j] = lastRow[j - 1] + lastRow[j];
            }
        }
        return lastRow[cols - 1];
    }

}
