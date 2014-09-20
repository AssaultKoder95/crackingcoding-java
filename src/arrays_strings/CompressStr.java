/**
 * CTCI 1.5
 */
package arrays_strings;

public class CompressStr {

    public static String compressString(String a) {
        if (a.length() == 0) {
            return null;
        }
        int count = 1;
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < a.length() - 1; i++) {
            if (a.charAt(i) == a.charAt(i + 1)) {
                count++;
            } else {
                ans.append(a.charAt(i));
                ans.append(count);
                count = 1;
            }
        }
        ans.append(a.charAt(a.length() - 1)).append(count);
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(CompressStr.compressString("fffwwwtttqpottt"));
    }
}
