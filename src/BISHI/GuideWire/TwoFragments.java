package BISHI.GuideWire;

import java.util.Arrays;

public class TwoFragments {
  public static void main(String[] args) {
    int[] arr = {1,3,-4,2,-1};
    System.out.println(solution(arr, 3, 2));
  }
  public static int solution(int[] A, int K, int L) {
    int maxSum = Integer.MIN_VALUE;
    int N = A.length;

    for (int i = 0; i <= N - K; i++) {
      int[] fragment1 = Arrays.copyOfRange(A, i, i + K);
      int[] fragment2 = new int[L];

      int currentSum1 = 0;
      for (int j = i; j < i + K; j++) {
        currentSum1 += A[j];
      }

      boolean[] used = new boolean[N];
      for (int j = 0; j < L; j++) {
        if (i <= j && j < i + K) {
          used[j] = true;
        }
      }

      int currentSum2 = 0;
      for (int j = 0; j < N; j++) {
        if (!used[j]) {
          currentSum2 += A[j];
        }
      }

      maxSum = Math.max(maxSum, currentSum1 + currentSum2);
    }

    return maxSum;
  }
}
