package A_OUEI.Codesignal.ziprecruitter;

public class alternatingParityPattern {
    int solution(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] % 2 != numbers[i + 1] % 2) {
                continue;
            } else {
                return i + 1;
            }
        }

        return -1;
    }
}
