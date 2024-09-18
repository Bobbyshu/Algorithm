package A_OnsiteClassical.Tiktok;

import java.util.ArrayList;
import java.util.List;

public class maxNumberCanReach {
  public static void main(String[] args) {
    int[] arr = {1,2,4,9};

    solution(arr, 2533);
  }
  public static void solution(int[] arr, int n) {
    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    dfs(arr, n, res, sb);

    System.out.println(res);
  }

  public static void dfs(int[] arr, int n, List<String> res, StringBuilder sb) {
    if (sb.length() == String.valueOf(n).length()) {
      if (Integer.parseInt(sb.toString()) < n) {
        res.add(sb.toString());
      }
      return;
    }

    for (int j : arr) {
      sb.append(j);
      dfs(arr, n, res, sb);
      sb.setLength(sb.length() - 1);
    }
  }
}
