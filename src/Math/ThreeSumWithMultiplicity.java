package Math;

import java.util.Arrays;

/*
首先遍历数组 arr，使用哈希表记录每个元素的出现次数。由于数组已经按升序排序，
因此重复元素在数组中的相邻位置，可以通过比较相邻位置的元素寻找重复元素，实现去重。

当 arr[i] = arr[i - 1]时，arr[i] + arr[j] + arr[k] = arr[i − 1] + arr[j] + arr[k]，
且三元组的第一个数位于下标 i − 1 的情况已经遍历过，
因此三元组的第一个数位于下标 ii 时一定会和已经遍历过的三元组重复，应跳过当前下标 i。

对于固定 i 之后的下标对 (j, k)，由于双指针的移动方向是 j 向右移动、k 向左移动，
因此如果 i + 1 < j < k 且 arr[j] = arr[j − 1]
或 j < k < n - 1 且 arr[k] = arr[k + 1]，
当前的下标对 (j, k) 与 i 组成的三元组一定会和已经遍历过的三元组重复，应跳过元素值重复的下标。

实现方面，由于数组 arr 中的元素都是不超过 100 的非负整数，因此可以使用数组代替哈希表。

 */
public class ThreeSumWithMultiplicity {
    public int threeSumMulti(int[] arr, int target) {
        final int mod = (int) 1e9 + 7;
        long res = 0L;
        Arrays.sort(arr);

        int n = arr.length;
        int maxNum = arr[n - 1];
        long[] counts = new long[maxNum + 1];
        for (int num : arr) {
            counts[num]++;
        }

        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }

            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (sum == target) {
                    long ci = counts[arr[i]];
                    long cj = counts[arr[j]];
                    long ck = counts[arr[k]];
                    long cur;
                    // n choose 3
                    if (arr[i] == arr[j] && arr[i] == arr[k]) {
                        cur = ci * (ci - 1) * (ci - 2) / 6 % mod;
                    } else if (arr[i] == arr[j]) {  // n choose 2
                        cur = ci * (ci - 1) / 2 * ck % mod;
                    } else if (arr[j] == arr[k]) {  // n choose 2
                        cur = cj * (cj - 1) / 2 * ci % mod;
                    } else {    // independent
                        cur = ci * cj * ck % mod;
                    }
                    res = (res + cur) % mod;
                    j++;
                    k--;
                    while (j < k && arr[j] == arr[j - 1]) {
                        j++;
                    }
                    while (j < k && arr[k] == arr[k + 1]) {
                        k--;
                    }
                } else if (sum < target) {
                    j++;
                    while (j < k && arr[j] == arr[j - 1]) {
                        j++;
                    }
                } else {
                    k--;
                    while (j < k && arr[k] == arr[k + 1]) {
                        k--;
                    }
                }
            }
        }

        return (int) res;
    }
}
