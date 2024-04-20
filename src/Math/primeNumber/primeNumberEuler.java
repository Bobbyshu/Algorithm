package Math.primeNumber;

import java.util.ArrayList;
import java.util.List;

public class primeNumberEuler {
    public int countPrimes(int n) {
        List<Integer> primes = new ArrayList<>();
        boolean[] notPrimes = new boolean[n];
        for (int i = 2; i < n; ++i) {
            if (!notPrimes[i]) {
                //haven't been checked
                primes.add(i);
            }
            //从小到大枚举所有质数。保证每个合数只被最小的质因子筛掉
            for (int j = 0; j < primes.size() && i * primes.get(j) < n; ++j) {
                // 每次把当前质数和 i 的乘积筛掉。
                // 根据下面的判断可以保证：primes[j] 是 primes[j] * i 的最小质因子
                notPrimes[i * primes.get(j)] = true;
                if (i * primes.get(j) == 0) {
                    break;
                }
            }
        }
        return primes.size();
    }
}
