package yamaxun_ouei.recently;

import java.util.HashSet;
import java.util.Set;

/*
给你一个整数数组nums 和一个整数k。请你向nums中追加k个未出现在nums中的互不相同的正整数，
并使结果数组的元素和最小 。
返回追加到nums中的k个整数之和。
 */
public class JIAKONG {
    public static void main(String[] args) {

    }

    public long minimalKSum(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();

        for(int num : nums) set.add(num);

        long res = (1L + k) * k / 2;
        int next = k + 1;
        for(int num : set) { // 这里必须遍历set而不是nums，为的就是跳过（nums[i - 1] == nums[i]）
            if(num <= k) {
                while(set.contains(next)) {
                    next++;
                }
                res = res - num + next;
                next++;
            }
        }

        return res;
    }
}
