package yamaxun_ouei.recently;

import java.util.HashMap;
import java.util.Map;

/*
第一道是 processor execution time，给一个int array有相同的执行时间的进程，
每次执行时间都会减半然向上取整ceil，求总时间。比如array = [8, 5, 8, 4, 5, 2]
第二个8就变成4，第二个5就变成3
 */
public class Processor {
    public static void main(String[] args) {
        int[] arr = new int[]{8, 4, 4, 8, 2};
        Processor pro = new Processor();
        System.out.println(pro.ceil(arr));
    }

    int ceil(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();

        int sum = 0;
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int num = entry.getKey(), times = entry.getValue();
            if (times == 1) {
                sum += num;
            } else {
                sum += process(num, times);
            }
        }

        return sum;
    }

    int process(int num, int times) {
        int sum = 0;

        while (times > 0) {
            sum += num;
            if (num % 2 != 0) {
                num = num / 2 + 1;
            } else {
                num /= 2;
            }
            times--;
        }

        return sum;
    }
}
