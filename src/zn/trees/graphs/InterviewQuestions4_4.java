package zn.trees.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

import zn.trees.graphs.BinaryTree.Node;


public class InterviewQuestions4_4 {

    /**
     * this is book's answer, using pre-order recursive traverse, very clear! TODO
     * TODO pre-order euqal to DFS
     * 
     * @param levelList
     * @param root
     * @param level
     */
    public static void createLevelLinkedlistRecursive(ArrayList<LinkedList<Node>> levelList, Node root, int level) {
        if (root == null)
            return; //TODO only a return keyword means that this function terminate!
        if (levelList.size() == level) {
            levelList.get(level - 1).add(root);
        } else {
            LinkedList<Node> tempList = new LinkedList<Node>();
            tempList.add(root);
            levelList.add(tempList);
        }
        createLevelLinkedlistRecursive(levelList, root.left, level + 1); //TODO this is the pre-order
        createLevelLinkedlistRecursive(levelList, root.right, level + 1);//TODO left first, right last
    }

    /**
     * this is my answer
     * TODO this is pre-order interative implementation which is also DFS(using 2 stacks)
     * @param levelList
     * @param root
     */
    public static void createLevelLinkedlistInterative(ArrayList<LinkedList<Node>> levelList, Node root) {
        if(root == null)
            return;
        Stack<Node> nodeStack = new Stack<Node>();
        Stack<Integer> levelStack = new Stack<Integer>();
        //Initialize
        nodeStack.push(root);
        levelStack.push(1);
        while(!nodeStack.empty()){
            Node tempNode = nodeStack.pop();
            int curLevel = levelStack.pop().intValue();
            if(levelList.size() < curLevel){
                LinkedList<Node> tempList = new LinkedList<Node>();
                tempList.add(tempNode);
                levelList.add(tempList);
            }
            else
                levelList.get(curLevel - 1).add(tempNode);
            if(tempNode.left != null){
                nodeStack.push(tempNode.left);
                levelStack.push(curLevel + 1);
            }
            if(tempNode.right != null){
                nodeStack.push(tempNode.right);
                levelStack.push(curLevel + 1);
            }
        }
    }
    
    /**
     * this is my answer, which use queue to mimic BFS, so is a very straight way
     * @param levelList
     * @param root
     */
    public static void createLevelLinkedlistQueue(ArrayList<LinkedList<Node>> levelList, Node root){
        if(root == null)
            return;
        LinkedList<Node> queue = new LinkedList<Node>();
        //initialize
        int oldLevelCount = 0;
        int curLevelCount = 0;
        int curLevel = 0;
        queue.add(root);
        oldLevelCount++;
        curLevel++;
        while(!queue.isEmpty()){
            Node tempNode = queue.pollFirst();
            oldLevelCount --;
            if(tempNode.left != null){
                curLevelCount++;
                queue.add(tempNode.left);
            }
            if(tempNode.right != null){
                curLevelCount++;
                queue.add(tempNode.right);
            }
            if(levelList.size() < curLevel){
                LinkedList<Node> tempList = new LinkedList<Node>();
                tempList.add(tempNode);
                levelList.add(tempList);
            }
            else
                levelList.get(curLevel - 1).add(tempNode);
            if(oldLevelCount == 0){
                oldLevelCount = curLevelCount;
                curLevelCount = 0;
                curLevel++;
            }
        }
    }
}
