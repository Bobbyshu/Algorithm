package BISHI.IBM;

public class getMinimumMoves {
  public static int get(int n, int[] q) {
    int sum = 0;
    for (int i : q) {
      sum += i;
    }

    int res = Integer.MAX_VALUE, cur = 0;
    for (int i : q) {
      cur += i;
      sum -= i;
      res = Math.min(res, Math.abs(sum - cur));
    }

    return res;
  }

  public static void main(String[] args) {
    int[] arr = {1,4,4};
    System.out.println(get(3, arr));
  }
}
