package util;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public void append(int x) {
        ListNode end = new ListNode(x);
        ListNode n = this;
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }
}