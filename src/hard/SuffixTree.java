package hard;

import java.util.Arrays;

public class SuffixTree {
    private int childNum = 26;
    private int label = 0;
    private int[][] suffixTree;

    public SuffixTree(String str) {
        suffixTree = new int[str.length() * str.length()][this.childNum];
        for (int i = 0; i < suffixTree.length; i++) {
            Arrays.fill(suffixTree[i], -1);
        }
        for (int i = 0; i < str.length(); i++) {
            insert(str.substring(i));
        }
    }

    public void insert(String str) {
        int pos = 0;
        for (int i = 0; i < str.length(); i++) {
            int child = str.charAt(i) - 'a';
            if (suffixTree[pos][child] == -1) {
                suffixTree[pos][child] = this.label++;
            }
            pos = suffixTree[pos][child];
        }
    }

    public boolean find(String str) {
        int pos = 0;
        for (int i = 0; i < str.length(); i++) {
            int child = str.charAt(i) - 'a';
            if (suffixTree[pos][child] == -1) {
                return false;
            }
            pos = suffixTree[pos][child];
        }
        return true;
    }

    public static void main(String[] args) {
        SuffixTree tree = new SuffixTree("mississippi");
        String patt[] = new String[] { "is", "sip", "hi", "sis", "mississippa" };
        for (int i = 0; i < patt.length; i++) {
            System.out.println(tree.find(patt[i]));
        }
    }
}
