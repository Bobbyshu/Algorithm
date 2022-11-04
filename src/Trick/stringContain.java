package Trick;

public class stringContain {
    public static void main(String[] args) {
        String s1 = "aaabaaaabaaabaaaabaaaabaaaabaaaaba";
        String s2 = "aaaba";
        maxRepeating2(s1, s2);
        System.out.println(maxRepeating2(s1, s2));
    }
    public static int maxRepeating(String sequence, String word) {
        int res = 0;
        StringBuilder sb = new StringBuilder(word);
        while (sequence.contains(sb)) {
            res++;
            sb.append(word);
        }
        return res;
    }

    public static int maxRepeating2(String sequence, String word) {
        int n = word.length();
        int m = sequence.length();
        if (m < n)
            return 0;

        int sum = 0;
        for (int i = 0; i <= m - n; i++) {
            for (int j = 0; j <= n; j++) {
                if (j == n) {
                    sum++;
                    break;
                }
                if (sequence.charAt(i) == word.charAt(j)) {
                    i++;
                } else {
                    break;
                }
            }
        }
        return sum;
    }
}
