package BISHI.Amazon.recently;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetMatchingScore {
    public static void main(String[] args) {
        String s1 = "acaccaa";
        String s2 = "aac";
        GetMatchingScore get = new GetMatchingScore();
        System.out.println(get.match1(s1, s2, 2));
    }

    int match1(String s1, String s2, int p) {
                    int[] dict2 = new int[26];
                    for (char c : s2.toCharArray()) {
                        dict2[c - 'a']++;
                    }

                    int res = 0;
                    List<String> list = new ArrayList<>();

                    for (int i = 0; i < s1.length(); i++) {
                        if (i + (s2.length() - 1) * p >= s1.length())
                            break;
                        StringBuilder sb = new StringBuilder();
                        for (int j = i; j < s1.length(); j += p) {
                            sb.append(s1.charAt(j));
                            if (sb.length() == s2.length()){
                    list.add(sb.toString());
                    break;
                }
            }
        }

        for (int i = 0; i < list.size(); i++) {
            String cur = list.get(i);
            int[] dict1 = new int[26];
            for (char c : cur.toCharArray()) {
                dict1[c - 'a']++;
            }
            if (Arrays.equals(dict1, dict2)) {
                res++;
            }
        }

        return res;
    }

    int match(String s1, String s2, int p) {
        int[] dict2 = new int[26];
        for (char c : s2.toCharArray()) {
            dict2[c - 'a']++;
        }

        int res = 0;

        for (int i = 0; i < s1.length(); i++) {
            int[] dict1 = new int[26];
            int len = s2.length();
            for (int j = i; j < s1.length(); j += p) {
                dict1[s1.charAt(j) - 'a']++;
                len--;
                if (len == 0) {
                    if (Arrays.equals(dict1, dict2)) {
                        res++;
                        break;
                    }
                }
            }
        }

        return res;
    }
}
