package A_OnsiteClassical.Tiktok;

public class SubarraySumsDivisibleK974 {
  public int subarraysDivByK(int[] nums, int k) {
    int n = nums.length;
    int[] prefix = new int[n + 1];
    for (int i = 1; i <= n; ++i) {
      prefix[i] = prefix[i - 1] + nums[i - 1];
    }

    // 0 4 9 9 7 4 5
    int[] mod = new int[k];
    for (int p : prefix) {
      mod[(p % k + k) % k]++;
    }

    int res = 0;
    for (int m : mod) {
      res += m * (m - 1) / 2;
    }

    return res;
  }
}
