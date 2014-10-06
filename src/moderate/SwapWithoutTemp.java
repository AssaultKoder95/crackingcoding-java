/**
 * CTCI 17.1
 * we use XOR to get the diff of (a, b)
 * one ^ diff -> another (eg. if xor = 1, apply 1 ^ xor -> 0, or apply 0 ^ xor -> 1)
 * if xor = 0, apply 1 ^ xor -> 1, or apply 0 ^ xor -> 0 
 */
package moderate;

public class SwapWithoutTemp {
    public static void solution(int a, int b){
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
    }
}
