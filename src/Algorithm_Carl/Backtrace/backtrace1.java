package Algorithm_Carl.Backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
//给定一个可能有重复数字的整数数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
//
//candidates中的每个数字在每个组合中只能使用一次，解集不能包含重复的组合。

public class backtrace1 {
    List<List<Integer>> res;
    LinkedList<Integer> path;
    boolean[] used;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        path = new LinkedList<>();
        used = new boolean[candidates.length];
        Arrays.sort(candidates);

        dfs(candidates, target, 0, 0);
        return res;
    }

    void dfs(int[] candidates, int target, int sum, int startIndex) {
        // if (sum > target) return;

        if (sum == target) {
            res.add(new LinkedList<>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            // used[i - 1] == true，说明同一树枝candidates[i - 1]使用过
            // used[i - 1] == false，说明同一树层candidates[i - 1]使用过
            // 要对同一树层使用过的元素进行跳过
            if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) continue;

            if (sum + candidates[i] > target) break;

            path.add(candidates[i]);
            used[i] = true;
            dfs(candidates, target, sum + candidates[i], i + 1);
            used[i] = false;
            path.removeLast();
        }
    }
}
