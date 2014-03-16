package trees_graphs;

import trees_graphs.BinaryTree.Node;

public class InterviewQuestions4_3 {
    
    /**
     * this it book answer
     * @param arrayToProcess
     * @param start
     * @param end
     * @return
     */
    public static Node buildMinimumBST(int[] arrayToProcess, int start, int end) {
        if(end - start + 1 == 3){
            Node tempLeft = new Node(arrayToProcess[start]);
            Node tempRoot = new Node(arrayToProcess[start + 1]);
            Node tempRight = new Node(arrayToProcess[end]);
            tempRoot.left = tempLeft;
            tempRoot.right = tempRight;
            return tempRoot;
        }
        if(end - start == 2){
            Node tempRoot = new Node(arrayToProcess[start]);
            Node tempRight = new Node(arrayToProcess[end]);
            tempRoot.right = tempRight;
            return tempRoot;
        }
        int middle = arrayToProcess.length / 2 + 1;
        Node leftRoot = buildMinimumBST(arrayToProcess, 0, middle - 1);
        Node rightRoot = buildMinimumBST(arrayToProcess, middle + 1, end);
        Node root = new Node(arrayToProcess[middle]);
        root.left = leftRoot;
        root.right = rightRoot;
        return root;
    }
    
    public static void main(String[] args){
        int[] test = {2,3,6,7,8,9}; //TODO not test yet~
        
    }
}
