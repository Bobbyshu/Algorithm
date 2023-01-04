package Algorithm_Carl.BinarySearch.rotatedArray;
/*
三种情况
左 < 中 < 右：说明在未旋转的序列中，此时最小值一定在左边
左 > 右 > 中：说明在已旋转的序列中，此时最小值在左边
中 > 左 > 右：说明在已旋转的序列中，此时最小值在右边
所以中间的值和右边作比较即可查找最小值
 */

public class lc153 {
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return nums[l];
    }
}
