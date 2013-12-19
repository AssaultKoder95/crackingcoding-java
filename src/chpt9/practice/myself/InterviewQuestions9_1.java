package chpt9.practice.myself;

public class InterviewQuestions9_1 {

    /**
     * assume that f(n) is total ways for going up n staircases
     * so f(n) = f(n-1) + f(n-2) + f(n-3) (cause f(n-1), f(n-2), f(n-3) are not intersect)
     * this is Changjian's answer, iterative solution;
     * just use a array(3) as cache; update this cache in round-robin way
     * 
     * @return
     */
    public static int countWays1(int n) {
        int[] cache = new int[3];
        //init
        cache[0] = 1;
        cache[1] = 1;
        cache[2] = 2;
        for (int i = 3; i <= n; i++) {
            int tempSum = cache[0] + cache[1] + cache[2];
            cache[i % 3] = tempSum;
        }
        return cache[n % 3];
    }

    /**
     * this is recursive way without any cache which need lots of stack space.
     * 
     * @param n
     * @return
     */
    public static int countWays2(int n) {
        if (n == 1)
            return 1;
        else if (n == 2)
            return 2;
        else if (n == 3)
            return 4;
        return countWays2(n - 1) + countWays2(n - 2) + countWays2(n - 3);
    }

    final static int MAX = 100;
    public static int cache[] = new int[MAX];

    /**
     * this is use cache to decrease the stack space when using recursive way to solve this problem.
     * @param n
     * @return
     */
    public static int countWays3(int n) {
        if (cache[n] != 0)
            return cache[n];
        if (n == 1) {
            cache[n] = 1;
            return cache[n];
        } else if (n == 2) {
            cache[n] = 2;
            return cache[n];
        } else if (n == 3) {
            cache[n] = 4;
            return cache[n];
        }
        cache[n] = countWays3(n - 3) + countWays3(n - 1) + countWays3(n - 2);
        return cache[n];
    }
    
    public static void main(String[] args) {
        System.out.println(InterviewQuestions9_1.countWays1(10));
        System.out.println(InterviewQuestions9_1.countWays2(10));
        System.out.println(InterviewQuestions9_1.countWays3(10));
    }
}
