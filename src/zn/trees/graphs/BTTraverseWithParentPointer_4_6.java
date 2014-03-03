package zn.trees.graphs;

import zn.trees.graphs.BinaryTreeWithParentPointer.Node;

public class BTTraverseWithParentPointer_4_6 {
    /**
     * use parent pointer to mimic stack, which is preOrder iter process.
     * 
     * @param root
     */
    public void preOrderIterative(Node root) {
        if (root != null)
            return;
        //initialize
        Node iter = root;
        while (iter != null) {
            System.out.println(iter.value);
            if (iter.left != null)
                iter = iter.left;
            else {
                while (iter.parent != null && iter.parent.right == iter)
                    //TODO error-prone
                    iter = iter.parent;
                iter = iter.parent;
                while (iter != null && iter.right == null)
                    //TODO key point, error-prone, explain in my notes 
                    iter = iter.parent;
                if (iter != null)
                    iter = iter.right;
            }
        }
    }

    /**
     * use parent pointer to mimic stack, which is inOrder iter process.
     * 
     * @param root
     */
    public void inOrderIterative(Node root) {
        if (root != null)
            return;
        //initialize, find the first element to print
        Node iter = root;
        while (iter.left != null) {
            iter = iter.left;
        }
        //----------------------------iteration begin
        while (iter != null) {
            System.out.println(iter.value);
            if (iter.right != null) {
                iter = iter.right;
                while (iter.left != null) {
                    iter = iter.left;
                }
            } else {
                if (iter.parent != null && iter.parent.left == iter) //TODO key-point error-prone, explain in my notes
                    iter = iter.parent;
                else {
                    while (iter.parent != null && iter.parent.right == iter) //TODO key-point error-prone
                        iter = iter.parent;
                    iter = iter.parent;
                }
            }
        }
    }

    /**
     * use parent pointer to mimic stack, which is postOrder iter process.
     * 
     * @param root
     */
    public void postOrderIterative(Node root) {
        if (root == null)
            return;
        //initialize, find the first element to print
        Node iter = root;
        while (iter.left != null)
            iter = iter.left;
        //TODO initilize use double loop, the start point begin left zigzag
        while (iter.right != null) {
            iter = iter.right;
            while (iter.left != null) {
                iter = iter.left;
            }
        }
        //-----------------iteration begin
        while (iter != null) {
            System.out.println(iter.value);
            if (iter.parent != null && iter.parent.left == iter) { //TODO error-prone
                iter = iter.parent;
                while (iter.right != null) {
                    iter = iter.right;
                    while (iter.left != null)
                        iter = iter.left;
                }
            } else {
                iter = iter.parent;
            }
        }
    }

}
