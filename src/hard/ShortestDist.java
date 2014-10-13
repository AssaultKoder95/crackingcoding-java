/**
 * CTCI 18.5
 */
package hard;

public class ShortestDist {
    public static int solution(String[] text, String word1, String word2) {
        int pos1 = -1, pos2 = -1, min = Integer.MAX_VALUE;
        for (int i = 0; i < text.length; i++) {
            if (text[i].equals(word1)) {
                pos1 = i;
                if(pos2 != -1){
                    min = Math.min(min, pos1 - pos2);
                }
            } else if (text[i].equals(word2)) {
                pos2 = i;
                if(pos1 != -1){
                    min = Math.min(min, pos2 - pos1);
                }
            }
        }
        return min;
    }
}
