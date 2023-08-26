package Leetcode.weeklycontest.Normal.NO342;

import java.util.Collections;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class t3 {

  public int[] getSubarrayBeauty(int[] nums, int k, int x) {
    int n = nums.length;
    int[] res = new int[n - k + 1];
    TreeMap<Integer, Integer> pq = new TreeMap<>();

    for (int i = 0; i < n; i++) {
      int num = nums[i];

      pq.put(num, pq.getOrDefault(num, 0) + 1);

      if (i >= k) {
        int arr = nums[i - k];
        pq.put(arr, pq.get(arr) - 1);
        if (pq.get(arr) == 0) {
          pq.remove(arr);
        }
      }

      if (i >= k - 1) {
        int cnt = 0;
        int val = 0;

        for (Map.Entry<Integer, Integer> entry : pq.entrySet()) {
          cnt += entry.getValue();
          if (cnt >= x) {
            val = entry.getKey();
            break;
          }
        }

        res[i - k + 1] = Math.min(val, 0);
      }
    }

    return res;
  }

}
