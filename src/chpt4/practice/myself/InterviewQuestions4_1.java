package chpt4.practice.myself;

import java.util.LinkedList;

import chpt4.practice.myself.BinaryTree.Node;

public class InterviewQuestions4_1 {
    /**
     * this is my aswer, very clear recursive algorithm for check the balanced of tree
     * 
     * @param tree
     * @param root
     * @return
     */
    public static boolean detectBalancedTreeRecursive(BinaryTree tree, Node root) {
        boolean ifLeftBalanced = false;
        boolean ifRigthBalanced = false;
        if (root.left != null) {
            ifLeftBalanced = detectBalancedTreeRecursive(tree, root.left);
        } else
            ifLeftBalanced = true;

        if (root.right != null) {
            ifRigthBalanced = detectBalancedTreeRecursive(tree, root.right);
        } else
            ifRigthBalanced = true;
        if (ifLeftBalanced == false)
            return false;
        if (ifRigthBalanced == false)
            return false;
        return Math.abs(tree.getHeightQueue(root.left) - tree.getHeightQueue(root.right)) <= 1 ? true : false;
    }

    /**
     * this detection about balance tree is to use bfs algorithm with updating heigth firstly when pushing
     * using the dif value between lowest leaf and highest leaf
     * @param tree
     * @param root
     * @return
     */
    public static boolean detectBalancedTreeIterative(BinaryTree tree, Node root) {
        LinkedList<Node> queue = new LinkedList<Node>();
        int lastCounter = 0;
        int curCounter = 0;
        int height = 0;
        int maxPathLength = Integer.MIN_VALUE; //TODO initialize max 
        int minPathLength = Integer.MAX_VALUE; //TODO initialize min
        queue.add(root);
        lastCounter++;
        height++; //TODO error -prone !!!!update firstly must when pushing, correspond  **code below, otherwise, when get first leafnode, update min incorrectly! 
        while (!queue.isEmpty()) {
            Node tempNode = queue.pollFirst();
            lastCounter--;
            if (tempNode.left != null) {
                curCounter++;
                queue.add(tempNode.left);
            }
            if (tempNode.right != null) {
                curCounter++;
                queue.add(tempNode.right);
            }
            if (lastCounter == 0) {
                if (tempNode.left != null || tempNode.right != null)
                    height++;
                lastCounter = curCounter;
                curCounter = 0;
            }
            if (tempNode.isLeafNode()) { //TODO **
                if (height > maxPathLength)
                    maxPathLength = height;
                if (height <= minPathLength)
                    minPathLength = height;
            }
            if (maxPathLength - minPathLength > 1)
                return false;
        }
        if (maxPathLength - minPathLength > 1)
            return false;
        else
            return true;
    }

    public static void main(String[] args) {
        InterviewQuestions4_1 test = new InterviewQuestions4_1();
        BinaryTree tree = new BinaryTree();
        Node root = new Node(5);
        tree.insert(root, 3);
        tree.insert(root, 9);
        tree.insert(root, 8);
        tree.insert(root, 11);
        tree.insert(root, 12);
        tree.insert(root, 1);

        System.out.println(test.detectBalancedTreeIterative(tree, root));
    }
}
