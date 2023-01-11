package Algorithm_Carl.BinarySearch.framework.XiangCuoZhongZhi;

public class equalReturn {
    // 相错终止
    // when finished, r = l - 1(when no index been searched)
    // 对于 #1 行，若进入该分支，则 l 下标更新后其左侧元素「必」 小于 target。
    // 对于 #2 行，若进入该分支，则 r 下标更新后其右侧元素「必」 大于 target 。
    public int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) >> 1;
            if (arr[mid] < target) {
                left = mid + 1;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
