package Sort;

public class BubbleSort {
  public int[] bubbleSort(int[] arr) {
    if (arr.length < 2) return arr;
    // n - 1轮次执行，当前 n - 1 个元素排好后，最后一个元素无需执行，故i < arr.length - 1
    for (int i = 0; i < arr.length - 1; i++) {
      // 本轮执行是否有交换的标志，若无则false，若有则true
      boolean swapped = false;
      // 每轮循环，通过依次向右比较两个数，将本轮循环中最大的数放到最右
      for (int j = 1; j < arr.length - i; j++) {
        // 若左大于右则交换，并将swapped置为true
        if (arr[j - 1] > arr[j]) {
          swap(arr, j - 1, j);
          swapped = true;
        }
      }
      // 若无交换，表示当前数组已完全排序，退出大循环
      if (!swapped) break;
    }
    return arr;
  }

  private void swap(int[] arr, int i, int j) {
    if(i == j) return; // 若无法保证swapXOR被调用时满足 i != j，则需有此句，否则i == j时此数将变为0
    arr[i] = arr[i] ^ arr[j]; // a = a ^ b，也可写成 arr[i] ^= arr[j];
    arr[j] = arr[i] ^ arr[j]; // b = (a ^ b) ^ b = a ^ (b ^ b) = a ^ 0 = a， 也可写成 arr[j] ^= arr[i];
    arr[i] = arr[i] ^ arr[j]; // a = (a ^ b) ^ a = (a ^ a) ^ b = 0 ^ b = b， 也可写成 arr[i] ^= arr[j];
  }
}
