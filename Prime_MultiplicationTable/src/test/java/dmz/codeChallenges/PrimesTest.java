package dmz.codeChallenges;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertArrayEquals;

public class PrimesTest {

    @Test
    public void getPrimesSuccess() {

        Integer[] primeNumbers = {  2, 3, 5, 7, 11 };
        List<Integer> result = Primes.getPrimes(5);

        assertArrayEquals("Result is wrong", primeNumbers, result.toArray());
    }
}
