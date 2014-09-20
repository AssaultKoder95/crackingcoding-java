/**
 * CTCI 4.3
 */
package trees_graphs;

import util.TreeNode;

public class BuildMinBST {
    
    public static TreeNode buildMinimumBST(int[] arr, int start, int end) {
        if(end < start){
            return null;
        }
        TreeNode root = new TreeNode((start + end) / 2);
        root.left = buildMinimumBST(arr, 0, (start + end) / 2 - 1);
        root.right = buildMinimumBST(arr, (start + end) / 2 + 1, end);
        return root;
    }
    
}
