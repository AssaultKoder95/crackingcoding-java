package chpt9.practice.myself;

import java.util.ArrayList;

public class InterviewQuestions9_6 {

    /**
     * NOTE: two basic solving ideas for how to get all possible valid permutation or combination of set, sequence recursively
     * 1. at ith recursive layer, we just insert ith element to the all valid sets got by first i-1 layers.
     * 2. just like a decision tree from top going down to the leaf, when getting to the layer of n, just print this decision process
     * each path from top to leaf is binary decision process which reflect one comprehensive choice.
     */

    /**
     * NOTE: how to check the validation of random combination for "(" and ")"
     * my summry(not sure correctness):
     * 1. go though from left to right char by char
     * 2. at ith position, the total #of "(" count1 must equal to or more than the #of ")"- count2 for first i char
     * 3. at last, check to total #of "(" must equal to total #of ")" for whole combination string
     */
    public static void findAllValidParentheses(ArrayList<String> output, char[] buffer, int left, int right, int n) {
        if ((left + right) == 2 * n) {
            if (left == right) {
                String temp = String.valueOf(buffer);
                output.add(temp);
            }
            return;
        }
        //process left
        buffer[left + right] = '('; //NOTE: array index start from 0, left, and right mean how many "(" and ")" aready stored in array 
        findAllValidParentheses(output, buffer, left + 1, right, n);
        //process right
        if (left > right) { //NOTE: carefull! don't add = 
            buffer[left + right] = ')';
            findAllValidParentheses(output, buffer, left, right + 1, n);
        }
    }

    public static ArrayList<String> findAllValidParentheses(int n) {
        ArrayList<String> output = new ArrayList<String>();
        char[] buffer = new char[2 * n];
        findAllValidParentheses(output, buffer, 0, 0, n);
        return output;
    }

    public static void main(String[] args) {
        ArrayList<String> output = InterviewQuestions9_6.findAllValidParentheses(4);
        for (String iter : output)
            System.out.println(iter);
    }
}
