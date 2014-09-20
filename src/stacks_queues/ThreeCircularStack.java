/**
 * CTCI 3.1
 */
package stacks_queues;

public class ThreeCircularStack {
    public static int sCount = 3;
    public static int initSize = 4;
    public static int[] buffer = new int[sCount * initSize];
    public static int bSize = buffer.length;
    public static MetaData[] metas = new MetaData[initSize];

    static {
        for (int i = 0; i < metas.length; i++) {
            metas[i] = new MetaData(i * initSize, initSize);
        }
    }

    public static class MetaData {
        public int start;
        public int capacity;
        public int curSize;
        public int topIdx;

        public MetaData(int start, int capacity) {
            this.start = start;
            this.curSize = 0;
            this.capacity = capacity;
            this.topIdx = this.start - 1;
        }

        public boolean isWithinStack(int idx) {//NOTE important!
            if (idx >= start && idx < start + capacity) {
                return true;
            } else if (start + capacity > bSize && idx < (start + capacity) % bSize) {
                return true;
            }
            return false;
        }
    }

    public void push(int stackNum, int value) throws Exception {
        MetaData stack = metas[stackNum];
        if (stack.curSize >= stack.capacity) {
            if (numAllElement() >= bSize) {
                throw new Exception("out of space");
            } else {
                expand(stackNum);
            }
        }
        stack.topIdx = nextElement(stack.topIdx);
        buffer[stack.topIdx] = value;
        stack.curSize++;
    }

    public int pop(int stackNum) throws Exception {
        MetaData stack = metas[stackNum];
        int popValue = 0;
        if (stack.curSize != 0) {
            popValue = buffer[stack.topIdx];
            stack.curSize--;
            stack.topIdx = previousElement(stack.topIdx);
            return popValue;
        } else
            throw new Exception("no elements in stack!");
    }

    public void expand(int stackNum) {
        shift((stackNum + 1) % sCount);
        metas[stackNum].capacity++;
    }

    public int nextElement(int index) {
        if (index + 1 == bSize)
            return 0;
        else
            return ++index;
    }

    public int previousElement(int index) {
        if (index == 0)
            return bSize - 1;
        else
            return --index;
    }

    public int numAllElement() {
        return metas[0].curSize + metas[1].curSize + metas[2].curSize;
    }

    public void shift(int stackNum) {//NOTE recursive way
        MetaData stack = metas[stackNum];
        if (stack.curSize >= stack.capacity) {
            shift((stackNum + 1) % sCount);
            stack.capacity++;
        }
        //NOTE check condition must be isWithinstack(i)
        for (int i = (stack.start + stack.capacity - 1) % bSize; stack.isWithinStack(previousElement(i)); i = previousElement(i)) {
            buffer[i] = buffer[previousElement(i)];
        }
        stack.topIdx = nextElement(stack.topIdx);
        stack.start = nextElement(stack.start);
        stack.capacity--;
    }
}
