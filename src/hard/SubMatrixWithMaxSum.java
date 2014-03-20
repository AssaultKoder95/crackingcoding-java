package hard;

public class SubMatrixWithMaxSum {
    /**
     * O(n^3), Note: http://hawstein.com/posts/20.12.html
     * 
     * @param input
     * @return
     */
    public static int getMaxSubSum(int[][] input) {
        return search(preCompute(input));
    }

    public static int search(int[][] partSum) {
        int lens = partSum.length, cols = partSum[0].length, ans = Integer.MIN_VALUE;
        for (int i = 1; i < lens; i++) {
            for (int j = i; j < lens; j++) {
                int sumItoJin1 = partSum[j][1] - partSum[j][1 - 1] - partSum[i - 1][1] + partSum[i - 1][1 - 1];
                int continueSum = sumItoJin1, maxSubArraySum = sumItoJin1;
                for (int k = 2; k < cols; k++) {
                    int sumItoJinK = partSum[j][k] - partSum[j][k - 1] - partSum[i - 1][k] + partSum[i - 1][k - 1];
                    continueSum = Math.max(continueSum + sumItoJinK, sumItoJinK);
                    maxSubArraySum = Math.max(maxSubArraySum, continueSum);
                }
                ans = Math.max(ans, maxSubArraySum);
            }
        }
        return ans;
    }

    public static int[][] preCompute(int[][] input) {
        int lens = input.length, cols = input[0].length, partSum[][] = new int[lens + 1][cols + 1];
        for (int i = 1; i <= lens; i++) {
            for (int j = 1; j <= cols; j++) {
                partSum[i][j] = partSum[i][j - 1] + partSum[i - 1][j] - partSum[i - 1][j - 1] + input[i - 1][j - 1];
            }
        }
        return partSum;
    }

    public static void main(String[] args) {
        int[][] test = { { 3, -1, 0 }, { 0, 2, -2 }, { -3, 4, 6 } };
        System.out.println(SubMatrixWithMaxSum.getMaxSubSum(test));
    }
}
