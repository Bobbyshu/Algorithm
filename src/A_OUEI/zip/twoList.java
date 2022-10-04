package A_OUEI.zip;

import java.util.HashSet;
import java.util.Set;

public class twoList {
    public static void main(String[] args) {
        twoList tl = new twoList();
        int[] arr = {2, 4, 7, 5, 3, 5, 8, 5, 1, 7};
        tl.solution(arr, 4, 10);
        System.out.println(tl.solution(arr, 4, 10));
    }
    int solution(int[] a, int m, int k) {
        int l = 0, r = m - 1;
        int res = 0;

        while (r < a.length) {
            Set<Integer> set = new HashSet<>();
            for (int i = l; i <= r; i++) {
                if (set.contains(k - a[i])) {
                    res++;
                }
                set.add(a[i]);
            }

            r++;
            l++;
        }

        return res;
    }
}
