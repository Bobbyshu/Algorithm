package Trick;
/*
给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */

public class RemoveDuplicate {
    //former k duplicate, after k, it start counted into the normal calculation
    int process(int[] nums, int k) {
        int index = 0;
        for (int num : nums) {
            if (index < k || nums[index - k] != num) {
                nums[index] = num;
                index++;
            }
        }

        return index;
    }
}
