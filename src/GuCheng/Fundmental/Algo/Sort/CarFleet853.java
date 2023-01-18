package GuCheng.Fundmental.Algo.Sort;

import java.util.PriorityQueue;

public class CarFleet853 {
  public int carFleet(int target, int[] position, int[] speed) {
    int n = position.length;
    if (n == 1) {
      return 1;
    }

    PriorityQueue<double[]> pq = new PriorityQueue<>((o1, o2) -> (int) (o2[0] - o1[0]));
    for (int i = 0; i < n; ++i) {
      pq.offer(new double[]{(double) position[i], (double) ((target - position[i])) / speed[i]});
    }

    int res = 0;
    while (!pq.isEmpty()) {
      double[] temp = pq.poll();
      while (!pq.isEmpty() && pq.peek()[1] <= temp[1]) {
        pq.poll();
      }
      ++res;
    }

    return res;
  }
}
