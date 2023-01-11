package Trick.primeNumber;

import java.util.ArrayList;
import java.util.List;

public class ClosestPrimeNumbersInRange {
    public int[] closestPrimes(int left, int right) {
        int[] check = new int[right + 1];
        List<Integer> primes = new ArrayList<>();
        check[0] = check[1] = 1;
        for (int i = 2; i <= right; ++i) {
            if (check[i] != 0) {
                primes.add(i);
            }
            for (long j = (long) i * i; j <= right; j += i) {
                check[(int) j] = 1;
            }
        }

        int n = primes.size(), num = Integer.MAX_VALUE;
        int[] res = {-1, -1};
        for (int i = 0; i < n - 1; ++i) {
            if (primes.get(i) < left)
                continue;

            if (num > primes.get(i + 1) - primes.get(i)) {
                num = primes.get(i + 1) - primes.get(i);
                res[0] = primes.get(i);
                res[1] = primes.get(i + 1);
            }
        }

        return res;
    }
}
