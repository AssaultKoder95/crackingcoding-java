package bit_manipulation;

import java.io.IOException;

//TODO un-test
public class InterviewQuestions5_3 {
    /**
     * compute the c1, c0 firstly, then we could get p easily
     * here I considerthe the sign bit
     * step1: find pth pos, reverse it from 0 to 1
     * step2: clear all bits behind pth
     * step3: add (c1-1) 1s from lowest bit 
     * @param et1
     * @return
     * @throws IOException
     */
    public static int getNextSmallest(int et1) throws IOException {
        if (et1 == 0)
            return 0;
        int temp = et1;
        //TODO compute c0 firstly, just traverse byte stream from 0th bit to highest bit, stop until meet first 1
        int p = 0; //TODO non-trailing zero 1101100 so p == 4
        int c0 = 0; //TODO how many zeros are the left of first 1
        while ((temp > 0) && ((temp & 1) == 0)) {
                c0++;
            temp = temp >>> 1;
        }
        int c1 = 0; // TODO how many 1s are right of pth 0
        while ((temp & 1) == 1) {
                c1++;
            temp = temp >>> 1;
        }
        p = c0 + c1;
        if (p == 32)
            throw new IOException("et1 don't have next smallest neighbor!");
        et1 = (et1 | (1 << p)); //TODO reverse the pth 0 to 1
        int mask = ~((1 << p) - 1);
        et1 = et1 & mask; //TODO clear all bits bihind pth pos
        et1 |= ((1 << (c1 - 1)) - 1); //TODO add (c1 -1) 1s
        return et1;
    }
    
    /**
     * compute the l1, l0 firstly, then we could get p easily
     * here I consider the the sign bit
     * step1: find qth pos, reverse it from 1 to 0
     * step2: clear all bits behind qth
     * step3: shift (c1-1) 1s to the bit which behind qth
     * step4: OR the results step3 to the input number
     * @param et1
     * @return
     * @throws IOException
     */
    public static int getPreviousLargest(int et1) throws IOException{
        if(et1 == 0)
            return 0;
        int temp = et1;
        //TODO compute l1 firstly, just traverse byte stream from 0th bit to highest bit, stop until meet first 0
        int q = 0; //TODO non-trailing 1  0010011 so q = 4
        int l1 = 0; //TODO how many 1s are the left of first 0
        while((temp & 1) == 1){
            l1++;
            temp = temp >>>1;
        }
        int l0 = 0; //TODO how many 0s are fith of qth 1
        while((temp > 0) && (temp & 1) == 0){
            l0++;
            temp = temp >>>1;
        }
        q = l1 + l0;
        if(q == 32)
            throw new IOException("et1 don't have previous largest neighbor!");
        et1 = (et1 & (~(1 << q)));//TODO reverse the qth 1 to 0
        int mask = ~((1 << q) - 1);
        et1 = et1 & mask;
        et1 |= ((1 << (l1 -1) - 1) << (q - (l1 - 1)));
        return et1;
    }
    public static void main(String[] args){
//        int a = -10000;
//        int b = a >> 1;
//        System.out.println(a >> 1);
    }
}
