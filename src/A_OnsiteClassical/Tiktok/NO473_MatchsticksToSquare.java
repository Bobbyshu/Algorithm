package A_OnsiteClassical.Tiktok;

import java.util.Arrays;

public class NO473_MatchsticksToSquare {
  public boolean makesquare(int[] matchsticks) {
    int sum = 0, max = 0;
    ;
    for (int m : matchsticks) {
      sum += m;
      max = Math.max(max, m);
    }

    if (sum % 4 != 0) {
      return false;
    }

    int line = sum / 4;
    if (max > line) {
      return false;
    }

    Integer[] nums = new Integer[matchsticks.length];
    for (int i = 0; i < matchsticks.length; ++i) {
      nums[i] = matchsticks[i];
    }

    Arrays.sort(nums, (o1, o2) -> o2 - o1);
    int[] edges = new int[4];

    return dfs(0, nums, edges, line);
  }

  private boolean dfs(int idx, Integer[] nums, int[] edges, int line) {
    if (idx == nums.length) {
      return true;
    }

    for (int i = 0; i < edges.length; ++i) {
      edges[i] += nums[idx];
      if (edges[i] <= line && dfs(idx + 1, nums, edges, line)) {
        return true;
      }
      edges[i] -= nums[idx];
    }

    return false;
  }
}
