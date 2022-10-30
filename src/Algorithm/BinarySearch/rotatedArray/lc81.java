package Algorithm.BinarySearch.rotatedArray;
//相比33多了个去重的操作，其他都是一样的
public class lc81 {
    public boolean search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1, mid = 0;
        while (lo <= hi) {
            mid = lo + ((hi - lo) / 2);
            if (nums[mid] == target) {
                return true;
            }

            if (nums[lo] == nums[mid]) {
                lo++;
                continue;
            }

            if(nums[mid] >= nums[lo]){
                if (nums[mid] > target && nums[lo] <= target) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else if (nums[mid] < nums[lo]){
                if(nums[mid] < target && nums[hi] >= target){
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return false;
    }
}
