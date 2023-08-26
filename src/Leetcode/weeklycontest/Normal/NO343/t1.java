package Leetcode.weeklycontest.Normal.NO343;

public class t1 {
  public int isWinner(int[] player1, int[] player2) {
    int n = player1.length;
    boolean flag1 = false, flag2 = false;
    int cnt1 = 0, cnt2 = 0;
    for (int i = 0; i < n; ++i) {
      if (i < 2) {
        if (player1[i] == 10) {
          flag1 = true;
        }
        if (player2[i] == 10) {
          flag2 = true;
        }
      }

      cnt1 += player1[i];
      cnt2 += player2[i];

      if (i > 1 && flag1) {
        cnt1 += player1[i];
      }
      if (i > 1 && flag2) {
        cnt2 += player2[i];
      }
    }
    if (cnt1 == cnt2) {
      return 0;
    }
    return cnt1 > cnt2 ? 1 : 2;
  }

  class Solution {
    public int isWinner(int[] player1, int[] player2) {
      int score1 = 0, score2 = 0;
      for (int i = 0; i < player1.length; i++) {
        if ((i > 0 && player1[i - 1] == 10) || (i > 1 && player1[i - 2] == 10)) {
          score1 += 2 * player1[i];
        } else {
          score1 += player1[i];
        }
      }

      for (int i = 0; i < player2.length; i++) {
        if ((i > 0 && player2[i - 1] == 10) || (i > 1 && player2[i - 2] == 10)) {
          score2 += 2 * player2[i];
        } else {
          score2 += player2[i];
        }
      }

      return (score1 == score2 ? 0 : (score1 > score2 ? 1 : 2));

    }
  }
}
