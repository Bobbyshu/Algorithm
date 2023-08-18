package BISHI.Cisco;

import java.util.Stack;

public class FormatString {
    public static String s;
    public static String decodeString() {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '}') {
                st.push(s.charAt(i));
            } else {
                String number = "";

                while (!st.empty() && Character.isDigit(st.peek())) {
                    number = st.peek() + number;
                    st.pop();
                }

                st.pop(); // pop '{'
                st.pop();// pop')'

                int num = Integer.parseInt(number);

                // get string to times
                String currStr = "";
                while (st.peek() != '('){
                    currStr = st.peek() + currStr;
                    st.pop();
                }
                st.pop(); // pop '('

                while (num-- > 0) {
                    for (int p = 0; p < currStr.length(); p++) {
                        st.push(currStr.charAt(p));
                    }
                }
            }
        }

        String res = "";
        while (!st.empty()) {
            res = st.peek() + res;
            st.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        String _s = "(ab){3}";
        s = _s;

        System.out.println("Result: " + decodeString());
    }
}
