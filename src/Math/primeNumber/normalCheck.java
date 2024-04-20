package Math.primeNumber;

public class normalCheck {
    public int countPrimes(int n) {
        int cnt = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                cnt++;
            }
        }
        return cnt;
    }

    private boolean isPrime(int num) {
        // we only need to check to sqrt(num)
        // because if num isn't a prime number
        // it must have a divisor that <= sqrt(num)
        int max = (int)Math.sqrt(num);
        for (int i = 2; i <= max; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
