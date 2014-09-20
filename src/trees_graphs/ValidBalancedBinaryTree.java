/**
 * CTCI 4.1
 */
package trees_graphs;

import util.TreeNode;

public class ValidBalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        return check(root) == -1 ? false : true;
    }

    public int check(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lht = check(root.left);
        int rht = check(root.right);
        if (lht == -1 || rht == -1 || Math.abs(lht - rht) > 1) {
            return -1;//NOTE -1 means false, otherwise return height of subtree
        }
        return 1 + Math.max(lht, rht);
    }

}
