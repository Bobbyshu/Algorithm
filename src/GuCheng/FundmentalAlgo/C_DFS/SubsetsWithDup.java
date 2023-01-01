package GuCheng.FundmentalAlgo.C_DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SubsetsWithDup {
    List<List<Integer>> res;
    LinkedList<Integer> path;
    boolean[] used;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        path = new LinkedList<>();
        Arrays.sort(nums);
        used = new boolean[nums.length];
        dfs(nums, 0);
        return res;
    }

    public void dfs(int[] nums, int idx) {
        res.add(new ArrayList<>(path));
        if (idx >= nums.length) {
            return;
        }

        for (int i = idx; i < nums.length; ++i) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            dfs(nums, i + 1);
            used[i] = false;
            path.removeLast();
        }
    }
}
