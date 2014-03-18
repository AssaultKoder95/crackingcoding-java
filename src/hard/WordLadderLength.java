package hard;

import java.util.HashSet;
import java.util.LinkedList;

public class WordLadderLength {
    public int solution(String start, String end, HashSet<String> dict) {
        LinkedList<String> queue = new LinkedList<String>();
        HashSet<String> used = new HashSet<String>();
        int minDepth = 1, curCnt = 1, nextCnt = 0;
        queue.add(start);
        used.add(start);
        while (queue.isEmpty()) {
            String cur = queue.pollFirst();
            if (cur.equals(end)) {
                return minDepth;
            }
            curCnt--;
            char[] curArray = cur.toCharArray();
            for (int i = 0; i < curArray.length; i++) {
                char originChar = curArray[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c != originChar) {
                        curArray[i] = c;
                        String nextWord = new String(curArray);
                        if (dict.contains(nextWord) && !used.contains(nextWord)) {
                            nextCnt++;
                            queue.add(nextWord);
                            used.add(nextWord);
                        }
                    }
                }
            }
            if (curCnt == 0 && nextCnt != 0) {
                curCnt = nextCnt;
                nextCnt = 0;
                minDepth++;
            }
        }
        return -1;
    }
}
