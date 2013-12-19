package chpt1.practice.myself;

public class InterviewQuestions1_5 {
    
    /**
     * compress String fffwwwtttqt -> f3w3t3q1t1, comlexity->n , using var ->curChar to traverse
     * @param et1
     * @return
     */
    public static String compressString(String et1) {
        char curChar = et1.charAt(0);
        int curCount = 1;
        StringBuilder target = new StringBuilder();
        for (int i = 0; i < et1.length(); i++) {
            if (curChar != et1.charAt(i)) {
                target.append(curChar);
                target.append(curCount);
                curChar = et1.charAt(i);
                curCount = 1;
            } else
                curCount++;
        }
        target.append(curChar);//FIXME notice the bound situation
        target.append(curCount);//FIXME notice the bound situation
        return target.toString().length() < et1.length() ? target.toString() : et1;
    }

    public static void main(String[] args) {
        System.out.println(InterviewQuestions1_5.compressString("fffwwwtttqpot"));
    }
}
