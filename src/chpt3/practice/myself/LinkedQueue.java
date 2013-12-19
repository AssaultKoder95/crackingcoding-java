package chpt3.practice.myself;

public class LinkedQueue {
    //TODO implement a node class
    private class Node {
        public Object Data;
        public Node next = null;

        Node(Object Data) {
            this.Data = Data;
        }
    }

    Node first;
    Node last;

    void enqueue(Object item) {
        if (first == null) {
            last = new Node(item);
            first = last;
        } else {
            last.next = new Node(item);
            last = last.next;
        }
    }

    Object dequeue() {
        if (first != null) {
            Object item = first.Data;
            first = first.next;
            return item;
        }
        return null;
    }
}
