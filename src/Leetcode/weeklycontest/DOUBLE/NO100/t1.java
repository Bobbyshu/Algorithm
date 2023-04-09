package Leetcode.weeklycontest.DOUBLE.NO100;

public class t1 {
  public int distMoney(int money, int children) {
    return 0;
  }

  public int distMoney2(int money, int children) {
    if (children > money) return -1;
    if (money < 8) return 0;
    int cnt = money / 8;
    int remain = money % 8;
    if (cnt == children && remain == 0)
      return children;

    if (cnt >= children)
      return children - 1;

    if (remain == 4 && (children - cnt) == 1)
      return children - 2;

    if (remain >= (children - cnt))
      return cnt;

    int left = children - cnt;

    while (remain < left) {
      left++;
      remain += 8;
      cnt--;
    }

    return cnt;
  }
}
