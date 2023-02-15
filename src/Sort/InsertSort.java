package Sort;

import java.util.Arrays;

public class InsertSort {
  public static void main(String[] args) {
    int[] arr = {6,5,3,1,8,7,2,4};
    insertionSort(arr);
  }
  public static int[] insertionSort(int[] arr) {
    if (arr.length < 2) return arr;
    // N-1轮次执行
    for (int i = 1; i < arr.length; i++) {
      int target = arr[i], j = i - 1;
      while (j >= 0 && target < arr[j]) {
        arr[j + 1] = arr[j];
        j--;
      }
      arr[j + 1] = target;// 若发生移动，此时的插入对象数字≥j位置的数字，故插入位置为j + 1，若未移动也成立，无需判断
//      System.out.println(Arrays.toString(arr));
    }
    return arr;
  }
}
