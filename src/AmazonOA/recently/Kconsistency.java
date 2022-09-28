package AmazonOA.recently;

import java.util.HashMap;
import java.util.Map;

public class Kconsistency {
    public static void main(String[] args) {
        int[] stock_price = {2, 7, 5, 7, 7, 1, 1, 7, 7};
        int k = 3;

        int len = stock_price.length;
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int maxCount = 0;

        for (int right = 0; right < len; right++) {
            map.put(stock_price[right], map.getOrDefault(stock_price[right], 0) + 1);
            maxCount = Math.max(maxCount, map.get(stock_price[right]));
            while (right - left + 1 > maxCount + k) {
                map.put(stock_price[left], map.get(stock_price[left]) - 1);
                left++;
            }
        }
        System.out.println(maxCount);
    }

    public int characterReplacement(String s, int k) {
        int left = 0, right = 0;
        int len = 0;
        int[] dict = new int[26];
        char[] arr = s.toCharArray();

        for (right = 0; right < arr.length; right++) {
            int i = arr[right] - 'A';
            dict[i]++;
            len = Math.max(len, dict[i]);

            while (right - left + 1 > len + k) {
                dict[arr[left] - 'A']--;
                left++;
            }

        }

        return arr.length - left;
    }
}
