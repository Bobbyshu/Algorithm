package Algorithm.Backtrace;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class permutation {
    List<List<Integer>> res;
    LinkedList<Integer> path;
    boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        path = new LinkedList<>();
        used = new boolean[nums.length];

        dfs(nums);
        return res;
    }

    //因为排列问题，每次都要从头开始搜索，例如元素1在[1,2]中已经使用过了，但是在[2,1]中还要再使用一次1。
    //而used数组，其实就是记录此时path里都有哪些元素使用了，一个排列里一个元素只能使用一次。
    void dfs(int[] nums) {
        if (path.size() == nums.length) {
            res.add(new LinkedList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            path.add(nums[i]);
            dfs(nums);
            path.removeLast();
            used[i] = false;
        }
    }
}
