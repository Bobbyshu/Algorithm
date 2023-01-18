package Algorithm_Carl.DynamicProgramming;

public class BestSightseeingPair {
    /*
    score = nums[i] + nums[j] + i - j
    when the values add one element,
    the current result is Math.max(res, Max(nums[i] + i) + nums[curj] - j)
    So, the j and nums[j] is constant
    which means that we only need to focus the nums[i] + i;
    We use array to register the Max(nums[i] + i)
    use a const to register the res
    By iterating, we can get the answer
    */
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length, res = 0;
        //By using const we can realize O(1) Space Complexity
        int max = values[0];

        for (int i = 1; i < n; ++i) {
            res = Math.max(res, max + values[i] - i);
            max = Math.max(max, values[i] + i);
        }
        return res;
    }
}
