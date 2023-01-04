package Algorithm_Carl.BFS.DoubleDFS;

import java.util.*;

public class OpenTheLock {
    public int openLockBFS(String[] deadends, String target) {
        Set<String> deads = new HashSet<>();
        Collections.addAll(deads, deadends);
        if (deads.contains(target)) {
            return -1;
        }

        Deque<String> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        queue.add("0000");
        int step = 0;
        visited.add("0000");

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();

                if (cur.equals(target)) {
                    return step;
                }

                if (deads.contains(cur)) {
                    continue;
                }

                // if (cur.equals(target)) {
                //     return step;
                // }

                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    if (!visited.contains(up)) {
                        queue.add(up);
                        visited.add(up);
                    }

                    String down = minusOne(cur, j);
                    if (!visited.contains(down)) {
                        queue.add(down);
                        visited.add(down);
                    }
                }
            }

            ++step;
        }

        return -1;
    }

    String plusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '9') {
            ch[j] = '0';
        } else {
            ch[j]++;
        }
        return new String(ch);
    }

    String minusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '0') {
            ch[j] = '9';
        } else {
            ch[j]--;
        }
        return new String(ch);
    }
}
