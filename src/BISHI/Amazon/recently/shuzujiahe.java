package BISHI.Amazon.recently;

import java.util.*;

/*
第一道，给一个正整数数组，然后相邻的数可以相加如果arr[i-1] < arr[i]
然后问最后数组里可能的最大的数是多少。注意第一次计算完之后的数组还要进行第二轮计算
直到最后没有更多变化
比如[20, 8, 2, 7] => [20, 8, 9(2+7)] => [20, 17(8+9)]，最后结果是20
再比如[20, 8, 2, 13] => [20, 8, 15(2+13)] => [20, 23(8+15)] => [43]，最后结果为43.
 */
public class shuzujiahe {
    int max(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {

            }
            list.add(nums[i]);
        }
        return 0;
    }
}
