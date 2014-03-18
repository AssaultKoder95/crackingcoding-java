package hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class WordladderII {
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        HashMap<String, ArrayList<String>> precursorSet = new HashMap<String, ArrayList<String>>();
        HashMap<String, Integer> used = new HashMap<String, Integer>();
        LinkedList<String> curQueue = new LinkedList<String>();
        LinkedList<String> nextQueue = new LinkedList<String>();
        int curDepth = 0;
        used.put(start, 1);
        nextQueue.add(start);
        boolean isFindFirstEnd = false;
        while (nextQueue.isEmpty()) {
            if (curQueue.isEmpty()) {
                if (isFindFirstEnd) {
                    break;
                }
                curQueue.addAll(nextQueue);
                curDepth++;
                nextQueue.clear();
            }
            while (!curQueue.isEmpty()) {
                String originWord = curQueue.pollFirst();
                char[] curWord = originWord.toCharArray();
                for (int i = 0; i < curWord.length; i++) {
                    char originChar = curWord[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c != curWord[i]) {
                            curWord[i] = c;
                            String nextWord = new String(curWord);
                            if (nextWord.equals(end)) {
                                isFindFirstEnd = true;
                            }
                            if (dict.contains(nextWord) || nextWord.equals(end)) {
                                if (!used.containsKey(nextWord)) {
                                    nextQueue.add(nextWord);
                                    used.put(nextWord, curDepth + 1);
                                    addEdge(nextWord, originWord, precursorSet);
                                } else if (curDepth + 1 == used.get(nextWord)) {
                                    addEdge(nextWord, originWord, precursorSet);
                                }
                            }
                            curWord[i] = originChar;
                        }
                    }
                }
            }
        }
        ArrayList<ArrayList<String>> ans = new ArrayList<ArrayList<String>>();
        LinkedList<String> curPath = new LinkedList<String>();
        curPath.add(end);
        backTrackDFS(curDepth + 1, end, start, precursorSet, curPath, ans);
        return ans;
    }

    public void backTrackDFS(int minDepth, String curNode, String start,
            HashMap<String, ArrayList<String>> precursorSet, LinkedList<String> curPath,
            ArrayList<ArrayList<String>> ans) {
        if (curPath.size() == minDepth) {
            if (curNode.equals(start)) {
                ans.add(new ArrayList<String>(curPath));
            }
            return;
        }
        if (precursorSet.containsKey(curNode)) {
            for (String iter : precursorSet.get(curNode)) {
                curPath.addFirst(iter);
                backTrackDFS(minDepth, iter, start, precursorSet, curPath, ans);
                curPath.pollFirst();
            }
        }
    }

    public void addEdge(String node, String edge, HashMap<String, ArrayList<String>> precursorSet) {
        if (precursorSet.containsKey(node)) {
            ArrayList<String> val = precursorSet.get(node);
            val.add(edge);
            precursorSet.put(node, val);
        } else {
            ArrayList<String> val = new ArrayList<String>();
            val.add(edge);
            precursorSet.put(node, val);
        }
    }
    
    public static void main(String[] args) {
        WordladderII test = new WordladderII();
        HashSet<String> dict = new HashSet<String>();
        dict.add("a");
        dict.add("b");
        dict.add("c");
        ArrayList<ArrayList<String>> res = test.findLadders("a", "b", dict);
        System.out.println("haha");
    }
}
