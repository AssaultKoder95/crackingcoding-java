/**
 * CTCI 5.4
 */
package bit_manipulation;

public class CheckPowerOf2 {
    /**
     * ask what does it mean -->> n & (n - 1) == 0
     */
    /**
     * A & B == 0 means what?
     * means A or B at least has a bit 0 in the each bit place.
     */
    /**
     * case1: 1101011000
     *                 1
     *       =1101010111
     */
    /**
     * case2: 1101011001
     *                 1
     *       =1101011000
     */
    /**
     *      case1 is n = abcde1000      case2 is  n = abcde1
     *             n-1 = abcde0111              n-1 = abcde0
     * if n & n-1 want to be 0, so abcde must all zeros
     * so n has to be 000001000 to make (n&(n-1)) == 0 which means to check if n is power of 2
     */
}
