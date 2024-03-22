package Leetcode.weeklycontest.DOUBLE.NO124;

import java.util.PriorityQueue;

public class t2 {
    public static void main(String[] args) {
        int[] nums =  {1000000000,999999999,1000000000,999999999,1000000000,999999999};

    }
    public static int minOperations(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int n : nums) {
            pq.offer(n);
        }

        int res = 0;
        while (pq.size() >= 2) {
            if (pq.peek() >= k) {
                return res;
            }
            int min = pq.poll(), secondLast = pq.poll();
            int cur = min * 2 + secondLast;
            pq.offer(cur);
            ++res;
        }

        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
        return res;
    }
}
