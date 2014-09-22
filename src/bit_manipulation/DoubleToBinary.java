package bit_manipulation;

import java.io.IOException;
import java.util.HashSet;

public class DoubleToBinary {

    public static String convertFloatToBinary(double num) throws IOException {
        if (num >= 1 || num <= 0)
            throw new IOException("error!");
        HashSet<Double> detectCircle = new HashSet<Double>();
        detectCircle.add(num);
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            if ((num *= 2) >= 1) {
                num = num - 1;
                ans.append(1);
            } else {
                ans.append(0);
            }
            if (detectCircle.contains(num)) {
                throw new IOException("has cycle!");
            } else if (num == 0) {
                break;
            }
        }
        return ans.toString();
    }
}
