package zn.bit.manipulation;

public class InterviewQuestions5_4 {
    /**
     * ask what does it mean -->> n & (n - 1) == 0
     */
    /**
     * A & B == 0 means what?
     * means A and B have a bit 1 in the same place.
     */
    /**
     * case1: 1101011000
     *                 1
     *       =1101011111
     */
    /**
     * case2: 1101011001
     *                 1
     *       =1101011000
     */
    /**
     * so general is n = abcde1000             or n = abcde1
     *             n-1 = abcde0111 (case 1)     n-1 = abcde0
     * if n & n-1 want to be 0, so abcde must all zeros
     * so n to be 000001000, so (n&(n-1)) == 0 checks if n is power of 2 TODO
     */
}
