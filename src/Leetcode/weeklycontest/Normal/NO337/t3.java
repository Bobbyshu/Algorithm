package Leetcode.weeklycontest.Normal.NO337;

import java.util.HashSet;
import java.util.Set;

public class t3 {
  int[] nums;
  Set<Integer> set;
  int k, ans = 0;

  // 优化可以用数组实现
  public int beautifulSubsets(int[] nums, int k) {
    this.nums = nums;
    set = new HashSet<>();
    this.k = k;
    dfs(0);
    // 去掉为空的那个
    return ans - 1;
  }

  // 从 i 开始选
  private void dfs(int i) {
    ++ans; // 合法子集
    if (i == nums.length) {
      return;
    }

    for (int j = i; j < nums.length; ++j) { // 枚举选哪个
      // 当前选取
      int cur = nums[j];
      if (!set.contains(cur + k) && !set.contains(cur - k)) {
        set.add(cur);
        dfs(j + 1);
        set.remove(cur);
      }
    }
  }
}
