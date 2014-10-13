/**
 * CTCI 17.11
 */
package moderate;

public class Rand7UsingRand5 {
    public static int rand7() {
        while (true) {
            int num = 5 * rand5() + rand5();
            if (num < 21) {
                return num % 7;
            }
        }
    }

    public static int rand5() {
        return (int) (Math.random() * 100) % 5;
    }
}
