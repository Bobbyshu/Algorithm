package Algorithm_Carl.Backtrace.subsets;

import java.util.*;

public class IncreasingSubsequences {
    List<List<Integer>> res;
    LinkedList<Integer> path;
    public List<List<Integer>> findSubsequences(int[] nums) {
        res = new ArrayList<>();
        path = new LinkedList<>();
        backtrace(nums, 0);
        return res;
    }

    void backtrace(int[] nums, int idx) {
        if (path.size() >= 2) {
            res.add(new LinkedList<>(path));
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = idx; i < nums.length; ++i) {
            // same layer remove duplicate
            if (path.size() != 0 && nums[i] < path.getLast()) {
                continue;
            }
            //remove used duplicate
            if (map.getOrDefault(nums[i], 0) >= 1){
                continue;
            }
            map.put(nums[i],map.getOrDefault( nums[i],0 )+1);
            path.add(nums[i]);
            backtrace(nums, i + 1);
            //cuz we generate each hashmap for all layer
            //so, we don't need to remove key-value when we outside the backtrace
            path.removeLast();
        }
    }
}
