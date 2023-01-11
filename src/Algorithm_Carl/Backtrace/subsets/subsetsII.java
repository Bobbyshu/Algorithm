package Algorithm_Carl.Backtrace.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
//去重思路：我们要的就是同树枝但是不同数层，但是怎么判断是不是在同一数层呢，就引入一个used数组
//如果当前used数组的前一个是没用过的，那说明肯定在同一树层，就是[0,1,0]，那就肯定不行，因为和前面的重复了
//如果当前used数组的前一个是用过的，那就说明肯定在同一树枝，就是[1,1,0]，那就可以继续添加了

public class subsetsII {
    List<List<Integer>> res;
    LinkedList<Integer> path;
    boolean[] used;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        path = new LinkedList<>();
        used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrace(nums, 0);
        return res;
    }

    public void backtrace(int[] nums, int idx) {
        res.add(new LinkedList<>(path));
        if (idx >= nums.length) {
            return;
        }

        for (int i = idx; i < nums.length; ++i) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backtrace(nums, i + 1);
            used[i] = false;
            path.removeLast();
        }
    }
}
