package arrays_strings;

public class StringReverse {
    
    /**
     * reverse a string
     */
    public static String reverseString(String target) {
        char[] tArray = target.toCharArray();
        char temp;
        //TODO point is odd/2 -> lower bound tricky!
        for(int i = 0; i < target.length() / 2; i ++){
            temp = tArray[i];
            tArray[i] = tArray[target.length() - 1 - i];
            tArray[target.length() - 1 - i] = temp;
        }
        return tArray.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(StringReverse.reverseString("sdfsdifsdfsdfb"));
    }
}
