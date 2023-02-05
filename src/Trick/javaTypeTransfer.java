package Trick;

import DataStructure.Tree.SegmentTree.SegmentTree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class javaTypeTransfer {
    public static void main(String[] args) {
        int a = 1;
        String s = a + "";
        String s1 = String.valueOf(a);
        String one = "1";
        char c = '1';
        int b = Integer.parseInt(one);
        System.out.println(b);
        int d = c - '0';
        System.out.println((int)c);
        System.out.println(d);
        System.out.println((char) (c + 1));
    }
}
