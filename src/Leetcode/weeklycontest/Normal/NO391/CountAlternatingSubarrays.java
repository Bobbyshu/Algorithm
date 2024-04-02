package Leetcode.weeklycontest.Normal.NO391;

public class CountAlternatingSubarrays {
    public long countAlternatingSubarrays(int[] nums) {
        int cnt = 1;
        long res = 1L;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] != nums[i - 1]) {
                ++cnt;
            } else {
                cnt = 1;
            }

            res += cnt;
        }

        return res;
    }
}
