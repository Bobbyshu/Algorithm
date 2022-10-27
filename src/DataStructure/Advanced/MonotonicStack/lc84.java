package DataStructure.Advanced.MonotonicStack;

import java.util.ArrayDeque;
import java.util.Deque;

public class lc84 {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        if (n == 1)
            return heights[0];

        // process first
        int res = 0;
        int[] newHeight = new int[n + 2];
        newHeight[0] = 0;
        System.arraycopy(heights, 0, newHeight, 1, n);
        newHeight[n + 1] = 0;
        n += 2;
        heights = newHeight;

        Deque<Integer> stack = new ArrayDeque<>();
        stack.addLast(0);

        for (int i = 1; i < n; i++) {
            while (heights[i] < heights[stack.peekLast()]) {
                int curHeight = heights[stack.pollLast()];
                int curWidth = i - stack.peekLast() - 1;
                res = Math.max(res, curHeight * curWidth);
            }
            stack.addLast(i);
        }

        return res;
    }
}
