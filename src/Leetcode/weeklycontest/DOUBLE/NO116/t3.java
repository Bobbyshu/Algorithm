package Leetcode.weeklycontest.DOUBLE.NO116;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// 1 1 2 3 4 5
// 7

public class t3 {
  public static void main(String[] args) {
//    int[] arr = {1,1,2,3,4,5};
    List<Integer> lst = Arrays.asList(1, 2, 3, 4, 5);
    int val = lengthOfLongestSubsequence(lst, 9);
    System.out.println(val);
  }

  public static int lengthOfLongestSubsequence(List<Integer> nums, int target) {
    int[] dp = new int[target + 1];
    Arrays.fill(dp, Integer.MIN_VALUE);

    dp[0] = 0;
    for (int cur : nums) {
      for (int j = target; j >= cur; --j) {
        dp[j] = Math.max(dp[j], dp[j - cur] + 1);
      }
    }

    return Math.max(-1, dp[target]);
  }
}
