package Algorithm_Carl.Backtrace.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class permutationII {
    List<List<Integer>> res;
    LinkedList<Integer> path;
    boolean[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        path = new LinkedList<>();
        used = new boolean[nums.length];
        Arrays.sort(nums);

        dfs(nums);
        return res;
    }

    void dfs(int[] nums) {
        if (path.size() == nums.length) {
            res.add(new LinkedList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; ++i) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            if (used[i]) {
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            dfs(nums);
            path.removeLast();
            used[i] = false;
        }
    }
}
