package A_OnsiteClassical.Tiktok;

public class SearchRotatedSortedArray {

  public int search(int[] nums, int target) {
    int l = 0, r = nums.length - 1;
    while (l <= r) {
      int mid = l + (r - l) / 2;
      if (nums[mid] == target) {
        return mid;
      }

      // in left side
      if (nums[mid] >= nums[l]) {
        // target located between nums[l] and nums[mid]
        if (target >= nums[l] && target < nums[mid]) {
          r = mid - 1;
        } else { // otherwise it should located at rightside of nums[mid]
          l = mid + 1;
        }
      } else { // nums[mid] < nums[l]
        // located at right side
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
