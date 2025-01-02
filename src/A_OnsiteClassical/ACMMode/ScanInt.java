package A_OnsiteClassical.ACMMode;

import java.util.Scanner;

public class ScanInt {
  public static void main(String[] args) {
    //  多⾏输⼊，每⾏两个整数
    Scanner sc = new Scanner(System.in);
    while (sc.hasNext()) {
      int a = sc.nextInt();
      int b = sc.nextInt();

      System.out.println(a + b);
    }

    // 多组数据，每组第⼀⾏为n, 之后输⼊n⾏两个整数
    Scanner sc2 = new Scanner(System.in);
    while (sc2.hasNext()) {
      int n = sc2.nextInt();
      while (n-- > 0) {
        int a = sc2.nextInt();
        int b = sc2.nextInt();
        System.out.println(a + b);
      }
    }
  }
}
