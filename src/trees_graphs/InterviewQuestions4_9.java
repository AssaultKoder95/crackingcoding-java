package trees_graphs;

import java.util.ArrayList;

import trees_graphs.BinaryTree.Node;



public class InterviewQuestions4_9 {

    /**
     * this is my answer, using 4 recursive branch,find any path in this tree, not tricky
     * it has a low print efficiency
     * @param targetNum
     * @param sum
     * @param curNode
     * @param path
     */
    public static void sumTree(int targetNum, int sum, Node curNode, ArrayList<Integer> path) {

        if (curNode == null)
            return;
        int curSum = sum + curNode.value;
        if (curSum == targetNum) {
            for (Integer e : path)
                System.out.println(e);
        } else {
            path.add(curNode.value);
            sumTree(targetNum, curSum, curNode.left, path);
            sumTree(targetNum, curSum, curNode.right, path);
        }
        sumTree(targetNum, curNode.value, curNode.right, new ArrayList<Integer>());
        sumTree(targetNum, curNode.value, curNode.left, new ArrayList<Integer>());

    }

    /**
     * This is book's answer , very clear, and only use one array to print
     * have a good print efficiency!
     * time complexity is nlog(n), TODO O(n - 0) + O(n - 0 - 1) + O (n - 0 - 1 - 2)..........
     * @param node
     * @param sum
     * @param path
     * @param level
     */
    public static void sumTree(Node node, int sum, int[] path, int level){
        if(node == null)
            return;
        path[level] = node.value;
        int curSum = 0;
        for(int i = level; i>= 0; i--){
            curSum+=path[i];
            if(curSum == sum){
                print(i, level, path);
            }
        }
        sumTree(node.left, sum, path, level + 1);
        sumTree(node.right, sum, path, level + 1);
        path[level] = Integer.MIN_VALUE;
    }
    
   
    public static void sumTreeEntry(Node root, int sum){
        int[] path = new int[depth(root)];
        sumTree(root, sum, path, 0);
    }
    
    public static int depth(Node root){
        if(root == null)
            return 0;
        else{
            return 1+ Math.max(depth(root.left), depth(root.right));
        }
    }
    
    public static void print(int start, int end, int[] path){
        for(int i = start; i <= end; i++)
            System.out.print(path[i] + " ");
        System.out.println();
    }

}
