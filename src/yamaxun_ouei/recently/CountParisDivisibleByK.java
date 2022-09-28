package yamaxun_ouei.recently;
/*
Given an array A[] and positive integer K
the task is to count the total number of pairs in the array whose sum is divisible by K.
[2, 2, 1, 7, 5, 3] K=4
(2, 2) (1, 7) (7, 5) (1, 3) (5, 3)
return 5
 */

public class CountParisDivisibleByK {
    public static void main(String[] args) {
        int[] nums = new int[]{2,2,1,7,5,3};
        CountParisDivisibleByK count = new CountParisDivisibleByK();
        System.out.println(count.count(nums, 4));
    }
    int count(int[] nums, int k) {
        int n = nums.length;
        // Create a frequency array to count
        // occurrences of all remainders when
        // divided by K
        int[] bucket = new int[k];
        // Count occurrences of all remainders
        for (int i = 0; i < n; i++)
            bucket[nums[i] % k]++;

        // the way that from freq[0] pick 2
        int sum = bucket[0] * (bucket[0] - 1) / 2;

        // count for all i and (k-i)
        // freq pairs
        for (int i = 1; i <= k / 2 && i != (k - i); i++)
            sum += bucket[i] * bucket[k - i];
        // If K is even
        if (k % 2 == 0)
            sum += (bucket[k / 2] * (bucket[k / 2] - 1) / 2);
        return sum;
    }
}
