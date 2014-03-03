package zn.math.probability;

import java.io.IOException;

public class InterviewQuestions7_4 {

    /**
     * formula: eg. 4 * 10 while(4){sum+=10}
     * 
     * @param et1
     * @param et2
     * @return
     */
    public static int multiplyWithAddOpt(int et1, int et2) {
        if (et1 == 0 || et2 == 0)
            return 0;
        else {
            int sum = 0;
            int outterLoopCon = et2 <= et1 ? et2 : et1;
            int innerLoopCon = et1 >= et2 ? et1 : et2;
            while (outterLoopCon != 0) {
                sum += innerLoopCon;
                outterLoopCon--;
            }
            return sum;
        }
    }

    /**
     * formula: eg. a * b ==> b(inner) * (2^0 * (0/1) + ......)(outter)
     * 
     * @param et1
     * @param et2
     * @return
     */
    public static int multiplyWithBitOpt(int et1, int et2) {
        if (et1 == 0 || et2 == 0)
            return 0;
        boolean isPositive = et1 > 0 && et2 < 0 || et1 < 0 && et2 > 0 ? false : true;
        if (et1 < 0) {
            et1 = -et1;
        }
        if (et2 < 0) {
            et2 = -et2;
        }
        int outterLoopCon = et1 <= et2 ? et1 : et2;
        int innerLoopCon = et2 >= et1 ? et2 : et1;
        int i = 0;
        int sum = 0;

        while (outterLoopCon != 0) { //TODO a
            if ((outterLoopCon & 1) == 1) { //--> a = 2^0*(0/1) + ........
                sum += innerLoopCon << i; //TODO b
            }
            outterLoopCon >>= 1;
            i++;
        }
        return isPositive == true ? sum : -sum;
    }

    /**
     * a - b ==> a + (-b)
     * 
     * @param et1
     * @param et2
     * @return
     */
    public static int substractionWithAddOpt(int et1, int et2) {
        int sign = et2 >= 0 ? 1 : -1;
        int newEt2 = 0;
        while (et2 != 0) {
            newEt2 += sign;
            et2 += sign;
        }
        return et1 + newEt2;
    }

    /**
     * this is a contrary way of how to implement multilying using bits
     * step1: et1: n bits et2: m bits; the bits of output is n - m or n - m + 1
     * step2: from highest significant bit: 2^i 
     * @param et1
     * @param et2
     * @return
     * @throws IOException
     */
    public static int divisionWithBitOpt1(int et1, int et2) throws IOException {
        if (et2 == 0)
            throw new IOException("wrong parameter2!");
        if (et1 == 0)
            return 0;
        boolean isPositive = et1 > 0 && et2 < 0 || et1 < 0 && et2 > 0 ? false : true;
        if (et1 < 0) {
            et1 = -et1;
        }
        if (et2 < 0) {
            et2 = -et2;
        }
        int NumEt1 = getNumOfBits(et1);
        int NumEt2 = getNumOfBits(et2);
        int NumOfBitsResult = NumEt1 >= NumEt2 ? NumEt1 - NumEt2 : NumEt2 - NumEt1;
        if (et2 * (1 << (NumOfBitsResult + 1)) <= et1) //TODO
            NumOfBitsResult++;
        int tempSum = 0;
        int output = 0;
        for (int i = NumOfBitsResult; i > 0; i--) { //TODO
            tempSum += et2 * (1 << i); //TODO
            if (tempSum <= et1) {
                output += 1 << i;
            } else {
                tempSum -= et2 * (1 << i);
            }
            if (tempSum == et1)
                break;
        }
        return isPositive == true ? output : -output;
    }

    public static int getNumOfBits(int target) {
        int i = 0;
        while (target != 0) {
            target >>= 1;
            i++;
        }
        return i;
    }

    public static int divisionWithBitOpt2(int et1, int et2) throws IOException {
        if (et2 == 0)
            throw new IOException("wrong parameter2!");
        if (et1 == 0)
            return 0;
        boolean isPositive = et1 > 0 && et2 < 0 || et1 < 0 && et2 > 0 ? false : true;
        if (et1 < 0) {
            et1 = -et1;
        }
        if (et2 < 0) {
            et2 = -et2;
        }
        int NumEt1 = getNumOfBits(et1);
        int NumEt2 = getNumOfBits(et2);
        int loopCount = NumEt1 >= NumEt2 ? NumEt1 - NumEt2 : NumEt2 - NumEt1;
        if (et2 * (1 << (loopCount + 1)) <= et1)
            loopCount++;
        int output = 0;
        int tempSub = 0;
        while (loopCount > 0) {
            NumEt1 = getNumOfBits(et1);
            NumEt2 = getNumOfBits(et2);
            et2 <<= NumEt1 >= NumEt2 ? (NumEt1 - NumEt2) : 0;
            tempSub = et1 - et2;
            if (tempSub >= 0) {
                output += 1;
            }
            if (tempSub == 0)
                break;
            et1 = tempSub << 1;
            output <<= 1;
            
        }
        return isPositive == true ? output : -output;
    }

    public static void main(String[] args) {
        //        Object x[] = new String[3];
        //        x[0] = new String("dd");
        //        System.out.println(x[0].toString());
        //        x[0] = new Integer(0);
        //        System.out.println(x[0].toString());
        System.out.println(InterviewQuestions7_4.multiplyWithAddOpt(10, 99));
        System.out.println(InterviewQuestions7_4.multiplyWithBitOpt(-10, 99));
        
    }
}
