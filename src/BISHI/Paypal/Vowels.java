package BISHI.Paypal;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Vowels {
    public static void main(String[] args) {
        String[] strArr = {"aba", "bcb", "ece", "aa", "e"};
        String[] queries = {"1-3", "2-5", "2-2"};
        int[] res = vowels(strArr, queries);
        System.out.println(Arrays.toString(res));
    }
    static int[] vowels(String[] strArr, String[] query) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        int n = strArr.length;
        int[] count = new int[n];
        for (int i = 0; i < n; i++) {
            if (set.contains(strArr[i].charAt(0)) && set.contains(strArr[i].charAt(strArr[i].length() - 1))) {
                count[i] = 1;
            }
        }

        int[] prefix = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + count[i - 1];
        }
        System.out.println(Arrays.toString(prefix));

        int[] res = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            String[] arr = query[i].split("-");
//            System.out.println(Arrays.toString(arr));
            int start = Integer.parseInt(arr[0]) - 1;
            int end = Integer.parseInt(arr[arr.length - 1]) - 1;
            res[i] = prefix[end + 1] - prefix[start];
        }

        return res;
    }
}
