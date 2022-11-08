package Matrix;

public class palindrome {
//    public static void main(String[] args) {
//        String s = "aabljlba";
//        int n = s.length() - 1;
//        System.out.println(isPalindrome(s, 0, n));
//    }
    static boolean isPalindrome(String s, int l, int r) {
        if (l >= r) {
            return true;
        }

        if (s.charAt(l) == s.charAt(r)) {
            l++;
            r--;
            return isPalindrome(s, l, r);
        } else {
            return false;
        }
    }
}
