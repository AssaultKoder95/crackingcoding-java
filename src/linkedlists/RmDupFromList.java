/**
 * CTCI 2.1
 */
package linkedlists;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

import util.ListNode;

public class RmDupFromList {

    public static class myComparater implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }
    }

    /**
     * sorting cannot keep the relative order of original list
     * please use iterator to process deletion about list
     */
    public static LinkedList<Integer> remove(LinkedList<Integer> list) {
        if (list.size() == 0)
            return null;
        Collections.sort(list, new myComparater());
        Iterator<Integer> iter = list.iterator();
        int cur = iter.next();
        while (iter.hasNext()) {
            int next = iter.next();
            if (cur == next) {
                iter.remove();//NOTE remove the element returned by next() which is invoked before!
            } else {
                cur = next;
            }
        }
        return list;
    }

    public static void remove2(ListNode head) {
        HashSet<Integer> set = new HashSet<Integer>();
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, cur = head;
        while (cur != null) {
            if (!set.contains(cur.val)) {
                set.add(cur.val);
                pre = cur;
                cur = cur.next;
            } else {
                pre.next = cur.next;
                cur = pre.next;
            }
        }
    }

    /**
     * no hashtable allowed
     */
    public static void remove3(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode cur = head;
        while (cur != null) {
            ListNode iter = cur;
            while (iter.next != null) {
                if (iter.next.val == cur.val) {
                    iter.next = iter.next.next;
                } else {
                    iter = iter.next;
                }
            }
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        int[] test = new int[] { 3, 3, 6, 6, 1, 1 };
        LinkedList<Integer> intList = new LinkedList<Integer>();
        for (int index = 0; index < test.length; index++) {
            intList.add(test[index]);
        }
        System.out.println(remove(intList));
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(6);
        ListNode node4 = new ListNode(6);
        ListNode node5 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        remove2(node1);
        ListNode head = node1;
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

}
