package A_OUEI.Amazon.recently;

import java.util.HashSet;
import java.util.Set;

/*
prefix + sliding window
给定一个长度为n的数组表示n个月的股价，给定k值，给连续k月并且k值各不一样的区间求和
找到最大和。
{1,2,3,4} k = 2
(1,2) (2,3) (3,4)
三个长度为K的连续区间且每个区间没有重复值，最大和是7
 */
public class maxAverageStockPrice {
    public static void main(String[] args) {
        maxAverageStockPrice ave = new maxAverageStockPrice();
        int[] arr = new int[]{1, 2, 7, 7, 4, 3, 6};
        int n = ave.max(arr, 3);
        System.out.println(n);
    }

    int max(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return 0;

        int len = nums.length;
        if (len == 1)
            return nums[0];

        int[] prefix = new int[nums.length + 1];
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }

        Set<Integer> window = new HashSet<>();
        int left = 0;
        int maxPrice = 0;

        for (int right = 0; right < len; right++) {
            while (window.contains(nums[right]) && left != right) {
                window.remove(nums[left]);
                left++;
            }
            window.add(nums[right]);

            if (right - left + 1 == k) {
                maxPrice = Math.max(maxPrice, prefix[right + 1] - prefix[left]);
                left++;
            }
        }

        return maxPrice;
    }
}
