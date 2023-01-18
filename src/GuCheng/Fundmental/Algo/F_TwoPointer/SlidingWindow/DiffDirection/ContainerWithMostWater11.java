package GuCheng.Fundmental.Algo.F_TwoPointer.SlidingWindow.DiffDirection;

public class ContainerWithMostWater11 {
  public int maxArea(int[] height) {
    int left = 0, right = height.length - 1;
    if (right == 0) {
      return 0;
    }

    int res = 0;
    while (left < right) {
      int width = right - left;
      int min = Math.min(height[left], height[right]);
      res = Math.max(res, width * min);
      if (min == height[left]) {
        left++;
      } else {
        right--;
      }
    }

    return res;
  }
}
