package Leetcode.weeklycontest.NO328;

import java.util.HashMap;
import java.util.Map;

public class t3 {
  public static void main(String[] args) {
    int[] arr = {3,1,4,3,2,2,4};
//    int[] arr2 = {1,1,1,1,1};
    countGood(arr, 2);
//    System.out.println(countGood(arr, 2));
  }

  public static long countGood(int[] nums, int k) {
    int n = nums.length;
    Map<Integer, Integer> map = new HashMap<>();
    long sum = 0, res = 0;

    int i = 0;
    for (int j = 0; j < n; ++j) {
      // update count number of nums[j]
      map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
      // if n == 4 => 3+2+1 => sum += n - 1
      sum += map.get(nums[j]) - 1;
      while (sum >= k) {
        // when we step into this loop
        // the rest of j is valid
        // 3 2 ok => 3 2 X X X X is ok
        res += n - j;
        // n(n - 1)/ 2 - (n - 1) * (n - 2) / 2
        // = 2 * (n - 1) / 2
        // = (n - 1)
        sum -= map.get(nums[i]) - 1;
        // update nums[i]
        map.put(nums[i], map.get(nums[i]) - 1);
        ++i;
      }
    }
    return res;
  }
}
