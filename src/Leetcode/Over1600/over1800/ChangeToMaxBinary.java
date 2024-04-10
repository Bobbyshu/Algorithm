package Leetcode.Over1600.over1800;

import java.util.Arrays;

public class ChangeToMaxBinary {
    public String maximumBinaryString(String binary) {
        int zero = 0, preOne = 0;
        char[] arr = binary.toCharArray();
        for (char c : arr) {
            if (c == '0') {
                ++zero;
            }
            if (zero == 0 && c == '1') {
                ++preOne;
            }
        }

        if (zero <= 1) {
            return binary;
        }

        Arrays.fill(arr, '1');
        arr[preOne + zero - 1] = '0';

        return new String(arr);
    }
}
