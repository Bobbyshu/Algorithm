package A_OnsiteClassical.grind75;

import java.util.Arrays;

public class productOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n], suffix = new int[n];
        Arrays.fill(prefix, 1);
        Arrays.fill(suffix, 1);
        for (int i = 1; i < n; ++i) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }
        // 1 -1 -1 0 0
        // 0 0 -9  3 1

        for (int i = n - 2; i >= 0; --i) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }

        int[] res = new int[n];
        for (int i = 0; i < n; ++i) {
            res[i] = prefix[i] * suffix[i];
        }

        return res;
    }

    public int[] trickyProductExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int k = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = k;
            k *= nums[i];
        }
        k = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= k;
            k *= nums[i];
        }

        return res;
    }
}
