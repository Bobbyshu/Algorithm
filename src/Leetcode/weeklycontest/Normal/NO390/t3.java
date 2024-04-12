package Leetcode.weeklycontest.Normal.NO390;

import java.util.*;

public class t3 {
  public long[] mostFrequentIDs(int[] nums, int[] freq) {
    // map shows freq of nums[i]
    Map<Integer, Long> map = new HashMap<>();
    // TreeMap shows freq times
    TreeMap<Long, Integer> cnt = new TreeMap<>();
    int n = nums.length;
    long[] res = new long[n];

    for (int i = 0; i < n; i++) {
      int cur = nums[i];

      // remove cur number's frequency
      // --cnt[cnt[x]] == 0
      if (map.containsKey(cur) && cnt.containsKey(map.get(cur))) {
        cnt.merge(map.get(cur), -1, Integer::sum);
        int after = cnt.get(map.get(cur));
        if (after == 0) {
          cnt.remove(map.get(cur));
        }
      }

      // cnt[x] += freq[i]
      long c = map.merge(cur, (long) freq[i], Long::sum);

      // ++cnt[cnt[x]]
      cnt.merge(c, 1, Integer::sum);
      res[i] = cnt.lastKey();
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
