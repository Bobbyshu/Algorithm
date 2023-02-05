package Leetcode.weeklycontest.DOUBLE.NO96;

import java.util.Arrays;
import java.util.PriorityQueue;

public class t3 {
  public static void main(String[] args) {

  }

  public static long maxScore(int[] nums1, int[] nums2, int k) {
    long res, sum = 0L;
    int n = nums1.length, min = Integer.MAX_VALUE;
    int[][] arr = new int[n][2];
    for (int i = 0; i < n; ++i) {
      arr[i][0] = nums1[i];
      arr[i][1] = nums2[i];
    }
    Arrays.sort(arr, (o1, o2) -> o2[1] - o1[1]);

    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int i = 0; i < k; ++i) {
      pq.offer(arr[i][0]);
      sum += arr[i][0];
    }

    res = sum * arr[k - 1][1];

    for (int i = k; i < n; ++i) {
      int j = arr[i][0];
      pq.offer(j);
      sum += j;
      sum -= pq.poll();
      res = Math.max(res, sum * arr[i][1]);
    }

    return res;
  }
}
