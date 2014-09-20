package trees_graphs;

import util.TreeNodeP;


public class BinaryTreeWithParent {
    
    public void insert(TreeNodeP root, int value) {
        if (value <= root.val) {
            if (root.left != null) {
                insert(root.left, value);
            } else {
                root.left = new TreeNodeP(value);
                root.left.parent = root;
            }
        } else {
            if (root.right != null) {
                insert(root.right, value);
            } else {
                root.right = new TreeNodeP(value);
                root.right.parent = root;
            }
        }
    }

}
