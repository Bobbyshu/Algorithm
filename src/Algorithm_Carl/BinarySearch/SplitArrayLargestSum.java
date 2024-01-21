package Algorithm_Carl.BinarySearch;

public class SplitArrayLargestSum {
  public int splitArray(int[] nums, int k) {
    int l = 0, r = (int)1e9;

    while (l < r) {
      int mid = (l + r) / 2;
      if (check(nums, mid) <= k) {
        r = mid;
      } else {
        l = mid + 1;
      }
    }
    // System.out.println(check(nums, 10));
    return l;
  }

  private int check(int[] nums, int mid) {
    int cnt = 0, sum = 0;
    for (int i = 0; i < nums.length; ++i) {
      // decrease group -> enlarge mid
      if (nums[i] > mid) {
        return (int) 1e9;
      }

      if (sum + nums[i] > mid) {
        ++cnt;
        sum = 0;
      }

      sum += nums[i];
    }

    return cnt + 1;
  }
}
