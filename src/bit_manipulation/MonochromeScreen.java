/**
 * CTCI 5.8
 */
package bit_manipulation;

public class MonochromeScreen {

    /**
     * NOTE 76543210 76543210 76543210 76543210
     * h byte0 h byte1 h byte2 h byte3
     * NOTE draw line from x1 to x2 (all include x1, and x2)
     * NOTE if x1 = 6, so the mask of this byte 0xff should >> 6 to be 00000011
     * NOTE if x2 = 1, so the mask of this byte 0xff should >> (1+1) then ~ to be 11000000
     */
    void drawLine(byte[] screen, int width, int x1, int x2, int y) {
        int startOffset = x1 % 8, startFullByte = x1 / 8;
        if (startOffset != 0) {
            startFullByte++;
        }
        int endOffset = x2 % 8, endFullByte = x2 / 8;
        if (endOffset != 7) {
            endFullByte--;
        }
        int globalStartByte = y * (width / 8); //locate to specific row
        for (int i = startFullByte; i <= endFullByte; i++) {
            screen[globalStartByte + i] = (byte) 0xff;
        }
        if (x1 / 8 == x2 / 8) {//same byte
            byte mask = (byte) ((0xff >> startOffset) & ~(0xff >> (endOffset + 1)));
            screen[globalStartByte + x1 / 8] |= mask;
        } else {
            if (startOffset != 0) {
                byte mask = (byte) (0xff >> startOffset);
                screen[globalStartByte + x1 / 8] |= mask;
            }
            if (endOffset != 7) {
                byte mask = (byte) ~(0xff >> (endOffset + 1));
                screen[globalStartByte + x2 / 8] |= mask;
            }
        }
    }

}
