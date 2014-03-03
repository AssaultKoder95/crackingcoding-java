package zn.stacks.queues;

import java.util.Stack;

public class InterviewQuestions3_6 {
    
    /**
     * use a additional stack as helper to help the orignal stack for sorting
     * that is my answer, pretty good, just like a insert sort, O(n);
     * each time when helper stack.peek() > original stack.pop(), then I will do batch shift between helper stack and original stack
     */
    Stack<Integer> buffer = new Stack<Integer>();

    public Stack<Integer> sort(Stack<Integer> target) {
        int temp = 0;
        int count = 0;
        if (!target.empty())
            buffer.push(target.pop());
        else
            return null;
        while (!target.empty()) {
            temp = target.pop();
            count = 0;
            while (buffer.peek() > temp) {
                target.push(buffer.pop());
                count++;
            }
            buffer.push(temp);
            for (int i = count; i > 0; i--) {
                buffer.push(target.pop());
            }
        }
        return buffer;
    }
    
    public static void main(String[] args) {
        InterviewQuestions3_6 test = new InterviewQuestions3_6();
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(3);
        stack.push(5);
        stack.push(6);
        stack.push(2);
        stack.push(1);
        System.out.println(test.sort(stack).toString());
    }
}
