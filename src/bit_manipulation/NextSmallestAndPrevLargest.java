/**
 * CTCI 5.3
 */
package bit_manipulation;

import java.io.IOException;

public class NextSmallestAndPrevLargest {

    public static int getNextSmallest(int num) throws IOException {
        if (num == 0) {
            return 0;
        }
        int cur = num, p = 1; //find the first occurrence of "01" from left, and p is the pos of "0" in "01"
        int c1 = 0; // how many 1s stay p's right behind
        while ((cur > 0)) {
            if ((cur & 1) == 1) {
                c1++;
                if ((cur & 2) == 0) {
                    break;
                }
            }
            p++;
            cur = cur >> 1;
        }
        if (p == 32) {
            throw new IOException("num don't have next smallest neighbor!");
        }
        num = (num | (1 << p)); //reverse the pth from 0 to 1
        int mask = ~((1 << p) - 1);
        num = num & mask; //clear all bits behind p
        num |= ((1 << (c1 - 1)) - 1); //add (c1 - 1) 1s from low-order
        return num;
    }

    public static int getPreviousLargest(int num) throws IOException {
        if (num == 0) {
            return 0;
        }
        int cur = num, p = 1;//find the first occurrence of "10" from left, and p is the pos of "1" in "10" 
        int l1 = 0; //how many 1s stays p's right behind
        while (cur > 0) {
            if ((cur & 1) == 0) {
                if ((cur & 2) == 2) {
                    break;
                }
            } else {
                l1++;
            }
            p++;
            cur = cur >> 1;
        }
        num = (num & (~(1 << p)));//reverse the pth 1 to 0
        int mask = ~((1 << p) - 1);
        num = num & mask;
        num |= ((1 << (l1 + 1) - 1) << (p - l1 - 1));
        return num;
    }

}
