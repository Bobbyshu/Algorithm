package Math;

public class MaxValAtBoundedArray {
    public int maxValue(int n, int index, int maxSum) {
        int l = index, r = index;
        int res = 1;
        int allocate = maxSum - n;
        while (l > 0 || r < n - 1) {
            int len = r - l + 1;
            if (allocate >= len) {
                // allocate the dist[l,r] for plus one
                allocate -= len;
                ++res;
                l = Math.max(0, l - 1);
                r = Math.min(n - 1, r + 1);
            } else {
                break;
            }
        }
        // if all the array been filled
        // we can allocate the rest of val
        res += allocate / n;
        return res;
    }
}
