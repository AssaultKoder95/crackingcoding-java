package zn.stacks.queues;

import java.util.LinkedList;

public class SimpleStack implements BasicStack{
    //TODO use a java linkedlist
    private LinkedList<Object> list= new LinkedList<Object>();

    @Override
    public void push(Object item) {
        list.addFirst(item);
    }

    @Override
    public Object pop() {
        return list.removeFirst();
    }

    @Override
    public Object peek() {
        return list.getFirst();
    }
    
    
}
