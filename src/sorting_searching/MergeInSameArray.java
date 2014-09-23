/**
 * CTCI 11.1
 */
package sorting_searching;

public class MergeInSameArray {
    public static void merge(int[] A, int[] B, int aLen, int bLen) {
        int idx = aLen + bLen - 1, a = aLen - 1, b = bLen - 1;
        if (A[a] >= B[b]) {
            A[idx--] = A[a--];
        } else {
            A[idx--] = B[b--];
        }
        while (b >= 0) {
            A[idx--] = B[b--];
        }
    }
}
