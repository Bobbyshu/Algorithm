package Trick;

public class yxzFrameWork {
  int left_bound(int[] nums, int target) {
    int l = 0, r = nums.length - 1;
    // find left_bound
    while (l < r) {
      int mid = l + (r - l) / 2;
      if (nums[mid] >= target) {
        r = mid;
      } else {
        l = mid + 1;
      }
    }

    return nums[r] == target ? r : -1;
  }

  int right_bound(int[] nums, int target) {
    int l = 0, r = nums.length - 1;
    // find right_bound
    while (l < r) {
      int mid = l + (r - l + 1) / 2;
      if (nums[mid] <= target) {
        l = mid;
      } else {
        r = mid - 1;
      }
    }

    return nums[r] == target ? r : -1;
  }
}
