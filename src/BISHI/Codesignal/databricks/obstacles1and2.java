package BISHI.Codesignal.databricks;

import java.util.HashSet;
import java.util.Set;

// 用一个Java TreeSet和higher()就能搞定。
public class obstacles1and2 {
    public static void main(String[] args) {
        int[][] operations = {
                {1, 2},
                {1, 5},
                {2, 3, 2},
                {2, 3, 3},
                {2, 1, 1},
                {2, 1, 2}
        };

        String output = buildBlocks(operations);
        System.out.println(output);  // Output: "10"
    }
    public static String buildBlocks(int[][] operations) {
        Set<Integer> obs = new HashSet<>();

        StringBuilder sb = new StringBuilder();

        for (int[] o : operations) {
            int type = o[0];

            if (type == 1) {
                int idx = o[1];
                obs.add(idx);
            } else if (type == 2) {
                int idx = o[1];
                int size = o[2];
                sb.append(check(obs, idx, size));
            }
        }

        return sb.toString();
    }

    public static int check(Set<Integer> obstacles, int x, int size) {
        for (int i = 0; i < size; i++) {
            if (obstacles.contains(x + i)) {
                return 0;
            }
        }
        return 1;
    }
}
