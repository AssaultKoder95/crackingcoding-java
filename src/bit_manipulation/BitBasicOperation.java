/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   BitBasicOperation.java
 *         Created:   Sep 19, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   CTCI basic operations
 *                    
 * All rights reserved.
 ******************************************************************************/
package bit_manipulation;

public class BitBasicOperation {
    boolean getBit(int num, int i) {
        return ((num & (1 << i)) != 0);
    }

    int setBit(int num, int i) {
        return num | (1 << i);
    }

    int clearBit(int num, int i) {
        return num & (~(1 << i));
    }

    int clearBitsMSBthroughI(int num, int i) {
        int mask = (1 << i) - 1;
        return num & mask;
    }
    
    int clearBitsIthrough0(int num, int i){
        int mask = ~((1 << (i + 1)) - 1);
        return num & mask;
    }
}
