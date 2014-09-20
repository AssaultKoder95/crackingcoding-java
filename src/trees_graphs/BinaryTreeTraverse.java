package trees_graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import util.TreeNode;

public class BinaryTreeTraverse {

    public static void preOrderTraverse(TreeNode root) {//preOrder
        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode curTreeNode = stack.pop();
            System.out.println(curTreeNode.val);
            if (curTreeNode.right != null)
                stack.push(curTreeNode.right);
            if (curTreeNode.left != null)
                stack.push(curTreeNode.left);
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {//inOrder
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if (root == null) {
            return ans;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<Integer> count = new Stack<Integer>();
        stack.push(root);
        count.push(1);
        while (!stack.empty()) {
            TreeNode curNode = stack.pop();
            int curCount = count.pop();
            if (curCount == 1) {
                stack.push(curNode);
                count.push(curCount + 1);
                if (curNode.left != null) {
                    stack.push(curNode.left);
                    count.push(1);
                }
            }
            if (curCount == 2) {
                ans.add(curNode.val);
                if (curNode.right != null) {
                    stack.push(curNode.right);
                    count.push(1);
                }
            }
        }
        return ans;
    }

    public static List<Integer> postOrderTraverse(TreeNode root) {//postOrder
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if (root == null){
            return ans;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<Integer> count = new Stack<Integer>();
        stack.push(root);
        count.push(1);
        while (!stack.empty()) {
            TreeNode curNode = stack.pop();
            int curCount = count.pop();
            if (curCount == 1) {
                stack.push(curNode);
                count.push(Integer.valueOf(curCount + 1));
                if (curNode.left != null) {
                    stack.push(curNode.left);
                    count.push(1);
                }
            }
            if (curCount == 2) {
                stack.push(curNode);
                count.push(Integer.valueOf(curCount + 1));
                if (curNode.right != null) {
                    stack.push(curNode.right);
                    count.push(1);
                }
            }
            if (curCount == 3){
                ans.add(curNode.val);
            }
        }
        return ans;
    }

}
