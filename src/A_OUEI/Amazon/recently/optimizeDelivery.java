package A_OUEI.Amazon.recently;

import java.util.HashMap;
import java.util.Map;

/*
送两个重量相同or送三个重量相同的包裹
找出送的最少次数或者返回-1
 */
public class optimizeDelivery {
    public static void main(String[] args) {
        optimizeDelivery opt = new optimizeDelivery();
        int[] arr = new int[]{2, 2, 3, 3, 2, 4, 4, 4, 4, 4};
        System.out.println(opt.min(arr));
    }
    int min(int[] nums) {
        Map<Integer, Integer> memo = new HashMap<>();
        for (int num : nums) {
            memo.put(num, memo.getOrDefault(num, 0) + 1);
        }

        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : memo.entrySet()) {
            int times = entry.getValue();
            if (times == 1)
                return -1;

            if (times % 3 == 0) {
                sum += (times / 3);
            } else {
                sum += (times / 2);
            }
        }
        return sum;
    }
}
