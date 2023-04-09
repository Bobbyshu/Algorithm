package BISHI.Amazon.recently;

import java.util.*;
/*
2268
 */

public class jiugongge {
    public static void main(String[] args) {
        jiugongge jiu = new jiugongge();
        String s = "hellowearetheworldchampion";
        System.out.println(jiu.leastClick(s));
    }

    int leastClick(String s) {
        char[] ch = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : ch) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        Integer[] arr = new Integer[map.size()];
        int index = 0;

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int times = entry.getValue();
            arr[index] = times;
            index++;
        }

        Arrays.sort(arr, (a, b) -> b - a);


        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i < 9) {
                sum += arr[i];
            } else if (i < 18) {
                sum += (2 * arr[i]);
            } else {
                sum += (3 * arr[i]);
            }
        }

        return sum;
    }

    int leastClick2(String s) {
        char[] ch = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : ch) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        Integer[] arr = new Integer[map.size()];
        //int[] arr = new int[map.size()];
        int index = 0;

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int times = entry.getValue();
            arr[index] = times;
            index++;
        }

        Arrays.sort(arr, (a, b) -> b - a);

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i < 9) {
                sum += arr[i];
            } else if (i < 18) {
                sum += (2 * arr[i]);
            } else {
                sum += (3 * arr[i]);
            }
        }

        return sum;
    }
}
