package chpt3.practice.myself;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class InterviewQuestions3_5 {

    /**
     * key point is whether stack2 need pop to stack1 back each time?
     * stack1 only contain push elements
     * each time when stack1.pop-> stack2.push, make a reverse and stack2 contain all elements that FIFO
     */
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public int size() {
        return stack1.size() + stack2.size();
    }

    public void add(int value) {
        stack1.push(value);

    }

    public int peek() throws Exception {
        if (size() == 0)
            throw new Exception("no elements !");
        if (!stack2.empty()) {
            return stack2.peek();
        } else {
            while (!stack1.empty())
                stack2.push(stack1.pop());
            return stack2.peek();
        }
    }

    public int remove() throws Exception {
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
