package BISHI.Codesignal.databricks;

public class PaintY {

    public static void main(String[] args) {
        int[][] matrix = {
                {2, 0, 0, 0, 2},
                {1, 2, 1, 2, 0},
                {0, 1, 2, 1, 0},
                {0, 0, 2, 1, 1},
                {1, 1, 2, 1, 1}
        };

        int result = minChangesForY(matrix);
        System.out.println("Minimum changes needed: " + result);
    }
    public static int minChangesForY(int[][] matrix) {
        int n = matrix.length;
        int yDigit = -1;
        int backgroundDigit = -1;

        // Calculate frequencies of each digit and track diagonal and center values
        int[] digitFreq = new int[3];
        int[] diagonalValues = new int[n];
        int centerValue = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int digit = matrix[i][j];
                digitFreq[digit]++;
                if (i == j) diagonalValues[i] = digit;
                if (i == n / 2 && j == n / 2) centerValue = digit;
            }
        }

        // Determine Y digit and background digit
        for (int i = 0; i < 3; i++) {
            if (digitFreq[i] >= n / 2) {
                yDigit = i;
            } else {
                backgroundDigit = i;
            }
        }

        // Calculate minimum changes required
        int minChanges = Integer.MAX_VALUE;

        for (int i = 0; i < 3; i++) {
            if (i != yDigit && i != backgroundDigit) {
                int changes = 0;
                if (diagonalValues[0] != yDigit) changes++;
                if (diagonalValues[n - 1] != yDigit) changes++;
                if (centerValue != yDigit) changes++;

                // Count changes for non-Y and non-background digits
                changes += digitFreq[i];

                minChanges = Math.min(minChanges, changes);
            }
        }

        return minChanges;
    }
}
