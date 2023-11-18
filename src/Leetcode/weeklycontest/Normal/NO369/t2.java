package Leetcode.weeklycontest.Normal.NO369;

public class t2 {
  public long minSum(int[] nums1, int[] nums2) {
    long cnt1 = 0, sum1 = 0, cnt2 = 0, sum2 = 0;
    for (int n : nums1) {
      if (n == 0) {
        ++cnt1;
      }
      sum1 += n;
    }

    for (int n : nums2) {
      if (n == 0) {
        ++cnt2;
      }
      sum2 += n;
    }

//    if (cnt1 == cnt2 && cnt1 == 0) {
//      return sum1 == sum2 ? sum1 : -1;
//    }


    if (cnt1 == 0) {
      if (sum1 < cnt2 + sum2) {
        return -1;
      }
    }
    if (cnt2 == 0) {
      if (sum2 < cnt1 + sum1) {
        return -1;
      }
    }

    return Math.max((long) cnt1 + (long) sum1, (long) cnt2 + (long) sum2);
  }


}
