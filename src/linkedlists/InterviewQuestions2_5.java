package linkedlists;

import java.util.Stack;

public class InterviewQuestions2_5 {

    /**
     * get summation of two backward linked list
     * 
     * @param et1
     * @param et2
     * @return
     */
    public static LinkedListNode sumTwoLinkedListBackward(LinkedListNode et1, LinkedListNode et2) {
        LinkedListNode iter1 = et1;
        LinkedListNode iter2 = et2;
        LinkedListNode virtulHead = new LinkedListNode(0);
        int carryBit = 0;
        int unitSum = 0;

        while (iter1 != null && iter2 != null) {
            unitSum = iter1.get() + iter2.get() + carryBit;
            if (unitSum >= 10) {
                carryBit = 1;
                virtulHead.appendToTrail(unitSum - 10);
            } else {
                carryBit = 0;
                virtulHead.appendToTrail(unitSum);
            }
            iter1 = iter1.next;
            iter2 = iter2.next;
        }
        while (iter1 != null) {
            if (carryBit + iter1.get() >= 10) {
                virtulHead.appendToTrail(carryBit + iter1.get() - 10);
                carryBit = 1;
            } else {
                virtulHead.appendToTrail(carryBit + iter1.get());
                carryBit = 0;
            }
            iter1 = iter1.next;//TODO forget shift the remaining nodes;
        }
        while (iter2 != null) {
            if (carryBit + iter2.get() >= 10) {
                virtulHead.appendToTrail(carryBit + iter2.get() - 10);
                carryBit = 1;
            } else {
                virtulHead.appendToTrail(carryBit + iter2.get());
                carryBit = 0;
            }
            iter2 = iter2.next; //TODO forget shift the remaining nodes;
        }
        return virtulHead.next;
    }

    /**
     * get summation of two forward linked list
     * this is my answer, user two stack to load these two linked lists
     * very tricky
     * 
     * @param et1
     * @param et2
     * @return
     */
    public static LinkedListNode sumTwoLinkedListForward(LinkedListNode et1, LinkedListNode et2) {
        Stack<LinkedListNode> stack1 = new Stack<LinkedListNode>();
        Stack<LinkedListNode> stack2 = new Stack<LinkedListNode>();
        Stack<LinkedListNode> outputStack = new Stack<LinkedListNode>();
        LinkedListNode virtulHead = new LinkedListNode(0);
        LinkedListNode iter1 = et1;
        LinkedListNode iter2 = et2;
        LinkedListNode iter = virtulHead;
        while (iter1 != null) {
            stack1.push(iter1);
            iter1 = iter1.next;
        }
        while (iter2 != null) {
            stack2.push(iter2);
            iter2 = iter2.next;
        }
        int carryBit = 0;
        int unitSum = 0;
        while (!stack1.empty() && !stack2.empty()) {
            unitSum = stack1.pop().get() + stack2.pop().get() + carryBit;
            if (unitSum >= 10) {
                LinkedListNode newNode = new LinkedListNode(unitSum - 10);
                outputStack.push(newNode);
                carryBit = 1;
            } else {
                LinkedListNode newNode = new LinkedListNode(unitSum);
                outputStack.push(newNode);
                carryBit = 0;
            }
        }
        while (!stack1.empty()) {
            unitSum = carryBit + stack1.pop().get();
            if (unitSum >= 10) {
                LinkedListNode newNode = new LinkedListNode(unitSum - 10);
                outputStack.push(newNode);
                carryBit = 1;
            } else {
                LinkedListNode newNode = new LinkedListNode(unitSum);
                outputStack.push(newNode);
                carryBit = 0;
            }
        }
        while (!stack2.empty()) {
            unitSum = carryBit + stack2.pop().get();
            if (unitSum >= 10) {
                LinkedListNode newNode = new LinkedListNode(unitSum - 10);
                outputStack.push(newNode);
                carryBit = 1;
            } else {
                LinkedListNode newNode = new LinkedListNode(unitSum);
                outputStack.push(newNode);
                carryBit = 0;
            }
        }
        while (!outputStack.empty()) {
            iter = virtulHead;
            while (iter.next != null)
                iter = iter.next;
            iter.next = outputStack.pop();
        }
        return virtulHead.next;
    }

    public static void main(String[] args) {
        int[] test = new int[] { 4, 6, 1 };
        LinkedListNode head1 = new LinkedListNode(test[0]);
        for (int i = 1; i < 3; i++) {
            head1.appendToTrail(test[i]);
        }
        int[] test2 = new int[] { 1, 4, 0, 4 };
        LinkedListNode head2 = new LinkedListNode(test2[0]);
        for (int i = 1; i < 4; i++) {
            head2.appendToTrail(test2[i]);
        }
        //TODO when an object passed into the function, a local reference copy generated (like C++ pointer)  
        LinkedListNode newhead = InterviewQuestions2_5.sumTwoLinkedListForward(head1, head2);
        LinkedListNode iter = newhead;
        for (int i = 0; i < 4; i++) {
            System.out.println(iter.get());
            iter = iter.next;
        }
    }
}
