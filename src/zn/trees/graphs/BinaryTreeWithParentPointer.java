package zn.trees.graphs;

import java.util.Stack;

import zn.trees.graphs.BinaryTree.Node;


public class BinaryTreeWithParentPointer {
    public static class Node {
        Node left;
        Node right;
        Node parent;
        int value;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
            this.parent = null;
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
                root.left.parent = root;
            }
        } else {
            if (root.right != null) {
                insert(root.right, value);
            } else {
                root.right = new Node(value);
                root.right.parent = root;
            }
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
        BinaryTreeWithParentPointer test = new BinaryTreeWithParentPointer();
        Node root = test.run();
        System.out.println("!!");
    }
}
