/**
 * CTCI 5.6
 */
package bit_manipulation;

public class SwapOddBitAndEvenBit {
    
    /**
     * step1: use mask 0xaaaaaaaa to get all odd bits and shift right them by 1
     * step2: use mask 0x55555555 to get all even bit and shift left them by 1
     * step3: use OR
     */
    public static int swapOddBitAndEvenBit(int et1){
        return ((et1 & 0xaaaaaaaa) >>> 1) | ((et1 & 0x55555555)<<1);
    }
}
