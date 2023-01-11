package Algorithm_Carl.BinarySearch.framework.XiangCuoZhongZhi;

public class SearchLess {
    public int Search(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        // l == r - 1

        while (left <= right) {
            int mid = left + (right - left) >> 1;
            // 1. all element less than target -> right unchanged -> return right
            // 2. exists element less than or equal to target -> left side of left must <= target(right)
            // 3. all elements more than target -> must return -1, while l unchanged, so return right
            if (arr[mid] < target) {    //#1 更新后l左侧元素「必」小于target
                left = mid + 1;
            } else {    //#2 更新后r右侧「必」大于等于target
                right = mid - 1;
            }
        }

        return right;
    }
}
