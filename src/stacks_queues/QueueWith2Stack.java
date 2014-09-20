/**
 * CTCI 3.5
 */
package stacks_queues;

import java.util.Stack;

public class QueueWith2Stack {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public int size() {
        return stack1.size() + stack2.size();
    }

    public void add(int value) {
        stack1.push(value);
    }

    public int peek() throws Exception {
        if (size() == 0) {
            throw new Exception("no elements !");
        }
        if (!stack2.empty()) {
            return stack2.peek();
        } else {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
            return stack2.peek();
        }
    }

    public int pollFirst() throws Exception {
        if (size() == 0)
            throw new Exception("no elements !");
        if (!stack2.empty()) {
            return stack2.pop();
        } else {
            while (!stack1.empty())
                stack2.push(stack1.pop());
            return stack2.pop();
        }
    }

}
