package zn.stacks.queues;

public class LinkedStack implements BasicStack{
    //TODO implement a node class
    private class Node {
        public Object Data;
        public Node next = null;

        Node(Object Data, Node next) {
            this.Data = Data;
            this.next = next;
        }
    }

    Node top;

    public void push(Object item) {
        top = new Node(item, top);
    }

    public Object peek() {
        return top.Data;
    }

    public Object pop() {
        Object item = peek();
        top = top.next;
        return item;
    }
}
