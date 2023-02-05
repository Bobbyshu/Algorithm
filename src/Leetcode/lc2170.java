package Leetcode;

import java.util.HashMap;
import java.util.Map;


public class lc2170 {
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return 0;

        Map<Integer, Integer> even = new HashMap<>();
        Map<Integer, Integer> odd = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                even.put(nums[i], even.getOrDefault(nums[i], 0) + 1);
            } else {
                odd.put(nums[i], odd.getOrDefault(nums[i], 0) + 1);
            }
        }

        int[][] even12Max = check(even);
        int[][] odd12Max = check(odd);

        if (even12Max[0][0] != odd12Max[0][0]) {
            n -= (even12Max[0][1] + odd12Max[0][1]);
        } else {
            n -= Math.max(even12Max[0][1] + odd12Max[1][1],
                    even12Max[1][1] + odd12Max[0][1]);
        }

        return n;
    }

    int[][] check (Map<Integer, Integer> map) {
        int[][] res = new int[2][2];
        for (int key : map.keySet()) {
            int val = map.get(key);
            //res[0][0] for maxTime key and res[0][1] for maxTime time;
            if (val > res[0][1]) {
                res[1][0] = res[0][0];
                res[1][1] = res[0][1];
                res[0][0] = key;
                res[0][1] = val;
            } else if (val > res[1][1]) {   //alternate second guy
                res[1][0] = key;
                res[1][1] = val;
            }
        }

        return res;
    }

}


