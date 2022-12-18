package Algorithm.SlidingWindow;

import java.util.ArrayList;
import java.util.List;

public class MinimumAdjacentSwaps {
    public int minMoves(int[] nums, int k) {
        List<Integer> zeros = new ArrayList<>();
        int cntZero = 0, cntOne = 0;
        for (int num : nums) {
            if (num != 1) {
                ++cntZero;
            } else {
                if (cntOne != 0) {
                    zeros.add(cntZero);
                }
                ++cntOne;
                cntZero = 0;
            }
        }

        int[] preSum = new int[zeros.size() + 1];
        for (int i = 0; i < zeros.size(); ++i) {
            preSum[i + 1] = preSum[i] + zeros.get(i);
        }
        int cost = 0;
        int left = 0, right = k - 2;

        for (int i = left; i <= right; ++i) {
            cost += zeros.get(i) * Math.min(i + 1, right - i + 1);
        }
        //sliding
        int minCost = cost;
        for (int i = 1, j = i + k - 2; j < zeros.size(); ++i, ++j) {
            int mid = (i + j) / 2;
            cost -= preSum[mid] - preSum[i - 1];
            cost += preSum[j + 1] - preSum[mid + k % 2];
            minCost = Math.min(minCost, cost);
        }

        return minCost;
    }
}
