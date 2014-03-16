package bit_manipulation;

public class InterviewQuestions5_8 {

    /**
     * TODO tricky point
     * point1. 76543210 76543210 76543210 76543210
     * h byte0 h byte1 h byte2 h byte3
     * point2. draw line from x1 to x2 (all include x1, and x2)
     * TODO point3. if x1 = 7, so the mask of this byte 0xff should >>7 to be 00000001
     * if x1 = 8, so this byte don't need to set 1 to some bit,
     * that's why startOffset = x1 % 8; startFullByte(offset) = startOffset != 0 ? x1/8 +1 : x1/8
     * TODO point4. if x2 = 1, so the mask of this byte 0xff should >>(1+1) then ~ to be 11000000
     * if x2 = 7, so this byte all need to set 1 to all of bits in it.
     * that's why endOffset = x2 % 8; endFullByte(offset) = endOffset != 7 ? x2/8 - 1 :x2/8
     * 
     * @param screen
     * @param width
     * @param x1
     * @param x2
     * @param y
     */
    void drawLine(byte[] screen, int width, int x1, int x2, int y) {
        int startOffset = x1 % 8;
        int startFullByte = x1 / 8;
        if (startOffset != 0) //TODO tricky!!!!!
            startFullByte++;
        int endOffset = x2 % 8;
        int endFullByte = x2 / 8;
        /***********/
        if (endOffset != 7) //TODO tricky!!
            endFullByte--;
        /**********/
        int globalStartByte = y * (width / 8); //TODO locate to specific row
        for (int i = startFullByte; i <= (endFullByte + 1); i++) {
            screen[globalStartByte + startFullByte] = (byte) 0xff;
        }
        if (x1 / 8 == x2 / 8) {
            byte mask = (byte) ((0xff >> startOffset) & ~(0xff >> (endOffset + 1)));
            screen[globalStartByte + x1 / 8] |= mask; //TODO locate the offset which need to be set
        } else {
            if (startOffset != 0) {
                byte mask = (byte) (0xff >> startOffset); //TODO point3
                screen[globalStartByte + x1 / 8] |= mask; //TODO locate the offset which need to be set
            }
            if (endOffset != 0) {
                byte mask = (byte) ~(0xff >> (endOffset + 1));//TODO point4
                screen[globalStartByte + x2 / 8] |= mask;//TODO locate the offset which need to be set
            }
        }
    }

}
