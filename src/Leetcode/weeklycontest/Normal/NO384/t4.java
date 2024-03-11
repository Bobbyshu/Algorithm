package Leetcode.weeklycontest.Normal.NO384;

public class t4 {
  public int countMatchingSubarrays(int[] nums, int[] pattern) {
    int n = nums.length, m = pattern.length;

    int[] arr = new int[n - 1];
    for (int i = 1; i < n; ++i) {
      if (nums[i] > nums[i - 1]) {
        arr[i - 1] = 1;
      } else if (nums[i] < nums[i - 1]) {
        arr[i - 1] = -1;
      }
    }

    int[] next = new int[m];
    kmp(next, pattern);

    int j = 0, res = 0;
    for (int i = 0; i < arr.length; ++i) {
      while (j > 0 && pattern[j] != arr[i]) {
        j = next[j - 1];
      }

      if (pattern[j] == arr[i]) {
        ++j;
      }

      if (j == m) {
        ++res;
        j = next[j - 1];
      }
    }

    return res;
  }

  private void kmp(int[] next, int[] pattern) {
    int j = 0;
    next[0] = 0;
    for (int i = 1; i < pattern.length; ++i) {
      while (j > 0 && pattern[i] != pattern[j]) {
        j = next[j - 1];
      }
      if (pattern[i] == pattern[j]) {
        ++j;
        next[i] = j;
      }
    }
  }
}
