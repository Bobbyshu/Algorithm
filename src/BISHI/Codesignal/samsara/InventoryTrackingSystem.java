package BISHI.Codesignal.samsara;

import javafx.scene.layout.Priority;

import java.util.*;

public class InventoryTrackingSystem {
    static int[] solution(String[][] logs) {
        Map<String, PriorityQueue<Integer>> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for (String[] s : logs) {
            if (s[0].equals("supply")) {
                map.putIfAbsent(s[1], new PriorityQueue<>());
                for (int i = 0; i < Integer.parseInt(s[2]); ++i) {
                    map.get(s[1]).offer(Integer.valueOf(s[3]));
                }
            } else if (s[0].equals("return")) {
                map.putIfAbsent(s[1], new PriorityQueue<>());
                for (int i = 0; i < Integer.parseInt(s[2]); ++i) {
                    map.get(s[1]).offer(Integer.valueOf(s[4]));
                }
            } else {
                int require = Integer.parseInt(s[2]);
                int cnt = 0;
                while (require > 0) {
                    int cur = map.get(s[1]).poll();
                    cnt += cur;
                    --require;
                }
                list.add(cnt);
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}
