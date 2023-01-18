package GuCheng.Fundmental.Algo.F_TwoPointer.SlidingWindow.DiffDirection;

public class TwoSumII167 {
  public int[] twoSum(int[] num, int target) {
    int i = 0, j = num.length - 1;
    while (i < j) {
      int sum = num[i] + num[j];
      if (sum > target) {
        --j;
      } else if (sum < target) {
        ++i;
      } else {
        return new int[]{i + 1, j + 1};
      }
    }
    return new int[0];
  }
}
