package Math;

import java.util.Arrays;

public class test2 {
  public static void main(String[] args) {
    test2 t = new test2(10);
    t.allocate(1, 1);
    t.allocate(1, 2);
    t.allocate(1, 3);
    t.free(2);
    t.allocate(3, 4);
    t.allocate(1,1);
    t.allocate(1,1);
  }

  int[] arr;
  int n;
  // Map<Integer, Integer> map;

  public test2(int n) {
    arr = new int[n];
    this.n = n;
    // map = new HashMap<>();
    // Arrays.fill(arr, -1);
  }

  public int allocate(int size, int mID) {
    if (size > n)
      return -1;

    int sum = 0;
    for (int i = 0; i < size; ++i) {
      sum += arr[i];
    }

    int i = 0, j = size;
    while (sum > 0 && j < n) {
      sum -= arr[i++];
      sum += arr[j++];
    }

    if (sum > 0) {
      return -1;
    }

    for (int k = i; k < j; ++k) {
      arr[k] = mID;
    }

    return i;
  }

  // int fill(int idx, int size, int mID) {
  //     for (int i = 0; i < size; ++i) {
  //         arr[idx + i] = mID;
  //     }
  //     return idx;
  // }

  public int free(int mID) {
    int cnt = 0;
    for (int i = 0; i < arr.length; ++i) {
      if (arr[i] == mID) {
        arr[i] = 0;
        ++cnt;
      }
    }
    return cnt;
  }
}
