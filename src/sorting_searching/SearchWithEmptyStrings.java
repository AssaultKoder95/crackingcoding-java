package sorting_searching;

public class SearchWithEmptyStrings {
    public static int search(String[] strings, String str) {
        if (strings.length == 0 || str.isEmpty()) {
            return -1;
        }
        return searchI(strings, str, 0, strings.length - 1);
    }

    public static int searchI(String[] strings, String str, int start, int end) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (strings[mid].isEmpty()) {
                int left = mid - 1, right = mid + 1;
                while (strings[left].isEmpty() && strings[right].isEmpty()) {
                    if (left < start && right > end) {
                        return -1;
                    } else if (left < start && right > end) {
                        return -1;
                    } else if (right <= start && !strings[right].isEmpty()) {
                        mid = right;
                        break;
                    } else if (left >= start && !strings[left].isEmpty()) {
                        mid = left;
                        break;
                    }
                    right++;
                    left--;
                }
                int res = strings[mid].compareTo(str);
                if (res == 0) {
                    return mid;
                } else if (res < 0) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
