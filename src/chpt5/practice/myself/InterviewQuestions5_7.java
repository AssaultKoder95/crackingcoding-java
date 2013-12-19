package chpt5.practice.myself;

import java.util.ArrayList;

public class InterviewQuestions5_7 {

    /**
     * suppose BitInteger is positive number
     * 
     * @author hadoop
     */
    public static class BitInteger {
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
     * TODO book's answer!!!!!
     * quesitons: 1. find the missing one from a array from 0 to n.
     * precondition: you can not fetch the number directly, you can only fetch the jth bit of A[i]
     * first thought time complexity:
     * I should get the total sum n * (n + 1) / 2, so should scan the 0 to n
     * so the runtime of this solution is n * length(n), the length(n) is log(n)
     * So the time nlogn, so skip it...........
     * we could do statistics about the binary arrangement
     * from 0 to n, we could find the least significant bit is 0 1 0 1 0 1 0 1 0 1
     * so we could use n is odd or even and other's count(0) and count(1) to detect the least significant bit is 0 or 1 of the missing number
     * if lsb is 0 then we remove all others which lsb is 1.
     * then we found the second least significant bit also is 0 1 0 1 0 1 0 1
     * so we could repeatedly do this computation.
     * Rule:
     * if n is even the Num0 = Num1
     * missing 1 (lsb) N0 > N1
     * missing 0 (lsb) N1 > N0
     * if n is odd the Num0 = Num1 + 1
     * missing 1 (lsb) N0 > N1
     * missing 0 (lsb) N1 = N0
     * 
     * @param array
     * @return
     */
    public static int findMissingNumContinuousArray(ArrayList<BitInteger> array, int maxBitLength) {

        return findMissingNumContinuousArray(array, maxBitLength, 0);
    }

    public static int findMissingNumContinuousArray(ArrayList<BitInteger> input, int maxBitLength, int column) {
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
            int v = findMissingNumContinuousArray(oneBits, maxBitLength, column + 1);
            return (v << 1) | 1; //TODO very tricky!!! not shift to the correct, each time only shift 1 time, due to invoke recursively, eventually it will get the correct position
        } else {
            int v = findMissingNumContinuousArray(zeroBits, maxBitLength, column + 1);
            return (v << 1) | 0; //TODO
        }
    }
}
