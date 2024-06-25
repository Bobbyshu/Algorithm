package A_OnsiteClassical.grind75;

public class searchInRotatedArray {
  public int search(int[] nums, int target) {
    int l = 0, r = nums.length - 1;
    // 基础版二分查找，要注意这里是 <= ，计算入l == r的情况
    while (l <= r) {
      int mid = l + (r - l) / 2;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] < target) {
        l = mid + 1;
      } else {
        r = mid - 1;
      }
    }

    return -1;
  }

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

  public int compareLeftBoundary(int[] nums, int target) {
    int l = 0, r = nums.length - 1;
    while (l <= r) {
      int mid = l + (r - l) / 2;
      if (nums[mid] == target) {
        return mid;
      }

      // because it will always has one side within mid in order
      // when we find that side
      // we can check whether target located in that side or not
      // and change the left/right boundary based on location
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
