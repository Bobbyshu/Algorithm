package BISHI.IBM;

public class PasswordSecurity {

  public static int minFlipsToSecurePassword(String password) {
    int minFlips = Integer.MAX_VALUE;

    // Iterate through possible even lengths
    for (int length = 2; length <= password.length(); length += 2) {
      int flipsForZeros = 0;
      int flipsForOnes = 0;

      // Count flips needed for all-zero and all-one substrings
      for (int i = 0; i < length; i++) {
        if (password.charAt(i) == '0') {
          flipsForOnes++;
        } else {
          flipsForZeros++;
        }
      }

      // Count flips needed for the rest of the password
      for (int i = length; i < password.length(); i++) {
        if (i % length == 0) {
          // Update flips count by subtracting flips needed for the character that's moving out of the substring
          if (password.charAt(i - length) == '0') {
            flipsForZeros--;
          } else {
            flipsForOnes--;
          }
        }

        // Update flips count for the current character
        if (password.charAt(i) == '0') {
          flipsForZeros++;
        } else {
          flipsForOnes++;
        }

        // Update minimum flips needed
        minFlips = Math.min(minFlips, Math.min(flipsForZeros, flipsForOnes));
      }
    }

    return minFlips;
  }

  public static void main(String[] args) {
    String password = "1110011000";
    int minFlips = minFlipsToSecurePassword(password);
    System.out.println("Minimum flips needed: " + minFlips);
  }
}

