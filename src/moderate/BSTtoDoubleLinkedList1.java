package moderate;

public class BSTtoDoubleLinkedList1 {
    public static class BiNode {
        public BiNode node1;
        public BiNode node2;
        public int data;

        public BiNode(int d) {
            data = d;
        }
    }

    public static BiNode convert(BiNode root) {
        if (root == null) {
            return null;
        }
        BiNode leftHead = convert(root.node1);
        BiNode rightHead = convert(root.node2);
        if (leftHead != null) {
            concat(getTail(leftHead), root);
        }
        if (rightHead != null) {
            concat(root, rightHead);
        }
        return leftHead == null ? root : leftHead;

    }

    public static BiNode getTail(BiNode node) {
        while (node.node2 != null) {
            node = node.node2;
        }
        return node;
    }

    public static void concat(BiNode x, BiNode y) {
        x.node2 = y;
        y.node1 = x;
    }

}
