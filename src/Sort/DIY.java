package Sort;

import java.util.Arrays;
import java.util.Comparator;

public class DIY {
    public int maxHeight(int[][] cuboids) {
        for (int[] cub : cuboids) {
            Arrays.sort(cub);
        }

        Arrays.sort(cuboids, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }

            public int compare(Integer[] o1, Integer[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else if (o1[1] != o2[1]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[2] - o2[2];
                }
            }
        });

        return 0;
    }
}
