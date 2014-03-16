package stacks_queues;

public class InterviewQuestions3_1 {
    /**
     * This is Approach which use fixed division to implement one array loading three stacks
     */
    // stack1 : [0, n/3)
    // stack2 : [n/3, n * 2/3)
    // stack3 : [n * 2/3, n)
    int stackSize = 100;
    int[] buffer = new int[stackSize * 3];
    int[] stackPointer = new int[] { -1, -1, -1 };

    void push(int stackNum, int value) throws Exception {
        switch (stackNum) {
            case 0:
                if (stackPointer[stackNum] >= stackSize / 3)
                    throw new Exception("exceed stacks size");
            case 1:
                if (stackPointer[stackNum] >= stackSize * 2 / 3)
                    throw new Exception("exceed stacks size");
            case 2:
                if (stackPointer[stackNum] >= stackSize)
                    throw new Exception("exceed stacks size");
        }
        buffer[++stackPointer[stackNum]] = value;
    }
    
    int pop(int stackNum) throws Exception {
        switch (stackNum) {
            case 0:
                if (stackPointer[stackNum] == -1)
                    throw new Exception("no element in stack");
            case 1:
                if (stackPointer[stackNum] == -1)
                    throw new Exception("no element in stack");
            case 2:
                if (stackPointer[stackNum] == -1)
                    throw new Exception("no element in stack");
        }
        return buffer[stackPointer[stackNum]--];
    }
}
