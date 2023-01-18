package GuCheng.Fundmental.Algo.F_TwoPointer.SlidingWindow.DiffDirection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum15 {
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(nums);
    int n = nums.length;

    for (int i = 0; i < n - 2; i++) {
      if (nums[i] > 0 || nums[i] + nums[n - 1] + nums[n - 2] < 0)
        break;

      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }

      int l = i + 1, r = n - 1;
      while (l < r) {
        int sum = nums[i] + nums[l] + nums[r];
        if (sum > 0) {
          r--;
        } else if (sum < 0) {
          l++;
        } else {
          res.add(Arrays.asList(nums[i], nums[l], nums[r]));
          while (l < r && nums[l + 1] == nums[l]) {
            l++;
          }

          while (l < r && nums[r - 1] == nums[r]) {
            r--;
          }

          l++;
          r--;
        }
      }
    }
    return res;
  }
}
