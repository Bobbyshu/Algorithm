package BISHI.Codesignal.databricks;

public class UorD {
    public static void main(String[] args) {
        String s = "DDUDDDUUUU";
        int res = 0;
        for (char c : s.toCharArray()) {
            if (c == 'U') {
                ++res;
            } else {
                --res;
            }
        }

        if (res == 0) {
            System.out.println();
        }

        if (res > 0) {
            System.out.println("U");
        } else {
            System.out.println("D");
        }
    }
}
