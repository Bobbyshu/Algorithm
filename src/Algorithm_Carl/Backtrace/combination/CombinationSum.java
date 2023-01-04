package Algorithm_Carl.Backtrace.combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
    List<List<Integer>> res;
    LinkedList<Integer> path;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        path = new LinkedList<>();
        Arrays.sort(candidates);
        backtrace(candidates, target, 0);
        return res;
    }

    void backtrace(int[] nums, int target, int startIndex) {
        if (target == 0) {
            res.add(new LinkedList<>(path));
            return;
        }

        for (int i = startIndex; i < nums.length; ++i) {
            if (nums[i] > target) {
                break;
            }

            path.add(nums[i]);
            backtrace(nums, target - nums[i], i);
            path.removeLast();
        }
    }
}
