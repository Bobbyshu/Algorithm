package Leetcode;

import java.util.PriorityQueue;

public class heapApplication {
  public String reorganizeString(String s) {
    int[] arr = new int[26];
    int max = 0;
    for (char c : s.toCharArray()) {
      arr[c - 'a']++;
      max = Math.max(max, arr[c - 'a']);
    }

    if (max > (s.length() + 1) / 2) {
      return "";
    }

    PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> arr[o2] - arr[o1]);

    for (int i = 0; i < 26; ++i) {
      if (arr[i] > 0) {
        pq.offer(i);
      }
    }

    StringBuilder sb = new StringBuilder();
    while (pq.size() >= 2) {
      int i = pq.poll(), j = pq.poll();
      char c1 = (char) (i + 'a'), c2 = (char) (j + 'a');
      sb.append(c1).append(c2);
      arr[i]--;
      arr[j]--;
      if (arr[i] > 0) {
        pq.offer(i);
      }
      if (arr[j] > 0) {
        pq.offer(j);
      }
    }

    // System.out.println(sb.toString());
    if (!pq.isEmpty()) {
      sb.append((char) (pq.poll() + 'a'));
    }

    return sb.toString();
  }
}
