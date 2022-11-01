package Trick;

public class javaTypeTransfer {
    public static void main(String[] args) {
        int a = 1;
        String s = a + "";
        String s1 = String.valueOf(a);
        String one = "1";
        char c = '1';
        int b = Integer.parseInt(one);
        int d = c - '0';
        System.out.println((char) (c + 1));
    }
}
