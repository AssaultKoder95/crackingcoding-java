package chpt3.practice.myself;

import java.util.NoSuchElementException;

public class BoundedStack implements BasicStack{
    //TODO use a fixed array
    private Object[] array;
    private int size = 0;
    
    public BoundedStack(int capacity) {
        array = new Object[capacity];
    }
    
    @Override
    public void push(Object item) {
        if (size == array.length) {
            throw new IllegalStateException("Cannot add to full stack");
        }
        array[size++] = item;
    }

    @Override
    public Object pop() {
        if (size == 0) {
            throw new NoSuchElementException("Cannot pop from empty stack");
        }
        Object result = array[size-1];
        array[--size] = null;
        return result;
    }

    @Override
    public Object peek() {
        if (size == 0) {
            throw new NoSuchElementException("Cannot peek into empty stack");
        }
        return array[size - 1];
    }
    
}
