/**
 * CTCI 4.8
 */
package trees_graphs;
import util.TreeNode;

public class CheckSubTree {

    /**
     * space useage: O(logm + logn) is better than that(m + n) of the simple way using checking pre/inorder substrings
     */
    public static boolean containsTree(TreeNode n1, TreeNode n2) {
        if (n2 == null)
            return true;
        return subTree(n1, n2);
    }

    public static boolean subTree(TreeNode n1, TreeNode n2) {
        if (n1 == null)
            return false;
        if (n1.val == n2.val) {
            if (matchTree(n1, n2)){
                return true;
            }
        }
        return (subTree(n1.left, n2) || subTree(n1.right, n2));
    }

    public static boolean matchTree(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null)
            return true;
        if (n1 == null || n2 == null)
            return false;
        return n1.val == n2.val && matchTree(n1.left, n2.left) && matchTree(n1.left, n2.left);
    }
}
