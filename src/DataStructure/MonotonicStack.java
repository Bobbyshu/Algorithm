package DataStructure;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class MonotonicStack {
    /*
    输入一个数组 nums，请你返回一个等长的结果数组，结果数组中对应索引存储着下一个更大元素，
    如果没有更大的元素，就存 -1
    [1, 3, 4, 2]
    []

     */
    int[] nextGreaterElement(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        // 倒着往栈里放
        for (int i = n - 1; i >= 0; i--) {
            // 判定个子高矮
            while (!stack.isEmpty() && stack.peekLast() <= nums[i]) {
                // 矮个起开，反正也被挡着了。。。
                stack.pollLast();
            }
            // nums[i] 身后的更大元素
            res[i] = stack.isEmpty() ? -1 : stack.peekLast();
            stack.addLast(nums[i]);
        }
        return res;
    }
}
