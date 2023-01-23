package Algorithm_Carl.Greedy;

import java.util.PriorityQueue;

public class DistantBarcodes1054 {
  public int[] rearrangeBarcodes(int[] barcodes) {
    if (barcodes.length == 1) {
      return new int[]{1};
    }
    int[] cnt = new int[10001];
    for (int n : barcodes) {
      // System.out.println(n);
      ++cnt[n];
    }

    PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);

    for (int i = 0; i < cnt.length; ++i) {
      if (cnt[i] > 0) {
        // System.out.println(i);
        // System.out.println(cnt[i]);
        pq.offer(new int[]{i, cnt[i]});
      }
    }

    int[] res = new int[barcodes.length];
    int i = 0;
    while (!pq.isEmpty()) {
      int[] most = pq.poll();
      if (pq.isEmpty()) {
        res[i] = most[0];
        return res;
      }
      int[] secondMost = pq.poll();
      res[i++] = most[0];
      res[i++] = secondMost[0];
      --most[1];
      --secondMost[1];
      if (most[1] != 0) {
        pq.offer(most);
      }

      if (secondMost[1] != 0) {
        pq.offer(secondMost);
      }
    }

    return res;
  }
}
