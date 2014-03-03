package zn.trees.graphs;

import zn.trees.graphs.BinaryTree.Node;

public class InterviewQuestions4_8 {
    
    /**
     * TODO this is book answer to check the bigger tree whether contain a smaller tree
     * very clear TODO(recursive)
     * space useage: O(logm + logn) (how many times for recursive calling this method in stack)
     * is better than check substrings are same when doing preOrder and Inorder traverse
     * @param et1
     * @param et2
     * @return
     */
    public static boolean containsTree(Node et1, Node et2){
        if(et2 == null)
            return true;
        return subTree(et1, et2);
    }
    
    public static boolean subTree(Node et1, Node et2){ //TODO recursive calling times is log(n)
        if(et1 == null)
            return false;
        if(et1.value == et2.value){
            if(matchTree(et1, et2))
                return true;
        }
        return (subTree(et1.left, et2) || subTree(et1.right, et2));
    }
    
    public static boolean matchTree(Node et1, Node et2){ //TODO recursive calling tims is log(m)
        if(et1 == null && et2 == null)
            return true;
        if(et1 == null || et2 == null)
            return false;
        if(et1.value != et2.value)
            return false;
        return (matchTree(et1.left, et2.left) && matchTree(et1.left, et2.left));
    }
}
