package zn.linkedlists;

public class InterviewQuestions2_2 {
    
    /**
     * kth to last element, using two pointers, pre, kAfter
     * @param head
     * @param k
     * @return
     */ 
    public static LinkedListNode findKthToEnd(LinkedListNode head, int k) {
        if(head == null)
            return null;
        LinkedListNode pre;
        LinkedListNode kAfter;
        LinkedListNode cur = head;
        for(int i = 0 ; i < k - 1; i++) { //TODO k-1 step between 2 pointers
            if(cur.next == null)
                return null;
            cur = cur.next;
        }
        kAfter = cur;
        pre = head;
        while(kAfter.next != null){ //TODO stay in the last element
            pre = pre.next;
            kAfter = kAfter.next;
        }
        return pre;
    }
    
    /**
     * this is the book's answer, But I don't like it. cause it cannot return the node but node.data
     * this is a recursive answer
     * @param head
     * @param k
     * @return
     */
    public static int findKthToEndRecursive(LinkedListNode head, int k) {
        if(head == null)
            return 0;
        int i = findKthToEndRecursive(head.next, k) + 1;
        if(i == k)
            System.out.println(head.data);
        return i;
    }
    
    public static void main(String [] args) {
        LinkedListNode head = new LinkedListNode(0);
        for(int i = 0; i < 10; i++) {
            head.appendToTrail(i);
        }
        System.out.println(InterviewQuestions2_2.findKthToEnd(head, 2).get());
    }
}
