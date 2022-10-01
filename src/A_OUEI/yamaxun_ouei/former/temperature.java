package A_OUEI.yamaxun_ouei.former;

public class temperature {
    int max(int[] nums) {
        int[] prefix = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }

        int res = 0;
        int[] Max = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            Max[i] = Math.max(prefix[i + 1], prefix[nums.length] - prefix[i + 1] + nums[i]);
            res = Math.max(res, Max[i]);
        }

        return res;
    }
}
