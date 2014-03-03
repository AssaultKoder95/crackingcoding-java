package zn.recursion.dp;

import java.util.Stack;

public class InterviewQuestions9_4 {

    /**
     * TODO this problem is typical, and there's lots of detail I need to review it!!!!
     * transform this type of problem to how to traverse binary tree
     * given a array: x1, x2, x3, x4, find all subset of this array(must be unique)
     * each element has two choices: 0 (choose); 1(don't choose) (the scale of this problem is 2^n (multiplication principle))
     * so we could build binary tree depending on above:
     * 0 left path; 1 right path; tree depth(total length of path): n; (from root to leaf, each path which length n represent a subset)
     * NOTE: we use DFS instead of preOrder, cause iterative solution stack element cannot correspond the trace of path
     * NOTE: so we use stack to mimic DFS, stack's poping-pushing process contain the meaning: each time when we get 1, mean 1's brother path already been traversed, so we should backtrack
     * NOTE：Binary Tree traverse: preOrder's iterative solution != DFS's iterative solution(diff in element in stack, dfs's stack can store a path)
     * NOTE: Binary Tree traverse: preOrder's recursive solution != DFS's recursive solution
     * depth i being 0 means we don't choose array[i], and vice versa;
     * we use stack to traverse this tree, and use ArrayList to print the subset;
     * 
     * @param src
     */
    public static void findAllSubSets(int[] src) {
        Stack<Integer> stack = new Stack<Integer>();
        int length = src.length;
        stack.push(0);
        while (!stack.empty()) {
            if (stack.size() < length) {
                stack.push(0);
            } else {
                for (int i = 0; i < stack.size(); i++) {
                    if (stack.get(i) != 0) {
                        System.out.print(src[i] + " ");
                    }
                }
                System.out.println();
                if (stack.peek() == 0) {//NOTE don't use pop() to check in if branch (eg. if(pop() ~~~)) it's very dangerous
                    stack.pop();
                    stack.push(1);
                } else {
                    while (!stack.empty() && stack.peek() == 1) {//NOTE //NOTE don't use pop() to check in if branch (eg. if(pop() ~~~)) it's very dangerous
                        stack.pop();
                    }
                    if (!stack.empty()) {//NOTE check if last element is 0, then pop and push1, if last elment is 1, directly pop, and due to empty, then break;
                        stack.pop();
                        stack.push(1);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
//        int[] test = { 1, 2, 3, 4 };
//        InterviewQuestions8_4.findAllSubSets(test);
        System.out.println((int)Math.pow(1.3, 27));
    }
}
