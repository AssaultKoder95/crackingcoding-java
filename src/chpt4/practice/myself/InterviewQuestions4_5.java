package chpt4.practice.myself;

import java.util.Stack;

import chpt4.practice.myself.BinaryTree.Node;

public class InterviewQuestions4_5 {

    //TODO error-prone: the max value of left child-subtree must < min value of right child-subtree
    //TODO left <= current < right
    public static void checkBTisBSTEntry(Node root, Integer min, Integer max) {
        checkBTisBSTRecurseive(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /**
     * this is book's answer using inOrder with Recursive, which use min-max variable to implement like this
     * very tricy TODO, so it is important to review it
     * vetry trikcy TODO, program structrue
     * 
     * @param root
     */
    public static boolean checkBTisBSTRecurseive(Node root, Integer min, Integer max) {
        if (root == null)
            return true;
        if (root.value <= min || root.value > max)
            return false;
        if (!checkBTisBSTRecurseive(root.left, min, root.value) || !checkBTisBSTRecurseive(root, root.value, max))
            return false;
        return true;
    }

    /**
     * left <= current < right
     * this is CJ's answer, which use stack to inOrder tranverse;
     * use two record counts; one is last count, one is cur count;
     * Inorder interative tranversing process is natural checking bst from left ->root -> right, (from smallet to biggest value)
     * 
     * @param root
     */
    public static boolean checkBTisBST(Node root) {
        if (root == null)
            return false;
        if(root.left != null && root.right != null)
            return true;
        Stack<Node> stack = new Stack<Node>();
        //initialize
        Node curNode = root;
        Node lastNode = root;
        stack.push(curNode);
        while (curNode.left != null) {
            lastNode = curNode;
            curNode = curNode.left;
            stack.push(curNode);
        }
        while (!stack.empty()) {
            curNode = stack.pop();
            if (lastNode.value > curNode.value) {//TODO error-prone
                return false;
            }
            if(lastNode.value == curNode.value){ //TODO  error-prone, check the "=="condition
                if(lastNode.right != null)
                    return false;
            }
            if (curNode.right != null) {
                curNode = curNode.right;
                stack.push(curNode);
                while (curNode.left != null) {
                    curNode = curNode.left;
                    stack.push(curNode);
                }
            }
            lastNode = curNode;
        }
        return true;
    }
}
