package DataStructure.HashMap.prefix;

import java.util.HashMap;
import java.util.Map;

public class BinarySubarraysWithSum {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        int res = 0;
        int[] prefix = new int[n + 1];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }

        for (int i = 1; i < n + 1; i++) {
            if (map.containsKey(prefix[i] - goal)) {
                res += map.get(prefix[i] - goal);
            }
            map.put(prefix[i], map.getOrDefault(prefix[i], 0) + 1);
        }

        return res;
    }
}
