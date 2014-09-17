package arrays_strings;

import java.util.HashMap;
import java.util.Iterator;

public class CheckPermutation {

    /**
     * use extra space
     */
    public static boolean check1(String a, String b) {
        if (a.length() != b.length())
            return false;
        int[] map = new int[256];
        for (int i = 0; i < a.length(); i++) {
            map[a.charAt(i)]++;
        }
        for (int i = 0; i < b.length(); i++) {
            if (map[b.charAt(i)] <= 0) {
                return false;
            } else {
                map[b.charAt(i)]--;
            }
        }
        return true;
    }

    /**
     * tricky logic single space
     */
    public static boolean check2(String a, String b) {
        if (a.length() != b.length())
            return false;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < a.length(); i++) {
            if (!map.containsKey(a.charAt(i)))
                map.put(a.charAt(i), 1);
            else
                map.put(a.charAt(i), map.get(a.charAt(i)) + 1);
            if (!map.containsKey(b.charAt(i)))
                map.put(b.charAt(i), -1);
            else
                map.put(b.charAt(i), map.get(b.charAt(i)) - 1);
        }
        Iterator<Integer> iterator = map.values().iterator();//NOTE API
        while (iterator.hasNext()) {
            if (!(iterator.next().equals(Integer.valueOf(0)))){//NOTE compare the val of two integers
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(CheckPermutation.check2("srdcr", "rsdrc"));
    }
}
