package BinarySearch.rotatedArray;
//在153的基础上加上去重，把right向左边找即可
/*
们采用 right = right - 1 解决此问题，证明：
此操作不会使数组越界：因为迭代条件保证了 right > left >= 0；
此操作不会使最小值丢失：假设 nums[right]nums[right] 是最小值，有两种情况：
若 nums[right] 是唯一最小值：那就不可能满足判断条件 nums[mid] == nums[right]，
因为 mid < right（left != right 且 mid = (left + right) // 2 向下取整）；
若 nums[right] 不是唯一最小值，由于 mid < right 而 nums[mid] == nums[right]，
即还有最小值存在于 [left, right - 1] 区间，因此不会丢失最小值。
 */
public class lc154 {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                right--;
            }
        }
        return nums[left];
    }
}
