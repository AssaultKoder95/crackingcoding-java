/**
 * CTCI 3.3
 */
package stacks_queues;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Stack;

public class SetStack {

    public LinkedList<Stack<Integer>> stackList = new LinkedList<Stack<Integer>>();
    public int threshold;

    public SetStack(int threshold) {
        this.threshold = threshold;
    }

    private Stack<Integer> getLastStack() {
        return stackList.get(stackList.size() - 1);
    }

    public void push(int value) {
        if (stackList.isEmpty()) {
            Stack<Integer> newStack = new Stack<Integer>();
            newStack.push(value);
            stackList.add(newStack);
        } else {
            Stack<Integer> curStack = getLastStack();
            if (curStack.size() == threshold) {
                Stack<Integer> newStack = new Stack<Integer>();
                newStack.push(value);
                stackList.add(newStack);
            } else
                curStack.push(value);
        }
    }

    public int pop() throws IOException {
        if(stackList.isEmpty()){
            throw new IOException("SetStack is empty!");
        }else{
            Stack<Integer> curStack = getLastStack();
            int outputValue = curStack.pop();
            if (curStack.empty())
                stackList.remove(stackList.size() - 1);
            return outputValue;
        }
    }
    
    public int popAt(int idx) throws IOException {
        int Val = stackList.get(idx).pop();
        if (idx < stackList.size() - 1) {
            for (int i = idx; i < stackList.size() - 1; i++) {
                shift(stackList.get(i + 1), stackList.get(i));
            }
        } else{
            return pop();
        }
        if (getLastStack().empty()) //NOTE need remove last empty stack
            stackList.remove(stackList.size() - 1);
        return Val;
    }
    
    private void shift(Stack<Integer> src, Stack<Integer> target) {
        Stack<Integer> tempStack = new Stack<Integer>();
        while (!src.empty()) {
            tempStack.push(src.pop());
        }
        while (target.size() < threshold) {
            target.push(tempStack.pop());
        }
        while (!tempStack.empty()) {
            src.push(tempStack.pop());
        }
    }
}
