package arrays_strings;

public class InterviewQuestions1_8 {
    
    /**
     * FIXME this is answer, is very clear to use the issubstring() skillfully
     * detect whether str2 is the rotation of str1.
     * Definition, eg. str: iloveyou if choose i as part1, loveyou as part2 to rotate, then the result will be loveyoui
     * this clever algorithm is str1: xy, detect str2 -> str2 isSubString of str1str1(xyxy)
     * background: string rotation as a way to normalize string, then can be easily to check the equality
     * @param et1
     * @param et2
     * @return
     */
    public static boolean detectStrRotation(String et1, String et2) {
        if (et1.length() == et2.length() && et2.length() != 0) {
            StringBuilder et1et1 = new StringBuilder();
            et1et1.append(et1).append(et1);
            if (et1et1.toString().contains(et2))
                return true;
            else
                return false;
        } else
            return false;
    }
    
    public static void main(String[] args) {
        System.out.println(InterviewQuestions1_8.detectStrRotation("iloveyou", "loveyoui"));
    }
}
