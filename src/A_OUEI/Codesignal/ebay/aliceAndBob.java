package A_OUEI.Codesignal.ebay;

import java.util.ArrayDeque;
import java.util.Deque;

public class aliceAndBob {
    public static void main(String[] args) {
        int[] arr = {1, 4, 5, 5, 6};
        int[] arr1 = {1, 3, 3, 1, 5};
        int[] arr2 = {1, 2, 2, 3, 3, 1, 1};
        System.out.println(solution(arr));
        System.out.println(solution(arr1));
        System.out.println(solution(arr2));
    }

    static String solution(int[] arr) {
        int time = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int num : arr) {
            if (!stack.isEmpty() && stack.peekLast() == num) {
                stack.pollLast();
                time++;
            } else {
                stack.addLast(num);
            }
        }

        return time % 2 != 0 ? "Alice" : "Bob";
    }
}
