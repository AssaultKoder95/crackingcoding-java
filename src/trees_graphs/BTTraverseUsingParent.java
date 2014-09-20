/**
 * CTCI 4.6
 */
package trees_graphs;

import java.util.ArrayList;

import util.TreeNodeP;

public class BTTraverseUsingParent {
    /**
     * 1. this function keeps the path from root to each traversed node
     * 2. this function can be used in binary tree iterator(why? only print traversed node in outter while loop)  
     */
    public ArrayList<Integer> preOrderIterative(TreeNodeP root) {
        ArrayList<Integer> path = new ArrayList<Integer>();
        if (root == null) {
            return path;
        }
        TreeNodeP iter = root;
        while (iter != null) {
            path.add(iter.val);
            if (iter.left != null) {
                iter = iter.left;
            } else if (iter.right != null) {
                iter = iter.right;
            } else {
                TreeNodeP temp = iter;
                iter = iter.parent;
                while (iter != null) {
                    if ((iter.left == temp && iter.right == null) || (iter.right == temp)) {
                        temp = iter;
                        iter = iter.parent;
                    } else {
                        iter = iter.right;
                        break;
                    }
                }
            }
        }
        return path;
    }

    /**
     * 1. this function keeps the path from root to each traversed node
     * 2. this function can be used in binary tree iterator(why? only print traversed node in outter while loop)  
     */
    public ArrayList<Integer> inOrderIterative(TreeNodeP root) {
        ArrayList<Integer> path = new ArrayList<Integer>();
        if (root != null)
            return path;
        TreeNodeP iter = root;
        while (iter.left != null) {
            iter = iter.left;
        }
        while (iter != null) {
            path.add(iter.val);
            if (iter.right != null) {
                iter = iter.right;
                while (iter.left != null) {
                    iter = iter.left;
                }
            } else {
                TreeNodeP temp = iter;
                iter = iter.parent;
                while (iter != null && iter.right == temp) {
                    iter = iter.parent;
                }
            }
        }
        return path;
    }

    /**
     * 1. this function keeps the path from root to each traversed node
     * 2. this function can be used in binary tree iterator(why? only print traversed node in outter while loop)  
     */
    public ArrayList<Integer> postOrderIterative(TreeNodeP root) {
        ArrayList<Integer> path = new ArrayList<Integer>();
        if (root != null)
            return path;
        TreeNodeP iter = root;
        while (iter.left != null)//find the first element to print, zigzag!!
            iter = iter.left;
        while (iter.right != null) {
            iter = iter.right;
            while (iter.left != null) {
                iter = iter.left;
            }
        }
        while (iter != null) {
            path.add(iter.val);
            TreeNodeP temp = iter;
            iter = iter.parent;
            if (iter != null && iter.left == temp) {
                while (iter.right != null) {
                    iter = iter.right;
                    while (iter.left != null)
                        iter = iter.left;
                }
            } 
        }
        return path;
    }

}
