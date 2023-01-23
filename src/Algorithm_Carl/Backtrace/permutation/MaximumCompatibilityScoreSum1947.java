package Algorithm_Carl.Backtrace.permutation;

public class MaximumCompatibilityScoreSum1947 {
  public static void main(String[] args) {
    MaximumCompatibilityScoreSum1947 m = new MaximumCompatibilityScoreSum1947();
    int[][] stu = {{1,1,0},{1,0,1},{0,0,1}}, men = {{1,0,0},{0,0,1},{1,1,0}};
    m.maxCompatibilitySum(stu, men);
  }
  int[][] score;
  int res, m, n, cur;
  boolean[] used;
  public int maxCompatibilitySum(int[][] students, int[][] mentors) {
    // initialize
    this.m = students.length;
    this.n = students[0].length;
    this.score = new int[m][m];
    this.used = new boolean[m];
    this.res = Integer.MIN_VALUE;
    this.cur = 0;

    for (int i = 0; i < m; ++i) {
      for (int j = 0; j < m; ++j) {
        int sum = 0;
        for (int k = 0; k < n; ++k) {
          if (students[i][k] == mentors[j][k]) {
            ++sum;
          }
        }
        score[i][j] = sum;
      }
    }

    backtrace(0, 0);
    return res;
  }

  void backtrace(int i, int sum) {
    if (i == m) {
      res = Math.max(res, sum);
      return;
    }

    // use boolean array to exclude num that has been used
    for (int j = 0; j < m; ++j) {
      if (!used[j]) {
        used[j] = true;
        sum += score[i][j];
        backtrace(i + 1, sum);
        sum -= score[i][j];
        used[j] = false;
      }
    }
  }
}
