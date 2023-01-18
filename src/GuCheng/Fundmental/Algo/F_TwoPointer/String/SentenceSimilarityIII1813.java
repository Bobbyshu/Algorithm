package GuCheng.Fundmental.Algo.F_TwoPointer.String;

public class SentenceSimilarityIII1813 {
  public boolean areSentencesSimilar(String s1, String s2) {
    String[] arr1 = s1.split(" "), arr2 = s2.split(" ");
    int m = arr1.length, n = arr2.length;

    // check prefix
    int i = 0;
    while (i < m && i < n && arr1[i].equals(arr2[i])) {
      ++i;
    }
    // left finish -> true;
    if (i == n) {
      return true;
    }

    // check suffix
    int j = 0;
    //should be j < n - i instead of j < n because we need to avoid overlapping
    while (j < n - i && j < m - i && arr1[m - 1 - j].equals(arr2[n - 1 - j])) {
      ++j;
    }
    // right finish -> true;
    if (j == n) {
      return true;
    }

    // prefix + suffix == short one
    return i + j == Math.min(m, n);
  }
}
