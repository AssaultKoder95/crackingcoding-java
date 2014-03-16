package linkedlists;

public class InterviewQuestions2_3 {
    
    /**
     * TODO this is book answer, very tricky, don't need to know the previous pointer, just shift the data
     * this algorithm only adapt to delete the middle node of linked list except the last node
     * @param curNode
     * @return
     */
    public static boolean deleteMiddleNodeFromLinkedList(LinkedListNode curNode) {
        if (curNode.next == null || curNode == null)
            return false;
        curNode.set(curNode.next.get());
        curNode.next = curNode.next.next;
        return true;
    }
    
}
