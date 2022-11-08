package A_OUEI.Amazon.former;

public class getMaxAggreTempChange {
    public static long getMaxAggreTempChange(int[] changes) {
        int n = changes.length;
        long[] prefix = new long[n];
        prefix[0] = (long) changes[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + (long)changes[i];
        }

        long maxAggre = Math.max(prefix[0], prefix[n - 1]);
        for (int i = 1; i < n; i++) {
            long temp = Math.max(prefix[i], prefix[n - 1] - prefix[i - 1]);
            maxAggre = Math.max(maxAggre, temp);
        }
        return maxAggre;
    }
}
