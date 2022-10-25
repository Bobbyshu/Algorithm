package DataStructure.Advanced.MonotonicQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class lc239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> maxQueue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            // 添加元素时，如果要添加的元素大于队尾处的元素，就将队尾元素弹出
            while (!maxQueue.isEmpty() && nums[i] >= nums[maxQueue.peekLast()]) {
                maxQueue.pollLast();
            }

            maxQueue.addLast(i);

            // 如果队首存储的角标就是滑动窗口左边界数值，就移除队首
            if (!maxQueue.isEmpty() && (i - k) == maxQueue.peekFirst()) {
                maxQueue.pollFirst();
            }

            // 当i增长到第一个窗口右边界时，每滑动一步都将队首角标对应元素(窗口最大值)放入结果数组
            if (i >= k - 1) {
                res[i - k + 1] = nums[maxQueue.peekFirst()];
            }

        }

        return res;
    }
}
