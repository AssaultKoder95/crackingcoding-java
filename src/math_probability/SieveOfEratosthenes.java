package math_probability;

import java.io.IOException;
import java.util.Arrays;

public class SieveOfEratosthenes {

    /**
     * fetch all primes <= max
     * TODO we could do a optimization for space which we only need to consider the odd number in this approach
     */
    boolean[] sieveOfEratosthenes(int max) throws IOException {
        if (max < 2){
            throw new IOException("minimum prime start from 2!");
        }
        boolean[] flags = new boolean[max + 1]; //NOTE: include max
        Arrays.fill(flags, Boolean.TRUE); //NOTE: one batch way to init a boolean array
        flags[0] = flags[1] = false;
        int prime = 2;
        while (prime <= Math.sqrt(max)) {
            crossOffNonPrime(prime, flags);
            prime = getNextPrime(flags, prime);
        }
        return flags;
    }

    public void crossOffNonPrime(int prime, boolean[] flags) {
        for (int i = prime * prime; i < flags.length; i += prime) {
            flags[i] = false;
        }
    }

    public int getNextPrime(boolean[] flags, int lastPrime) {
        int i = lastPrime + 1;
        for (; i < flags.length; i++) {
            if (flags[i] == true)
                break;
        }
        return i;
    }
}
