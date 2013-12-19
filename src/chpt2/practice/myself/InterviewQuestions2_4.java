package chpt2.practice.myself;

public class InterviewQuestions2_4 {

    /**
     * this is my answer, very very complicated and vulnerable.
     * process linked list, please think of virtual nodes to process linked in most time.
     * use the runner technique with two pointer
     * @param head
     * @param partitionValue
     * @return
     */
    public static LinkedListNode partitionListByGivenValue1(LinkedListNode head, int partitionValue) {
        if (head == null)
            return null;
        LinkedListNode firstOffset = head;
        LinkedListNode lastOffset = head;
        while (lastOffset.next != null) {
            lastOffset = lastOffset.next;
            if (firstOffset.next.get() < partitionValue)
                firstOffset = firstOffset.next;
        }
        LinkedListNode fixedLast = lastOffset;
        while (firstOffset.next != fixedLast) {
            if (firstOffset.next.get() >= partitionValue) {
                lastOffset.next = firstOffset.next;
                firstOffset.next = firstOffset.next.next;
                lastOffset = lastOffset.next;
                lastOffset.next = null;
            }
        }
        if (firstOffset.get() >= partitionValue) {//TODO error-prone point, this if branch always forget to check, easy to overlook the first element
            head = firstOffset.next;
            lastOffset.next = firstOffset;
            firstOffset.next = null;
        }
        return head;
    }

    /**
     * this is a better answer, which we could create two virtual nodes
     * @param args
     */
    public static LinkedListNode partitionListByGivenValue2(LinkedListNode head, int partitionValue) {
        if (head == null)
            return null;
        LinkedListNode lessValueList = new LinkedListNode(0);
        LinkedListNode largerValueList = new LinkedListNode(0);
        LinkedListNode leslistIter = lessValueList;
        LinkedListNode laglistIter = largerValueList;
        LinkedListNode iter = head;
        while (iter != null) {
            if (iter.get() < partitionValue) {
                leslistIter.next = iter;
                leslistIter = leslistIter.next;
            }

            if (iter.get() >= partitionValue) {
                laglistIter.next = iter;
                laglistIter = laglistIter.next;
            }
            iter = iter.next;
        }
        laglistIter.next = null;
        leslistIter.next = largerValueList.next;
        largerValueList.next = null;
        head = lessValueList.next;
        return head;
    }

    public static void main(String[] args) {
        int[] test = new int[] { 4, 6, 7, 8, 1 };// TODO primitive array , and object array must use 'new' to generate
        LinkedListNode head = new LinkedListNode(test[0]);
        for (int i = 1; i < 5; i++) {
            head.appendToTrail(test[i]);
        }
        //TODO when an object passed into the function, a local reference copy generated (like C++ pointer)  
        LinkedListNode newhead = InterviewQuestions2_4.partitionListByGivenValue2(head, 4);
        LinkedListNode iter = newhead;
        for (int i = 0; i < 5; i++) {
            System.out.println(iter.get());
            iter = iter.next;
        }
    }
}
