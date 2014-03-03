package zn.trees.graphs;

import java.util.LinkedList;
import java.util.Stack;

import zn.stacks.queues.InterviewQuestions3_7.Dog;


public class BinaryTree {
    public static class Node {
        Node left;
        Node right;
        int value;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
        
        public boolean isLeafNode(){
            if(this.left == null && this.right == null)
                return true;
            else
                return false;
        }
    }

    public void insert(Node root, int value) {
        if (value <= root.value) {
            if (root.left != null) {
                insert(root.left, value);
            } else {
                root.left = new Node(value);
            }
        } else {
            if (root.right != null) {
                insert(root.right, value);
            } else {
                root.right = new Node(value);
            }
        }
    }

    /**
     * get Height of a tree, using recursive algorithm
     * 
     * @param root
     * @return
     */
    public int getHeightRecursive(Node root) {
        if(root == null) //TODO must have for safety!
            return 0;
        if (root.left == null && root.right == null)
            return 1; //TODO should return 1
        if (root.left == null && root.right != null)
            return getHeightRecursive(root.right) + 1;
        if (root.left != null && root.right == null)
            return getHeightRecursive(root.left) + 1;
        int leftHeight = getHeightRecursive(root.left);
        int rightHeigth = getHeightRecursive(root.right);
        return leftHeight > rightHeigth ? leftHeight + 1 : rightHeigth + 1;
    }

    /**
     * get height of a tree using queue(BFS) TODO very very important, use two counters,
     * 
     * @param root
     * @return
     */
    public int getHeightQueue(Node root) {
        if(root == null) //TODO must have for safety!
            return 0;
        LinkedList<Node> queue = new LinkedList<Node>();
        int lastCounter = 0;//TODO using 2 counters£¬ when using queue to record how many layers of the tree
        int curCounter = 0;//TODO using 2 counters£¬ when using queue to record how many layers of the tree
        int height = 0; //TODO update height latterly, after pop a element!each time
        queue.add(root);
        lastCounter++;
        while (!queue.isEmpty()) {
            Node temp = queue.pollFirst();
            lastCounter--;
            //TODO update the curCounter firstly, then update the lastCounter, this is very very important.
            if (temp.left != null) {
                queue.add(temp.left);
                curCounter++;
            }
            if (temp.right != null) {
                queue.add(temp.right);
                curCounter++;
            }
            if (lastCounter == 0) {
                height++;
                lastCounter = curCounter;
                curCounter = 0; //TODO after update the lastCounter, the curCounter should recover to 0
            }
        }
        return height; //TODO height  = # of layers of tree
    }

    public void printTree(Node root) {
        if (root == null)
            return;
        Stack<Node> stack = new Stack<Node>();
        //initialize
        stack.add(root);
        while (!stack.empty()) {
            Node curNode = stack.pop();
            System.out.println(curNode.value);
            if (curNode.right != null)
                stack.add(curNode.right);
            if (curNode.left != null)
                stack.add(curNode.left);
        }
    }
    
    public Node run() { //TODO build a binary tree, usually using a binary search tree to build it!
        Node root = new Node(5);
        insert(root, 1);
        insert(root, 8);
        insert(root, 6);
        insert(root, 3);
        insert(root, 9);
        insert(root, 10);
        return root;
    }

   
    public static void main(String[] args) {
        BinaryTree test = new BinaryTree();
        Node root = test.run();
        test.printTree(root);
//        System.out.println(test.getHeightRecursive(root));
    }
}
