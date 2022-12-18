package Sort;

public class UndefinedSort {
    public static void main(String[] args) {

    }

    static void sort(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return;
        }

        for (int i = 0; i < n; ++i) {
            int minIndex = i, min = nums[minIndex];
            for (int j = i; j < n; ++j) {
                if (nums[j] < min) {
                    minIndex = j;
                    min = nums[minIndex];
                }
            }
            if (i != minIndex) {
                swap(nums, i, minIndex);
            }
        }
    }

    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
