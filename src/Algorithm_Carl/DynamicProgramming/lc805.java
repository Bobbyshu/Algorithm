package Algorithm_Carl.DynamicProgramming;

import java.util.HashSet;
import java.util.Set;

public class lc805 {
    /*
    A(sum) * (n - k) = B(sum) * k;
    A(sum) * n = k * (A(sum) + B(sum))
    A(sum) * n = k * (Total Sum)
    Average(A) = Average(Total)
    */
    public boolean splitArraySameAverage(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return false;

        int m = n / 2;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // 这样好算点，本意是找和平均值的差数
        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] * n - sum;
        }

        Set<Integer> left = new HashSet<>();
        for (int i = 1; i < (1 << m); i++) {
            int tot = 0;
            for (int j = 0; j < m; j++) {
                if ((i & (1 << j)) != 0) {
                    tot += nums[j];
                }
            }
            if (tot == 0) {
                return true;
            }
            left.add(tot);
        }
        int rsum = 0;
        for (int i = m; i < n; i++) {
            rsum += nums[i];
        }
        for (int i = 1; i < (1 << (n - m)); i++) {
            int tot = 0;
            for (int j = m; j < n; j++) {
                if ((i & (1 << (j - m))) != 0) {
                    tot += nums[j];
                }
            }
            if (tot == 0 || (rsum != tot && left.contains(-tot))) {
                return true;
            }
        }
        return false;
    }
}

