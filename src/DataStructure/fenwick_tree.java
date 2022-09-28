package DataStructure;
import java.util.PriorityQueue;

public class fenwick_tree {

}

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        //大根堆
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> squareSum(p1) - squareSum(p2));

        for (int[] point : points) {
            if (pq.size() < k) {
                pq.offer(point);
            } else if (squareSum(pq.peek()) > squareSum(point)) {
                pq.poll();
                pq.offer(point);
            }
        }

        int[][] res = new int[k][2];
        int i = 0;
        while (!pq.isEmpty()) {
            res[i++] = pq.poll();
        }

        return res;
    }

    int squareSum (int[] arr) {
        return arr[0] * arr[0] + arr[1] * arr[1];
    }
}

