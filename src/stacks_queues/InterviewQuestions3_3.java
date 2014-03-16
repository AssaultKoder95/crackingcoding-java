package stacks_queues;

import java.util.LinkedList;
import java.util.Stack;

public class InterviewQuestions3_3 {

    /**
     * key point is popAt()
     */
    public LinkedList<Stack<Integer>> stackList = new LinkedList<Stack<Integer>>();
    public int threshold;

    public InterviewQuestions3_3(int threshold) {
        this.threshold = threshold;
    }

    private Stack<Integer> retriveLatestStack() {
        return stackList.get(stackList.size() - 1);
    }

    public void push(int value) {
        if (stackList.isEmpty()) {
            Stack<Integer> curStack = new Stack<Integer>();
            curStack.push(value);
            stackList.add(curStack);
        } else {
            Stack<Integer> curStack = retriveLatestStack();
            if (curStack.size() == threshold) {
                curStack = new Stack<Integer>();
                curStack.push(value);
                stackList.add(curStack);
            } else
                curStack.push(value);
        }
    }

    private void shift(Stack<Integer> srcStack, Stack<Integer> targetStack) {
        Stack<Integer> tempStack = new Stack<Integer>();
        while (!srcStack.empty()) {
            tempStack.push(srcStack.pop());
        }
        while (targetStack.size() < threshold) {
            targetStack.push(tempStack.pop());
        }
        while (!tempStack.empty()) { //TODO error-prone condition not: srcStack.size() < threshold
            srcStack.push(tempStack.pop());
        }
    }

    public int popAt(int index) {
        //        return retriveLatestStack().pop();
        int outputValue = stackList.get(index).pop();
        if (index < stackList.size() - 1) {
            for (int i = index; i < stackList.size() - 1; i++) {
                shift(stackList.get(i + 1), stackList.get(i));
            }
        } else
            return pop();
        if (retriveLatestStack().empty()) //TODO error-prone forget this if branch
            stackList.remove(stackList.size() - 1);
        return outputValue;
    }

    public int pop() {
        Stack<Integer> curStack = retriveLatestStack();
        int outputValue = curStack.pop();
        if (curStack.empty())
            stackList.remove(stackList.size() - 1); //TODO error-prone forget this if branch
        return outputValue;
    }

    public static void main(String[] args) {
        InterviewQuestions3_3 setStack = new InterviewQuestions3_3(2);
        for (int i = 0; i < 6; i++) {
            setStack.push(i);
        }
        //        setStack.popAt(1);
        //        setStack.popAt(1);
        setStack.pop();
        setStack.pop();
        for (int i = 0; i < setStack.stackList.size(); i++) {
            System.out.println(setStack.stackList.get(i).toString());
        }
    }
}
