package DataStructure.Tree.heap;

import java.util.*;
import java.util.PriorityQueue;

public class lc2462 {
    public static void main(String[] args) {
        int[] res = {2,2,2,2,2,2,1,4,5,5,5,5,5,2,2,2,2,2,2,2,2,2,2,2,2,2};
        int k = 7, c = 3;
        totalCost(res, k, c);
    }

    public static long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> left = new PriorityQueue<>();
        PriorityQueue<Integer> right = new PriorityQueue<>();
        int n = costs.length;
        long res = 0L;

        if (n > 2 * candidates) {
            for (int i = 0; i < candidates; i++) {
                left.add(costs[i]);
            }

            for(int i = n - 1; i >= n - candidates; i--){
                right.add(costs[i]);
            }

            int l = candidates, r = n - candidates - 1;

            for (int i = 0; i < k; i++) {
                int a = Integer.MAX_VALUE;
                int b = a;

                if (!left.isEmpty()) {
                    a = left.peek();
                }

                if (!right.isEmpty()) {
                    b = right.peek();
                }

                if (a <= b) {
                    res += a;
                    left.poll();
                    if (l <= r) {
                        left.add(costs[l]);
                        l++;
                    }
                } else {
                    res+=b;
                    right.poll();
                    if(l <= r){
                        right.add(costs[r]);
                        r--;
                    }
                }
            }
        } else {
            Arrays.sort(costs);
            for (int i = 0; i < k; i++) {
                res += costs[i];
            }
        }

        return res;
    }

//    public static long totalCost(int[] costs, int k, int candidates) {
//        long res = 0L;
//        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] o1, int[] o2) -> o1[0] - o2[0]);
//        int n = costs.length;
//        int l = candidates, r = n - candidates - 1;
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < n; i++) {
//            map.put(i, costs[i]);
//        }
//
//        for (int i = 0; i < candidates; i++) {
//            pq.offer(new int[]{costs[i], i});
//        }
//
//        for (int i = n - candidates; i < n; i++) {
//            pq.offer(new int[]{costs[i], i});
//        }
//
//        while (k > 0 && l < r) {
//            int[] temp = pq.poll();
//            res += temp[0];
//            k--;
//            map.remove(temp[1]);
//
//            if (temp[1] < l) {
//                pq.offer(new int[]{costs[l], l});
//                l++;
//            } else {
//                pq.offer(new int[]{costs[r], r});
//                r--;
//            }
//        }
//
//        PriorityQueue<Integer> heap = new PriorityQueue<>();
//        if (k > 0) {
//            for (int value : map.values()) {
//                heap.offer(value);
//            }
//
//            while (k > 0 && !heap.isEmpty()) {
//                res += heap.poll();
//                k--;
//            }
//        }
//
//        return res;
//    }
}
