/**
 * CTCI 7.4
 */
package math_probability;

public class MutiplyInBitWay {
    /**
     * a * b ==> b(inner) * (2^0 * (0/1) + ......)(outter)
     */
    public static int multiplyInBitWay(int num1, int num2) {
        if (num1 == 0 || num2 == 0){
            return 0;
        }
        boolean isPositive = num1 > 0 && num2 > 0 || num1 < 0 && num2 < 0 ? true : false;
        num1 = Math.abs(num1);
        num2 = Math.abs(num2);
        int inner = 0, outter = 0;
        if(num1 > num2){
            outter = num1;
            inner = num2;
        }else{
            outter = num2;
            inner = num1;
        }
        int i = 0, sum = 0;
        while (outter != 0){ 
            if ((outter & 1) == 1) {
                sum += inner << i;
            }
            outter >>= 1;
            i++;
        }
        return isPositive == true ? sum : -sum;
    }
}