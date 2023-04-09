package BISHI.Amazon.former;

public class letfAvgAndRightAvg {
    public int findMinAverage(int[] arr) {
        int len = arr.length;
        int total = 0;
        for (int a : arr) {
            total += a;
        }
        int diff = Integer.MAX_VALUE;
        int leftSum = 0, rightSum = 0;
        int leftAvg = 0, rightAvg = 0;
        for (int i = 0; i < len; i++) {
            leftSum += arr[i];
            leftAvg = leftSum / (i + 1);
            rightSum = total - leftSum;
            rightAvg = rightSum / (len - i - 1);
            diff = Math.min(diff, Math.abs(leftSum - rightSum));
        }
        return diff;
    }
}
