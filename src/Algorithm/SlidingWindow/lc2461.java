package Algorithm.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/*
发病了，就很简单的滑动窗口，不需要判断当size为n的时候会不会出现单个数字有2以上的频率，因为
每个数字都是不同的，只要他有n个数字记录在案且间隔为n，那每个数字的频率肯定为1
 */
public class lc2461 {
    public long maximumSubarraySum(int[] nums, int k) {
        long res = 0L, sum = 0L;
        int n = nums.length;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            sum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        if (map.size() == k) {
            res = sum;
        }

        for (int i = k; i < n; i++) {
            sum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            sum -= nums[i - k];
            int cnt = map.get(nums[i - k]);
            if (cnt == 1) {
                map.remove(nums[i - k]);
            } else {
                map.put(nums[i - k], cnt - 1);
            }

            if (map.size() == k) {
                res = Math.max(res, sum);
            }
        }

        return res;
    }
}
