package A_OnsiteClassical.grind75;

import java.util.ArrayList;
import java.util.List;

public class permutation {
  List<List<Integer>> res;
  List<Integer> path;
  boolean[] used;

  public List<List<Integer>> permute(int[] nums) {
    path = new ArrayList<>();
    res = new ArrayList<>();
    used = new boolean[nums.length];

    dfs(nums);
    return res;
  }

  private void dfs(int[] arr) {
    if (path.size() == arr.length) {
      res.add(new ArrayList<>(path));
      return;
    }

    for (int i = 0; i < arr.length; ++i) {
      if (used[i]) {
        continue;
      }

      path.add(arr[i]);
      used[i] = true;
      dfs(arr);
      used[i] = false;
      path.remove(path.size() - 1);
    }
  }
}
