/**
 * CTCI 9.8
 */
package recursion_dp;

public class Cents {
    /**
     * we cannot define dp function like this: f(n) = f(n-25)+f(n-10)+f(n-5)+f(n-1)
     * because we cannot fix the order of subproblems
     * Time Complexity: O(total * N * (total/Ci))
     */
    public int findNumOfMakeChange(int total, int[] cents) {
        int[][] dp = new int[cents.length + 1][total + 1];
        for (int i = 0; i <= cents.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= cents.length; i++) {
            for (int j = 1; j <= total; j++) {
                int remain = j;
                while (remain >= 0) {
                    dp[i][j] += dp[i - 1][remain];
                    remain -= cents[i - 1];
                }
            }
        }
        return dp[cents.length][total];
    }

    //Time Complexity: O(total * N)
    public int findNumOfMakeChangeOptimized(int total, int[] cents) {
        int[] dp = new int[total + 1];
        dp[0] = 1;
        for (int i = 1; i <= cents.length; i++) {
            for (int j = cents[i - 1]; j <= total; j++) {
                dp[j] = dp[j] + dp[j - cents[i - 1]];
            }
        }
        return dp[total];
    }

    public static void main(String[] args) {
        int[] cent = new int[] { 25, 10, 5, 2, 1 };
        Cents test = new Cents();
        System.out.println(test.findNumOfMakeChange(5, cent));
        System.out.println(test.findNumOfMakeChangeOptimized(5, cent));
    }
}
