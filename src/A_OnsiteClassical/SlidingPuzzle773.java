package A_OnsiteClassical;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class SlidingPuzzle773 {
  int[][] directions = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
  public int slidingPuzzle(int[][] board) {
    int m = 2, n = 3;
    StringBuilder sb = new StringBuilder();
    String target = "123450";

    for (int[] b : board) {
      for (int c : b) {
        sb.append(c);
      }
    }

    String init = sb.toString();
    Deque<String> q = new ArrayDeque<>();
    Set<String> visited = new HashSet<>();
    q.add(init);
    int res = 0;
    visited.add(init);
    while (!q.isEmpty()) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        String cur = q.pollFirst();
        if (cur.equals(target)) {
          return res;
        }
        int zeroPos = cur.indexOf('0');

        for (int adj : directions[zeroPos]) {
          String newStr = swap(cur, zeroPos, adj);
          if (!visited.contains(newStr)) {
            q.add(newStr);
            visited.add(newStr);
          }
        }
      }
      res++;

    }

    return -1;
  }

  String swap(String str, int i, int j) {
    char[] arr = str.toCharArray();
    char temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
    return new String(arr);
  }
}
