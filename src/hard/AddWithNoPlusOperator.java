/**
 * CTCI 18.1 
 */
package hard;

public class AddWithNoPlusOperator {
    public static int solution(int a, int b) {
        if (b == 0) {
            return a;
        }
        int sum = a ^ b;
        int carry = (a & b) << 1;
        return solution(sum, carry);
    }
}
