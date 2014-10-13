/**
 * CTCI 18.8
 * see http://hawstein.com/posts/20.8.html
 */
package hard;

import java.util.Arrays;

public class SuffixTrie {
    private int childNum = 26;
    private int label = 0;
    private int[][] suffixTrie;

    public SuffixTrie(String str) {
        suffixTrie = new int[str.length() * str.length()][this.childNum];
        for (int i = 0; i < suffixTrie.length; i++) {
            Arrays.fill(suffixTrie[i], -1);
        }
        for (int i = 0; i < str.length(); i++) {
            insert(str.substring(i));
        }
    }

    public void insert(String str) {
        int pos = 0;
        for (int i = 0; i < str.length(); i++) {
            int child = str.charAt(i) - 'a';
            if (suffixTrie[pos][child] == -1) {
                suffixTrie[pos][child] = this.label++;
            }
            pos = suffixTrie[pos][child];
        }
    }

    public boolean find(String str) {
        int pos = 0;
        for (int i = 0; i < str.length(); i++) {
            int child = str.charAt(i) - 'a';
            if (suffixTrie[pos][child] == -1) {
                return false;
            }
            pos = suffixTrie[pos][child];
        }
        return true;
    }

    public static void main(String[] args) {
        SuffixTrie tree = new SuffixTrie("mississippi");
        String patt[] = new String[] { "is", "sip", "hi", "sis", "mississippa" };
        for (int i = 0; i < patt.length; i++) {
            System.out.println(tree.find(patt[i]));
        }
    }
}
