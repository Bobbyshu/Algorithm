package Algo5800.Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class problem3 {
  public static void main(String[] args) {
    int[][] arr2 = {{1, 4}, {3, 5}, {2, 6}, {7, 9}, {8, 11}};
    System.out.println(coloringIntervals(arr2));
  }
  public static int coloringIntervals(int[][] x) {
    Arrays.sort(x, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);

    PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 - o2);
    pq.offer(x[0][1]);

    for (int i = 1; i < x.length; i++) {
      int[] currInterval = x[i];
      boolean foundPrevColor = false;

      if (currInterval[0] >= pq.peek()) {
        pq.poll();
        pq.offer(currInterval[1]);
        foundPrevColor = true;
      }

      if (!foundPrevColor) {
        pq.offer(currInterval[1]);
      }
    }

    return pq.size();
  }
}
