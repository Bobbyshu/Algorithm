package GuCheng.Fundmental.Algo.D_MonotonicStack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class NextGreaterElement496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
      Map<Integer, Integer> map = new HashMap<>();
      int[] helper = getArray(nums2);
      for (int i = 0; i < nums2.length; ++i) {
        map.put(nums2[i], helper[i]);
      }

      int[] res = new int[nums1.length];
      for (int i = 0; i < nums1.length; ++i) {
        res[i] = map.get(nums1[i]);
      }

      return res;
    }

    int[] getArray(int[] arr) {
      int[] res = new int[arr.length];
      Deque<Integer> stack = new ArrayDeque<>();
      for (int i = arr.length - 1; i >= 0; --i) {
        while (!stack.isEmpty() && arr[i] > stack.peekLast()) {
          stack.pollLast();
        }
        res[i] = stack.isEmpty() ? -1 : stack.peekLast();
        stack.addLast(arr[i]);
      }
      return res;
    }
}
