package chpt9.practice.myself;

import java.util.ArrayList;
import java.util.Arrays;

public class InterviewQuestions9_5 {

    /**
     * this is book's answer, but this solution will show all duplicate permutations
     * use recursive method;
     * after getting all permutation of next layer method, just insert cur char into all of them (insertion need scan each char in a string which need o(n))
     * so the time complexity: n * (n - 1)! (n-1)! will be the all permutations from the next layer, n will how many time it will take to insert a char a string
     * 
     * @param src
     * @return
     */
    public static ArrayList<String> findStrPermutation1(String src) {
        if (src == null)
            return null;
        ArrayList<String> curPermutations = new ArrayList<String>();
        if (src.length() == 1) { //NOTE: boundary case
            curPermutations.add(src);
            return curPermutations;
        }
        char curChar = src.charAt(0);
        String nextStr = src.substring(1);//NOTE .substring(int offset) (include the offset)
        ArrayList<String> nextLayerPermutations = findStrPermutation1(nextStr);
        //insert curChar to nextLayerPermutations
        for (String iter : nextLayerPermutations) {
            for (int i = 0; i <= iter.length(); i++) {
                curPermutations.add(insert(i, iter, curChar));
            }
        }
        return curPermutations;
    }

    public static String insert(int i, String iter, char curChar) {
        StringBuilder buffer = new StringBuilder();
        buffer.append(iter);
        buffer.insert(i, curChar); //NOTE: StringBuilder has insert(), however String doesn't
        return buffer.toString();
    }

    /**
     * this is a solution provided by Changjian;
     * this iterative solution, the basic idea is to find .getNext() for permutation of sequence
     * this solution also support duplicates permutation, which 1 2 2 3 -- > 0 1 1 3
     * @param src
     * @return
     */
    public static ArrayList<String> findStrPermutation2(String src) {
        if (src == null)
            return null;
        ArrayList<String> output = new ArrayList<String>();
        int[] index = new int[src.length()];
        //preprocess
        preProcess(index, src);
        output = add(output, index, src);
        boolean stop = false;
        do {
            stop = true;
            for (int j = index.length - 1; j > 0; j--) {
                if (index[j - 1] < index[j]) {
                    stop = true;
                    int k = index.length - 1;
                    for (; k >= j; k--) {
                        if ((index[k] > index[j - 1])) {
                            break;
                        }
                    }
                    int temp = index[j - 1];
                    index[j - 1] = index[k];
                    index[k] = temp;
                }
                output = add(output, index, src);
            }
        } while (!stop);
        return output;
    }

    public static void preProcess(int[] index, String src) {
        for (int i = 0; i < src.length(); i++) {
            index[i] = i;
        }
        // NOTE: preProcess the duplicates eg. 1 2 2 3 -> 0 1 1 3
        for (int i = 1; i < src.length(); i++) {
            if (src.charAt(i - 1) == src.charAt(i))
                index[i] = index[i - 1];
        }
    }

    public static ArrayList<String> add(ArrayList<String> output, int[] index, String src) {
        StringBuilder buffer = new StringBuilder();
        for (int k = 0; k < index.length; k++) {
            buffer.append(src.charAt(index[k]));
        }
        output.add(buffer.toString());
        return output;
    }

    public static void main(String[] args) {
        //        System.out.println(InterviewQuestions8_5.findStrPermutation1("good"));
        System.out.println(InterviewQuestions9_5.findStrPermutation2("good"));
    }
}
