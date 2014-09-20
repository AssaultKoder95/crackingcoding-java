package trees_graphs;

import java.util.LinkedList;

import util.TreeNode;

public class BinaryTreeBasicOperation {

    public void insert(TreeNode root, int value) {
        if (value <= root.val) {
            if (root.left != null) {
                insert(root.left, value);
            } else {
                root.left = new TreeNode(value);
            }
        } else {
            if (root.right != null) {
                insert(root.right, value);
            } else {
                root.right = new TreeNode(value);
            }
        }
    }

    public int getHeight(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left == null && root.right != null) {
            return getHeight(root.right) + 1;
        }
        if (root.left != null && root.right == null) {
            return getHeight(root.left) + 1;
        }
        int leftHeight = getHeight(root.left);
        int rightHeigth = getHeight(root.right);
        return leftHeight > rightHeigth ? leftHeight + 1 : rightHeigth + 1;
    }

    public int getHeightQueue(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        int cur = 1, next = 0, height = 1;
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.pollFirst();
            cur--;
            if (temp.left != null) {
                queue.add(temp.left);
                next++;
            }
            if (temp.right != null) {
                queue.add(temp.right);
                next++;
            }
            if (cur == 0 && next != 0) {
                height++;
                cur = next;
                next = 0;
            }
        }
        return height;
    }
}
