package BISHI.Citadel;

public class sprintTraining {
  /*
  public int GetMostVisited(int markerCount, int[] sprints)
  {
    var incremental = new int[markerCount + 2];
    for (int i = 0; i < sprints.Length - 1; i++)
    {
      var start = Math.Min(sprints[i], sprints[i + 1]);
      var end = Math.Max(sprints[i], sprints[i + 1]);
      incremental[start]++;
      incremental[end + 1]--;
    }

    var scores = new int[markerCount + 1];
    var score = 0;
    for (int i = 1; i < markerCount + 1; i++)
    {
      score += incremental[i];
      scores[i] = score;
    }

    var result = new KeyValuePair<int, int>(0, 0);
    for (int i = 1; i < markerCount + 1; i++)
    {
      if (scores[i] > result.Value)
      {
        result = new KeyValuePair<int, int>(i, scores[i]);
      }
    }
    return result.Key;
  }

   */
  int getMostVisited(int n, int[] sprint) {
    int[] ans = new int[n];
    int m = sprint.length;
    int res = 0;
    for (int i = 0; i < m - 1; ++i) {
      int start = Math.min(sprint[i], sprint[i + 1]) - 1;
      int end = Math.max(sprint[i], sprint[i + 1]) - 1;
      ans[start] += 1;
      if (end < n - 1) ans[end + 1] -= 1;
    }
    res = ans[0];
    for (int i = 1; i < n; ++i) {
      ans[i] = ans[i - 1] + ans[i];
      res = Math.max(res, ans[i]);
    }
    return res;
  }
}
