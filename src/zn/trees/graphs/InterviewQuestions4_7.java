package zn.trees.graphs;

import zn.trees.graphs.BinaryTree.Node;

public class InterviewQuestions4_7 {

    /**
     * this recursive methods to find first common Ancester for two nodes
     * 
     * @param root
     * @param et1
     * @param et2
     * @return
     */
    public static int findFirstCommonAncesterRecursive(Node root, Node et1, Node et2) {
        if (root == null)
            return 0;
        int count = 0;
        if (root == et1 || root == et2)
            count++;
        count += findFirstCommonAncesterRecursive(root.left, et1, et2);
        if (count == 2) { //TODO efficiency promotion point which could stop early
            System.out.println(root.value);
            System.exit(0);
        }
        count += findFirstCommonAncesterRecursive(root.right, et1, et2);
        if (count == 2) {
            System.out.println(root.value);
            System.exit(0);
        }
        return count;
    }

    /**
     * this recursive methods to find first common Ancester using parent pointers
     * TODO this methods reflect one type of problems: find the intersection point of two linked lists
     * @param root
     * @param et1
     * @param et2
     */
    public static void findFirstCommonAncesterWithParentPointer(BinaryTreeWithParentPointer.Node root,
            BinaryTreeWithParentPointer.Node et1, BinaryTreeWithParentPointer.Node et2) {
        if (root == null)
            return;
        int et1Count = 0;
        int et2Count = 0;
        BinaryTreeWithParentPointer.Node iter1 = et1;
        BinaryTreeWithParentPointer.Node iter2 = et2;
        while (iter1.parent != null) {
            iter1 = iter1.parent;
            et1Count++;
        }
        while (iter2.parent != null) {
            iter2 = iter2.parent;
            et2Count++;
        }
        int diff = Math.abs(et1Count - et2Count);
        if (et1Count > et2Count) {
            iter1 = et1;
            iter2 = et2;
            for (int i = diff; i > 0; i--)
                iter1 = iter1.parent;
        } else {
            iter1 = et1;
            iter2 = et2;
            for (int i = diff; i > 0; i--)
                iter2 = iter2.parent;
        }
        while (iter1.parent != null && iter2.parent != null) {
            if (iter1 == iter2) {
                System.out.println(iter1.value);
                break;
            } else {
                iter1 = iter1.parent;
                iter2 = iter2.parent;
            }
        }
    }
}
