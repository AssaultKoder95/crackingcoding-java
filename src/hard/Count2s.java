package hard;

public class Count2s {
    /**
     * Three Case http://hawstein.com/posts/20.4.html
     * 
     * @param n
     * @return
     */
    public static int solution(int n) {
        int ans = 0, x = n;
        for (int i = 0; x > 0; x = x / 10, i++) {
            int digit = x % 10;
            if (digit < 2) {
                ans += (x / 10) * (Math.pow(10, i));
            } else if (digit == 2) {
                ans += (x / 10) * (Math.pow(10, i)) + (n - x * (Math.pow(10, i)) + 1);
            } else {
                ans += (x / 10 + 1) * (Math.pow(10, i));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Count2s.solution(122));
    }
}
