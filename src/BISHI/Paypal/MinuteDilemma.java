package BISHI.Paypal;

public class MinuteDilemma {
    public int numPairsDivisibleBy60(int[] time) {
        long res = 0;
        long[] remainder = new long[60];
        for (int t : time) {
            remainder[t % 60]++;
        }

        if (remainder[30] >= 2) {
            res += remainder[30] * (remainder[30] - 1) / 2;
        }

        if (remainder[0] >= 2) {
            res += remainder[0] * (remainder[0] - 1) / 2;
        }

        int left = 1, right = 59;
        while (left < right) {
            res += remainder[left] * remainder[right];
            left++;
            right--;
        }

        return (int) res;
    }

    public int combination(int n, int k) {
        long result = 1;
        for(int i = 1; i <= k; i++) {
            result = result * (n - i + 1) / i;
        }
        return (int)result;
    }
}
