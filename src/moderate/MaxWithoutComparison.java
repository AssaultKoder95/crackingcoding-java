/**
 * CTCI 17.4
 */
package moderate;

public class MaxWithoutComparison {
    public static int solution1(int a, int b) {//this solution may overflow
        int[] ans = new int[] { a, b };
        int z = a - b;
        z = (z >> 31) & 1;
        return ans[z];
    }

    public static int solution2(int a, int b) {//this solution consider overflow
        int[] ans = new int[] { a, b };
        int signDiff = ((a ^ b) >> 31) & 1;//if sign(a) diff with sign(b), signDiff = 1; signSame = 0;
        int signSame = signDiff ^ 1;//if sign(a) equal with sign(b), signDiff = 0; signSame = 1;
        int signA = (a >> 31) & 1;
        int idx = signDiff * signA + signSame * (((a - b) >> 31) & 1);
        return ans[idx];
    }

    public static void main(String[] args) {
        System.out.println(solution2(Integer.MIN_VALUE, 16));
    }
}
