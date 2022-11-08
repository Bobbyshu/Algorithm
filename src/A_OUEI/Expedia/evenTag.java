package A_OUEI.Expedia;

public class evenTag {
    int evenTag(int[] arr) {
        int minOdd = Integer.MAX_VALUE;
        int sum = 0;
        for (int a : arr) {
            minOdd = Math.min(minOdd, a);
            sum += a;
        }

        return sum % 2 == 0 ? sum : sum - minOdd;
    }
}
