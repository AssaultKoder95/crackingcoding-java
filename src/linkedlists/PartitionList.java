/**
 * CTCI 2.4
 */
package linkedlists;

import util.ListNode;

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode(0), right = new ListNode(0);
        ListNode iter = head, ltail = left, rtail = right;
        for (; iter != null; iter = iter.next) {
            if (iter.val < x) {
                ltail.next = iter;
                ltail = ltail.next;
            } else {
                rtail.next = iter;
                rtail = rtail.next;
            }
        }
        rtail.next = null;
        ltail.next = right.next;
        return left.next;
    }
}
