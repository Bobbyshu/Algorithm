package A_OnsiteClassical;

public class mergeSort {
  private static int[] temp;

  public static void func(int[] nums) {
    temp = new int[nums.length];
    sort(nums, 0, nums.length - 1);
  }

  private static void sort(int[] nums, int left, int right) {
    if (left == right) {
      return;
    }

    int mid = (left + right) / 2;
    sort(nums, left, mid);
    sort(nums, mid + 1, right);
    merge(nums, left, mid, right);
  }

  private static void merge(int[] nums, int left, int mid, int right) {
    for (int i = left; i <= right; ++i) {
      temp[i] = nums[i];
    }

    int i = left, j = mid + 1;
    for (int p = left; p <= right; ++p) {
      if (i == mid + 1) {
        nums[p] = nums[j++];
      } else if (j == right + 1) {
        nums[p] = nums[i++];
      } else if (temp[i] > temp[j]) {
        nums[p] = temp[j++];
      } else {
        nums[p] = temp[i++];
      }
    }
  }
}
