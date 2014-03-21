package moderate;

public class MaxWithoutComparison {
    public static int solution(int a, int b) {
        int[] ans = new int[] { a, b };
        int z = a - b;
        z = (z >> 31) & 1;
        return ans[z];
    }
}
