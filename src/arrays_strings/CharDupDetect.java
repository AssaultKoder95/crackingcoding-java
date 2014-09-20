/**
 * CTCI 1.1
 */
package arrays_strings;

import java.util.Arrays;
import java.util.HashSet;

public class CharDupDetect {
    
    /**
     * use data structure
     */
    public static boolean detectDuplicates1 (String target) {
        HashSet<Character> set = new HashSet<Character>();
        for(int i = 0; i < target.length(); i++) {
            if(!set.contains(target.charAt(i)))
                set.add(target.charAt(i));
            else
                return false;
        }
        return true;
    }
    
    /**
     * don't use extra space
     */
    public static boolean detectDuplicates2 (char[] target) {
        Arrays.sort(target);
        for(int i = 0; i < target.length - 1; i++) {
            if(target[i] == target[i+1])
                return false;
        }
        return true;
    }
    
}
