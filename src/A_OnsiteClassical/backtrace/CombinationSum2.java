package A_OnsiteClassical.backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
  List<List<Integer>> res;
  List<Integer> path;
  boolean[] used;

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Arrays.sort(candidates);
    res = new ArrayList<>();
    path = new ArrayList<>();
    used = new boolean[candidates.length];

    int sum = 0;
    dfs(0, candidates, target, sum);
    return res;
  }

  public void dfs(int startIdx, int[] arr, int target, int sum) {
    if (sum > target) {
      return;
    }

    if (sum == target) {
      res.add(new ArrayList<>(path));
      return;
    }

    for (int i = startIdx; i < arr.length; i++) {
      // used[i - 1] == true，说明同一树枝candidates[i - 1]使用过
      // used[i - 1] == false，说明同一树层candidates[i - 1]使用过
      // 要对同一树层使用过的元素进行跳过
      if (i > 0 && arr[i] == arr[i - 1] && !used[i - 1]) {
        continue;
      }
      path.add(arr[i]);
      used[i] = true;
      dfs(i + 1, arr, target, sum + arr[i]);
      used[i] = false;
      path.remove(path.size() - 1);
    }
  }
}
