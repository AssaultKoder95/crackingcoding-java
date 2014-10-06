/**
 * CTCI 11.2
 */
package sorting_searching;

import java.util.Arrays;
import java.util.Comparator;

public class SortStrInAnagram {
    public static class anaComparator implements Comparator<String> {
        public String sort(String s) {
            char[] content = s.toCharArray();
            Arrays.sort(content);
            return new String(content);
        }

        @Override
        public int compare(String o1, String o2) {
            return sort(o1).compareToIgnoreCase(sort(o2));
        }
    }
    
    public static String[] sort(String[] input){
        Arrays.sort(input, new anaComparator());
        return input;
    }
}
