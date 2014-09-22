/**
 * CTCI 5.7
 */
package bit_manipulation;

import java.util.ArrayList;

public class FindMissingNumber {

    public static class BitInteger {//suppose BitInteger is from 0 to n
        int internalNum;

        public BitInteger() {
            internalNum = 0;
        }

        public BitInteger(int other) {
            this.internalNum = other;
        }

        public int fetch(int pos) {
            int temp = this.internalNum;
            return (temp >> pos) & 1;
        }

        public int getActualBitLength() {
            int temp = this.internalNum;
            int count = 0;
            while (temp != 0) {
                count++;
                temp = temp >> 1;
            }
            return count;
        }
    }

    /**
     * find the missing one from a array from 0 to n.
     * precondition: you can not fetch the number directly, you can only fetch the jth bit of A[i].
     * the time complexity of basic idea is n * length(n), the length(n) is log(n)
     * We change to another way:
     * detect the least significant bit is 0 or 1 of the missing number, if lsb is 0 then we remove all other numbers which lsb is 1.
     * then we detect the second least significant bit
     * repeatedly do this computation similar to binary search
     * Rule:
     * if n is even the Num0 = Num1 + 1
     * missing 1 (lsb) N0 > N1
     * missing 0 (lsb) N0 = N1
     * if n is odd the Num0 = Num1
     * missing 1 (lsb) N0 > N1
     * missing 0 (lsb) N0 < N1
     */
    public static int findMissingNum(ArrayList<BitInteger> array, int maxBitLength) {
        return findMissingNum(array, maxBitLength, 0);
    }

    public static int findMissingNum(ArrayList<BitInteger> input, int maxBitLength, int column) {
        if (column >= maxBitLength)
            return 0;
        ArrayList<BitInteger> oneBits = new ArrayList<BitInteger>(input.size() / 2);
        ArrayList<BitInteger> zeroBits = new ArrayList<BitInteger>(input.size() / 2);
        for (BitInteger t : input) {
            if (t.fetch(column) == 0)
                zeroBits.add(t);
            else
                oneBits.add(t);
        }
        if (zeroBits.size() > oneBits.size()) {
            int v = findMissingNum(oneBits, maxBitLength, column + 1);
            return (v << 1) | 1; 
        } else {
            int v = findMissingNum(zeroBits, maxBitLength, column + 1);
            return (v << 1) | 0; 
        }
    }
}
