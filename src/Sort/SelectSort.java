package Sort;

public class SelectSort {
  public int[] selectionSort(int[] arr) {
    if (arr.length < 2) return arr;
    for (int i = 0; i < arr.length - 1; i++) { // 当前 N-1 个元素排好后，最后一个元素无需执行，故 i < arr.length - 1
      int minIdx = i;
      for (int j = i + 1; j < arr.length; j++) { // 找到本轮执行中最小的元素，将最小值下标赋值给 minIdx
        if (arr[j] < arr[minIdx]) minIdx = j;
      }
      swap(arr, i, minIdx);
    }
    return arr;
  }

  private void swap(int[] arr, int i, int j) {
    if (i == j) return; // 若无法保证swapXOR被调用时满足 i != j，则需有此句，否则i == j时此数将变为0
    arr[i] = arr[i] ^ arr[j]; // a = a ^ b，也可写成 arr[i] ^= arr[j];
    arr[j] = arr[i] ^ arr[j]; // b = (a ^ b) ^ b = a ^ (b ^ b) = a ^ 0 = a， 也可写成 arr[j] ^= arr[i];
    arr[i] = arr[i] ^ arr[j]; // a = (a ^ b) ^ a = (a ^ a) ^ b = 0 ^ b = b， 也可写成 arr[i] ^= arr[j];
  }
}
