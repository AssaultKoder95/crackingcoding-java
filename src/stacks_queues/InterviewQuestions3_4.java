package stacks_queues;

import java.util.Stack;

public class InterviewQuestions3_4 {
    /**
     * 
     * TODO key point is recursive, and find the atomic operation for each recursive operation
     * This is the implementation of Towers of Hanoi //TODO after discussion with CJ, only can recursive algorithm
     * this algorithm can use recursive algorithm
     * Recursive unit operation: last ele and first n-1 ele
     * Clylider 0, 1, 2
     * move first n-1 ele to 1 using 2 as temper buffer
     * move last ele to 2 directly
     * move n-1 of 2 to 2 using 0 as temper buffer
     */
    public class Tower {
        private Stack<Integer> disks;
        private int cylider;
        public Tower(int i) {
            disks = new Stack<Integer>();
            cylider = i;
        }
        
        public int getCylider(){
            return this.cylider;
        }
        
        public void add(int d) throws Exception{
            if(!disks.empty() && disks.peek() <= d){
                throw new Exception("Error placing disk!");
            }
            else
                disks.push(d);
        }
        
        public void moveTopTo(Tower t) throws Exception{
            int  top = disks.pop();
            t.add(top);
        }
        
        public void moveDisks(int n, Tower des , Tower buffer) throws Exception{
            if(n > 0){
                moveDisks(n-1, buffer, des);
                moveTopTo(des);
                buffer.moveDisks(n-1, des, this);
                
            }
        }
    }

}
