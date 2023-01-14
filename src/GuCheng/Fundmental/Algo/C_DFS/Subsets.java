package GuCheng.Fundmental.Algo.C_DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
//找全部叶子结点
public class Subsets {
    List<List<Integer>> res;
    LinkedList<Integer> path;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        path = new LinkedList<>();
        dfs(nums, 0);
        return res;
    }

    public void dfs(int[] nums, int idx) {
        res.add(new ArrayList<>(path));
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
