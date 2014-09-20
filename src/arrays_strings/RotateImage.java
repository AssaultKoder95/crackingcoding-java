/**
 * CTCI 1.6
 */
package arrays_strings;

public class RotateImage {

    public static int[][] rotate(int[][] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                int temp = a[i][j];
                a[i][j] = a[n - 1 - j][n - 1 - i];
                a[n - 1 - j][n - 1 - i] = temp;
            }
        }
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = a[i][j];
                a[i][j] = a[n - 1 - i][j];
                a[n - 1 - i][j] = temp;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int[][] test = new int[][] { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 },
                { 16, 17, 18, 19, 20 }, { 21, 22, 23, 24, 25 } };
        test = rotate(test);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(test[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}
