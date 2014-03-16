package stacks_queues;

import java.util.Stack;

public class InterviewQuestions3_2 extends Stack<Integer> {

    /**
     * this stack can get min() each time, we use a inner stack to implement this.
     * compare to the first solution of book, please write sth to summerize it.
     */
    private static final long serialVersionUID = 1L;
    Stack<Integer> minStack = new Stack<Integer>();

    public void push(int item) {
        if (item <= min()) //TODO error-prone point, forget the == min(), cuase the pop() if(popValue ==min)
            minStack.push(item);
        push(item);

    }

    public Integer min() {
        if (!minStack.empty())
            return minStack.peek();
        else
            return Integer.MAX_VALUE; //FIXME, built-in maxmum integer value, don't worry about the empty situation of this stack
    }

    public Integer pop() {
        int popValue = pop();
        if (popValue == min())
            minStack.pop();
        return popValue;
    }
    
    public static void main(String[] args){
//        InterviewQuestions3_2 stack = new InterviewQuestions3_2();
//        stack.push(2);
//        stack.push(3);
//        stack.push(2);
//        System.out.println(stack.)
        System.out.println(Integer.MAX_VALUE + Integer.MAX_VALUE);// overflow! which have no any exception
    }
}
