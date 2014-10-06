/**
 * CTCI 17.5
 */
package moderate;

import java.util.HashMap;

public class MasterMind {
    public static class Result {
        public int hits = 0;
        public int pseudoHits = 0;
    }

    public static Result estimate(char[] solution, char[] guess) {
        Result res = new Result();
        HashMap<Character, Integer> solMap = new HashMap<Character, Integer>();
        HashMap<Character, Integer> gueMap = new HashMap<Character, Integer>();
        for (int i = 0; i < 4; i++) {
            if (guess[i] == solution[i]) {
                res.hits++;
                continue;
            }
            solMap.put(solution[i], solMap.containsKey(solution[i]) ? solMap.get(solution[i]) + 1 : 1);
            gueMap.put(guess[i], gueMap.containsKey(guess[i]) ? gueMap.get(guess[i]) + 1 : 1);
        }
        char[] all = new char[] { 'R', 'G', 'B', 'Y' };
        for (int i = 0; i < all.length; i++) {
            if (solMap.containsKey(all[i]) && gueMap.containsKey(all[i])) {
                res.pseudoHits += Math.min(solMap.get(all[i]), gueMap.get(all[i]));
            }
        }
        res.pseudoHits -= res.hits;
        return res;
    }
}
