package DataStructure.Queue;

/*
TC : O(n) traverse array
SC : O(n) Queue
 */

import java.util.*;

public class lc2007 {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if (n % 2 != 0) {
            return new int[0];
        }

        Deque<Integer> queue = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(changed);

        for (int c : changed) {
            if (queue.isEmpty()) {
                queue.addLast(c);
            } else {
                //不加两倍的数就相当于阳江过滤了两倍的数字，而且排序后可以保证最小的一定是undoubled的
                if (queue.peekFirst() * 2 == c) {
                    list.add(queue.pollFirst());
                } else {
                    queue.addLast(c);
                }
            }
        }

        if (!queue.isEmpty()) {
            return new int[0];
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}
