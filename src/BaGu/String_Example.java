package BaGu;
/*
change第一个函数传递的不是string的引用，所以不会改变值，
第二个参数会退化为指针，所以改变传入参数的值，
第一个string不变为hello,第二个改变第一个字符，为cb，所以答案为Hello and cb
 */
public class String_Example {
    String str = new String("Hello");
    char[] ch = {'a', 'b'};

    public static void main(String args[]) {
        String_Example ex = new String_Example();
        ex.change(ex.str, ex.ch);
        System.out.print(ex.str + " and ");
        System.out.print(ex.ch);
    }

    public void change(String str, char[] ch) {
        str = "test ok";
        ch[0] = 'c';
    }
}
