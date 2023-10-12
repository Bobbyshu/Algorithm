package Algo5800.DP;

import java.util.Arrays;

/* Given an array A[1...n] of positive
integers, compute the length of the longest alternating subsequence.
A sequence P [1..m] is alternating if P [i] < P [i − 1] for every even index i ≥ 2,
and if P [i] > P [i − 1] for every odd index i ≥ 3.
For example, in the sequence
(3,1,4,1,5,9,2,6,5,2,5,8)
the longest alternating subsequence is
(3,1,4,1,5,2,6,5,8)
so we should return 9.
 */
public class LongestAlternateSubsequence {
  public static int longestAlternatingSubsequence(int[] A) {
    int n = A.length;
    int[] inc_len = new int[n];
    int[] dec_len = new int[n];

    // 初始化为1
    Arrays.fill(inc_len, 1);
    Arrays.fill(dec_len, 1);

    for (int i = 1; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (A[i] > A[j]) {
          inc_len[i] = Math.max(inc_len[i], dec_len[j] + 1);
        } else if (A[i] < A[j]) {
          dec_len[i] = Math.max(dec_len[i], inc_len[j] + 1);
        }
      }
    }

    int maxLen = 0;
    for (int i = 0; i < n; i++) {
      maxLen = Math.max(maxLen, Math.max(inc_len[i], dec_len[i]));
    }
    System.out.println(Arrays.toString(inc_len));
    System.out.println(Arrays.toString(dec_len));
    return maxLen;
  }

  public static void main(String[] args) {
    int[] A = {3, 1, 4, 1, 5, 9, 2, 6, 5, 2, 5, 8};
    int result = longestAlternatingSubsequence(A);
    System.out.println(result); // 输出：9
  }
}
