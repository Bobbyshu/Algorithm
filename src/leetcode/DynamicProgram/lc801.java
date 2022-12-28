package leetcode.DynamicProgram;
/*
我们有两个长度相等且不为空的整型数组 nums1 和 nums2 。在一次操作中，我们可以交换 nums1[i] 和 nums2[i]的元素。

例如，如果 nums1 = [1,2,3,8] ， nums2 =[5,6,7,4] ，你可以交换 i = 3 处的元素，
得到 nums1 =[1,2,3,4] 和 nums2 =[5,6,7,8] 。
返回 使 nums1 和 nums2 严格递增 所需操作的最小次数 。

数组 arr 严格递增 且  arr[0] < arr[1] < arr[2] < ... < arr[arr.length - 1] 。
 */

public class lc801 {
    public int minSwap(int[] a, int[] b) {
        int n = a.length;
        if (n == 1)
            return 0;

        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = 1;

        for (int i = 1; i < n; i++) {
            if (a[i - 1] < a[i] && b[i - 1] < b[i]) {
                if (a[i - 1] < b[i] && b[i - 1] < a[i]) {   //如果两个数组都合法，那就可换可不换
                    dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][1]);
                    dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + 1;
                } else {    //换了之后出问题，那就要么都不换，要么都换
                    dp[i][0] = dp[i - 1][0];    //都不换
                    dp[i][1] = dp[i - 1][1] + 1;    //都换
                }
            } else {    //数组有问题，必换，要么换前面，要么换当前
                dp[i][0] = dp[i - 1][1];    //换前面
                dp[i][1] = dp[i - 1][0] + 1;    //换当前
            }
        }

        return Math.min(dp[n - 1][0], dp[n - 1][1]);
    }
}
