/**
 * CTCI 2.2
 */
package linkedlists;

import util.ListNode;

public class KthFromTail {

    public static ListNode findKthToEnd1(ListNode head, int k) {
        if (head == null)
            return null;
        ListNode prev = head, succ = head;
        for (int i = 0; i < k - 1; i++) {
            succ = succ.next;
        }
        while (succ.next != null) {
            prev = prev.next;
            succ = succ.next;
        }
        return prev;
    }

    /**
     * recursive way!
     */
    public static int findKthToEnd2(ListNode head, int k) {
        if (head == null)
            return 0;
        int i = findKthToEnd2(head.next, k) + 1;
        if (i == k)
            System.out.println(head.val);
        return i;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        for (int i = 0; i < 10; i++) {
            head.append(i);
        }
        System.out.println(findKthToEnd1(head, 2).val);
    }
}
