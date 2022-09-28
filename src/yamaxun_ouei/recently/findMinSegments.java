package yamaxun_ouei.recently;

import java.util.HashSet;
import java.util.Set;

/*
第一题the number of redundancy-free segments
给一个string 找出 minimum number of redundancy-free segments
aabcdea: a/abcde/a      return 3
 */
public class findMinSegments {
    public static void main(String[] args) {
        findMinSegments num = new findMinSegments();
        String s = "aabcdea";
        System.out.println(num.min(s));
    }
    int min(String s) {
        Set<Character> dict = new HashSet<>();
        int segement = 0;
        for (char c : s.toCharArray()) {
            if (dict.contains(c)) {
                dict.clear();
                segement++;
            }
            dict.add(c);
        }
        return segement + 1;
    }
}
