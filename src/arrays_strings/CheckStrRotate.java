/**
 * CTCI 1.8
 */
package arrays_strings;

public class CheckStrRotate {
    
    /**
     * if s1s1 -> xyxy, check whether it contains yx
     */
    public static boolean detectStrRotation(String s1, String s2) {
        if (s1.length() == s2.length() && s2.length() != 0) {
            StringBuilder et1et1 = new StringBuilder();
            et1et1.append(s1).append(s1);
            if (et1et1.toString().contains(s2))
                return true;
            else
                return false;
        } else
            return false;
    }
    
    public static void main(String[] args) {
        System.out.println(CheckStrRotate.detectStrRotation("iloveyou", "loveyoui"));
    }
}
