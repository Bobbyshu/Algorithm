package Leetcode.weeklycontest.Normal.NO371;

import java.util.Arrays;

public class t3 {

  public static int minOperations(int[] nums1, int[] nums2) {
    int n = nums1.length;
    int res = Math.min(check(nums1[n - 1], nums2[n - 1], nums1, nums2),
        1 + check(nums2[n - 1], nums1[n - 1], nums1, nums2));
    return res > n ? -1 : res;
  }

  private static int check(int last1, int last2, int[] nums1, int[] nums2) {
    int res = 0;
    for (int i = 0; i + 1 < nums1.length; ++i) {
      int x = nums1[i], y = nums2[i];
      if (x > last1 || y > last2) {
        if (y > last1 || x > last2) {
          return nums1.length + 1;
        }
        res++;
      }
    }
    return res;
  }


  public static void main(String[] args) {
    int[] arr1 = {1, 2, 7}, arr2 = {4, 5, 3};
    minOperations(arr1, arr2);
  }
}
