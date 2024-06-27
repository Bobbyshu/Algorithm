package A_OnsiteClassical.grind75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationSum {
  // O(n × 2^n) is a loose upper bound, meaning that in this code,
  // each of the n positions considers whether to select or not select.
  // If the condition is met, it adds the solution to the answer, incurring the time cost.
  // However, in actual execution, since not all solutions meet the conditions,
  // the recursion will cut branches where target − candidates[idx] ≥ 0,
  // making the actual running time far less than this upper bound.

  // when confronted with combination, if we set it in same array
  // it always require startIndex to remove duplicate path
  // 2 3 4 7
  // after select all 2 we can't use 2 again
  // to make sure the answer will always in ascending order
  // which means we need to sort array in ascending order at first
  List<List<Integer>> res;
  List<Integer> path;

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    path = new ArrayList<>();
    res = new ArrayList<>();
    Arrays.sort(candidates);

    dfs(candidates, target, 0);
    return res;
  }

  private void dfs(int[] arr, int target, int startIndex) {
    if (target == 0) {
      res.add(new ArrayList<>(path));
      return;
    }

    for (int i = startIndex; i < arr.length; ++i) {
      if (target < arr[i]) {
        break;
      }

      path.add(arr[i]);
      dfs(arr, target - arr[i], i);
      path.remove(path.size() - 1);
    }
  }
}
