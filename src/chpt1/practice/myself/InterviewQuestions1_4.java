package chpt1.practice.myself;

public class InterviewQuestions1_4 {
    /**
     * FIXME this is answer, my thought is n2, answer is n
     * critical points: 1.only one char array, how to replace space char efficiently? better no other data structure
     * :),from end of true length to traverse the backward the char array, no need to worry about the overwrite the original char
     * the true length is actual length for the string in this char array (array may be very long)
     * use char array to implement instead of String lib
     * copy complexity is 2n, not n2(from the start of this array, and traverse forward this array)
     * @param src
     * @return
     */
    public static char[] replaceSpace(char[] src, int length) {//TODO length is true length which contain real char, not whole array
        int countSpace = 0;
        for(int i = 0; i < length; i++) {
            if(src[i] == ' ')
                countSpace ++;
        }
        int newStringLength = length + 2 * countSpace;
        //TODO start from end of this array, and traverse backward; no need to worry about overwriting original char
        for(int i = length - 1, j = newStringLength - 1; i >= 0; i--) {//TODO for Loop could init multiple variables
            if(src[i] == ' ') {
                src[j - 2] = '%';//TODO no need to worry 'escape character'
                src[j - 1] = '2';
                src[j - 0] = '0';
                j = j - 3;
            }
            else {
                src[j] = src[i];
                j--;
            }
        }
        return src;
    }
    
    public static void main(String[] args) {
        char[] test = new char[10];
        test[0] = 's';
        test[1] = 'f';
        test[2] = 'g';
        test[3] = ' ';
        System.out.println(InterviewQuestions1_4.replaceSpace(test, 4));
    }
}
