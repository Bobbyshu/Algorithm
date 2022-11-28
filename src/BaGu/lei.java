package BaGu;

public class lei {
    static class A{}

    static class B extends A{}

    static class C extends A{}

    static class D extends B{}

    public static void main(String[] args) {
        A obj = new D();

        System.out.println(obj instanceof B);

        System.out.println(obj instanceof C);

        System.out.println(obj instanceof D);

        System.out.println(obj instanceof A);
    }
}
