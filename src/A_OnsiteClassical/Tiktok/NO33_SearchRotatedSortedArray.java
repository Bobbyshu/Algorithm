package A_OnsiteClassical.Tiktok;

public class NO33_SearchRotatedSortedArray {
  public int search2(int[] nums, int target) {
    int l = 0, r = nums.length - 1;
    while (l < r) {
      int mid = l + (r - l) / 2;
      if (nums[mid] == target) {
        return mid;
      }

      // in left side
      if (nums[mid] >= nums[l]) {
        // target located between nums[l] and nums[mid]
        if (target >= nums[l] && target < nums[mid]) {
          r = mid;
        } else { // otherwise it should located at rightside of nums[mid]
          l = mid + 1;
        }
      } else { // nums[mid] < nums[l]
        // located at right side
        if (target > nums[mid] && target < nums[l]) {
          l = mid + 1;
        } else {
          r = mid;
        }
      }
    }

    return nums[r] == target ? r : -1;
  }

  public int search(int[] nums, int target) {
    int l = 0, r = nums.length - 1;
    while (l <= r) {
      int mid = l + (r - l) / 2;
      if (nums[mid] == target) {
        return mid;
      }

      // in rotated left side
      // 这里要取 >= 因为mid = (l + r) / 2
      // 是地板除，mid一定要在左边处理
      if (nums[mid] >= nums[l]) {
        // target located between nums[l] and nums[mid]
        if (target >= nums[l] && target < nums[mid]) {
          r = mid - 1;
        } else { // otherwise it should located at rightside of nums[mid]
          l = mid + 1;
        }
      } else { // nums[mid] < nums[l]
        // located at rotated right side
        if (target > nums[mid] && target < nums[l]) {
          l = mid + 1;
        } else {
          r = mid - 1;
        }
      }
    }

    return -1;
  }
}
