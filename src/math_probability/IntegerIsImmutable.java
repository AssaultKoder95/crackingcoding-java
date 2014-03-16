package math_probability;

public class IntegerIsImmutable {

    public static void big(Integer s) {
        s++; //TODO each time when s++, s--, s automatically create a new instance and pointed to this new instance
    }

    public static void main(String[] args) {
        Integer s = new Integer(1); //TODO after Integer, String is created, they are fixed, can not change the value
                                    //TODO string+= operation just create new instance
        big(s);
        System.out.println(s); //TODO found that s didn't change the value outside
    }
}
