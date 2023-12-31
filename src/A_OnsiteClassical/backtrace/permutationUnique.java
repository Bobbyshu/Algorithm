package A_OnsiteClassical.backtrace;

public class permutationUnique {
  List<List<Integer>> res;
  List<Integer> path;
  boolean[] used;

  public List<List<Integer>> permuteUnique(int[] nums) {
    res = new ArrayList<>();
    path = new ArrayList<>();
    used = new boolean[nums.length];
    Arrays.sort(nums);

    dfs(nums);
    return res;
  }

  void dfs(int[] nums) {
    if (path.size() == nums.length) {
      res.add(new ArrayList<>(path));
      return;
    }

    for (int i = 0; i < nums.length; ++i) {
      if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false) {
        continue;
      }
      if (used[i]) {
        continue;
      }
      used[i] = true;
      path.add(nums[i]);
      dfs(nums);
      path.remove(path.size() - 1);
      used[i] = false;
    }
  }
}
