package Algorithm_Carl.BinarySearch.framework.XiangCuoZhongZhi;

public class SearchMoreEqual {
    // because we want the >= which means that nums[c] must < target
    // so, for
    // 对于 #1 行，若进入该分支，则 l 下标更新后其左侧元素「必」 小于 target。
    // 对于 #2 行，若进入该分支，则 r 下标更新后其右侧元素「必」 大于等于 target 。
    public int Search(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) >> 1;
            if (arr[mid] < target) {
                left = mid - 1;
            } else {
                right = mid - 1;
            }
        }
        // avoid
        return left == arr.length ? -1 : left;
    }
}
