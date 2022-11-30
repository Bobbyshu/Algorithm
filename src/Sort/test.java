package Sort;

public class test {
    public static void main(String[] args) {
        int a = 1;
        increase(a);
        int b = increase(a);
        System.out.println(a);
        System.out.println(b);
    }

    static int increase(int a) {
        a = a + 1;
        return a;
    }
}
