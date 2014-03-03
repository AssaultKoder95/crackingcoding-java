package zn.bit.manipulation;

public class InterviewQuestions5_6 {
    
    /**
     * step1: use mask 0xaaaaaaaa to get all odd bits and shift right them by 1
     * step2: use mask 0x55555555 to get all even bit and shift left them by 1
     * step3: use OR
     * @param et1
     * @return
     */
    public static int swapOddBitAndEvenBit(int et1){
        return ((et1 & 0xaaaaaaaa) >>> 1) | ((et1 & 0x55555555)<<1);
    }
    public static void main(String[] args){
        int test = 5;
        System.out.println(Integer.toBinaryString(test));
        System.out.println(Integer.toBinaryString(InterviewQuestions5_6.swapOddBitAndEvenBit(test)));
    }
}
