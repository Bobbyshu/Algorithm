package leetcode_week_contest.greedy;

import java.util.ArrayDeque;
import java.util.Deque;

public class lc2434 {
    public String robotWithString(String s) {
        StringBuilder sb = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();
        char[] arr = s.toCharArray();
        int[] dict = new int[26];

        for (char c : arr) {
            dict[c - 'a']++;
        }

        int min = 0;
        for (char c : arr) {
            dict[c - 'a']--;
            while (min < 25 && dict[min] == 0) {
                min++;
            }

            stack.addLast(c);

            while (!stack.isEmpty() && stack.peekLast() - 'a' <= min) {
                sb.append(stack.pollLast());
            }
        }

        return sb.toString();
    }
}
