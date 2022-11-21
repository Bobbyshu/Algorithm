package Math;
/*
假设排序后一个元素左边有left个元素，右边有right个元素，
那么这个元素作为最小值出现的子序列一共有2^right个(右边的每个元素可以选取或不选取);
而作为最大值出现的子序列一共有2^left个。
因此，元素A[i]对最后的总和的贡献就等于
(2 ^ left - 2 ^ right) * nums[i] = (2 ^ i - 2 ^ (n - i - 1)) * nums[i];
 */
import java.util.Arrays;

public class SumOfSubsequenceWidths {
    public int sumSubseqWidths(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        int mod = (int) 1e9 + 7;
        int n = nums.length;
        Arrays.sort(nums);

        long[] two = new long[n + 1];
        two[0] = 1L;
        for (int i = 1; i <= n; ++i) {
            two[i] = (two[i - 1] << 1) % mod;
        }

        long res = 0;
        for (int i = 0; i < n; ++i) {
            int left = i;
            int right = n - i - 1;
            res = (res + (two[left] - two[right]) * nums[i]) % mod;
        }

        return (int) (res + mod) % mod;
    }
}
