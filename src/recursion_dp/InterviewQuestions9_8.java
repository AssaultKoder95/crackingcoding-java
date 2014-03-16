package recursion_dp;

public class InterviewQuestions9_8 {

    /**
     * 这道题不能用动态规划， f(n) = f(n-25)+f(n-10)+f(n-5)+f(n-1)（因为同等规模的子问题，出现依赖，这在动态规划中是不允许的；动态规划中得不同规模子问题有递归顺序可言）
     * 因为f(25) 的情况 可能包含在f(29)中得情况， 这道问题可以转化是求组合，而非排列，有duplicates
     * 这道题 还是利用tree + dfs搜索思想， 每一层节点就是25，10，5，1，
     * 路径选择是根据上一层的情况，来做出本层判断
     * 
     * @param n
     */
    public static void printAllPermutationsForTotalN(int n) {
        int[] path = new int[4];
        int[] resource = new int[] { 25, 10, 5, 1 };
        printAllPermutationsForTotalN(resource, path, 0, n, 0, resource.length - 1);
    }

    /**
     * path array store #of each element in resource
     * curTotal: before this layer, already got how may cents for(layer -1 to 0)
     * n: the target
     * layer: layer in which the recursive function stays
     * depth: resource.length
     * 
     * @param path
     * @param curTotal
     * @param n
     * @param layer
     * @param depth
     */
    public static void printAllPermutationsForTotalN(int[] resource, int[] path, int curTotal, int n, int layer,
            int depth) {
        if (layer <= depth) {
            int temp = resource[layer];
            int i = 0;
            printAllPermutationsForTotalN(resource, path, curTotal, n, layer + 1, depth);
            while (temp <= (n - curTotal)) {
                path[layer] = ++i;
                printAllPermutationsForTotalN(resource, path, curTotal + temp, n, layer + 1, depth);
                temp += resource[layer];
            }
        } else {
            if (curTotal == n) {
                for (int i = 0; i < path.length; i++) {
                    for (int j = 0; j < path[i]; j++) {
                        System.out.print(resource[i] + " ");
                    }
                }
                System.out.println();
                return;
            }
        }
    }

    public static void main(String[] args) {
        //        InterviewQuestions9_8.printAllPermutationsForTotalN(1);
        //                InterviewQuestions9_8.printAllPermutationsForTotalN(3);
        InterviewQuestions9_8.printAllPermutationsForTotalN(7);
        //        InterviewQuestions9_8.printAllPermutationsForTotalN(15);
        //        InterviewQuestions9_8.printAllPermutationsForTotalN(30);
    }
}
