package arrays_strings;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class DuplicatesDetection {
    
    /**
     * use data structure
     * @param target
     * @return
     */
    public static boolean detectDuplicates1 (String target) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < target.length(); i++) {
            if(!map.containsKey(target.charAt(i)))
                map.put(target.charAt(i), 1);
            else
                return false;
        }
        return true;
    }
    
    /**
     * un-use data structure
     * @param target
     * @return
     */
    
    public static boolean detectDuplicates2 (String target) {
        char[] charArray = target.toCharArray();
        Arrays.sort(charArray);
        for(int i = 0; i < charArray.length - 1; i++) {
            if(charArray[i] == charArray[i+1])
                return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        DuplicatesDetection o = new DuplicatesDetection();
        System.out.println(DuplicatesDetection.detectDuplicates1("ssgt"));
    }
}
