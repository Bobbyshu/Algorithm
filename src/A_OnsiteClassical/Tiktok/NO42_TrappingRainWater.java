package A_OnsiteClassical.Tiktok;

public class NO42_TrappingRainWater {
  public int trap(int[] height) {
    int n = height.length;
    int[] leftMax = new int[n], rightMax = new int[n];

    for (int i = 1; i < n; ++i) {
      leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
    }

    for (int i = n - 2; i >= 0; --i) {
      rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
    }

    int res = 0;
    for (int i = 1; i < n - 1; ++i) {
      int shorterOne = Math.min(leftMax[i], rightMax[i]);
      if (shorterOne > height[i]) {
        res += (shorterOne - height[i]);
      }
    }

    return res;
  }
}
