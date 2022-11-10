package Algorithm.SlidingWindow;

public class lc713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }

        int res = 0;
        int product = 1;
        int n = nums.length;
        int l = 0, r = 0;

        while (r < n) {
            product *= nums[r];
            r++;

            while (product >= k) {
                product /= nums[l];
                l++;
            }
            /*
            每次右指针位移到一个新位置，应该加上 x 种数组组合：
              nums[right]
              nums[right-1], nums[right]
              nums[right-2], nums[right-1], nums[right]
              nums[left], ......, nums[right-2], nums[right-1], nums[right]
            共有 right - left + 1 种
             */
            res += (r - l);
        }

        return res;
    }
}
