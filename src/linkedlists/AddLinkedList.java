/**
 * CTCI 2.5
 */
package linkedlists;

import java.util.Stack;

import util.ListNode;

public class AddLinkedList {

    /**
     * get summation of two backward linked list
     */
    public static ListNode sumTwoLinkedListBackward(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), tail = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l1 != null ? l1.val : 0;
            tail.next = new ListNode((val1 + val2 + carry) % 10);
            tail = tail.next;
            carry = (val1 + val2 + carry) / 10;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        if (carry != 0) {
            tail.next = new ListNode(carry);
            tail = tail.next;
        }
        return dummy.next;
    }

    /**
     * get summation of two forward linked list
     */
    public static ListNode sumTwoLinkedListForward(ListNode l1, ListNode l2) {
        Stack<ListNode> s1 = new Stack<ListNode>(), s2 = new Stack<ListNode>(), ans = new Stack<ListNode>();
        ListNode dummy = new ListNode(0), tail = dummy;
        while (l1 != null) {
            s1.push(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2);
            l2 = l2.next;
        }
        int carry = 0;
        while (!s1.empty() || !s2.empty()) {
            int val1 = !s1.empty() ? s1.pop().val : 0;
            int val2 = !s2.empty() ? s2.pop().val : 0;
            ans.push(new ListNode((val1 + val2 + carry) % 10));
            carry = (val1 + val2 + carry) / 10;
        }
        if (carry != 0) {
            ans.push(new ListNode(carry));
        }
        while (!ans.empty()) {
            tail.next = ans.pop();
            tail = tail.next;
        }
        return dummy.next;
    }

}
