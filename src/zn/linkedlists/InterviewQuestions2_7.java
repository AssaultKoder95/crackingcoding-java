package zn.linkedlists;

import java.util.Stack;

public class InterviewQuestions2_7 {
    /**
     * this is my answer, if it is allowed to change the list order passed in;
     * use a virtual head
     * detect Palindrome
     * @param head
     * @return
     */
    public static boolean detectPalindrome1(LinkedListNode head) {
        if (head == null)
            return false;
        LinkedListNode iter = head;
        int sizeOfList = 0;
        while (iter != null) {
            iter = iter.next;
            sizeOfList++;
        }
        LinkedListNode virtulHead = new LinkedListNode(0);
        iter = head;
        LinkedListNode iterNext = iter.next;
        for (int i = 0; i < (sizeOfList - sizeOfList / 2); i++) {
            iter = iter.next;
            iterNext = iterNext.next;
        }
        while (iter != null) {
            iter.next = virtulHead.next;
            virtulHead.next = iter;
            iter = iterNext;
            if (iterNext != null) //TODO error-prone point, must check iterNext each time whether equal to true in case of nullpointer exception
                iterNext = iterNext.next;
        }
        iter = head;
        LinkedListNode vIter = virtulHead.next;
        for (int i = 0; i < sizeOfList / 2; i++) {
            if (iter.get() == vIter.get()) {
                iter = iter.next;
                vIter = vIter.next;
            } else
                return false;
        }
        return true;
    }

    /**
     * this is CJ' answer, use stack, which doesn't change the list order
     * very clear, and not erro-prone point
     * @param head
     * @return
     */
    public static boolean detectPalindrome2(LinkedListNode head) {
        if (head == null)
            return false;
        Stack<LinkedListNode> stack = new Stack<LinkedListNode>(); //TODO how to use java.lang.util.stack
        LinkedListNode iter = head;
        int sizeOfList = 0;
        while (iter != null) {
            iter = iter.next;
            sizeOfList++;
        }
        iter = head;
        for (int i = 0; i < sizeOfList / 2; i++) {
            stack.push(iter);
            iter = iter.next;
        }
        if (sizeOfList % 2 == 1)
            iter = iter.next;
        while (iter != null) {
            if (stack.pop().get() != iter.get())
                return false;
            iter = iter.next;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] test = new int[] { 4, 6, 1, 4 };
        LinkedListNode head = new LinkedListNode(test[0]);
        for (int i = 1; i < 4; i++) {
            head.appendToTrail(test[i]);
        }

        System.out.println(InterviewQuestions2_7.detectPalindrome1(head));
    }
}
