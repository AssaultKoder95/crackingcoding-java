/**
 * CTCI 17.3
 */
package moderate;

import util.TreeNode;

public class BSTtoDoubleLinkedList2 {

    public static TreeNode convertToCircular(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            root.left = root;
            root.right = root;
            return root;
        }
        TreeNode leftHead = convertToCircular(root.left);
        TreeNode rightHead = convertToCircular(root.right);

        if (leftHead == null) {
            concat(rightHead.left, root);
        } else {
            concat(leftHead.left, root);
        }

        if (rightHead == null) {
            concat(root, leftHead);
        } else {
            concat(root, rightHead);
        }

        if (leftHead != null && rightHead != null) {
            concat(rightHead.left, leftHead);
        }

        return leftHead == null ? root : leftHead;
    }

    public static TreeNode convert(TreeNode root) {
        TreeNode head = convertToCircular(root);
        head.left.right = null;
        head.left = null;
        return head;
    }

    public static void concat(TreeNode x, TreeNode y) {
        x.right = y;
        y.left = x;
    }
}
