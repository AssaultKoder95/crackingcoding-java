/**
 * CTCI 3.2
 */
package stacks_queues;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack = new Stack<Integer>();
    private Stack<Integer> min = new Stack<Integer>();

    public void push(int item) {
        if (item <= getMin()) {//NOTE "<="
            min.push(item);
        }
        stack.push(item);

    }

    public int getMin() {
        if (!min.empty()) {
            return min.peek();
        } else {
            return Integer.MAX_VALUE;
        }
    }

    public int pop() {
        int val = stack.pop();
        if (val == getMin()) {
            min.pop();
        }
        return val;
    }
}
