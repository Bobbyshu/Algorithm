package AIKeSiPiDia_OUEI;

import java.util.PriorityQueue;

public class BankTransaction {
    public static void main(String[] args) {
        BankTransaction bt = new BankTransaction();
        int[] arr = {3, 2, -5, -6, -5, 4};
        System.out.println(bt.bankTransaction(arr));
    }

    int bankTransaction(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int sum = 0;
        int res = 0;

        for (int n : arr) {
            sum += n;
            res++;
            if (n < 0) {
                pq.offer(n);
            }

            while (sum <= 0 && !pq.isEmpty()) {
                int temp = pq.poll();
                res--;
                sum -= temp;
            }
        }

        return res;
    }
}
