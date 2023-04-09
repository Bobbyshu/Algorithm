package Leetcode.weeklycontest.Normal.NO335;

public class t1 {
  public int passThePillow(int n, int time) {
    if (time < n) {
      return 1 + time;
    }

    int each = n - 1;
    int round = time / each;
    int more = time % each;
    return round % 2 == 0 ? more + 1 : n - more;
  }
}
