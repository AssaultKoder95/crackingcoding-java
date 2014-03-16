package trees_graphs;

import java.util.Stack;

import trees_graphs.BinaryTree.Node;



public class BinaryTreeTraverse {
    /**
     * this is preOrder traverse using stack (the detail I already written in the note!)
     * 
     * @param root
     */
    public static void preOrderTraverse(Node root) {
        if (root == null)
            return;
        Stack<Node> stack = new Stack<Node>();
        //initialize
        stack.push(root);
        while (!stack.empty()) {
            Node curNode = stack.pop();
            System.out.println(curNode.value);
            if (curNode.right != null)
                stack.push(curNode.right);
            if (curNode.left != null)
                stack.push(curNode.left);
        }
    }

    /**
     * this is inOrder traverse using stack (CJ's answer which is already written in my note!)
     * 
     * @param root
     */
    public static void inOrderTraverse(Node root) {
        if (root != null)
            return;
        Stack<Node> stack = new Stack<Node>();
        //initilize
        stack.push(root);
        Node curNode = root.left;
        while (curNode != null) {
            stack.push(curNode);
            curNode = curNode.left;
        }
        while (!stack.empty()) {
            curNode = stack.pop();
            System.out.println(curNode.value);
            if (curNode.right != null) {
                stack.push(curNode.right);
                Node nextNode = curNode.right.left;
                while (nextNode != null) {
                    stack.push(nextNode);
                    nextNode = nextNode.left;
                }
            }
        }
    }

    /**
     * this is postOrder traverse using stack (CJ's answer which is alreay written in my note!)
     * 
     * @param root
     */
    public static void postOrderTraverse(Node root) {
        if (root != null)
            return;
        Stack<Node> stack = new Stack<Node>();
        //initialize
        stack.push(root);
        Node curNode;

        if (root.left != null) {
            curNode = root.left;
        } else if (root.right != null)
            curNode = root.right;
        else {
            System.out.println(stack.pop().value);
            return;
        }

        //TODO initilize use double loop, the start point begin most left node!
        while (curNode.left != null) {
            stack.push(curNode);
            curNode = curNode.left;
        }
        while (curNode.right != null) {
            curNode = curNode.right;
            stack.push(curNode);
            while (curNode.left != null) {
                stack.push(curNode);
                curNode = curNode.left;
            }
        }
        //--------------------------------------
        while (!stack.empty()) {
            curNode = stack.pop();
            System.out.println(curNode.value);
            Node nextNode = stack.peek();
            while (nextNode.right != null) {
                nextNode = nextNode.right;
                stack.push(nextNode);
                while (nextNode.left != null) {
                    stack.push(nextNode);
                    nextNode = nextNode.left;
                }
            }
        }
    }

    public static void inOrderTraverse2Stacks(Node root) {
        if (root == null)
            return;
        Stack<Node> nodeStack = new Stack<Node>();
        Stack<Integer> countStack = new Stack<Integer>();
        //initialize
        nodeStack.push(root);
        countStack.push(1);
        while (!nodeStack.empty()) {
            Node curNode = nodeStack.pop();
            int curCount = countStack.pop().intValue();
            if (curCount == 2)
                System.out.println(curNode.value);
            else {
                nodeStack.push(curNode);
                countStack.push(Integer.valueOf(curCount + 1));
                if (curNode.left != null)
                    nodeStack.push(curNode.left);
            }
            if (curNode.right != null)
                nodeStack.push(curNode.right);
        }
    }

    public static void postOrdertraverse2Stacks(Node root) {
        if (root == null)
            return;
        Stack<Node> nodeStack = new Stack<Node>();
        Stack<Integer> countStack = new Stack<Integer>();
        //initialize
        nodeStack.push(root);
        countStack.push(1);
        while (!nodeStack.empty()) {
            Node curNode = nodeStack.pop();
            int curCount = countStack.pop().intValue();
            if (curCount == 1) {
                nodeStack.push(curNode);
                countStack.push(Integer.valueOf(curCount + 1));
                if (curNode.left != null)
                    nodeStack.push(curNode.left);
            }
            if (curCount == 2) {
                nodeStack.push(curNode);
                countStack.push(Integer.valueOf(curCount + 1));
                if (curNode.right != null)
                    nodeStack.push(curNode.right);
            }
            if (curCount == 3)
                System.out.println(curNode.value);
        }
    }
    
    
}
