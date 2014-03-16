package bit_manipulation;

public class InterviewQuestions5_5 {

    /**
     * this is nomal solution which shift every bit including the zero in it (sometimes we could remove these anoying zeros)
     */
    public static int computesNumOfBitsForAConvertToB1(int a, int b) {
        int count = 0;
        for (int c = a ^ b; c != 0; c = c >>> 1) {
            count += c & 1; //TODO must c &1, if lowest bit of c if 0 count+=0, else count+=1
        }
        return count;
    }

    /**
     * this is better solution which the technique of 5_4. directly remove zeros which don't need shift 1bit by 1bit
     * 
     * @param a
     * @param b
     * @return
     */
    public static int computesNumOfBitsForAConvertToB2(int a, int b) {
        int count = 0;
        for (int c = a ^ b; c != 0; c = c & (c - 1)) {
            count++;
        }
        return count;
    }
    
    public static void main(String[] args){
        Integer a = new Integer(3);
        System.out.println(a.SIZE);
        System.out.println(InterviewQuestions5_5.computesNumOfBitsForAConvertToB2(14, 31));
    }
}
