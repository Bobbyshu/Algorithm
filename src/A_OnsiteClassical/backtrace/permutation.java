package A_OnsiteClassical.backtrace;

import java.util.ArrayList;
import java.util.List;

public class permutation {

  List<List<Integer>> res;
  List<Integer> path;
  boolean[] used;

  public List<List<Integer>> permute(int[] nums) {
    res = new ArrayList<>();
    path = new ArrayList<>();
    used = new boolean[nums.length];

    dfs(nums);
    return res;
  }

  void dfs(int[] nums) {
    if (path.size() == nums.length) {
      res.add(new ArrayList<>(path));
      return;
    }

    for (int i = 0; i < nums.length; ++i) {
      if (used[i]) {
        continue;
      }
      used[i] = true;
      path.add(nums[i]);
      dfs(nums);
      path.remove(path.size() - 1);
      used[i] = false;
    }
  }

  public static void main(String[] args) {
    permutation p = new permutation();
    int[] arr = {1,2,3};
    p.permute(arr);
  }
}
