package BISHI.Paypal;

public class FirstUniqueCharacter {
    public int firstUniqChar(String s) {
        int[] dict = new int[26];
        for (char c : s.toCharArray()) {
            dict[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (dict[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }
}
