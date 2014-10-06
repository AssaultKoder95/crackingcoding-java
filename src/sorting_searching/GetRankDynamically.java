/**
 * CTCI 11.8
 */
package sorting_searching;

import util.RankNode;

public class GetRankDynamically {
    private RankNode root = null;

    public void track(int number) {
        root = insert(root, number);
    }

    public int getRankOfNumber(int number) {
        return getRank(root, number);
    }

    private RankNode insert(RankNode root, int val) {
        if (root == null) {
            return new RankNode(val);
        }
        if (val <= root.val) {
            root.left = insert(root.left, val);
            root.leftSize++;
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    private int getRank(RankNode root, int val) {
        if (root == null) {
            return -1;
        }
        if (val == root.val) {
            return root.leftSize;
        } else if (val < root.val) {
            return getRank(root.left, val);
        } else {
            int rightRank = getRank(root.right, val);
            return rightRank == -1 ? -1 : root.leftSize + 1 + rightRank;
        }
    }

}
