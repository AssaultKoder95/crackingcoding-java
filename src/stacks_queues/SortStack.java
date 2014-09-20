/**
 * CTCI 3.6
 */
package stacks_queues;

import java.util.Stack;

public class SortStack {

    Stack<Integer> buffer = new Stack<Integer>();
    public Stack<Integer> sort(Stack<Integer> target) {
        if (!target.empty()) {
            buffer.push(target.pop());
        } else {
            return null;
        }
        while (!target.empty()) {//like a insertion sort
            int cur = target.pop();
            int count = 0;
            while (buffer.peek() > cur) {
                target.push(buffer.pop());
                count++;
            }
            buffer.push(cur);
            for (int i = count; i > 0; i--) {
                buffer.push(target.pop());
            }
        }
        return buffer;
    }
}
