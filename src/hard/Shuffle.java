/**
 * CTCI 18.2
 */
package hard;

public class Shuffle {
    public static void solution(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int pos = i + (int) Math.random() * ((array.length - 1) - i + 1);
            swap(array, i, pos);
        }
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
