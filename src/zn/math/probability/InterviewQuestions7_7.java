package zn.math.probability;

import java.util.ArrayList;

public class InterviewQuestions7_7 {

    public static ArrayList<Integer> heap = new ArrayList<Integer>();

    public static int findKthNumContainPrime357(int k) {
        int output = 0;
        heap.add(3);
        heap.add(5);
        heap.add(7);
        buildHeap(heap);
        for (int i = 0; i < k; i++) {
            output = extractMin(heap);
            heap.add(output * 3);
            heap.add(output * 5);
            heap.add(output * 7);
            reConstruct(heap, 1, heap.size());
        }
        return output;
    }

    private static void buildHeap(ArrayList<Integer> heap) {
        for (int i = heap.size() / 2; i >= 1; i--) {//TODO
            reConstruct(heap, i, heap.size()); //TODO
        }
    }

    private static int extractMin(ArrayList<Integer> heap) {
        int minIndex = 1 - 1;
        int lastEleIndex = heap.size() - 1;
        int min = heap.get(minIndex);
        heap.set(minIndex, heap.get(lastEleIndex));
        heap.remove(lastEleIndex);
        reConstruct(heap, 1, heap.size());
        return min;
    }

    private static void reConstruct(ArrayList<Integer> heap, int i, int n) { //TODO
        int j = i;
        int tempMax = 0;
        while (j <= n / 2) {
            int curNode = j - 1;
            int leftChild = 2 * j - 1;
            int rightChild = 2 * j + 1 - 1;
            if ((2 * j < n) && (heap.get(rightChild) < heap.get(leftChild))) {
                tempMax = rightChild;
            } else
                tempMax = leftChild;
            if (heap.get(curNode) > heap.get(tempMax)) {
                int temp = heap.get(curNode);
                heap.set(curNode, heap.get(tempMax));
                heap.set(tempMax, temp);
                j = tempMax;
            } else
                break;
        }
    }

}
