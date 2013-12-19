package chpt3.practice.myself;

public class InterviewQuestions3_1_Circular {
    public static int stackCount = 3;
    public static int iniStackCapacity = 4;
    public static int[] buffer = new int[3 * 4];
    public static int bufferLength = 12;

    //TODO If you want to use the array initializer, you cannot split the declaration and assignment.
    //TODO int[] a; a = {1,2,3,4}
    //TODO initial this array, the stackMetaData must be also a static, otherwise this class is invisible
    public static stackMetaData[] stackMetaArray = { new stackMetaData(0, iniStackCapacity),
            new stackMetaData(iniStackCapacity, iniStackCapacity),
            new stackMetaData(iniStackCapacity * 2, iniStackCapacity) };

    public static class stackMetaData {
        public int stackStart;
        public int stackCapacity;
        public int stackCurSize;
        public int stackTop;

        public stackMetaData(int stackStart, int stackCapacity) {
            this.stackStart = stackStart;
            this.stackCurSize = 0;
            this.stackCapacity = stackCapacity;
            this.stackTop = this.stackStart - 1;
        }

        //FIXME key point, error-prone point, it is relative position
        public boolean isWithinStack(int index) {
            if (index >= stackStart && stackStart + index <= bufferLength) {
                return true;
            } else if (stackStart + stackCapacity > bufferLength && index < (stackStart + stackCapacity) % bufferLength) {
                return true;
            }
            return false;
        }
    }

    public void push(int stackNum, int value) throws Exception {
        stackMetaData stack = stackMetaArray[stackNum];
        if (stack.stackCurSize >= stack.stackCapacity) {
            if (numAllElement() >= bufferLength)// TODO don't forget the numAllElement
                throw new Exception("out of space");
            else {
                expand(stackNum);
            }
        }
        stack.stackTop = nextElement(stack.stackTop);
        buffer[stack.stackTop] = value;
        stack.stackCurSize++;
    }

    public int pop(int stackNum) throws Exception {
        stackMetaData stack = stackMetaArray[stackNum];
        int popValue = 0;
        if(stack.stackCurSize != 0){
            popValue = buffer[stack.stackTop];
            stack.stackCurSize--;
            stack.stackTop = previousElement(stack.stackTop);
            return popValue;
        }
        else
            throw new Exception("no elements in stack!");
    }
    public void expand(int stackNum) {
        shift((stackNum + 1) % stackCount);
        stackMetaArray[stackNum].stackCapacity++;
    }

    public int nextElement(int index) {
        if (index + 1 == bufferLength)
            return 0;
        else
            return ++index;
    }

    public int previousElement(int index) {
        if (index == 0)
            return bufferLength - 1;
        else
            return --index;
    }

    public int numAllElement() {
        return stackMetaArray[0].stackCurSize + stackMetaArray[1].stackCurSize + stackMetaArray[2].stackCurSize;
    }

    public void shift(int stackNum) {
        stackMetaData stack = stackMetaArray[stackNum];
        if (stack.stackCurSize >= stack.stackCapacity) {
            shift((stackNum + 1) % stackCount);
            stack.stackCapacity++;
        }

        //FIXME error-prone point, shift loop, the condition must be isWithinstack(), not i< stack.stackStart
        for (int i = (stack.stackStart + stack.stackCapacity - 1) % bufferLength; stack.isWithinStack(i); i = previousElement(i)) {
            buffer[i] = buffer[previousElement(i)];
        }

        stack.stackTop = nextElement(stack.stackTop);
        stack.stackStart = nextElement(stack.stackStart);
        stack.stackCapacity--;
    }
}
