package Leetcode.weeklycontest.NO327;

import java.util.PriorityQueue;

public class t2 {
    public static void main(String[] args) {
        int[] arr = {881784984,829998714,730002802,56524562,120336848,548306998,801116106,828640251,519131180,819176153,476262254,15904939,540793851,53572296,259044378,491129827,561147559,205793082,967833729};
        maxKelements(arr, 16);

    }
    /*
    [881784984,829998714,730002802,56524562,120336848,548306998,801116106,828640251,519131180,819176153,476262254,15904939,540793851,53572296,259044378,491129827,561147559,205793082,967833729]
16
9770761772
9888530217
     */

    public static long maxKelements(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>((o1, o2) -> (int) (o2 - o1));
        for (int n : nums) {
            pq.offer((long) n);
        }

        long res = 0L;
        while (k > 0) {
            long temp = pq.poll();
            res += temp;
            pq.offer(ceil(temp));
            --k;
        }
        return res;
    }
    static long ceil(long n) {
        if (n % 3 == 0) {
            return n / 3;
        } else {
            return n / 3 + 1;
        }
    }
}
