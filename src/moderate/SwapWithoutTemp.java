package moderate;

public class SwapWithoutTemp {
    public static void solution(int a, int b){
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
    }
}
