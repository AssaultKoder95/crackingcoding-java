package hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class LongestWordBreak {
    public static String solution(String[] data) {
        HashSet<String> set = new HashSet<String>();
        for (String iter : data) {
            set.add(iter);
        }
        Arrays.sort(data, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -(o1.length() - o2.length());
            }
        });
        for (String iter : data) {
            set.remove(iter);
            if (search(iter, set)) {
                return iter;
            }
            set.add(iter);
        }
        return null;
    }

    public static boolean search(String str, HashSet<String> set) {
        if (str.equals("")) {
            return true;
        }
        for (int i = 1; i <= str.length(); i++) {
            String cur = str.substring(0, i);
            String next = str.substring(i);
            if (set.contains(cur) && search(next, set)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(LongestWordBreak.solution(new String[] { "cat", "banana", "dog", "nana", "walk", "walker",
                "dogwalker" }));
    }
}
