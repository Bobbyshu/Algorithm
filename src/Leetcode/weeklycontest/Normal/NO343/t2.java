package Leetcode.weeklycontest.Normal.NO343;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class t2 {
  public static void main(String[] args) {
    int[] arr = {1, 3, 4, 2};
    int[][] mat = {{1, 4}, {2, 3}};
    firstCompleteIndex(arr, mat);
  }

  public static int firstCompleteIndex(int[] arr, int[][] mat) {
    int m = mat.length, n = mat[0].length;
    Map<Integer, int[]> map = new HashMap<>();
    for (int i = 0; i < m; ++i) {
      for (int j = 0; j < n; ++j) {
        map.put(mat[i][j], new int[]{i, j});
      }
    }
    // 1 -> [0,1] 2 -> [1,0] 3 -> [1,1] 4 -> [1,0]
    int[] row = new int[m];
    int[] col = new int[n];

    int target = 0;
    for (int num : arr) {
      int[] pos = map.get(num);
      row[pos[0]]++;
      if (row[pos[0]] == n) {
        target = num;
        break;
      }
      col[pos[1]]++;
      if (col[pos[1]] == m) {
        target = num;
        break;
      }
    }
    // System.out.println(target + " = target");

    for (int i = 0; i < n; ++i) {
      if (arr[i] == target) {
        return i;
      }
    }

    return 0;
  }

}
