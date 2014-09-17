package bit_manipulation;

public class FindDupWithBitSet {
    public static class BitSet {
        private byte[] bitField;

        public BitSet(int size) {
            bitField = new byte[size / 8];
        }

        public void set(int pos) {
            bitField[pos / 8] |= 1 << (pos % 8);
        }

        public boolean get(int pos) {
            if ((bitField[pos / 8] & (1 << (pos % 8))) == 0) {
                return false;
            } else {
                return true;
            }
        }
    }
    
    public static void checkDuplicates(int[] array) {
        BitSet bs = new BitSet(32000);
        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            int num0 = num - 1; // bitset starts at 0, numbers start at 1
            if (bs.get(num0)) { 
                System.out.println(num);
            } else {
                bs.set(num0);               
            }
        }
    }
}
