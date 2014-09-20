package trees_graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import util.TreeNode;

public class PrintBinaryTree {

    public static void printNode(TreeNode root) {
        int maxLevel = maxLevel(root);
        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static void printNodeInternal(List<TreeNode> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || isAllElementsNull(nodes)) {
            return;
        }
        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));//edgeline is 0, 1, 2, 4....lines from bottom up
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;//firstSpace is 2^i - 1 from bottom up, i start from 0
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;//betweenSpace is 2^(i+1) - 1 from bottom up, i starts from 0 
        printWhitespaces(firstSpaces);
        List<TreeNode> newNodes = new ArrayList<TreeNode>();
        for (TreeNode node : nodes) {
            if (node != null) {
                System.out.print(node.val);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);//use null as placeholder
                newNodes.add(null);
                System.out.print(" ");//NOTE
            }
            printWhitespaces(betweenSpaces);
        }
        System.out.println("");
        for (int i = 1; i <= endgeLines; i++) {//NOTE
            for (int j = 0; j < nodes.size(); j++) {
                printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }
                if (nodes.get(j).left != null) {
                    System.out.print("/");
                } else {
                    printWhitespaces(1);
                }
                printWhitespaces(i + i - 1);
                if (nodes.get(j).right != null) {
                    System.out.print("\\");
                } else {
                    printWhitespaces(1);
                }
                printWhitespaces(endgeLines + endgeLines - i);
            }
            System.out.println("");
        }
        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }

    private static int maxLevel(TreeNode node) {//get maximum levels of a binary tree, start from 1
        if (node == null) {
            return 0;
        }
        return Math.max(maxLevel(node.left), maxLevel(node.right)) + 1;
    }

    private static boolean isAllElementsNull(List<TreeNode> list) {
        for (TreeNode object : list) {
            if (object != null)
                return false;
        }
        return true;
    }

    private static TreeNode test1() {
        TreeNode root = new TreeNode(2);
        TreeNode n11 = new TreeNode(7);
        TreeNode n12 = new TreeNode(5);
        TreeNode n21 = new TreeNode(2);
        TreeNode n22 = new TreeNode(6);
        TreeNode n23 = new TreeNode(3);
        TreeNode n24 = new TreeNode(6);
        TreeNode n31 = new TreeNode(5);
        TreeNode n32 = new TreeNode(8);
        TreeNode n33 = new TreeNode(4);
        TreeNode n34 = new TreeNode(5);
        TreeNode n35 = new TreeNode(8);
        TreeNode n36 = new TreeNode(4);
        TreeNode n37 = new TreeNode(5);
        TreeNode n38 = new TreeNode(8);

        root.left = n11;
        root.right = n12;
        n11.left = n21;
        n11.right = n22;
        n12.left = n23;
        n12.right = n24;
        n21.left = n31;
        n21.right = n32;
        n22.left = n33;
        n22.right = n34;
        n23.left = n35;
        n23.right = n36;
        n24.left = n37;
        n24.right = n38;
        return root;
    }

    private static TreeNode test2() {
        TreeNode root = new TreeNode(2);
        TreeNode n11 = new TreeNode(7);
        TreeNode n12 = new TreeNode(5);
        TreeNode n21 = new TreeNode(2);
        TreeNode n22 = new TreeNode(6);
        TreeNode n23 = new TreeNode(9);
        TreeNode n31 = new TreeNode(5);
        TreeNode n32 = new TreeNode(8);
        TreeNode n33 = new TreeNode(4);

        root.left = n11;
        root.right = n12;
        n11.left = n21;
        n11.right = n22;
        n12.right = n23;
        n22.left = n31;
        n22.right = n32;
        n23.left = n33;
        return root;
    }

    public static void main(String[] args) {
        printNode(test1());
        printNode(test2());
    }
}
