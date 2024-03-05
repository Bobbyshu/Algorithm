package Leetcode.weeklycontest.DOUBLE.NO122;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class T3 {
    /**
     * [5, 2, 2, 2, 9, 10]
     * 52221 -> 2211 -> 1 1 -> 0
     */
    public int minimumArrayLength(int[] nums) {
        // 2 number -> 1 number
        int min = Integer.MAX_VALUE;
        for (int n : nums) {
            min = Math.min(min, n);
        }

        // if nums exist a number which can create a smaller number than min
        // we can use min to delete other
        // finally we use this one and min to create last one
        for (int n : nums) {
            if (n % min > 0) {
                return 1;
            }
        }

        // at this time
        // nums exist all min or min*k
        // we can only remain (min+1) / 2
        int res = 0;
        for (int n : nums) {
            if (n == min) {
                ++res;
            }
        }

        return (res + 1) / 2;
    }
}
