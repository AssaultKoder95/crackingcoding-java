package zn.linkedlists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

public class InterviewQuestions2_1 {
    
    /**
     * remove duplicates without using extra space
     * TODO when it comes to deletion operation, very very carefull about use number index, such as for(i), while loop
     * it is better use iterator to traverse it.
     * @param list
     * @return
     */
    
    //TODO should be familiar with user-defined comparator which must implements Comparator<>
    //TODO myComparater would be static class or not depends on invoking methods , invoking position; please see chapt2 notes
    public static class myComparater implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }
    }
    
    /**
     * this is my answer, use sorting, but the relative order of original list
     * @param list
     * @return
     */
    //FIXME do not use for loop and while loop to process ArrayList and LinkedList, when relate to remove()
    //FIXME please use iterator to process it
    public static LinkedList<Integer> rmDupFromLinkedlist(LinkedList<Integer> list) {
        if(list.size() == 0)
            return null;
        //FIXME Arrays.sort used for array
        //FIXME, Collections.sort used for list, or subclass of list, or implementing class of list
        Collections.sort(list, new myComparater());
        Iterator<Integer> iter = list.iterator();
        int temp = iter.next(); //TODO this is first element in LinkedList
        while(iter.hasNext()) {
            int cur = iter.next();
            if(cur == temp)
                iter.remove();
            else
                temp = cur;
        }
        return list;
    }

    public static void main(String[] args) {
        int [] test = new int[]{3,3,6,6,1,1}; //TODO this is a way to initialize it;
        
        //TODO this is a way to convert a int[] to list
        LinkedList<Integer> intList = new LinkedList<Integer>();
        for (int index = 0; index < test.length; index++)
        {
            intList.add(test[index]);
        }
        System.out.println(InterviewQuestions2_1.rmDupFromLinkedlist(intList));
    }
    
}
