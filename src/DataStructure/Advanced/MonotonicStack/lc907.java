package DataStructure.Advanced.MonotonicStack;

import java.util.ArrayDeque;
import java.util.Deque;

public class lc907 {
    public int sumSubarrayMins(int[] arr) {
        int mod = 1000000007;
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            // 向左找第一个小于等于E的元素
            while (!stack.isEmpty() && arr[stack.peekLast()] > arr[i]) {
                stack.pollLast();
            }

            left[i] = stack.isEmpty() ? -1 : stack.peekLast();

            stack.add(i);
        }

        stack.clear();

        for (int i = n - 1; i >= 0; i--) {
            // 向右找第一个小于E的元素
            while (!stack.isEmpty() && arr[stack.peekLast()] >= arr[i]) {
                stack.pollLast();
            }

            right[i] = stack.isEmpty() ? n : stack.peekLast();

            stack.add(i);
        }

        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum = (sum + (long) (i - left[i]) * (right[i] - i) * arr[i]) % mod;
        }

        return (int) sum;
    }
}
