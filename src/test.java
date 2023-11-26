public class test {
  public static void main(String[] args) {
    int[] arr = {1,3,5,8,20};
    binar(arr, 0, 5, 4);
  }
  static int binar(int[] arr, int l, int r, int x) {
    if (r >= l) {
      int mid = l + (r - l) / 2;
      if (arr[mid] == x) {
        return mid;
      }
      if (arr[mid] > x) {
        return binar(arr, l , mid+ 1, x);
      }
      return binar(arr, mid+1, r, x);
    }
    return -1;
  }
}
