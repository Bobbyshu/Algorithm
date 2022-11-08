package A_OUEI.Codesignal.ebay;

public class replaceMessage {
    public static void main(String[] args) {
        System.out.println(replace("CodeSignal"));
    }

    static String replace(String message) {
        char[] s = message.toCharArray();
        int n = s.length;
        for (int i = 0; i < n; i++) {
            if (!isVowel(s[i])) {
                if (s[i] == 'z') {
                    s[i] = 'b';
                } else if (s[i] == 'Z') {
                    s[i] = 'B';
                } else {
                    s[i] = (char) (s[i] + 1);
                    if (isVowel(s[i])) {
                        s[i] = (char) (s[i] + 1);
                    }
                }
            }
        }
        return String.valueOf(s);
    }

    static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
