/**
 * CTCI 3.4  
 */
package stacks_queues;

import java.util.Stack;

public class Hanoi {
    public class Tower {
        private Stack<Integer> disks;
        public int cylider;

        public Tower(int i) {
            disks = new Stack<Integer>();
            cylider = i;
        }

        public void add(int d) throws Exception {
            if (!disks.empty() && disks.peek() <= d) {
                throw new Exception("Error placing disk!");
            } else {
                disks.push(d);
            }
        }

        public void moveTopTo(Tower t) throws Exception {
            int top = disks.pop();
            t.add(top);
        }

        public void moveDisks(int n, Tower des, Tower buffer) throws Exception {
            if (n <= disks.size()) {
                moveDisks(n - 1, buffer, des);
                moveTopTo(des);
                buffer.moveDisks(n - 1, des, this);
            }else{
                throw new Exception("no enough disks to move!");
            }
        }
    }
}
