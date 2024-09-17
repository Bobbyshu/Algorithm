package A_OnsiteClassical.Tiktok;

public class MinSwapGroupOne1151 {
  public int minSwaps(int[] data) {
    int one = 0;
    for (int d : data) {
      one += d;
    }

    if (one <= 0) {
      return 0;
    }

    int cntOne = 0;
    for (int i = 0; i < one; ++i) {
      cntOne += data[i];
    }

    int maxOne = cntOne;
    for (int i = one; i < data.length; ++i) {
      cntOne += data[i];
      cntOne -= data[i - one];
      maxOne = Math.max(maxOne, cntOne);
    }

    return one - maxOne;
  }
}
