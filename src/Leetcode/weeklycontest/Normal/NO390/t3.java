package Leetcode.weeklycontest.Normal.NO390;

import java.util.*;

public class t3 {
  public long[] mostFrequentIDs(int[] nums, int[] freq) {
    // map shows freq of nums[i]
    Map<Integer, Long> cnt = new HashMap<>();
    // TreeMap shows freq times
    TreeMap<Long, Integer> m = new TreeMap<>();
    int n = nums.length;
    long[] res = new long[n];

    for (int i = 0; i < n; i++) {
      int x = nums[i];

      // remove cur number's frequency
      // --m[cnt[x]] == 0
      if (cnt.containsKey(x) && m.containsKey(cnt.get(x))) {
        int adjust = m.merge(cnt.get(x), -1, Integer::sum);
        if (adjust == 0) {
          m.remove(cnt.get(x));
        }
      }

      // cnt[x] += freq[i]
      long c = cnt.merge(x, (long) freq[i], Long::sum);

      // ++m[cnt[x]]
      m.merge(c, 1, Integer::sum);
      res[i] = m.lastKey();
    }

    return res;
  }

  // lazy load
//  public long[] lazyLoad(int[] nums, int[] freq) {
//    int n = nums.length;
//    long[] ans = new long[n];
//    Map<Integer, Long> cnt = new HashMap<>();
//    PriorityQueue<Pair<Long, Integer>> pq = new PriorityQueue<>((a, b) -> Long.compare(b.getKey(), a.getKey()));
//    for (int i = 0; i < n; i++) {
//      int x = nums[i];
//      long c = cnt.merge(x, (long) freq[i], Long::sum);
//      pq.add(new Pair<>(c, x));
//      while (!pq.peek().getKey().equals(cnt.get(pq.peek().getValue()))) { // 堆顶保存的数据已经发生变化
//        pq.poll(); // 删除
//      }
//      ans[i] = pq.peek().getKey();
//    }
//    return ans;
//  }
}
