/**
 * CTCI 5.5
 */
package bit_manipulation;

public class NumOfBitsAConvertToB {

    public static int compute1(int a, int b) {
        int count = 0;
        for (int c = a ^ b; c != 0; c = c >>> 1) {
            count += c & 1;
        }
        return count;
    }

    public static int compute2(int a, int b) {
        int count = 0;
        for (int c = a ^ b; c != 0; c = c & (c - 1)) {
            count++;
        }
        return count;
    }

}
