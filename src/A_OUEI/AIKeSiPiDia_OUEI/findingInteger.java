package A_OUEI.AIKeSiPiDia_OUEI;

import java.util.Arrays;
import java.util.PriorityQueue;

public class findingInteger {
    public static void main(String[] args) {
        findingInteger fi = new findingInteger();
        int[] arr = {4, 2, 1, 3};
        System.out.println(Arrays.toString(fi.findInteger(arr, 2)));
    }
    int[] findInteger(int[] arr, int k) {
        if (k == 0)
            return new int[0];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = arr.length;
        int[] res = new int[n - k + 1];
        for (int i = 0; i < n; i++) {
            if (pq.size() == k && pq.peek() > arr[i]) {
                pq.offer(arr[i]);
                pq.poll();
            } else {
                pq.offer(arr[i]);
            }

            if (i - k + 1 >= 0) {
                res[i - k + 1] = pq.peek();
            }
        }

        return res;
    }
}
