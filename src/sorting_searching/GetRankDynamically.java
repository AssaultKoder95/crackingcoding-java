package sorting_searching;

public class GetRankDynamically {

    public static class RankNode {
        public int left_size = 0;
        public RankNode left;
        public RankNode right;
        public int data = 0;

        public RankNode(int data) {
            this.data = data;
        }

        public void insert(int target) {
            if (target <= this.data) {
                if (this.left != null) {
                    this.left.insert(target);
                } else {
                    this.left = new RankNode(target);
                }
                this.left_size++;
            } else {
                if (this.right != null) {
                    this.right.insert(target);
                } else {
                    this.right = new RankNode(target);
                }
            }
        }

        public int getRank(int target) {
            if (target == this.data) {
                return this.left_size;
            } else if (target < this.data) {
                if (this.left == null) {
                    return -1;
                } else {
                    return this.left.getRank(target);
                }
            } else {
                int rightRank = this.right == null ? -1 : this.right.getRank(target);
                if (rightRank == -1) {
                    return -1;
                } else {
                    return left_size + 1 + rightRank;
                }
            }
        }

    }

    private static RankNode root = null;

    public static void track(int number) {
        if (root == null) {
            root = new RankNode(number);
        } else {
            root.insert(number);
        }
    }

    public static int getRankOfNumber(int number) {
        return root.getRank(number);
    }
}
