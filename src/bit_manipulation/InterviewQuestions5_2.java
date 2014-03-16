package bit_manipulation;

import java.io.IOException;
import java.util.HashMap;

public class InterviewQuestions5_2 {

    /**
     * this program's target is to convert Double to binary within 32 bits
     * TODO rule, double *2 , get Integer as binary, then use the fraction to teminate (0 or infinite loop)(IN MY NOTE!)
     * 
     * @param et1
     * @return
     * @throws IOException
     */
    public static String convertFloatToBinary(double et1) throws IOException {
        
        //TODO ommit the bound cases
        if(et1 >= 1 || et1 <= 0)
            throw new IOException("error!");
        HashMap<Double, Integer> detectCircle = new HashMap<Double, Integer>();
        detectCircle.put(Double.valueOf(et1), 1);
        StringBuilder outputBuilder = new StringBuilder();
        int count = 32;
        boolean isError = true;
        int curBit = 0;
        while (count > 0) {
            et1 = et1 * 2;
            if (et1 >= 1) {
                et1 = et1 - 1;
                curBit = 1;
            } else
                curBit = 0;

            if (detectCircle.containsKey(Double.valueOf(et1)))
                isError = false;
            else if (et1 == 0) {
                outputBuilder.append(String.valueOf(curBit));
                isError = false;
            } else
                outputBuilder.append(String.valueOf(curBit));
            if (!isError)
                break;
            count--;
        }
        if (isError)
            throw new IOException("Error!");
        else
            return outputBuilder.toString();
    }

    public static void main(String[] args) throws IOException {
        double et1 = 0.125;
        System.out.println(InterviewQuestions5_2.convertFloatToBinary(et1));
    }
}
