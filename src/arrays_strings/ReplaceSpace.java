/**
 * CTCI 1.4
 */
package arrays_strings;

public class ReplaceSpace {
    
    public static char[] replaceSpace(char[] input, int length) {
        int numSpac = 0;
        for(int i = 0; i < length; i++) {
            if(input[i] == ' ')
                numSpac ++;
        }
        int newLen = length + 2 * numSpac;
        for(int i = length - 1, j = newLen - 1; i >= 0; i--) {
            if(input[i] == ' ') {
                input[j--] = '0';
                input[j--] = '2';
                input[j--] = '%';
            }else {
                input[j--] = input[i];
            }
        }
        return input;
    }
    
    public static void main(String[] args) {
        char[] test = new char[10];
        test[0] = 's';
        test[1] = 'f';
        test[2] = 'g';
        test[3] = ' ';
        test[4] = 's';
        test[5] = 'f';
        test[6] = 'g';
        System.out.println(ReplaceSpace.replaceSpace(test, 7));
    }
}
