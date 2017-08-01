package dmz.codeChallenges;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

class Primes {

    static List<Integer> getPrimes(int numPrimes) {
        final List<Integer> primes = new ArrayList<>(numPrimes);

        IntStream.iterate(2, i -> i + 1).
                filter(i -> {
                    for (int prime : primes)
                        if (i % prime == 0)
                            return false;
                    return true;
                }).limit(numPrimes).
                forEach(primes::add);
        return primes;
    }
}