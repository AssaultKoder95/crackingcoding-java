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
    public static void main(String[] args) {
        System.out.println(AddWithNoPlusOperator.solution(3, 5));
    }
}
