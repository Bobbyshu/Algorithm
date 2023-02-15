package Algorithm_Carl.Backtrace.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LetterTilePossibilities {
  boolean[] used;
  int cnt = 0;
  List<List<Character>> res = new ArrayList<>();
  LinkedList<Character> path = new LinkedList<>();

  public int numTilePossibilities(String tiles) {
    used = new boolean[tiles.length()];
    char[] arr = tiles.toCharArray();
    Arrays.sort(arr);
    dfs(arr, 0);
    System.out.println(res);
    return cnt;
  }

  void dfs(char[] arr, int idx) {
    res.add(new LinkedList<>(path));
    if (idx >= arr.length) {
      return;
    }

    for (int i = 0; i < arr.length; ++i) {
      if (!used[i]) {
        if (i > 0 && arr[i] == arr[i - 1] && !used[i - 1]) {
          continue;
        }

        ++cnt;
        path.add(arr[i]);
        used[i] = true;
        dfs(arr, idx + 1);
        used[i] = false;
        path.removeLast();
      }
    }
  }
}
