package bit_manipulation;

public class SetRange {
    /**
     * 1. clear the bits from j through i in N
     * 2. shift M so that it lines up with bits j with i
     * 3. Merge M and N
     */
    public static int updateBits(int n, int m, int i, int j) {
        int mask = ((1 << (j + 1)) - 1) - ((1 << (i)) - 1); //NOTE the priority of +- is greater than <<, >>!!!
        int clearMask = ~mask;
        n = n & clearMask;
        m = m << i;
        return n | m;
    }
}
