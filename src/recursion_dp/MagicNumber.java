/**
 * CTCI 9.3
 */
package recursion_dp;

public class MagicNumber {

    /**
     * find whether A[i]==i in a sorted array;
     * this solution is fit for the array without duplicates
     */
    public static boolean findMagicIdxNonDup(int[] array) {
        if (array[array.length - 1] < (array.length - 1))//NOTE
            return false;
        return findRecurisve(array, 0, array.length - 1);
    }

    public static boolean findRecurisve(int[] src, int start, int end) {
        if (start > end) {
            return false;
        }
        int mid = (start + end) / 2;
        if (src[mid] == mid) {
            return true;
        } else if (src[mid] < mid) {
            return findRecurisve(src, mid + 1, end);
        } else {
            return findRecurisve(src, start, mid - 1);
        }
    }

    /**
     * this function is designed for solving sorted array with duplicates
     * don't use bisection but use the last element value as index to detect
     * the average time is still log(n)
     */
    public static boolean findMagicIdxDup(int[] array) {
        return findRecurisveDup(array, 0, array.length - 1);
    }

    public static boolean findRecurisveDup(int[] array, int start, int end) {
        if (start > end) {
            return false;
        }
        if (array[end] == end) {
            return true;
        } else if (array[end] >= start && array[end] < end && array[array[end]] == array[end]) {
            if (array[array[end]] == array[end]) {
                return true;
            } else {
                return findRecurisveDup(array, start, array[end] - 1);
            }
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        int[] test = { -3, -2, -1, 3, 8, 9, 10 };
        System.out.println(MagicNumber.findMagicIdxNonDup(test));
        int[] test2 = { -1, 1, 1, 2, 2, 2, 2, 3 };
        System.out.println(MagicNumber.findMagicIdxDup(test2));
    }
}
