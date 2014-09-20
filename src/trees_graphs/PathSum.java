/**
 * CTCI 4.9
 */
package trees_graphs;

import java.util.ArrayList;

import util.TreeNode;

public class PathSum {

    /**
     * Recursive: time complexity is round: 4 ^ (logn) = 2 ^ (2logn) = n^2 (because 2 ^ logn = n)
     */
    public static void sumTree(int target, int sum, TreeNode curNode, ArrayList<Integer> path) {
        if (curNode == null)
            return;
        int curSum = sum + curNode.val;
        if (curSum == target) {
            for (Integer e : path)
                System.out.println(e);
        } else {
            path.add(curNode.val);
            sumTree(target, curSum, curNode.left, path);
            sumTree(target, curSum, curNode.right, path);
        }
        sumTree(target, curNode.val, curNode.right, new ArrayList<Integer>());
        sumTree(target, curNode.val, curNode.left, new ArrayList<Integer>());

    }

    /**
     * time complexity is nlog(n)
     */
    public static void sumTreeEntry(TreeNode root, int sum) {
        int[] path = new int[depth(root)];
        sumTree(root, sum, path, 0);
    }

    public static void sumTree(TreeNode TreeNode, int sum, int[] path, int level) {
        if (TreeNode == null) {
            return;
        }
        path[level] = TreeNode.val;
        int curSum = 0;
        for (int i = level; i >= 0; i--) {
            curSum += path[i];
            if (curSum == sum) {
                print(i, level, path);
            }
        }
        sumTree(TreeNode.left, sum, path, level + 1);
        sumTree(TreeNode.right, sum, path, level + 1);
        path[level] = Integer.MIN_VALUE;
    }

    public static int depth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + Math.max(depth(root.left), depth(root.right));
        }
    }

    public static void print(int start, int end, int[] path) {
        for (int i = start; i <= end; i++) {
            System.out.print(path[i] + " ");
        }
        System.out.println();
    }

}
