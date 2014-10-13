/**
 * CTCI 17.13
 */
package moderate;

import util.TreeNode;

public class BSTtoDoubleLinkedList1 {
    //Time complexity: T(n) = 2T(n/2) + n
    public static TreeNode convert(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode leftHead = convert(root.left);
        TreeNode rightHead = convert(root.right);
        if (leftHead != null) {
            concat(getTail(leftHead), root);
        }
        if (rightHead != null) {
            concat(root, rightHead);
        }
        return leftHead == null ? root : leftHead;
    }

    public static TreeNode getTail(TreeNode node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    public static void concat(TreeNode x, TreeNode y) {
        x.right = y;
        y.left = x;
    }
}
