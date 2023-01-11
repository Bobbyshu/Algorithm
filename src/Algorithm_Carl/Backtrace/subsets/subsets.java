package Algorithm_Carl.Backtrace.subsets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class subsets {
    List<List<Integer>> res;
    LinkedList<Integer> path;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        path = new LinkedList<>();
        dfs(nums, 0);
        return res;
    }

    public void dfs(int[] nums, int idx) {
        res.add(new LinkedList<>(path));
        if (idx >= nums.length) {
            return;
        }

        for (int i = idx; i < nums.length; ++i) {
            path.add(nums[i]);
            dfs(nums, i + 1);
            path.removeLast();
        }
    }
}
