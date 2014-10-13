/**
 * CTCI 17.6
 */
package moderate;

public class MinUnsortedSubArray {
    public static void solution(int[] array) {
        int i = 0, j = array.length - 1;
        while (i < j) {
            if (array[i] <= array[i + 1]) {
                i++;
                continue;
            }
            if (array[j] >= array[j - 1]) {
                j--;
                continue;
            }
            break;
        }
        if (i >= j) {
            System.out.println("The Array already been sorted!");
            return;
        }
        int unSortedMax = Integer.MIN_VALUE, unSortedMin = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            unSortedMin = Math.min(unSortedMin, array[k]);
            unSortedMax = Math.max(unSortedMax, array[k]);
        }
        while (i >= 0 || j <= array.length - 1) {
            if (array[i] > unSortedMin) {
                unSortedMin = Math.min(unSortedMin, array[i]);
                unSortedMax = Math.max(unSortedMax, array[i]);
                i--;
                continue;
            }
            if (array[j] < unSortedMax) {
                unSortedMin = Math.min(unSortedMin, array[j]);
                unSortedMax = Math.max(unSortedMax, array[j]);
                j++;
                continue;
            }
            break;
        }
        System.out.println("Left: " + (i + 1) + " --- " + "right: " + (j - 1));
    }

    public static void main(String[] args) {
        MinUnsortedSubArray.solution(new int[] { 1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19 });
    }
}
