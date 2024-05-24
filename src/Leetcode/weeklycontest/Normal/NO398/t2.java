package Leetcode.weeklycontest.Normal.NO398;

public class t2 {
  public boolean[] isArraySpecial(int[] nums, int[][] queries) {
    int n = nums.length;
    int[] prefix = new int[n];
    for (int i = 1; i < n; ++i) {
      prefix[i] = prefix[i - 1] + ((nums[i - 1] % 2 == nums[i] % 2) ? 1 : 0);
    }

    int m = queries.length;
    boolean[] res = new boolean[m];
    for (int i = 0; i < m; ++i) {
      res[i] = prefix[queries[i][0]] == prefix[queries[i][1]];
    }

    return res;
  }
}
