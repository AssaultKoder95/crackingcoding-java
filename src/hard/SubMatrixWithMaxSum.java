/**
 * CTCI 18.12
 */
package hard;

public class SubMatrixWithMaxSum {
    //O(n^3)
    public int getMaxSubSum(int[][] input) {
        int rows = input.length, cols = input[0].length;
        int ans = 0;
        for(int rowStart = 0; rowStart < rows; rowStart++){
            int[] partSum = new int[cols];
            for(int rowEnd = rowStart; rowEnd < rows; rowEnd++){
                for(int i = 0; i < cols; i++){
                    partSum[i] += input[rowEnd][i];
                }
                int res = maxSubArray(partSum);
                ans = Math.max(ans, res);
            }
        }
        return ans;
    }

    public int maxSubArray(int[] array){
        int curSum = array[0], maxSum = array[0];
        for(int i = 1; i < array.length; i++){
            curSum = Math.max(curSum + array[i], array[i]);
            maxSum = Math.max(maxSum, curSum);
        }
        return maxSum;
    }
    
    public static void main(String[] args) {
        int[][] test = { { 3, -1, 0 }, { 0, 2, -2 }, { -3, 4, 6 } };
        SubMatrixWithMaxSum in = new SubMatrixWithMaxSum();
        System.out.println(in.getMaxSubSum(test));
    }
}
