package Trick.prefix;

import java.util.HashMap;
import java.util.Map;

/*
给你一个整数数组 nums 和一个整数 k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组：

子数组大小 至少为 2 ，且
子数组元素总和为 k 的倍数。
如果存在，返回 true ；否则，返回 false 。

如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。0 始终视为 k 的一个倍数。
 */
public class SameModule {
    class Solution {
        public boolean checkSubarraySum(int[] nums, int k) {
            int n = nums.length;
            if (n == 1)
                return false;

            // int[] prefix = new int[n + 1];
            // for (int i = 1; i <= n; i++) {
            //     prefix[i] = prefix[i - 1] + nums[i - 1];
            // }
            // System.out.println(Arrays.toString(prefix));
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, -1);
            int remainder = 0;

            for (int i = 0; i < n; i++) {
                remainder = (remainder + nums[i]) % k;
                if (map.containsKey(remainder)) {
                    int prevIndex = map.get(remainder);
                    if (i - prevIndex >= 2) {
                        return true;
                    }
                } else {
                    map.put(remainder, i);
                }
            }

            return false;
        }
    }
}
