package Leetcode.weeklycontest.Normal.NO338;

public class t2 {
  public boolean primeSubOperation(int[] nums) {
    if (nums[0] != 2) {
      nums[0] = nums[0] - prime(nums[0]);
    }
    // System.out.print(nums[0] + " ");
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] - prime(nums[i]) > nums[i-1]) {
        nums[i] = nums[i] - prime(nums[i]);
      } else if (nums[i] > nums[i-1]) {
        int diff = nums[i] - nums[i-1];
        if (diff > 2) {
          nums[i] = nums[i] - prime(diff);
        }
      } else {
        return false;
      }
      // System.out.print(nums[i] + " ");
    }
    return true;
  }

  public int prime(int n) {
    if ((n & 1) == 1) {
      n -= 2;
    } else {
      n--;
    }

    int i, j;
    for (i = n; i >= 2; i -= 2) {
      if (i % 2 == 0) {
        continue;
      }
      for (j = 3; j <= Math.sqrt(i); j += 2) {
        if (i % j == 0) {
          break;
        }
      }
      if (j > Math.sqrt(i)) {
        return i;
      }
    }
    return 2;
  }
}
