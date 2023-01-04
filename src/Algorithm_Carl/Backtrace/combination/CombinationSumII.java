package Algorithm_Carl.Backtrace.combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/*
都知道组合问题可以抽象为树形结构，那么“使用过”在这个树形结构上是有两个维度的，
一个维度是同一树枝上使用过，一个维度是同一树层上使用过。
所以我们要去重的是同一树层上的“使用过”，同一树枝上的都是一个组合里的元素，不用去重。

 */

public class CombinationSumII {
    List<List<Integer>> res;
    LinkedList<Integer> path;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
            // important
            if (i > startIndex && nums[i] == nums[i - 1])
                continue;
            if (nums[i] > target) {
                break;
            }
            path.add(nums[i]);
            backtrace(nums, target - nums[i], i + 1);
            path.removeLast();
        }
    }
}
