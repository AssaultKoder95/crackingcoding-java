package bit_manipulation;

public class InterviewQuestions5_1 {
    /**
     * thought:
     * 1. clear the bits from j through i in N
     * 2. shift M so that lines up with bits j with i
     * 3. Merge M and N
     * @param n
     * @param m
     * @param i
     * @param j
     * @return
     */
    public static int updateBits(int n, int m, int i, int j) {
        int mask = ((1 << (j + 1)) - 1) - ((1 << (i)) - 1); //TODO the priority of +- is greater than <<, >>, so must use ()
        int clearMask = ~mask;
        n = n & clearMask;
        m = (m << (j - (computeBitsForInt(m) - 1))); //TODO error-prone should be offset = computeBitsForInt(m) - 1
        return n | m;
    }

    public static int computeBitsForInt(int et1) {
        int count = 0;
        while (et1 > 0) {
            et1 = et1 >> 1;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(1325));
        System.out.println(Integer.toBinaryString(InterviewQuestions5_1.updateBits(1325, 13, 6, 9)));
    }
}
