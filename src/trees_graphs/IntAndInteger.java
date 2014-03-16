package trees_graphs;

public class IntAndInteger {
    public static boolean isEqual(Integer a, Integer b) {
        return a == b; //TODO == for The == operator performs reference identity comparisons on Integer expressions and value equality comparisons on int expressions
    }

    /**
     * Integer.valueOf(int i) use valueCache which cache(-128~+127), out of this range, it will new instance
     * 
     * @param args
     */
    public static void main(String[] args) {
        int i = 0;
        for (int j = 0; i < 500; ++i, ++j) {
            if (isEqual(i, j)) { //TODO int cast to Integer using Integer.valueOf(), 
                continue;
            } else {
                break;
            }
        }
        System.out.println(i); //TODO output answer is 128
    }
}
