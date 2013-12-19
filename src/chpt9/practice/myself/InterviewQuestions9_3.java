package chpt9.practice.myself;

public class InterviewQuestions9_3 {

    /**
     * find whether A[i]==i in a sorted array;
     * this solution only fit in the array without duplicates
     * cause this array is sorted, so we don't need linear scan but binary search
     * 
     * @param src
     * @return
     */
    public static boolean findMagicIndexNonDuplicates(int[] src) {
        if (src[src.length - 1] < (src.length - 1))
            return false;
        return findMagicIndexRecursive(src, 0, src.length - 1);
    }

    public static boolean findMagicIndexRecursive(int[] src, int start, int end) {
        if ((end - start) <= 1) {
            if ((src[start] == start) || (src[end] == end))
                return true;
            else
                return false;
        }
        int mid = (start + end) / 2;
        if (src[mid] == mid)
            return true;
        else if (src[mid] < mid)
            return findMagicIndexRecursive(src, mid + 1, end);
        else
            return findMagicIndexRecursive(src, start, mid - 1);
    }

    /**
     * this function is designed for solving array with duplicates
     * don't use bisection but use the last element value as index to detect
     * the average time is still log(n)
     * 
     * @param src
     * @return
     */
    public static boolean findMagicIndexDuplicates(int[] src) {
        return findMagicIndexDuplicatesRecursive(src, 0, src.length - 1);
    }

    public static boolean findMagicIndexDuplicatesRecursive(int[] src, int start, int end) {
        if ((end - start) <= 1) {
            if ((src[start] == start) || (src[end] == end))
                return true;
            else
                return false;
        }
        if (src[end] == end)
            return true;
        else if (src[src[end]] == src[end])
            return true;
        else
            return findMagicIndexDuplicatesRecursive(src, start, src[end] - 1);
    }

    public static void main(String[] args) {
        int[] test = { -3, -2, -1, 3, 8, 9, 10 };
        System.out.println(InterviewQuestions9_3.findMagicIndexNonDuplicates(test));
        int[] test2 = { -1, 1, 1, 2, 2, 2, 2, 3};
        System.out.println(InterviewQuestions9_3.findMagicIndexDuplicates(test2));
    }
}
