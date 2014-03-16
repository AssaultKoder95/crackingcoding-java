package recursion_dp;

import java.io.IOException;
import java.util.HashMap;
import java.util.Stack;

public class InterviewQuestions9_10 {
    public static class bottle {
        int width;
        int depth;
        int height;

        public int hashcode() {
            return width * 311 + depth * 157 + height;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof bottle)) {
                return false;
            }
            bottle other = (bottle) obj;
            if (this.width == other.width && this.depth == other.height && this.height == other.height) {
                return true;
            } else {
                return false;
            }
        }

        public bottle(int width, int depth, int height) {
            this.width = width;
            this.depth = depth;
            this.height = height;
        }

        public boolean compareTo(bottle other) {
            if ((this.width < other.width) && (this.depth < other.depth) && (this.height < other.height)) {
                return true;
            } else
                return false;
        }
    }

    /**
     * this is recursive way using insertion which has advantage: curMaxHeight = bottom(bottom of curLayer) + Max{lastSubStack}
     * this problem is not better for using tree recursive + dfs cause we only need find the max
     * tree recursive + dfs => find all possible solution requring more extra space
     * However, insertion recursive is also a tree brutal search, just has a diff form with tree recursive+dfs
     * this solution also don't use cache
     * 
     * @param src
     * @param bottom
     * @return
     * @throws IOException
     */
    public static Stack<bottle> getHighestStack(bottle[] src, bottle bottom) throws IOException {
        int curMaxHeight = 0; // curMaxHeight = bottom + Max{lastSubStack}
        Stack<bottle> curSubStack = null;

        for (int i = 0; i < src.length; i++) {
            if (bottom != null && src[i].compareTo(bottom)) {
                Stack<bottle> lastSubStack = getHighestStack(src, src[i]);
                int lastMaxHeight = getHeightOfStack(lastSubStack);
                if (lastMaxHeight > curMaxHeight) {
                    curMaxHeight = lastMaxHeight;
                    curSubStack = lastSubStack;
                }
            }
        }
        Stack<bottle> curMaxStack = new Stack<bottle>();
        curMaxStack.addAll(curSubStack);
        if (bottom != null) {
            curMaxStack.push(bottom);
        }
        return curMaxStack;
    }

    /**
     * this is dynamic programming for using hashmap to cache some sub-path which already was got by some bottom based long length
     * 
     * @param src
     * @param bottom
     * @param cache
     * @return
     * @throws IOException
     */
    public static Stack<bottle> getHighestStack(bottle[] src, bottle bottom, HashMap<bottle, Stack<bottle>> cache)
            throws IOException {
        if (bottom != null && cache.containsKey(bottom)) {
            return cache.get(bottom);
        }
        int curMaxHeight = 0; // curMaxHeight = bottom + Max{lastSubStack}
        Stack<bottle> curSubStack = null;
        for (int i = 0; i < src.length; i++) {
            if (bottom != null && src[i].compareTo(bottom)) {
                Stack<bottle> lastSubStack = getHighestStack(src, src[i]);
                int lastMaxHeight = getHeightOfStack(lastSubStack);
                if (lastMaxHeight > curMaxHeight) {
                    curMaxHeight = lastMaxHeight;
                    curSubStack = lastSubStack;
                }
            }
        }
        Stack<bottle> curMaxStack = new Stack<bottle>();
        curMaxStack.addAll(curSubStack);
        if (bottom != null) {
            curMaxStack.push(bottom);
        }
        cache.put(bottom, curMaxStack);
        return curMaxStack;
    }

    public static int getHeightOfStack(Stack<bottle> stack) throws IOException {
        if (stack == null)
            throw new IOException("null don't have height");
        int totalHeight = 0;
        for (int i = 0; i < stack.size(); i++) {
            totalHeight += stack.get(i).height;
        }
        return totalHeight;
    }

    public static void main(String[] args) {

    }
}
