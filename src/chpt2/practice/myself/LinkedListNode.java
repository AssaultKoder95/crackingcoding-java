package chpt2.practice.myself;

public class LinkedListNode  {
    LinkedListNode next;
    public int data;
    
    public LinkedListNode(int d) {
        this.data = d;
        this.next = null;
    }
    
    void appendToTrail(int d) {
        LinkedListNode end = new LinkedListNode(d);
        LinkedListNode cur = this; //TODO error if cur = this.next
        while(cur.next != null) { //TODO error-prone point, if want to stay in last element, cur.next!= null not cur!= null
            cur = cur.next; // TODO notice it!
        }
        cur.next = end;
    }
    
    public int get() {
        return data;
    }
    
    public void set(int data) {
        this.data = data;
    }
}
