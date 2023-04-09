package BISHI.Codesignal.ziprecruitter;

import java.util.*;

public class longestFilePrefix {
    public static void main(String[] args) {
        String[] paths = {"/root/folder1/b/../a/leaf.txt",
                "/root/folder1/a/leaf.txt",
                "/root/folder1/a/b/../../a/branch.txt"};
        solution(paths);
    }
    static String solution(String[] paths) {
        String[] arr = paths[0].split("/");
        List<String> res = new ArrayList<>();
        for (String s : arr) {
            if (s.equals("..")) {
                continue;
            } else {
                res.add(s);
            }
        }
        System.out.println(res);

        for (int k = 1; k < paths.length; k++) {
            String[] temp = paths[k].split("/");
            int i = 0;
            while (i < res.size()) {
                for (int j = 0; j < temp.length; j++) {
                    if (temp[j].equals(res.get(i))) {
                        break;
                    }
                    res.remove(i);
                }
                i++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String s : res) {
            sb.append("/").append(s);
        }
        return sb.toString();
    }
}
