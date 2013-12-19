package chpt1.practice.myself;

import java.util.HashMap;
import java.util.Iterator;

public class InterviewQuestions1_3 {
    
    /**
     * normal logic double space
     * @param src
     * @param target
     * @return
     */
    public static boolean detectPermutation1(String src, String target) {
        if(src.length() != target.length())
            return false;
        HashMap<Character, Integer> srcMap = new HashMap<Character, Integer>();
        HashMap<Character, Integer> targetMap = new HashMap<Character, Integer>();
        for(int i = 0; i < src.length(); i++) {
            if(!srcMap.containsKey(src.charAt(i)))
                srcMap.put(src.charAt(i), 1);
            else
                srcMap.put(src.charAt(i), srcMap.get(src.charAt(i)) + 1);
            if(!targetMap.containsKey(target.charAt(i)))
                targetMap.put(target.charAt(i), 1);
            else
                targetMap.put(target.charAt(i), targetMap.get(target.charAt(i)) + 1);
        }
        if(!srcMap.equals(targetMap))
            return false;
        return true;
    }
    
    /**
     * tricky logic single space
     * @param src
     * @param target
     * @return
     */
    public static boolean detectPermutation2(String src, String target) {
        if(src.length() != target.length())
            return false;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < src.length(); i++) {
            if(!map.containsKey(src.charAt(i)))
                map.put(src.charAt(i), 1);
            else
                map.put(src.charAt(i), map.get(src.charAt(i)) + 1);
            if(!map.containsKey(target.charAt(i)))
                map.put(target.charAt(i), -1);
            else
                map.put(target.charAt(i), map.get(target.charAt(i)) - 1);
        }
        Iterator<Integer> iterator = map.values().iterator();
        while(iterator.hasNext()) {
            if(!(iterator.next().intValue() == 0))
                return false;
            //TODO when you try to compare two objects (and an Integer is an object, not a variable) the result will always be that they're not equal,
            //in your case you should compare fields of the objects (in this case intValue)
//            if(!iterator.next().equals(Integer.valueOf(0)));
//                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(InterviewQuestions1_3.detectPermutation2("srdc", "rsdc"));
    }
}
