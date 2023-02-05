package Algorithm_Carl.BinarySearch;

import java.util.Arrays;

public class MostBeautifulItem {
  public static void main(String[] args) {
    int[][] i = {{1, 2}, {3, 2}, {2, 4}, {5, 6}, {3, 5}};
    int[] q = {1, 2, 3, 4, 5, 6};
    maximumBeauty(i, q);
  }

  static public int[] maximumBeauty(int[][] items, int[] queries) {
    Arrays.sort(items, (o1, o2) -> o1[0] - o2[0]);
    // System.out.println(Arrays.deepToString(items));
    // Arrays.sort(queries);
    int n = queries.length;
    int[] res = new int[n];
    // System.out.println("hello");

    // let every items[i][1] become current maximum
    for (int i = 1; i < items.length; ++i) {
      items[i][1] = Math.max(items[i][1], items[i - 1][1]);
    }

    for (int i = 0; i < n; ++i) {
      res[i] = right_bound(items, queries[i]);
    }

    return res;
  }

  static int right_bound(int[][] items, int target) {
    if (items[0][0] > target) {
      return 0;
    }

    int l = 0, r = items.length;
    while (l < r) {
      int mid = l + ((r - l) >> 1);
      if (items[mid][0] > target) {
        r = mid;
      } else {
        l = mid + 1;
      }
    }

    return items[l - 1][1];
  }
}
