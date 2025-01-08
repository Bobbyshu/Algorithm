package Trick;

public class yxzFrameWork {
  // 取到等于target最左边的一个数，或者大于他的第一个数字
  int left_bound(int[] nums, int target) {
    int l = 0, r = nums.length - 1;
    // find left_bound
    while (l < r) {
      int mid = l + (r - l) / 2;
      // 取到大于target的第一个数字是因为一直归到结尾的话，取到的nums[mid] >= target
      // 所以可以取到大于的第一个数字
      if (nums[mid] >= target) {
        r = mid;
      } else {
        l = mid + 1;
      }
    }

    return nums[r] == target ? r : -1;
  }

  // 取到等于target最右边的一个数，或者小于他的第一个数字
  int right_bound(int[] nums, int target) {
    int l = 0, r = nums.length - 1;
    // find right_bound
    while (l < r) {
      int mid = l + (r - l + 1) / 2;
      // 取到小于target的第一个数字是因为一直归到结尾的话，取到的nums[mid] <= target
      // 所以可以取到小于的第一个数字
      if (nums[mid] <= target) {
        l = mid;
      } else {
        r = mid - 1;
      }
    }

    return nums[r] == target ? r : -1;
  }
}
