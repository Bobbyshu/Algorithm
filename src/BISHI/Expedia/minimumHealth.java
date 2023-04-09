package BISHI.Expedia;

import java.util.PriorityQueue;

public class minimumHealth {
    int getMinimumHealth(int[] arr1, int[] arr2, int rank) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int res = 0;

        for (int n : arr1) {
            pq.offer(n);
            if (pq.size() >= rank) {
                int temp = pq.poll();
                res += temp;
            }
        }

        for (int n : arr2) {
            pq.offer(n);
            if (pq.size() >= rank) {
                int temp = pq.poll();
                res += temp;
            }
        }

        return res;
    }
}
