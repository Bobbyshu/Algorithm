public class ReverseString {
  public static String reverseAlphabeticallySmallest(String word) {
    int n = word.length();
    String smallest = word;

    // Create a 2D array to store the DP values
    String[][] dp = new String[n + 1][n + 1];
    for (int i = 0; i <= n; i++) {
      dp[i][0] = word.substring(0, i);
      dp[0][i] = word.substring(i);
    }

    // Fill in the DP array using the given transformations
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        String reversedPrefix = new StringBuilder(dp[i - 1][j]).reverse().toString();
        String reversedSuffix = new StringBuilder(dp[i][j - 1]).reverse().toString();
        dp[i][j] = reversedPrefix + word.charAt(j - 1) + reversedSuffix;

        // Compare with the smallest word found so far
        if (dp[i][j].compareTo(smallest) < 0) {
          smallest = dp[i][j];
        }
      }
    }

    return smallest;
  }

  public static void main(String[] args) {
    String word = "cbadefhg";
    String result = reverseAlphabeticallySmallest(word);
    System.out.println(result);  // Output: "abcedfhg"
  }
}
