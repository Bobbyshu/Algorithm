package A_OUEI.DaiMaXingHao.zip;

import java.util.ArrayDeque;
import java.util.Deque;

public class longestFilePrefix {
    String solution(String[] paths) {
        StringBuilder sb = new StringBuilder();
        int min = Integer.MAX_VALUE;
        for (String s : paths) {
            min = Math.min(s.length(), min);
        }
        String[] arr = paths[0].split("/");
        for (int i = 1; i < paths.length; i++) {
            String[] str = paths[i].split("/");

        }
        return "";
    }
}
