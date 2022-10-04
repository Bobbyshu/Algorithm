package A_OUEI.AIKeSiPiDia_OUEI;

import java.util.*;

public class Complementary_Pair {
    public static void main(String[] args) {
//        Complementary_Pair cp = new Complementary_Pair();
        List<String> arr = new ArrayList<>();
        arr.add("abc");
        arr.add("abcd");
        arr.add("bc");
        arr.add("adc");
        System.out.println(countComplement(arr));
//        System.out.println(1 << 2);
//        System.out.println(test("abcd"));
    }

    public static long countComplement(List<String> list) {
        long ans = 0;

        for (int i = 0; i < list.size() - 1; i++) {
            String cur = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                String next = list.get(i + 1);
                Set<Character> set = new HashSet<>();
                for (char c : cur.toCharArray()) {
                    if (!set.add(c)) {
                        set.remove(c);
                    }
                }
                for (char c : next.toCharArray()) {
                    if (!set.add(c)) {
                        set.remove(c);
                    }
                }

                if (set.size() <= 1)
                    ans++;
            }
        }

        return ans;
    }
    static long test(String s) {
        long bitmask = 0;
        for (char c : s.toCharArray()) {
            bitmask ^= (c - 'a');
        }

        return bitmask;
    }
}
