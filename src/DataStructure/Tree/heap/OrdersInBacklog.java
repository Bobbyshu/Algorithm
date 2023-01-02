package DataStructure.Tree.heap;

import java.util.PriorityQueue;

public class OrdersInBacklog {
    public static void main(String[] args) {
        int[][] o = {{27,30,0},{10,10,1},{28,17,1},{19,28,0},{16,8,1},{14,22,0},{12,18,1},{3,15,0},{25,6,1}};
        System.out.println(getNumberOfBacklogOrders(o));
//        getNumberOfBacklogOrders(o);
    }
    public static int getNumberOfBacklogOrders(int[][] orders) {
        int mod = (int) 1e9 + 7;
        // heap<[price, amount]>
        //maxHeap for buying stock because we want to get the highest price order
        PriorityQueue<int[]> buy = new PriorityQueue<>(
                (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o2[0] - o1[0]);
        //minHeap for selling stock because we want to get the lowest price order
        PriorityQueue<int[]> sell = new PriorityQueue<>(
                (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);

        for (int[] arr : orders) {
            //buy something to check sell heap
            int price = arr[0], amount = arr[1];
            if (arr[2] == 0) {
                //no stock or can poll stock from sell
                if (sell.isEmpty() || price < sell.peek()[0]) {
                    buy.offer(new int[]{price, amount});
                    continue;
                }

                // can pop order from sell
                // can buy all the order in sell stock
                if (amount < sell.peek()[1]) {
                    int[] cur = sell.poll();
                    cur[1] -= amount;
                    amount = 0;
                    //totally finish
                    sell.offer(cur);
                } else {    // cant purchase all sell stock at peek
                    while (!sell.isEmpty() && price >= sell.peek()[0] && amount > 0) {
                        if (amount >= sell.peek()[1]) {
                            amount -= sell.poll()[1];
                        } else {    // can finish
                            int[] cur = sell.poll();
                            cur[1] -= amount;
                            sell.offer(cur);
                            amount = 0;
                        }
                    }
                }

                if (amount > 0) {
                    buy.offer(new int[]{price, amount});
                }

            } else { // sell order
                // no stock to sell or nothing qualify
                if (buy.isEmpty() || price > buy.peek()[0]) {
                    sell.offer(new int[]{price, amount});
                    continue;
                }
                // can sell all stock
                if (amount < buy.peek()[1]) {
                    int[] cur = buy.poll();
                    cur[1] -= amount;
                    amount = 0;
                    //totally finish
                    buy.offer(cur);
                } else {    // cant purchase all sell stock at peek
                    while (!buy.isEmpty() && price <= buy.peek()[0] && amount > 0) {
                        if (amount >= buy.peek()[1]) {
                            amount -= buy.poll()[1];
                        } else {
                            int[] cur = buy.poll();
                            cur[1] -= amount;
                            buy.offer(cur);
                            amount = 0;
                        }
                    }
                }

                if (amount > 0) {
                    sell.offer(new int[]{price, amount});
                }
            }
        }

        long res = 0L;
        while (!buy.isEmpty()) {
            res = (res + buy.poll()[1]) % mod;
        }
        while (!sell.isEmpty()) {
            res = (res + sell.poll()[1]) % mod;
        }

        return (int) res;
    }
}
