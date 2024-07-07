package Leetcode.weeklycontest.Normal.NO405;

import java.util.ArrayList;
import java.util.List;

public class t2 {
  List<String> res;
  char[] arr;
  char[] dict = {'0', '1'};
  public List<String> validStringsDFS(int n) {
    res = new ArrayList<>();
    arr = new char[n];
    System.out.println(arr);

    dfs(0);

    return res;
  }

  private void dfs(int idx) {
    if (idx == arr.length) {
      if (check(arr)) {
        res.add(new String(arr));
      }
      return;
    }

    for (int i = 0; i < 2; ++i) {
      arr[idx] = dict[i];
      dfs(idx + 1);
      arr[idx] = '0';
    }
  }

  private boolean check(char[] arr) {
    for (int i = 1; i < arr.length; ++i) {
      if (arr[i] == '0' && arr[i - 1] == '0') {
        return false;
      }
    }

    return true;
  }
}
