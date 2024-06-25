package A_OnsiteClassical.grind75;

public class searchInRotatedArray {
  // 4 5 6 7 8 9 10 11 12 13 14 0 1 2
  //
  public int compareFirstElement(int[] nums, int target) {
    int l = 0, r = nums.length - 1;
    while (l < r) {
      int mid = l + (r - l) / 2;
      if (nums[mid] == target) {
        return mid;
      }

      // if target & nums[mid] located in same side with nums[0]
      // we can take it otherwise we should change it
      // so we can change the rightside
      // started from mid to INF
      if (target >= nums[0]) {
        // nums[mid] located in another smaller side
        if (nums[mid] < nums[0]) {
          nums[mid] = Integer.MAX_VALUE;
        }
      } else {
        // nums[mid] located in another bigger side
        if (nums[mid] >= nums[0]) {
          nums[mid] = Integer.MIN_VALUE;
        }
      }

      if (nums[mid] < target) {
        l = mid + 1;
      } else {
        r = mid - 1;
      }
    }

    return nums[l] == target ? l : -1;
  }
}
