package String;

public class kmp {
    public static void main(String[] args) {
        String s = "abcxabcdabcdabcy";
        String pattern = "abcdabcy";

        System.out.println(kmp(s.toCharArray(), pattern.toCharArray()));
    }

    private static int kmp(char[] s, char[] pattern) {
        int[] next = getNext(pattern);

        int j = 0;
        for (int i = 0; i < s.length; ++i) {
            while (j > 0 && s[i] != pattern[j]) {
                j = next[j - 1];
            }

            if (s[i] == pattern[j]) {
                ++j;
            }

            if (j == pattern.length) {
                return i - j + 1;
            }
        }

        return -1;
    }

    private static int[] getNext(char[] pattern) {
        int[] next = new int[pattern.length];
        int j = 0;
        for (int i = 1; i < pattern.length; ++i) {
            while (j > 0 && pattern[i] != pattern[j]) {
                j = next[j - 1];
            }

            if (pattern[i] == pattern[j]) {
                ++j;
            }

            next[i] = j;
        }

        return next;
    }
}
