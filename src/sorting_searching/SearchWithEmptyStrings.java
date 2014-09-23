/**
 * CTCI 11.5
 */
package sorting_searching;

public class SearchWithEmptyStrings {
    //strings have already been sorted and interspersed with empty strings
    public static int search(String[] strings, String str) {
        if (strings.length == 0 || str.isEmpty()) {
            return -1;
        }
        return binarySearch(strings, str, 0, strings.length - 1);
    }

    public static int binarySearch(String[] strings, String str, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (strings[mid].isEmpty()) {
            int left = mid - 1, right = mid + 1;
            while (true) {
                if (left < start && right > end) {
                    return -1;
                } else if (right <= end && !strings[right].isEmpty()) {
                    mid = right;
                    break;
                } else if (left >= start && !strings[left].isEmpty()) {
                    mid = left;
                    break;
                }
                right++;
                left--;
            }
        }
        int res = strings[mid].compareTo(str);
        if (res == 0) {
            return mid;
        } else if (res < 0) {
            return binarySearch(strings, str, mid + 1, end);
        } else {
            return binarySearch(strings, str, start, mid - 1);
        }
    }
}
