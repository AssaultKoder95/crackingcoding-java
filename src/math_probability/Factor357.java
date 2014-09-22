/**
 * CTCI 7.7
 */
package math_probability;

import java.util.LinkedList;

public class Factor357 {

    public static int findKthNum(int k) {
        if (k < 0) {
            return 0;
        }
        int val = 0;
        //time complexity is O(k), why we need 3queue? because we don't need compare 5*A1 with 5*A3
        LinkedList<Integer> queue3 = new LinkedList<Integer>();
        LinkedList<Integer> queue5 = new LinkedList<Integer>();
        LinkedList<Integer> queue7 = new LinkedList<Integer>();
        for (int i = 0; i <= k; i++) {
            int v3 = queue3.size() > 0 ? queue3.peek() : Integer.MAX_VALUE;
            int v5 = queue3.size() > 0 ? queue5.peek() : Integer.MAX_VALUE;
            int v7 = queue3.size() > 0 ? queue7.peek() : Integer.MAX_VALUE;
            val = Math.min(v3, Math.min(v5, v7));
            if (val == v3) {
                queue3.remove();
                queue3.add(3 * val);
                queue5.add(5 * val);
            } else if (val == v5) {
                queue5.remove();
                queue5.add(5 * val);//NOTE think why we don't need add to queue3?(in case of dup)
            } else if (val == v7) {
                queue7.remove();//NOTE think why ....to queue3, and queue5?
            }
            queue7.add(7 * val);
        }
        return val;
    }

}