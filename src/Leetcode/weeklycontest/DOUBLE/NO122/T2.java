package Leetcode.weeklycontest.DOUBLE.NO122;

public class T2 {
    public boolean canSortArray(int[] nums) {
        int i = 0, n = nums.length;
        // for (int m : nums) {
        //     System.out.println(Integer.bitCount(m));
        // }

        int lastMax = 0;
        while (i < n) {
            int cur = Integer.bitCount(nums[i]);
            int max = -1, min = 1000, j = i;
            while (j < n && Integer.bitCount(nums[j]) == cur) {
                max = Math.max(nums[j], max);
                min = Math.min(nums[j], min);
                ++j;
            }
            if (min < lastMax) {
                return false;
            } else {
                lastMax = max;
                i = j;
            }
        }

        return true;
    }
}
