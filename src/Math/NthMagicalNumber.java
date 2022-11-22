package Math;

public class NthMagicalNumber {
    public int nthMagicalNumber(int n, int a, int b) {
        int mod = (int) 1e9 + 7;
        long left = 0L, right = (long) Math.min(a, b) * n;
        int lcm = a * b / gcd(a, b);

        while (left < right) {
            long mid = left + (right - left) / 2;
            if (mid / a + mid / b - mid / lcm >= n) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return (int) (left % mod);
    }

    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
