package moderate;

import java.util.HashMap;
import java.util.HashSet;

public class MasterMind {
    public static class Result {
        public int hits = 0;
        public int pseudoHits = 0;
    }

    /**
     * Don't consider Duplicates, eg. RYYY, GRRR, so the pseudoHits for R is 3
     * 
     * @param solution
     * @param guess
     * @return
     */
    public static Result estimate1(char[] solution, char[] guess) {
        Result res = new Result();
        HashSet<Character> set = new HashSet<Character>();
        for (char iter : solution) {
            set.add(iter);
        }
        for (int i = 0; i < guess.length; i++) {
            if (guess[i] == solution[i]) {
                res.hits++;
            } else if (set.contains(guess[i])) {
                res.pseudoHits++;
            }
        }
        return res;
    }

    public static Result estimate2(char[] solution, char[] guess) {
        Result res = new Result();
        HashMap<Character, Integer> solMap = new HashMap<Character, Integer>();
        HashMap<Character, Integer> gueMap = new HashMap<Character, Integer>();
        for (int i = 0; i < 4; i++) {
            if (guess[i] == solution[i]) {
                res.hits++;
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
