/**
 * CTCI 2.7
 */
package linkedlists;

import java.util.Stack;

import util.ListNode;

public class PalindromeLinkedList {

    public static boolean detectPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        Stack<Integer> stack = new Stack<Integer>();
        while(fast != null && fast.next != null){
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast != null){//NOTE odd number of elements, skip the middle element
            slow = slow.next;
        }
        while(slow != null){
            int top = stack.pop().intValue();
            if(top != slow.val){
                return false;
            }
            slow = slow.next;
        }
        return true;
    }

}
