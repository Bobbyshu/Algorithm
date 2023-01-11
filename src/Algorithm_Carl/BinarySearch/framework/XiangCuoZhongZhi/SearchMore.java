package Algorithm_Carl.BinarySearch.framework.XiangCuoZhongZhi;

public class SearchMore {
    // because we want the >= which means that nums[c] must < target
    // so, for
    public int Search(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) >> 1;
            // search more so when equal we want right one
            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // avoid
        return left == arr.length ? -1 : left;
    }
}
