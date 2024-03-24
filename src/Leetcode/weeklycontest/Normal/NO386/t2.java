package Leetcode.weeklycontest.Normal.NO386;

public class t2 {
  public long largestSquareArea(int[][] b, int[][] t) {
    int n = b.length;
    long res = 0L;
    for (int i = 0; i < n; ++i) {
      int[] firstL = b[i], firstR = t[i];
      for (int j = i + 1; j < n; ++j) {
        int[] secondL = b[j], secondR = t[j];
        int vertical = Math.min(firstR[1], secondR[1]) - Math.max(firstL[1], secondL[1]);
        int horizon = Math.min(firstR[0], secondR[0]) - Math.max(firstL[0], secondL[0]);
        long len = Math.min(vertical, horizon);
        if (len > 0) {
          res = Math.max(res, len * len);
        }
      }
    }

    return res;
  }

  // private String serialize(int[] arr) {
  //     return arr[0] + "," + arr[1];
  // }

  // private int[] deserialize(String s) {
  //     String[] arr = s.split(",");
  //     System.out.println(Arrays.toString())
  //     return new int[]{Integer.parseInt(arr[0]), Integer.parseInt(arr[1])};
  // } 
}
