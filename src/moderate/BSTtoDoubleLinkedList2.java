package moderate;

public class BSTtoDoubleLinkedList2 {
    public static class BiNode {
        public BiNode node1;
        public BiNode node2;
        public int data;

        public BiNode(int d) {
            data = d;
        }
    }

    public static BiNode convertToCircular(BiNode root) {
        if (root == null) {
            return null;
        }
        if (root.node1 == null && root.node2 == null) {
            root.node1 = root;
            root.node2 = root;
            return root;
        }
        BiNode leftHead = convertToCircular(root.node1);
        BiNode rightHead = convertToCircular(root.node2);

        BiNode tail = rightHead == null ? null : rightHead.node1;

        if (leftHead == null) {
            concat(rightHead.node1, root);
        } else {
            concat(leftHead.node1, root);
        }

        if (rightHead == null) {
            concat(root, leftHead);
        } else {
            concat(root, rightHead);
        }

        if (leftHead != null && rightHead != null) {
            concat(tail, leftHead);
        }

        return leftHead == null ? root : leftHead;
    }

    public static BiNode convert(BiNode root) {
        BiNode head = convertToCircular(root);
        head.node1.node2 = null;
        head.node1 = null;
        return head;
    }

    public static void concat(BiNode x, BiNode y) {
        x.node2 = y;
        y.node1 = x;
    }
}
