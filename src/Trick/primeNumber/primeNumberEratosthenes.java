package Trick.primeNumber;
/*
任意素数x的倍数有：2x, 3x, 4x, ..., x*x, (x+1)*x, ...

任意小于x*x的倍数都被之前的素数筛过滤过，如：2 过滤 2x, 4x, ...，3 过滤 3x, ...

所以从x*x开始过滤之后的倍数，所以x只需遍历到sqrt(N)
 */

import java.util.Arrays;

public class primeNumberEratosthenes {
    /*
    任意素数x的倍数有：2x, 3x, 4x, ..., x*x, (x+1)*x, ...
    任意小于x*x的倍数都被之前的素数筛过滤过，如：2 过滤 2x, 4x, ...，3 过滤 3x, ...
    所以从x*x开始过滤之后的倍数，所以x只需遍历到sqrt(N)
    1 - n 中质数的数量是 n / ln(n)
    n loglog (N)
     */
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        // 从 2 开始枚举到 sqrt(n)。
        for (int i = 2; i * i < n; i++) {
            // 如果当前是素数
            if (isPrime[i]) {
                // 就把从 i*i 开始，i 的所有倍数都设置为 false。
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // 计数
        int cnt = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                cnt++;
            }
        }
        return cnt;
    }
}
