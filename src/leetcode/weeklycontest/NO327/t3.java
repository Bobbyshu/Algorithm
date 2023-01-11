package leetcode.weeklycontest.NO327;

import Algorithm_Carl.Backtrace.subsets.IncreasingSubsequences;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class t3 {
    public static void main(String[] args) {
        String s1 = "abcc";
        String s2 = "aab";
        isItPossible("ab", "abcc");
        System.out.println(isItPossible("abcde", "fghij"));
    }

    public static boolean isItPossible(String word1, String word2) {
        Map<Character, Integer> map1 = new HashMap<>(), map2 = new HashMap<>();
        // O(m) and O(n) and O(1) -> TC = O(Math.max(word1.length(), word2.length())
        for (char c : word1.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }

        for (char c : word2.toCharArray()) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }

        int size1, size2, num1, num2;
        char c, d;
        //O(26 * 26) = O(1)
        for (Map.Entry<Character, Integer> i : map1.entrySet()) {
            c = i.getKey();
            num1 = i.getValue();

            for (Map.Entry<Character, Integer> j : map2.entrySet()) {
                size1 = map1.size();
                size2 = map2.size();
                d = j.getKey();
                num2 = j.getValue();

                if (c == d) {
                    // for "bb" and "b"
                    if (size1 == size2) {
                        return true;
                    } else {
                        continue;
                    }
                }
                // add a new char
                if (!map1.containsKey(d)) {
                    ++size1;
                }
                if (!map2.containsKey(c)) {
                    ++size2;
                }

                // delete a empty char
                if (num1 == 1) {
                    --size1;
                }
                if (num2 == 1) {
                    --size2;
                }

                if (size1 == size2) {
                    return true;
                }
            }
        }

        return false;
    }
}
