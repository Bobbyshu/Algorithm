package BISHI.Cisco;

public class MeanAndMode {
    public double[] modeAndMean(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return new double[]{nums[0], nums[0]};

        double mode = 0, sum = 0, mean = 0;
        for (int num : nums) {
            if (sum == 0)
                mode = num;

            if (num == mode) {
                sum++;
            } else {
                sum--;
            }
            mean += num;
        }

        return new double[]{mode, mean / n};
    }
}
