package Leetcode.weeklycontest.DOUBLE.NO126;

import java.util.*;

public class t2 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 1, 2, 3, 1};
        int[][] q = {{1, 2}, {3, 3}, {4, 2}};
        unmarkedSumArray(nums, q);
    }

    // nums = [1,2,2,1,2,3,1], queries = [[1,2],[3,3],[4,2]]
    // res = [8, 3, 0]
    public static long[] unmarkedSumArray(int[] nums, int[][] queries) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
        long sum = 0L;
        for (int i = 0; i < nums.length; ++i) {
            pq.offer(new int[]{nums[i], i});
            sum += nums[i];
        }

        int m = queries.length, n = nums.length;
        boolean[] visited = new boolean[n];
        long[] res = new long[m];

        for (int i = 0; i < m; ++i) {
            int[] q = queries[i];
            int idx = q[0], remove = q[1];
            if (!visited[idx]) {
                visited[idx] = true;
                sum -= nums[idx];
            }

            while (remove > 0 && !pq.isEmpty()) {
                while (!pq.isEmpty() && visited[pq.peek()[1]]) {
                    pq.poll();
                }

                if (!pq.isEmpty()) {
                    int[] cur = pq.poll();
                    --remove;
                    sum -= cur[0];
                    visited[cur[1]] = true;
                }
            }

            res[i] = sum;
        }

        return res;
    }
}
